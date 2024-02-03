package kr.co.ooweat.coupon.application.dto;

import kr.co.ooweat.common.BaseTimeEntity;
import kr.co.ooweat.coupon.domain.CouponConfig;
import lombok.Getter;

@Getter
public class ConfigRequest extends BaseTimeEntity {
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
    
    public ConfigRequest(final CouponConfig couponConfig){
        this.seq = couponConfig.getSeq();
        this.companySeq = couponConfig.getCompanySeq();
        this.paymentType = couponConfig.getPaymentType();
        this.remainPoint = couponConfig.getRemainPoint();
        this.issuanceLimitDays = couponConfig.getIssuanceLimitDays();
        this.fixedUsableCount = couponConfig.getFixedUsableCount();
        this.fixedIssuanceAmount = couponConfig.getFixedIssuanceAmount();
        this.merchantName = couponConfig.getMerchantName();
        this.binCode = couponConfig.getBinCode();
        this.useYn = couponConfig.getUseYn();
    }
    
    public ConfigRequest(final Long seq, final Long companySeq, final Long organSeq,
        final char paymentType, final String remainPoint, final String issuanceLimitDays,
        final String fixedUsableCount, final String fixedIssuanceAmount, final String merchantName,
        final String binCode, final char useYn) {
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
    
    /* Test Case*/
    public ConfigRequest(ConfigResponse configResponse) {
        this.seq = configResponse.getSeq();
        this.companySeq = configResponse.getCompanySeq();
        this.organSeq = configResponse.getOrganSeq();
        this.paymentType = configResponse.getPaymentType();
        this.remainPoint = configResponse.getRemainPoint();
        this.issuanceLimitDays = configResponse.getIssuanceLimitDays();
        this.fixedUsableCount = configResponse.getFixedUsableCount();
        this.fixedIssuanceAmount = configResponse.getFixedIssuanceAmount();
        this.merchantName = configResponse.getMerchantName();
        this.binCode = configResponse.getBinCode();
        this.useYn = configResponse.getUseYn();
    }
}
