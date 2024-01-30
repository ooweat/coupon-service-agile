package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.StatusResponse;
import kr.co.ooweat.coupon.mappers.ConfigMapper;
import kr.co.ooweat.coupon.mappers.IssuanceMapper;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final IssuanceMapper issuanceMapper;
    private final ConfigMapper configMapper;
    public StatusService(IssuanceMapper issuanceMapper, ConfigMapper configMapper) {
        this.issuanceMapper = issuanceMapper;
        this.configMapper = configMapper;
    }
    
    public StatusResponse updateCouponStatus(final char status, final String couponNo) {
        IssuanceRequest issuanceRequest = new IssuanceRequest(status, couponNo);
        StatusResponse response = new StatusResponse(issuanceMapper.updateStatusByCouponNo(issuanceRequest));
        return response;
    }
}
