package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import kr.co.ooweat.coupon.domain.CouponConfig;
import kr.co.ooweat.mappers.CouponMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponService {
    private final CouponMapper couponMapper;
    
    public CouponService(CouponMapper couponMapper) {
        this.couponMapper = couponMapper;
    }
    
    public ConfigResponse findConfigByCompanySeq(Long companySeq) {
        return new ConfigResponse(couponMapper.findAllByCompanySeq(companySeq));
    }
    
    @Transactional
    public void updateCouponConfig(ConfigRequest configRequest) {
        final CouponConfig config = new CouponConfig(configRequest);
        couponMapper.save(config);
    }
}
