package kr.co.ooweat.coupon.application.dto;

import kr.co.ooweat.coupon.domain.CouponConfig;
import lombok.Getter;

@Getter
public class ConfigResponse {
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
    
    private ConfigResponse(){
    
    }
    
    public ConfigResponse(final CouponConfig couponConfig){
        this.seq = couponConfig.getSeq();
        this.companySeq = couponConfig.getCompanySeq();
        this.issuanceMaxCount = couponConfig.getIssuanceMaxCount();
        this.issuanceMaxAmount = couponConfig.getIssuanceMaxAmount();
        this.issuanceMaxValidity = couponConfig.getIssuanceMaxValidity();
        this.fixedUsableCount = couponConfig.getFixedUsableCount();
        this.fixedIssuanceAmount = couponConfig.getFixedIssuanceAmount();
        this.merchantName = couponConfig.getMerchantName();
        this.sendCount = couponConfig.getSendCount();
        this.useYn = couponConfig.getUseYn();
    }
}
