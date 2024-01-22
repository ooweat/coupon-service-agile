package kr.co.ooweat.coupon.application;

import kr.co.ooweat.coupon.application.dto.CouponConfigResponse;
import kr.co.ooweat.member.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    public List<CouponConfigResponse> findAllByCompanySeq(Member authMember, Long companySeq) {

    }
}
