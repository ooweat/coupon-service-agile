package kr.co.ooweat.coupon.application.dto;

import kr.co.ooweat.common.BaseTimeEntity;
import kr.co.ooweat.coupon.domain.CouponConfig;
import lombok.Getter;

@Getter
public class IssuanceRequest extends BaseTimeEntity {
    private Long companySeq;
    private Long memberSeq;
    private String binCode;
    private Long issuanceAmount;
    private Long remainAmount;
    private int remainCount;
    private String expireDate;
    private char status;
    private char sendType;
    private String sendInfo;
    private int sendCount;
    
    public IssuanceRequest(Long companySeq, Long memberSeq, String binCode, String expireDate,
        Long issuanceAmount, Long remainAmount, int remainCount, char status, char sendType,
        String sendInfo, int sendCount) {
        this.companySeq = companySeq;
        this.memberSeq = memberSeq;
        this.binCode = binCode;
        this.issuanceAmount = issuanceAmount;
        this.remainAmount = remainAmount;
        this.remainCount = remainCount;
        this.expireDate = expireDate;
        this.status = status;
        this.sendType = sendType;
        this.sendInfo = sendInfo;
        this.sendCount = sendCount;
    }
}
