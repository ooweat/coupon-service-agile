package kr.co.ooweat.coupon.api;

import kr.co.ooweat.coupon.application.CouponService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
public class IssuanceController {
    private CouponService couponService;

    public IssuanceController(final CouponService couponService){
        this.couponService = couponService;
    }
    
    @PostMapping("/issuance")
    public ResponseEntity<ConfigResponse> issuance(final Long companySeq) {
        System.out.println(companySeq);
        ConfigResponse response = couponService.findConfigByCompanySeq(companySeq);
        return ResponseEntity.ok(response);
    }
}
