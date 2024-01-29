package kr.co.ooweat.coupon.application;

import static kr.co.ooweat.dummey.IssuanceFixture.ISSUANCE_1;
import static kr.co.ooweat.dummey.MemberFixture.OOWEAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE;

import java.time.LocalDate;
import kr.co.ooweat.auth.application.AuthService;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.ConfigResponse;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceResponse;
import kr.co.ooweat.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class IssuanceServiceTest {
    
    @Autowired
    private ConfigService configService;
    @Autowired
    private AuthService authService;
    
    @Autowired
    private IssuanceService issuanceService;
    
    @DisplayName("로그인")
    @Test
    Member 로그인() {
        Member member = authService.login(OOWEAT.createLogin());
        return member;
    }
    
    @DisplayName("쿠폰 설정 조회")
    @Test
    ConfigResponse 쿠폰_설정_조회() {
        //인증된 멤버가 자신의 설정 정보를 조회한다.
        // given
        Member member = 로그인();
        // when
        ConfigResponse configResponse = configService.findConfigByCompanySeq(
            member.getCompanySeq());
        
        return configResponse;
    }
    
    @DisplayName("쿠폰 발권")
    @Test
    void 쿠폰_발권() {
        // given
        //Member member = 로그인();
        //ConfigResponse configResponse = 쿠폰_설정_조회();
        
        //쿠폰을 발권한다.
        // given & when
        //TODO: 일부 데이터에 값을 넣지 않을 경우, config 기본 값에서 처리
        IssuanceRequest issuanceRequest = new IssuanceRequest(
            ISSUANCE_1.getCompanySeq(),
            ISSUANCE_1.getOrganSeq(),
            ISSUANCE_1.getMemberSeq(),
            ISSUANCE_1.getBinCode(),
            ISSUANCE_1.getExpireDate(),
            ISSUANCE_1.getIssuanceAmount(),
            ISSUANCE_1.getRemainAmount(),
            ISSUANCE_1.getRemainCount(),
            ISSUANCE_1.getStatus(),
            ISSUANCE_1.getSendType(),
            ISSUANCE_1.getSendInfo(),
            ISSUANCE_1.getSendCount()
        );
        // then
        IssuanceResponse response = issuanceService.save(issuanceRequest);
        log.info(response.getCouponNo());
    }
    
}
