package kr.co.ooweat.member.domain;

import kr.co.ooweat.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
    
    
    public Member(String userId, String userPass, String userToken) {
        this.userId = userId;
        this.userPass = userPass;
        this.token = userToken;
    }
    
    public void firstLogin(final String token) {
        this.isFirstLogin = false;
        this.token = token;
    }
}
