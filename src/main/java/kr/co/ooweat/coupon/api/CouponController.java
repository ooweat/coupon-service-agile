package kr.co.ooweat.coupon.api;

import kr.co.ooweat.coupon.application.CouponService;
import kr.co.ooweat.coupon.application.dto.CouponConfigResponse;
import kr.co.ooweat.member.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {
    private CouponService couponService;

    public CouponController(final CouponService couponService){
        this.couponService = couponService;
    }

    @GetMapping("/config")
    public List<CouponConfigResponse> find(final Member authMember) {
        return couponService.findConfigByCompanySeq(authMember);
    }
}
