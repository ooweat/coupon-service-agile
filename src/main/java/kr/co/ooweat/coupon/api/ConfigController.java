package kr.co.ooweat.coupon.api;

import javax.validation.Valid;

import kr.co.ooweat.coupon.application.ConfigService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupon/config")
public class ConfigController {
    private ConfigService configService;

    public ConfigController(final ConfigService configService) {
        this.configService = configService;
    }

    //TODO: 시스템 관리자만 접근가능한 옵션으로 처리 예정
    @GetMapping("/companys")
    public List<ConfigResponse> findAllByCompanySeq() {
        return configService.findAllConfigs();
    }

    @GetMapping("/companys/{company_seq}")
    public ResponseEntity<ConfigResponse> find(@PathVariable Long companySeq) {
        ConfigResponse response = configService.findConfigByCompanySeq(companySeq);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/companys")
    public ResponseEntity<Void> save(@RequestBody @Valid final ConfigRequest configRequest) {
        configService.save(configRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBySeq(@RequestParam Long seq) {
        configService.deleteBySeq(seq);
        return ResponseEntity.noContent().build();
    }
}
