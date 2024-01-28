CREATE TABLE TB_COUPON_CONFIG
(
    SEQ                   MEDIUMINT AUTO_INCREMENT PRIMARY KEY COMMENT 'SEQ',
    COMPANY_SEQ           MEDIUMINT   NOT NULL COMMENT '소속 SEQ',
    ISSUANCE_MAX_COUNT    SMALLINT    NOT NULL DEFAULT 0 COMMENT '(한달)한도 발권 량: 0=무제한',
    ISSUANCE_MAX_AMOUNT   MEDIUMINT   NOT NULL DEFAULT 0 COMMENT '(한달)한도 발권 금액: 0=무제한',
    ISSUANCE_LIMIT_DAYS   SMALLINT    NOT NULL DEFAULT 30 COMMENT '(기본값)유효기간 (발급일로부터 +n일)',
    FIXED_USABLE_COUNT    TINYINT     NOT NULL DEFAULT 1 COMMENT '기본값 쿠폰 사용 가능 횟수',
    FIXED_ISSUANCE_AMOUNT MEDIUMINT   NULL COMMENT '기본값 발권 금액',
    MERCHANT_NAME         VARCHAR(50) NULL COMMENT '쿠폰에 표기될 사용처 명칭',
    BIN_CODE              VARCHAR(6)           DEFAULT '525252' NOT NULL COMMENT '쿠폰 BIN CODE',
    USE_YN                CHAR        NOT NULL DEFAULT 'Y' COMMENT '사용여부',
    CREATE_DATE           DATETIME             DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '생성일자',
    MODIFY_DATE           DATETIME    NULL COMMENT '수정일자'
) COMMENT '쿠폰발행규칙: 한도지정' COLLATE = UTF8MB4_GENERAL_CI;
CREATE INDEX IDX_TB_COUPON_CONFIG01
    ON TB_COUPON_CONFIG (COMPANY_SEQ);
CREATE TABLE TB_MEMBER
(
    SEQ         MEDIUMINT AUTO_INCREMENT COMMENT 'SEQ' PRIMARY KEY COMMENT 'SEQ',
    COMPANY_SEQ MEDIUMINT    NOT NULL COMMENT '소속 SEQ',
    ORGAN_SEQ   MEDIUMINT    NOT NULL COMMENT '조직 SEQ',
    AUTH_SEQ    SMALLINT     NOT NULL COMMENT '권한 SEQ',
    ID          VARCHAR(20)  NOT NULL,
    PASSWORD    VARCHAR(100) NOT NULL,
    NAME        VARCHAR(20)  NOT NULL,
    PHONE       VARCHAR(20)  NULL,
    EMAIL       VARCHAR(50)  NULL,
    USE_YN      CHAR         NOT NULL DEFAULT 'Y' COMMENT '사용여부',
    CREATE_DATE DATETIME              DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '생성일자',
    MODIFY_DATE DATETIME     NULL COMMENT '등록일자'
) COMMENT '사용자' COLLATE = UTF8MB4_GENERAL_CI;
CREATE INDEX IDX_TB_MEMBER01
    ON TB_MEMBER (COMPANY_SEQ);
CREATE INDEX IDX_TB_MEMBER02
    ON TB_MEMBER (ORGAN_SEQ);
CREATE INDEX IDX_TB_MEMBER03
    ON TB_MEMBER (AUTH_SEQ);
CREATE TABLE TB_COUPON_ISSUANCE
(
    SEQ             MEDIUMINT AUTO_INCREMENT COMMENT 'SEQ' PRIMARY KEY,
    COMPANY_SEQ     MEDIUMINT                             NOT NULL COMMENT '소속 SEQ',
    MEMBER_SEQ      MEDIUMINT                             NOT NULL COMMENT 'TB_MEMBER 의 SEQ',
    ISSUANCE_DATE   VARCHAR(8)                            NOT NULL COMMENT '발권일자: YYYYMMDD',
    EXPIRE_DATE     VARCHAR(8)                            NOT NULL COMMENT '만료일자: YYYYMMDD',
    COUPON_NO       VARCHAR(100)                          NOT NULL COMMENT '쿠폰번호: 난수 포함 20자리',
    ISSUANCE_AMOUNT MEDIUMINT DEFAULT 0                   NOT NULL COMMENT '발권금액',
    REMAIN_AMOUNT   MEDIUMINT DEFAULT 0                   NOT NULL COMMENT '잔여금액',
    REMAIN_COUNT    SMALLINT  DEFAULT 0                   NOT NULL COMMENT '잔여사용가능횟수',
    STATUS          CHAR      DEFAULT 'N'                 NOT NULL COMMENT '쿠폰상태:
	: N - NORMAL 정상
	  L - LOCK      잠금
	  E - EXPIRE    만료
	  U - USE 사용
	  H - Hide 숨김(제거)',
    SEND_TYPE       CHAR      DEFAULT 'M'                 NOT NULL COMMENT '발송타입: M - 메일 / S - SMS / K - 카카오톡',
    SEND_INFO       VARCHAR(200)                          NULL COMMENT '수신정보: 암호화',
    SEND_COUNT      SMALLINT  DEFAULT 1                   NOT NULL COMMENT '알림톡 발송횟수: 발행시 기본 1',
    CREATE_DATE     DATETIME  DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '생성일자',
    MODIFY_DATE     DATETIME                              NULL COMMENT '수정일자',
    CONSTRAINT UIX_TB_COUPON_ISSUANCE
        UNIQUE (COUPON_NO)
) COMMENT '쿠폰발권내역 ' COLLATE = UTF8MB4_GENERAL_CI;
CREATE INDEX IDX_TB_COUPON_ISSUANCE01
    ON TB_COUPON_ISSUANCE (COMPANY_SEQ);
CREATE INDEX IDX_TB_COUPON_ISSUANCE02
    ON TB_COUPON_ISSUANCE (MEMBER_SEQ);
CREATE INDEX IDX_TB_COUPON_ISSUANCE03
    ON TB_COUPON_ISSUANCE (ISSUANCE_DATE);
CREATE INDEX IDX_TB_COUPON_ISSUANCE04
    ON TB_COUPON_ISSUANCE (EXPIRE_DATE);

CREATE TABLE TB_COMPANY
(
    SEQ         MEDIUMINT AUTO_INCREMENT PRIMARY KEY COMMENT 'SEQ',
    NAME        VARCHAR(50) COLLATE UTF8MB3_BIN NOT NULL COMMENT '소속명',
    USE_YN      CHAR                            NOT NULL DEFAULT 'Y' COMMENT '사용여부',
    CREATE_DATE DATETIME                                 DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '생성일자',
    MODIFY_DATE DATETIME                        NULL COMMENT '수정일자'
) COMMENT '소속' COLLATE = UTF8MB4_GENERAL_CI;


CREATE TABLE TB_ORGANIZATION
(
    SEQ         MEDIUMINT AUTO_INCREMENT PRIMARY KEY COMMENT 'SEQ',
    COMPANY_SEQ DECIMAL(15) NOT NULL COMMENT '소속 SEQ',
    PARENT_SEQ  DECIMAL(15) NOT NULL COMMENT '상위조직 등록번호',
    DEPTH       DECIMAL(4)  NOT NULL COMMENT '깊이',
    SORT        DECIMAL(1)  NOT NULL COMMENT '정렬 (0/1, 타이틀/리스트)',
    NAME        VARCHAR(50) NOT NULL COMMENT '조직명',
    USE_YN      CHAR        NOT NULL DEFAULT 'Y' COMMENT '사용여부',
    CREATE_DATE DATETIME             DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '생성일자',
    MODIFY_DATE DATETIME    NULL COMMENT '수정일자'
) COMMENT '조직' COLLATE = UTF8MB4_GENERAL_CI;
CREATE INDEX IX_ORGAN_COMPANY_SEQ
    ON TB_ORGANIZATION (COMPANY_SEQ);
CREATE INDEX IX_ORGAN_DEPTH
    ON TB_ORGANIZATION (DEPTH);
CREATE INDEX IX_ORGAN_PARENT_SEQ
    ON TB_ORGANIZATION (PARENT_SEQ);
CREATE INDEX IX_ORGAN_SORT
    ON TB_ORGANIZATION (SORT);

CREATE TABLE TB_AUTH
(
    SEQ         MEDIUMINT AUTO_INCREMENT PRIMARY KEY COMMENT 'SEQ',
    COMPANY_SEQ MEDIUMINT NOT NULL COMMENT '소속 SEQ',
    ROLES       CHAR(1)   NOT NULL COMMENT '권한 (S:시스템, A:관리자, M:매니저, G:게스트)',
    USE_YN      CHAR(1)   NOT NULL DEFAULT 'Y' COMMENT '사용여부',
    CREATE_DATE DATETIME           DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '생성일자',
    MODIFY_DATE DATETIME  NULL COMMENT '수정일자'
) COMMENT '소속' COLLATE = UTF8MB4_GENERAL_CI;
