package kr.co.ooweat.mappers;

import java.util.List;
import kr.co.ooweat.coupon.application.dto.CouponConfigResponse;
import kr.co.ooweat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    List<CouponConfigResponse> findAllByCompanySeq(Member authMember);
    
}
