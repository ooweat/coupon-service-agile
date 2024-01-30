package kr.co.ooweat.coupon.application;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.coupon.application.dto.StatusResponse;
import kr.co.ooweat.coupon.domain.Issuance;
import kr.co.ooweat.coupon.mappers.ConfigMapper;
import kr.co.ooweat.coupon.mappers.IssuanceMapper;
import kr.co.ooweat.utils.Util;
import org.springframework.stereotype.Service;

@Service
public class IssuanceService {
    
    private final IssuanceMapper issuanceMapper;
    private final ConfigMapper configMapper;
    public IssuanceService(IssuanceMapper issuanceMapper, ConfigMapper configMapper) {
        this.issuanceMapper = issuanceMapper;
        this.configMapper = configMapper;
    }
    
    public IssuanceResponse issuance(IssuanceRequest issuanceRequest) throws NoSuchAlgorithmException {
        final Issuance issuance = new Issuance(issuanceRequest,
            generateCouponNo(issuanceRequest.getBinCode()));
        
        /*
        TODO:
         Q1. 수익구조?
         A1. 코인 개념 도입: 쿠폰을 1회 발권할 때마다 코인 차감 처리 (포인트를 쓰려고 했으나 이 후 포인트를 쓸 여지를 남김)
         Q2. 코인은 선불 개념, 그렇다면 후불 개념은?
        */
        if(issuanceMapper.issuance(issuance)){
            /*
            TODO:
             Q1. 소속 단위로 소모할 것인가? 계정단위로 소모할 것인가?
             //issuanceMapper.consumeCoin(issuance.getCompanySeq());
             //issuanceMapper.consumeCoin(issuance.getMemberSeq());
                Q1-1. 전체 플랫폼을 제공할 것인가? 서비스를 제공할 것인가? -> 소속
                Q1-2. 플랫폼 제공 시, 결제는 본사가 일괄로 진행한다.
            */
            configMapper.consumeCoin(issuance.getCompanySeq());
        };
        
        return new IssuanceResponse(issuance);
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
    *    binCode + coupontype + YYMMddHHmmss + 1-9 random
    * */
    private String generateCouponNo(String binCode) {
        String couponNo = "";
        binCode += Util.dateUtils().now("YYMMddHHmmssS");
        couponNo+=binCode;
        issuanceMapper.findByCouponNo(binCode);
        return binCode;
    }
    
    public IssuanceResponse reSendByCouponNo(String couponNo) {
        //TODO: 재전송 Logic 추가 -> 이메일, 알림톡 SMS 등
    
        //DESC: 재전송 시, 전송 횟수 증가
        if(issuanceMapper.addSendCountByCouponNo(couponNo)){
            return new IssuanceResponse(true, couponNo);
        }
        return new IssuanceResponse(false, couponNo);
    }
}
