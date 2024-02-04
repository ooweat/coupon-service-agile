package kr.co.ooweat.coupon.api;

import kr.co.ooweat.coupon.application.IssuanceService;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.coupon.application.dto.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/issuance")
public class IssuanceController {
    
    private IssuanceService issuanceService;
    
    public IssuanceController(final IssuanceService issuanceService) {
        this.issuanceService = issuanceService;
    }

    @GetMapping
    public ResponseEntity<IssuanceResponse> coupon(@PathVariable("couponNo") final String couponNo){
        return ResponseEntity.ok(issuanceService.findByCouponNo(couponNo));
    }

    //TODO: Coupon 기본값에 대한 interceptor 처리 진행할 예정 Swagger 로 처리할지 고민
    @PostMapping
    public ResponseEntity<IssuanceResponse> issuance(final IssuanceRequest issuanceRequest) {
        try {
            return ResponseEntity.ok(issuanceService.issuance(issuanceRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PatchMapping("/resend/coupon/{couponNo}}")
    public ResponseEntity<IssuanceResponse> resendByCouponNo(@PathVariable("couponNo") final String couponNo){
        try {
            return ResponseEntity.ok(issuanceService.reSendByCouponNo(couponNo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    

}
