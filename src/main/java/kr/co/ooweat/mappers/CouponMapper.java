package kr.co.ooweat.mappers;

import kr.co.ooweat.coupon.domain.CouponConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    CouponConfig findAllByCompanySeq(Long companySeq);
    void save(CouponConfig couponConfig);
    void deleteBySeq(Long seq);
}
