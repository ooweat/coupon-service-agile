package kr.co.ooweat.coupon.domain;

import java.time.LocalDate;
import kr.co.ooweat.common.BaseTimeEntity;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Issuance extends BaseTimeEntity {
    private Long seq;
    private Long companySeq;
    private Long memberSeq;
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
    
    public Issuance(IssuanceRequest issuanceRequest, String couponNo) {
        this.companySeq = issuanceRequest.getCompanySeq();
        this.memberSeq = issuanceRequest.getMemberSeq();
        this.couponNo = couponNo;
        this.issuanceDate = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.expireDate = issuanceRequest.getExpireDate();
        this.issuanceAmount = issuanceRequest.getIssuanceAmount();
        this.remainAmount = issuanceRequest.getRemainAmount();
        this.remainCount = issuanceRequest.getRemainCount();
        this.status = issuanceRequest.getStatus();
        this.sendType = issuanceRequest.getSendType();
        this.sendInfo = issuanceRequest.getSendInfo();
        this.sendCount = issuanceRequest.getSendCount();
    }
}
