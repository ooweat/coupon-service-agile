package kr.co.ooweat.coupon.domain;

import kr.co.ooweat.common.BaseTimeEntity;
import lombok.Getter;

@Getter
public class CouponConfig extends BaseTimeEntity {
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
}
