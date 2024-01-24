package kr.co.ooweat.coupon.application;

import static kr.co.ooweat.dummey.CouponConfigFixture.COMPANY_0;
import static kr.co.ooweat.dummey.MemberFixture.OOWEAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDateTime;
import kr.co.ooweat.auth.application.AuthService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import kr.co.ooweat.coupon.domain.CouponConfig;
import kr.co.ooweat.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CouponServiceTest {
    @Autowired
    private CouponService couponService;
    
    @Autowired
    private AuthService authService;
    
    @DisplayName("로그인")
    @Test
    Member 로그인(){
        Member member = authService.login(OOWEAT.createLogin());
        return member;
    }
    
    
    @DisplayName("쿠폰 설정 조회")
    @Test
    void 쿠폰_설정_조회() {
        //인증된 멤버가 자신의 설정 정보를 조회한다.
        // given
        Member member = 로그인();
        // when
        ConfigResponse configResponse = couponService.findConfigByCompanySeq(member.getCompanySeq());
        // then
        assertThat(member.getUserPhone()).isNotEmpty();
        assertThat(configResponse).isNotNull();
    }
    

    @DisplayName("쿠폰 설정 업데이트")
    @Test
    void 쿠폰_설정_업데이트(){
        //인증된 멤버가 자신의 설정 정보를 조회 후, 업데이트 한다.
        // given
        Member member = 로그인();
        ConfigResponse configResponse = couponService.findConfigByCompanySeq(member.getCompanySeq());
        assertThat(configResponse).isNotNull();
        
        // when
        couponService.updateCouponConfig(COMPANY_0.createCouponConfig());
        ConfigResponse response = couponService.findConfigByCompanySeq(member.getCompanySeq());
        // then
        assertThat(response.getSendCount()).isEqualTo(COMPANY_0.getSendCount());
    }
    
}
