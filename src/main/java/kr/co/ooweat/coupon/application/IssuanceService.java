package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
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
    public IssuanceResponse save(Long companySeq, Long memberSeq, ConfigRequest configRequest) {
        final Issuance issuance = new Issuance(companySeq, memberSeq, configRequest);
        return null;
        //couponMapper.save(issuance);
    }
}
