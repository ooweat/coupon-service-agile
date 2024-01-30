package kr.co.ooweat.auth.application;

import static kr.co.ooweat.dummey.MemberFixture.OOWEAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import kr.co.ooweat.auth.application.dto.LoginResponse;
import kr.co.ooweat.member.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {
    
    @Autowired
    private AuthService authService;
    
    @DisplayName("로그인")
    @Test
    void login() {
        // given
        Member member = authService.login(OOWEAT.createLogin());
        
        // when
        //LoginResponse response = authService.login(OOWEAT.createLogin());
        
        // then
        //assertThat(response.getToken()).isNotEmpty();
    }
    
    
    @Test
    void test() {
        String my_string = "banana";
        String is_suffix = "ana";
        //int answer = 0;
        
        int[] num_list = {2, 1, 6};
        int start_num = 3;
        int end_num = 10;
        int[] answer = {};
        for(int i = start_num; i <= end_num; i++){
            answer[i]+=i;
            System.out.printf("answer:" + answer);
        }
        
        
    }
}
