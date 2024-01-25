package kr.co.ooweat.coupon.mappers;

import kr.co.ooweat.coupon.domain.CouponConfig;
import kr.co.ooweat.coupon.domain.Issuance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IssuanceMapper {
    void save(Issuance couponConfig);
}
