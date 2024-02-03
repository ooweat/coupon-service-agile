package kr.co.ooweat.coupon.domain;

import kr.co.ooweat.common.BaseTimeEntity;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponConfig extends BaseTimeEntity {
    
    private Long seq;
    private Long companySeq;
    private Long organSeq;
    private char paymentType;
    private String remainPoint;
    private String issuanceLimitDays;
    private String fixedUsableCount;
    private String fixedIssuanceAmount;
    private String merchantName;
    private String binCode;
    private char useYn;
    
    public CouponConfig(ConfigRequest configRequest) {
        this.seq = configRequest.getSeq();
        this.companySeq = configRequest.getCompanySeq();
        this.organSeq = configRequest.getOrganSeq();
        this.paymentType = configRequest.getPaymentType();
        this.remainPoint = configRequest.getRemainPoint();
        this.issuanceLimitDays = configRequest.getIssuanceLimitDays();
        this.fixedUsableCount = configRequest.getFixedUsableCount();
        this.fixedIssuanceAmount = configRequest.getFixedIssuanceAmount();
        this.merchantName = configRequest.getMerchantName();
        this.binCode = configRequest.getBinCode();
        this.useYn = configRequest.getUseYn();
    }
}
