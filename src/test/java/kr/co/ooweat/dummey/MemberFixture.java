package kr.co.ooweat.dummey;

public enum MemberFixture {

    OOWEAT("ooweat", "1234", ""),
    ;

    private final String userId;
    private final String userPass;
    private final String userToken;
    
    MemberFixture(final String userId, final String userPass, final String userToken) {
        this.userId = userId;
        this.userPass = userPass;
        this.userToken = userToken;
    }
    
    public Member createLogin(){
    
    }
}
