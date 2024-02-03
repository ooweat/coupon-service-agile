package kr.co.ooweat.coupon.domain;

import java.time.LocalDate;
import kr.co.ooweat.common.BaseTimeEntity;
import kr.co.ooweat.coupon.application.dto.IssuanceRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Issuance extends BaseTimeEntity {
    private Long seq;
    private Long companySeq;
    private Long organSeq;
    private Long memberSeq;
    private String issuanceDate;
    private String expireDate;
    private String couponNo;
    private char couponType;
    private Long issuanceAmount;
    private Long remainAmount;
    private int remainCount;
    private char status;
    private char sendType;  //발송타입: E- 이메일 / M - MMS / S - SMS / K - 카카오톡
    private String sendInfo;
    private int sendCount;
    private String companyName;
    private String organName;
    private String memberName;
    
    //DESC: save
    public Issuance(IssuanceRequest issuanceRequest, String couponNo) {
        this.companySeq = issuanceRequest.getCompanySeq();
        this.organSeq = issuanceRequest.getOrganSeq();
        this.memberSeq = issuanceRequest.getMemberSeq();
        this.couponNo = couponNo;
        this.couponType = issuanceRequest.getCouponType();
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
