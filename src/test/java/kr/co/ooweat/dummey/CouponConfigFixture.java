package kr.co.ooweat.dummey;

import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import lombok.Getter;

@Getter
public enum CouponConfigFixture {

    COMPANY_1(1L, 1L, 1L, 'P', 100000L,
            90, 1, 10000L, "ooweat", "525252", 'Y'),
    COMPANY_2(2L, 2L, 1L, 'D', 0L,
            30, 1, 10000L,
            "ooweat", "525252", 'Y'),
    ;

    private final Long seq;
    private final Long companySeq;
    private final Long organSeq;
    private final char paymentType;
    private final Long remainPoint;
    private final int issuanceLimitDays;
    private final int fixedUsableCount;
    private final Long fixedIssuanceAmount;
    private final String merchantName;
    private final String binCode;
    private final char useYn;

    CouponConfigFixture(Long seq, Long companySeq, Long organSeq, char paymentType,
                        Long remainPoint, int issuanceLimitDays, int fixedUsableCount,
                        Long fixedIssuanceAmount, String merchantName, String binCode, char useYn) {
        this.seq = seq;
        this.companySeq = companySeq;
        this.organSeq = organSeq;
        this.paymentType = paymentType;
        this.remainPoint = remainPoint;
        this.issuanceLimitDays = issuanceLimitDays;
        this.fixedUsableCount = fixedUsableCount;
        this.fixedIssuanceAmount = fixedIssuanceAmount;
        this.merchantName = merchantName;
        this.binCode = binCode;
        this.useYn = useYn;
    }

    public ConfigRequest createCouponConfig() {
        ConfigRequest configRequest = new ConfigRequest(seq, companySeq, organSeq, paymentType,
                remainPoint, issuanceLimitDays, fixedUsableCount,
                fixedIssuanceAmount, merchantName, binCode, useYn);
        return configRequest;
    }
}
