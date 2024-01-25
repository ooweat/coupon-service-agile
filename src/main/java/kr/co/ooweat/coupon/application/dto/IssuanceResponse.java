package kr.co.ooweat.coupon.application.dto;

import kr.co.ooweat.coupon.domain.Issuance;
import lombok.Getter;

@Getter
public class IssuanceResponse {
    private String issuanceDate;
    private String expireDate;
    private String couponNo;
    private Long issuanceAmount;
    private Long remainAmount;
    private int remainCount;
    private char status;
    private char sendType;
    private String sendInfo;
    private int sendCount;
    
    public IssuanceResponse(Issuance issuance) {
        this.issuanceDate = issuance.getIssuanceDate();
        this.expireDate = issuance.getExpireDate();
        this.couponNo = issuance.getCouponNo();
        this.issuanceAmount = issuance.getIssuanceAmount();
        this.remainAmount = issuance.getRemainAmount();
        this.remainCount = issuance.getRemainCount();
        this.status = issuance.getStatus();
        this.sendType = issuance.getSendType();
        this.sendInfo = issuance.getSendInfo();
        this.sendCount = issuance.getSendCount();
    }
}
