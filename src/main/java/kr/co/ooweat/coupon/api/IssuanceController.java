package kr.co.ooweat.coupon.api;

import kr.co.ooweat.coupon.application.IssuanceService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon/issuance")
public class IssuanceController {
    
    private IssuanceService issuanceService;
    
    public IssuanceController(final IssuanceService issuanceService) {
        this.issuanceService = issuanceService;
    }
    
    @PostMapping
    public ResponseEntity<IssuanceResponse> issuance(final IssuanceRequest issuanceRequest) {
        IssuanceResponse response = issuanceService.save(issuanceRequest);
        return ResponseEntity.ok(response);
    }
}
