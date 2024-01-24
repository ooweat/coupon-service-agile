package kr.co.ooweat.auth.application;

import kr.co.ooweat.auth.mappers.AuthMapper;
import kr.co.ooweat.member.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthMapper authMapper;
    
    public AuthService(AuthMapper authMapper){
        this.authMapper = authMapper;
    }
    
    public Member login(Member member) {
        return authMapper.findAllByMember(member.getUserId(), member.getUserPass());
    }
}
