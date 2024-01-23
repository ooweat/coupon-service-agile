package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.CouponConfigResponse;
import kr.co.ooweat.mappers.CouponMapper;
import kr.co.ooweat.member.domain.Member;
import org.springframework.stereotype.Service;

//TODO: Autowired 를 최대한 지양하는 버릇들이기
import java.util.List;

@Service
public class CouponService {
    private final CouponMapper couponMapper;
    
    public CouponService(CouponMapper couponMapper) {
        this.couponMapper = couponMapper;
    }
    
    public List<CouponConfigResponse> findConfigByCompanySeq(Member authMember) {
        return couponMapper.findAllByCompanySeq(authMember);
    }
}
