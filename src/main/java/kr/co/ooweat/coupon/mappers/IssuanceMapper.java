package kr.co.ooweat.coupon.mappers;

import java.util.List;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.domain.Issuance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IssuanceMapper {
    boolean findByCouponNo(String couponNo);
    void save(Issuance couponConfig);
    List<Issuance> findAllByCompanyWithOrgan(IssuanceRequest issuanceRequest);
}
