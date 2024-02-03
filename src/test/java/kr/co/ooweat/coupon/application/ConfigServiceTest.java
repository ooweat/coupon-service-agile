package kr.co.ooweat.coupon.application;

import static kr.co.ooweat.dummey.CouponConfigFixture.COMPANY_1;
import static kr.co.ooweat.dummey.MemberFixture.OOWEAT;
import static org.assertj.core.api.Assertions.assertThat;

import kr.co.ooweat.auth.application.AuthService;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import kr.co.ooweat.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ConfigServiceTest {
    
    @Autowired
    private ConfigService configService;
    @Autowired
    private AuthService authService;
    
    @DisplayName("로그인")
    @Test
    Member 로그인() {
        Member member = authService.login(OOWEAT.createLogin());
        return member;
    }

    @DisplayName("쿠폰 설정 전체 조회")
    @Test
    void 쿠폰_설정_전체_조회() {
        //인증된 멤버가 자신의 설정 정보를 조회한다.
        // given
        Member member = 로그인();
        // when
        List<ConfigResponse> configResponse = configService.findAllConfigs();
        log.info(configResponse.toString());

        // then
        assertThat(member.getUserPhone()).isNotEmpty();
        assertThat(configResponse).isNotNull();
    }
    
    @DisplayName("쿠폰 설정 조회")
    @Test
    void 쿠폰_설정_조회() {
        //인증된 멤버가 자신의 설정 정보를 조회한다.
        // given
        Member member = 로그인();
        // when
        ConfigResponse configResponse = configService.findConfigByOrganSeq(member.getOrganSeq());
        // then
        assertThat(member.getUserPhone()).isNotEmpty();
        assertThat(configResponse).isNotNull();
    }
    
    @DisplayName("쿠폰 설정 추가 또는 업데이트")
    @Test
    void 쿠폰_설정_추가_또는_업데이트() {
        //인증된 멤버가 자신의 설정 정보를 조회 후, 업데이트 한다.
        // given & when
        Member member = 로그인();
        configService.save(COMPANY_1.createCouponConfig());
        ConfigResponse response = configService.findConfigByOrganSeq(member.getCompanySeq());
        //then
        assertThat(response.getBinCode()).isEqualTo(COMPANY_1.getBinCode());
    }
    
    @DisplayName("쿠폰 설정 업데이트")
    @Test
    void 쿠폰_설정_업데이트() {
        //인증된 멤버가 자신의 설정 정보를 조회 후, 업데이트 한다.
        // given
        Member member = 로그인();
        ConfigResponse configResponse = configService.findConfigByOrganSeq(
            member.getCompanySeq());
        assertThat(configResponse).isNotNull();
        
        // when
        configService.save(COMPANY_1.createCouponConfig());
        ConfigResponse response = configService.findConfigByOrganSeq(member.getCompanySeq());
        // then
        assertThat(response.getBinCode()).isEqualTo(COMPANY_1.getBinCode());
    }
    
    @DisplayName("쿠폰 설정 제거")
    @Test
    void 쿠폰_설정_제거() {
    
    }
}
