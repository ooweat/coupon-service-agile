package kr.co.ooweat.coupon.application;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.coupon.domain.Issuance;
import kr.co.ooweat.coupon.mappers.IssuanceMapper;
import kr.co.ooweat.utils.Util;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Service;

@Service
public class IssuanceService {
    
    private final IssuanceMapper issuanceMapper;
    
    public IssuanceService(IssuanceMapper issuanceMapper) {
        this.issuanceMapper = issuanceMapper;
    }
    
    public IssuanceResponse save(IssuanceRequest issuanceRequest) throws NoSuchAlgorithmException {
        final Issuance issuance = new Issuance(issuanceRequest,
            generateCouponNo(issuanceRequest.getBinCode()));
        issuanceMapper.save(issuance);
        
        return new IssuanceResponse(issuance);
        //couponMapper.save(issuance);
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
        binCode += Util.dateUtils().now("YYMMddHHmmss");
        couponNo+=binCode;
        
        
        
        issuanceMapper.findByCouponNo(binCode);
        return binCode;
    }
}
