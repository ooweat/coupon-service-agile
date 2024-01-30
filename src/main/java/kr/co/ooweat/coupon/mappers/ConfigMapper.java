package kr.co.ooweat.coupon.mappers;

import java.util.List;
import kr.co.ooweat.coupon.application.dto.StatusRequest;
import kr.co.ooweat.coupon.application.dto.StatusResponse;
import kr.co.ooweat.coupon.domain.CouponConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigMapper {
    List<CouponConfig> findAllConfigs();
    CouponConfig findAllByCompanySeq(Long companySeq);
    void save(CouponConfig couponConfig);
    void deleteBySeq(Long seq);
    boolean consumeCoin(Long companySeq);
}
