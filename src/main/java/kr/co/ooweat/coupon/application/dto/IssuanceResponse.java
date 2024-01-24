package kr.co.ooweat.coupon.application.dto;

import lombok.Getter;

@Getter
public class IssuanceResponse {
    private String issuanceDate;
    private String expireDate;
    private String couponNo;
    private String issuanceAmount;
    private String remainAmount;
    private String remainCount;
    private char status;
    private char sendType;
    private String sendInfo;
    private Long sendCount;
    
}
