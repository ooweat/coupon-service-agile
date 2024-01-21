package kr.co.ooweat.member.domain;

import lombok.Getter;

@Getter
public class Member {
    
    private Long userSeq;
    private String userId;
    private String userPass;
    private String userName;
    private String userPhone;
    private String userEmail;
    private boolean isFirstLogin = true;

    private String token;

    protected Member() {
    }

    public Member(final String userId, final String username) {
        this.userId = userId;
        this.userName = username;
    }

    public void firstLogin(final String token) {
        this.isFirstLogin = false;
        this.token = token;
    }
}
