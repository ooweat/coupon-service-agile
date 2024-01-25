package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.coupon.domain.Issuance;
import kr.co.ooweat.coupon.mappers.IssuanceMapper;
import org.springframework.stereotype.Service;

@Service
public class IssuanceService {
    
    private final IssuanceMapper issuanceMapper;
    
    public IssuanceService(IssuanceMapper issuanceMapper) {
        this.issuanceMapper = issuanceMapper;
    }
    
    public IssuanceResponse save(IssuanceRequest issuanceRequest) {
        final Issuance issuance = new Issuance(issuanceRequest,
            generateCouponNo(issuanceRequest.getBinCode()));
        issuanceMapper.save(issuance);
        
        return new IssuanceResponse(issuance);
        //couponMapper.save(issuance);
    }
    
    //TODO: 당장은 couponNO 를 상수로 선언(암호화 예정)
    private String generateCouponNo(String binCode) {
        binCode = binCode+"1234567890";
        return binCode;
    }
}
