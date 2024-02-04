package kr.co.ooweat.coupon.mappers;

import kr.co.ooweat.coupon.domain.CouponConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConfigMapper {
    List<CouponConfig> findAllConfigs();
    CouponConfig findAllByOrganSeq(Long organSeq);
    void save(CouponConfig couponConfig);
    void deleteBySeq(Long seq);
    boolean consumePoint(Long organSeq, Long consumePoint);
}
