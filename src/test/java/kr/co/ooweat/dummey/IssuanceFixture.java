package kr.co.ooweat.dummey;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public enum IssuanceFixture {
    ISSUANCE_1(1L, 1L,
        1L, "525252",
        LocalDate.now().plusDays(90).format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")),
        10000L, 10000L,
        1, 'N',
        'K', "010-1234-5678",
        1),
    ;
    
    private final long companySeq;
    private final Long organSeq;
    private final long memberSeq;
    private final String binCode;
    private final String expireDate;
    private final long issuanceAmount;
    private final long remainAmount;
    private final int remainCount;
    private final char status;
    private final char sendType;
    private final String sendInfo;
    private final int sendCount;
    
    
    IssuanceFixture(long companySeq, long organSeq, long memberSeq, String binCode, String expireDate,
        long issuanceAmount, long remainAmount, int remainCount, char status, char sendType,
        String sendInfo, int sendCount) {
        this.companySeq = companySeq;
        this.organSeq = organSeq;
        this.memberSeq = memberSeq;
        this.binCode = binCode;
        this.expireDate = expireDate;
        this.issuanceAmount = issuanceAmount;
        this.remainAmount = remainAmount;
        this.remainCount = remainCount;
        this.status = status;
        this.sendType = sendType;
        this.sendInfo = sendInfo;
        this.sendCount = sendCount;
    }
}
