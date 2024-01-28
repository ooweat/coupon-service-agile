package kr.co.ooweat.auth.application;

import kr.co.ooweat.auth.application.dto.AuthResponse;
import kr.co.ooweat.auth.mappers.AuthMapper;
import kr.co.ooweat.member.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final AuthMapper authMapper;

    public AuthService(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Transactional
    public void save(Member member) throws Exception {
        if(authMapper.findByUserId(member.getUserId())){
            throw new Exception("이미 존재하는 아이디입니다.");
        }

        authMapper.save(member);
    }

    public Member login(Member member) {
        return authMapper.findAllByMember(member.getUserId(), member.getUserPass());
    }

    public AuthResponse findByCompanySeq(Long companySeq) {
        AuthResponse authResponse = new AuthResponse(authMapper.findByCompanySeq(companySeq));
        return authResponse;
    }
}
