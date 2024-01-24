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
    private String issuanceMaxCount;
    private String issuanceMaxAmount;
    private String issuanceMaxValidity;
    private String fixedUsableCount;
    private String fixedIssuanceAmount;
    private String merchantName;
    private String sendCount;
    private char useYn;
    
    public CouponConfig(ConfigRequest configRequest) {
        this.seq = configRequest.getSeq();
        this.companySeq = configRequest.getCompanySeq();
        this.issuanceMaxCount = configRequest.getIssuanceMaxCount();
        this.issuanceMaxAmount = configRequest.getIssuanceMaxAmount();
        this.issuanceMaxValidity = configRequest.getIssuanceMaxValidity();
        this.fixedUsableCount = configRequest.getFixedUsableCount();
        this.fixedIssuanceAmount = configRequest.getFixedIssuanceAmount();
        this.merchantName = configRequest.getMerchantName();
        this.sendCount = configRequest.getSendCount();
        this.useYn = configRequest.getUseYn();
    }
}
