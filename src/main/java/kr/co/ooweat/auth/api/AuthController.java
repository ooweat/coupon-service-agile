package kr.co.ooweat.auth.api;

import kr.co.ooweat.auth.application.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }
}
