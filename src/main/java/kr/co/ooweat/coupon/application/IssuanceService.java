package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.coupon.domain.Issuance;
import kr.co.ooweat.coupon.mappers.IssuanceMapper;
import kr.co.ooweat.utils.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssuanceService {

    private final IssuanceMapper issuanceMapper;
    private final ConfigService configService;

    public IssuanceService(IssuanceMapper issuanceMapper, ConfigService configService) {
        this.issuanceMapper = issuanceMapper;
        this.configService = configService;
    }

    @Transactional(readOnly = true)
    public IssuanceResponse findByCouponNo(final String couponNo) {
        return new IssuanceResponse(issuanceMapper.findByCouponNo(couponNo));
    }
    @Transactional(readOnly = true)
    public IssuanceResponse issuance(IssuanceRequest issuanceRequest) {
        final Issuance issuance = new Issuance(issuanceRequest,
                generateCouponNo(issuanceRequest.getBinCode(), issuanceRequest.getCouponType()));
        /*
        TODO:
         Q1. 소속 단위로 소모할 것인가? 계정단위로 소모할 것인가?
         -> 조직 단위로 소모한다.
            Q1-1. 전체 플랫폼을 제공할 것인가? 서비스를 제공할 것인가? -> 소속
            Q1-2. 플랫폼 제공 시, 결제는 본사가 일괄로 진행한다.
        */

        if (issuanceMapper.issuance(issuance)) {
        /*
        TODO:
         Q1. 수익구조?
         A1. 포인트 개념 도입: 쿠폰을 1회 발권할 때마다 포인트 차감
        */
            sendCoupon(issuance.getSendType(), issuance.getOrganSeq());
        }

        return new IssuanceResponse(issuance);
    }

    private void sendCoupon(char sendType, Long organSeq) {
        boolean success = false;
        Long consumePoint = 0L;
        switch (sendType){
            case 'E':
                //E-mail 전송 로직
                success = true;
                break;
            case 'M':
            case 'S':
                //MMS / SMS 전송 로직
                success = true;
                consumePoint = 70L;
                break;
            case 'K':
                //알림톡 전송 로직
                success = true;
                consumePoint = 12L;
                break;
        }

        if(success){
            configService.consumePoint(organSeq, consumePoint);
        }
    }

    public List<IssuanceResponse> findAllByCompanyWithOrganSeq(IssuanceRequest issuanceRequest) {
        List<Issuance> findAllByCompanyWithOrganSeq = issuanceMapper.findAllByCompanyWithOrgan(issuanceRequest);
        List<IssuanceResponse> issuanceResponse = new ArrayList<>();

        for (Issuance v : findAllByCompanyWithOrganSeq) {
            issuanceResponse.add(new IssuanceResponse(v));
        }
        return issuanceResponse;
    }

    /*
     * @param binCode
     * @DESC: 쿠폰 번호 생성
     *    binCode(6) + coupontype(1) + YYMMddHHmmss(12) + 1to9 Cycle Sequence(1)
     * */
    private String generateCouponNo(String binCode, char couponType) {
        String couponNo = binCode + couponType + Util.dateUtils().now("YYMMddHHmmss");
        return couponNo;
    }

    public IssuanceResponse reSendByCouponNo(String couponNo) {
        //TODO: 재전송 Logic 추가 -> 이메일, 알림톡 SMS 등

        //DESC: 재전송 시, 전송 횟수 증가
        if (issuanceMapper.addSendCountByCouponNo(couponNo)) {
            return new IssuanceResponse(true, couponNo);
        }
        return new IssuanceResponse(false, couponNo);
    }


}
