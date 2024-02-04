package kr.co.ooweat.coupon.mappers;

import java.util.List;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.domain.Issuance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IssuanceMapper {
    Issuance findByCouponNo(String couponNo);
    List<Issuance> findAllByCompanyWithOrgan(IssuanceRequest issuanceRequest);
    boolean issuance(Issuance issuance);
    boolean addSendCountByCouponNo(String couponNo);
    Issuance updateStatusByCouponNo(IssuanceRequest issuanceRequest);
}
