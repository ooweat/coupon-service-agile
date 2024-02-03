package kr.co.ooweat.coupon.application.dto;

import kr.co.ooweat.common.BaseTimeEntity;
import lombok.Getter;

@Getter
public class IssuanceRequest extends BaseTimeEntity {
    
    private Long companySeq;
    private Long organSeq;
    private Long memberSeq;
    private String binCode;
    private char couponType;
    private Long issuanceAmount;
    private Long remainAmount;
    private int remainCount;
    private String expireDate;
    private char status;
    private char sendType;
    private String sendInfo;
    private int sendCount;
    private String startDate;
    private String endDate;
    
    public IssuanceRequest(final Long companySeq, final Long organSeq, final char couponType,
        final char sendType, final String sendInfo, final String startDate, final String endDate) {
        this.companySeq = companySeq;
        this.organSeq = organSeq;
        this.couponType = couponType;
        this.sendType = sendType;
        this.sendInfo = sendInfo;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public IssuanceRequest(char status, String couponNo) {
        this.status = status;
        this.binCode = couponNo;
    }
    
    public IssuanceRequest(Long companySeq, Long organSeq, Long memberSeq, String binCode, char couponType,
        String expireDate, long issuanceAmount, long remainAmount, int remainCount,
        char status, char sendType, String sendInfo) {
        this.companySeq = companySeq;
        this.organSeq = organSeq;
        this.memberSeq = memberSeq;
        this.binCode = binCode;
        this.couponType = couponType;
        this.expireDate = expireDate;
        this.issuanceAmount = issuanceAmount;
        this.remainAmount = remainAmount;
        this.remainCount = remainCount;
        this.status = status;
        this.sendType = sendType;
        this.sendInfo = sendInfo;
    }
}
