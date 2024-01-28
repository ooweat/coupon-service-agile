package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import kr.co.ooweat.coupon.domain.CouponConfig;
import kr.co.ooweat.coupon.mappers.ConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigService {
    private final ConfigMapper configMapper;

    public ConfigService(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    public ConfigResponse findConfigByCompanySeq(Long companySeq) {
        return new ConfigResponse(configMapper.findAllByCompanySeq(companySeq));
    }

    @Transactional
    public void save(ConfigRequest configRequest) {
        final CouponConfig config = new CouponConfig(configRequest);
        configMapper.save(config);
    }

    @Transactional
    public void deleteBySeq(Long seq) {
        configMapper.deleteBySeq(seq);
    }

    public List<ConfigResponse> findAllConfigs() {
        List<CouponConfig> findAllConfigs = configMapper.findAllConfigs();
        List<ConfigResponse> configResponse = new ArrayList<>();

        for(CouponConfig v : findAllConfigs){
            configResponse.add(new ConfigResponse(v));
        }

        return configResponse;
    }
}
