package kr.co.ooweat.coupon.application;

import static kr.co.ooweat.dummey.MemberFixture.OOWEAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


import kr.co.ooweat.auth.application.AuthService;

import kr.co.ooweat.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CouponServiceTest {
    @Autowired
    private CouponService couponService;
    
    @Autowired
    private AuthService authService;
    
    @DisplayName("쿠폰 기본 설정정보")
    @Test
    void config() {
        // given
        Member member = authService.login(OOWEAT.createLogin());
        // when
        couponService.findConfigByCompanySeq(member);
        
        // then
        assertThat(member.getUserPhone()).isNotEmpty();
    }
}
