package kr.co.ooweat.coupon.mappers;

import java.util.List;
import kr.co.ooweat.coupon.domain.CouponConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigMapper {
    List<CouponConfig> findAllConfigs();
    CouponConfig findAllByOrganSeq(Long organSeq);
    void save(CouponConfig couponConfig);
    void deleteBySeq(Long seq);
    boolean consumeCoin(Long companySeq);
}
