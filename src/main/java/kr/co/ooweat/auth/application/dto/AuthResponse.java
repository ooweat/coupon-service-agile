package kr.co.ooweat.auth.application.dto;

import kr.co.ooweat.auth.domain.Auth;
import lombok.Getter;

@Getter
public class AuthResponse {
    Long seq;
    char roles;

    public AuthResponse(Auth auth){
        this.seq = auth.getSeq();
        this.roles = auth.getRoles();
    }
}
