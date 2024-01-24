package kr.co.ooweat.dummey;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import lombok.Getter;

@Getter
public enum CouponConfigFixture {
    
    COMPANY_0(1L, 0L, "10", "10000",
        "30", "1", "10000",
        "ooweat", "15", 'Y');
    
    private final Long seq;
    private final Long companySeq;
    private final String issuanceMaxCount;
    private final String issuanceMaxAmount;
    private final String issuanceMaxValidity;
    private final String fixedUsableCount;
    private final String fixedIssuanceAmount;
    private final String merchantName;
    private final String sendCount;
    private final char useYn;
    
    CouponConfigFixture(Long seq, Long companySeq, String issuanceMaxCount,
        String issuanceMaxAmount, String issuanceMaxValidity, String fixedUsableCount,
        String fixedIssuanceAmount, String merchantName, String sendCount, char useYn){
        this.seq = seq;
        this.companySeq = companySeq;
    
        this.issuanceMaxCount = issuanceMaxCount;
        this.issuanceMaxAmount = issuanceMaxAmount;
        this.issuanceMaxValidity = issuanceMaxValidity;
        this.fixedUsableCount = fixedUsableCount;
        this.fixedIssuanceAmount = fixedIssuanceAmount;
        this.merchantName = merchantName;
        this.sendCount = sendCount;
        this.useYn = useYn;
    }
    
    public ConfigRequest createCouponConfig() {
        ConfigRequest configRequest = new ConfigRequest(seq, companySeq, issuanceMaxCount,
            issuanceMaxAmount, issuanceMaxValidity, fixedUsableCount,
            fixedIssuanceAmount, merchantName, sendCount, useYn);
        return configRequest;
    }
}
