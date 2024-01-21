package kr.co.ooweat.auth.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
        //members.save("ooweat", "1234");
        
        // when
        //LoginResponse response = authService.login(OOWEAT.createLogin());
        
        // then
        //assertThat(response.getToken()).isNotEmpty();
    }
}
