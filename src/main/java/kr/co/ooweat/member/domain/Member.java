package kr.co.ooweat.member.domain;

import kr.co.ooweat.common.BaseTimeEntity;
import lombok.Getter;

@Getter
public class Member extends BaseTimeEntity {
    
    private Long seq;
    private Long companySeq;
    private Long organSeq;
    private int authSeq;
    private String userId;
    private String userPass;
    private String userName;
    private String userPhone;
    private String userEmail;
    private char useYn;
    private boolean isFirstLogin = true;

    private String token;

    protected Member() {
    }

    public Member(final String userId, final String username) {
        this.userId = userId;
        this.userName = username;
    }
    
    public Member(final Long companySeq){
        this.companySeq = companySeq;
    }
    
    public Member(Long companySeq, String userId, String userPass, String userToken) {
        this. companySeq = companySeq;
        this.userId = userId;
        this.userPass = userPass;
        this.token = userToken;
    }
    
    public void firstLogin(final String token) {
        this.isFirstLogin = false;
        this.token = token;
    }
}
