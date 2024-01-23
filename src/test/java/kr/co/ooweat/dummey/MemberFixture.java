package kr.co.ooweat.dummey;

import kr.co.ooweat.member.domain.Member;
import lombok.Getter;

public enum MemberFixture {

    OOWEAT(0L, "ooweat", "ooweat!@#$", ""),
    ;
    @Getter
    private final Long companySeq;
    @Getter
    private final String userId;
    @Getter
    private final String userPass;
    @Getter
    private final String userToken;
    
    MemberFixture(final Long companySeq, final String userId, final String userPass, final String userToken) {
        this.companySeq = companySeq;
        this.userId = userId;
        this.userPass = userPass;
        this.userToken = userToken;
    }
    
    public Member createLogin(){
        Member member = new Member(companySeq, userId, userPass, userToken);
        return member;
    }
}
