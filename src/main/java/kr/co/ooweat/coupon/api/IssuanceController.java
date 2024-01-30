package kr.co.ooweat.coupon.api;

import kr.co.ooweat.coupon.application.IssuanceService;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.coupon.application.dto.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/issuance")
public class IssuanceController {
    
    private IssuanceService issuanceService;
    
    public IssuanceController(final IssuanceService issuanceService) {
        this.issuanceService = issuanceService;
    }
    
    //TODO: Coupon 기본값에 대한 interceptor 처리 진행할 예정 Swagger 로 처리할지 고민
    @PostMapping
    public ResponseEntity<IssuanceResponse> issuance(final IssuanceRequest issuanceRequest) {
        try {
            IssuanceResponse response = issuanceService.issuance(issuanceRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PatchMapping("/resend/coupon/{couponNo}}")
    public ResponseEntity<IssuanceResponse> resendByCouponNo(@PathVariable("couponNo") final String couponNo){
        try {
            IssuanceResponse response = issuanceService.reSendByCouponNo(couponNo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    

}
