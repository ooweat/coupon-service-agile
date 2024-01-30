package kr.co.ooweat.auth.api;

import kr.co.ooweat.auth.application.AuthService;
import kr.co.ooweat.auth.application.dto.AuthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    //DESC: 소속의 권한 목록을 불러오기 위함(소속의 관리자에서 매니저 계정 등록 시, 불러올 권한
    @GetMapping("/company/{company_seq}")
    public AuthResponse findByCompanySeq(@PathVariable Long companySeq) {

        return authService.findByCompanySeq(companySeq);
    }

}
