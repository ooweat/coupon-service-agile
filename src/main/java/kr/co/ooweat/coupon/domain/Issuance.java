package kr.co.ooweat.coupon.domain;

import java.time.LocalDate;
import kr.co.ooweat.common.BaseTimeEntity;
import kr.co.ooweat.coupon.application.dto.ConfigRequest;
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
    private String issuanceAmount;
    private String remainAmount;
    private String remainCount;
    private char status;
    private char sendType;
    private String sendInfo;
    private Long sendCount;
    
    public Issuance(Long companySeq, Long memberSeq, ConfigRequest configRequest) {
        this.companySeq = companySeq;
        this.memberSeq = memberSeq;
        this.issuanceDate = LocalDate.now().plusDays(
                Long.parseLong(configRequest.getIssuanceLimitDays()))
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
