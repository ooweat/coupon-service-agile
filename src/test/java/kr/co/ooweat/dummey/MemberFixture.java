package kr.co.ooweat.dummey;

import kr.co.ooweat.member.domain.Member;
import lombok.Getter;

public enum MemberFixture {

    OOWEAT("ooweat", "ooweat!@#$", ""),
    ;
    @Getter
    private final String userId;
    @Getter
    private final String userPass;
    @Getter
    private final String userToken;
    
    MemberFixture(final String userId, final String userPass, final String userToken) {
        this.userId = userId;
        this.userPass = userPass;
        this.userToken = userToken;
    }
    
    public Member createLogin(){
        Member member = new Member(userId, userPass, userToken);
        return member;
    }
}
