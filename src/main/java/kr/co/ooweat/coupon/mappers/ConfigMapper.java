package kr.co.ooweat.coupon.mappers;

import kr.co.ooweat.coupon.domain.CouponConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConfigMapper {
    List<CouponConfig> findAllConfigs();
    CouponConfig findAllByCompanySeq(Long companySeq);
    void save(CouponConfig couponConfig);

    void deleteBySeq(Long seq);
}
