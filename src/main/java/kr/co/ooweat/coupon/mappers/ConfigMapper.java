package kr.co.ooweat.coupon.mappers;

import kr.co.ooweat.coupon.domain.CouponConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigMapper {
    CouponConfig findAllByCompanySeq(Long companySeq);
    void save(CouponConfig couponConfig);
    void deleteBySeq(Long seq);
}
