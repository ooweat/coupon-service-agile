package kr.co.ooweat.dummey;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import lombok.Getter;

@Getter
public enum CouponConfigFixture {
    
    COMPANY_1(1L, 1L, 1L, "100", "10000",
        "90", "1", "10000", "ooweat", "525252", 'Y'),
    COMPANY_2(2L, 2L, 1L, "10", "10000",
        "30", "1", "10000",
        "ooweat", "525252", 'Y'),
    ;
    
    private final Long seq;
    private final Long companySeq;
    private final Long organSeq;
    private final String issuanceMaxCount;
    private final String issuanceMaxAmount;
    private final String issuanceLimitDays;
    private final String fixedUsableCount;
    private final String fixedIssuanceAmount;
    private final String merchantName;
    private final String binCode;
    private final char useYn;
    
    CouponConfigFixture(Long seq, Long companySeq, Long organSeq, String issuanceMaxCount,
        String issuanceMaxAmount, String issuanceLimitDays, String fixedUsableCount,
        String fixedIssuanceAmount, String merchantName, String binCode, char useYn) {
        this.seq = seq;
        this.companySeq = companySeq;
        this.organSeq = organSeq;
        this.issuanceMaxCount = issuanceMaxCount;
        this.issuanceMaxAmount = issuanceMaxAmount;
        this.issuanceLimitDays = issuanceLimitDays;
        this.fixedUsableCount = fixedUsableCount;
        this.fixedIssuanceAmount = fixedIssuanceAmount;
        this.merchantName = merchantName;
        this.binCode = binCode;
        this.useYn = useYn;
    }
    
    public ConfigRequest createCouponConfig() {
        ConfigRequest configRequest = new ConfigRequest(seq, companySeq, organSeq, issuanceMaxCount,
            issuanceMaxAmount, issuanceLimitDays, fixedUsableCount,
            fixedIssuanceAmount, merchantName, binCode, useYn);
        return configRequest;
    }
}
