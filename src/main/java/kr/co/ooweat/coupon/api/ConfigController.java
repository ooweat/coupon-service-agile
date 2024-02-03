package kr.co.ooweat.coupon.api;

import java.util.List;
import javax.validation.Valid;
import kr.co.ooweat.coupon.application.ConfigService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/config")
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
        ConfigResponse response = configService.findConfigByOrganSeq(companySeq);
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
