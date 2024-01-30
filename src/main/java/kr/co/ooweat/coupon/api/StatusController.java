package kr.co.ooweat.coupon.api;

import kr.co.ooweat.coupon.application.StatusService;
import kr.co.ooweat.coupon.application.dto.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    private StatusService statusService;
    
    public StatusController(final StatusService statusService) {
        this.statusService = statusService;
    }
    
    @PatchMapping("/{status}/coupon/{couponNo}}")
    public ResponseEntity<StatusResponse> updateCouponStatus(@PathVariable("status") final char status, @PathVariable("couponNo") final String couponNo){
        try {
            StatusResponse response = statusService.updateCouponStatus(status, couponNo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
}
