package kr.co.ooweat.coupon.application.dto;

import kr.co.ooweat.coupon.domain.CouponConfig;
import lombok.Getter;

@Getter
public class ConfigResponse {
    private Long seq;
    private Long companySeq;
    private Long organSeq;
    private char paymentType;
    private Long remainPoint;
    private int issuanceLimitDays;
    private int fixedUsableCount;
    private Long fixedIssuanceAmount;
    private String merchantName;
    private String binCode;
    private char useYn;
    
    private ConfigResponse(){
    
    }

    public ConfigResponse(final CouponConfig couponConfig){
        this.seq = couponConfig.getSeq();
        this.companySeq = couponConfig.getCompanySeq();
        this.organSeq = couponConfig.getOrganSeq();
        this.paymentType = couponConfig.getPaymentType();
        this.remainPoint = couponConfig.getRemainPoint();
        this.issuanceLimitDays = couponConfig.getIssuanceLimitDays();
        this.fixedUsableCount = couponConfig.getFixedUsableCount();
        this.fixedIssuanceAmount = couponConfig.getFixedIssuanceAmount();
        this.merchantName = couponConfig.getMerchantName();
        this.binCode = couponConfig.getBinCode();
        this.useYn = couponConfig.getUseYn();
    }

}
