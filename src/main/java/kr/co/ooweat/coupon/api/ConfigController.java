package kr.co.ooweat.coupon.api;

import javax.validation.Valid;
import kr.co.ooweat.coupon.application.CouponService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon/config")
public class ConfigController {
    private CouponService couponService;

    public ConfigController(final CouponService couponService){
        this.couponService = couponService;
    }
    
    @GetMapping
    public ResponseEntity<ConfigResponse> find(@RequestParam Long companySeq) {
        ConfigResponse response = couponService.findConfigByCompanySeq(companySeq);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid final ConfigRequest configRequest) {
        couponService.save(configRequest);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteBySeq(@RequestParam Long seq) {
        couponService.deleteBySeq(seq);
        return ResponseEntity.noContent().build();
    }
}
