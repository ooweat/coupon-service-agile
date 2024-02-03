INSERT INTO TB_COMPANY (NAME)
VALUES ('코레일유통');

-- 조직 Depth 의  타이틀을 위함
INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 0, 0, 0, '본부');

INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 0, 0, 1, '서울본부');
INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 0, 0, 1, '경기본부');
INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 0, 0, 1, '인천본부');

INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 1, 1, 0, '역사');
INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 1, 1, 1, '서울역');
INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 1, 1, 1, '용산역');
INSERT INTO TB_ORGANIZATION (COMPANY_SEQ, PARENT_SEQ, DEPTH, SORT, NAME)
VALUES (1, 1, 1, 1, '구로역');

-- 시스템 관리자용
INSERT INTO TB_COUPON_CONFIG (COMPANY_SEQ, ORGAN_SEQ, PAYMENT_TYPE, REMAIN_POINT,
                              ISSUANCE_LIMIT_DAYS, FIXED_USABLE_COUNT, FIXED_ISSUANCE_AMOUNT,
                              MERCHANT_NAME, BIN_CODE, USE_YN, CREATE_DATE)
VALUES ( 0, 0, 'D', 100000, 90, 100, 1000000, '시스템관리자', '000000', 'Y', NOW());

-- 선불제를 사용하는 경우
INSERT INTO TB_COUPON_CONFIG (COMPANY_SEQ, ORGAN_SEQ, PAYMENT_TYPE, REMAIN_POINT,
                              ISSUANCE_LIMIT_DAYS, FIXED_USABLE_COUNT, FIXED_ISSUANCE_AMOUNT,
                              MERCHANT_NAME, BIN_CODE, USE_YN, CREATE_DATE)
VALUES ( 1, 1, 'P', 100000, 90, 1, 10000, '선불제 조직', '525252', 'Y', NOW());

-- 후불제를 사용하는 경우
INSERT INTO TB_COUPON_CONFIG (COMPANY_SEQ, ORGAN_SEQ, PAYMENT_TYPE, REMAIN_POINT,
                              ISSUANCE_LIMIT_DAYS, FIXED_USABLE_COUNT, FIXED_ISSUANCE_AMOUNT,
                              MERCHANT_NAME, BIN_CODE, USE_YN, CREATE_DATE)
VALUES ( 1, 2, 'D',0,  90, 1, 10000, '후불제 조직', '525253', 'Y', NOW());

-- 시스템관리자
INSERT INTO TB_MEMBER (COMPANY_SEQ, ORGAN_SEQ, AUTH_SEQ, ID, PASSWORD, NAME, PHONE, EMAIL)
VALUES (0, 0, 0, 'ooweat', MD5('ooweat!@#$'), 'ooweat', '010-0000-0000', 'ooweat@kakao.com');

-- 본사 관리자
INSERT INTO TB_MEMBER (COMPANY_SEQ, ORGAN_SEQ, AUTH_SEQ, ID, PASSWORD, NAME, PHONE, EMAIL)
VALUES (1, 1, 0, 'korail', MD5('korail!@#$'), 'korail', '010-0000-0000', 'korail@korail.com');

-- 분사 관리자
INSERT INTO TB_MEMBER (COMPANY_SEQ, ORGAN_SEQ, AUTH_SEQ, ID, PASSWORD, NAME, PHONE, EMAIL)
VALUES (1, 2, 0, 'korailseoul', MD5('korail!@#$'), '코레일 서울본부', '010-0000-0000', 'seoul@korail.com');

-- 운영자
INSERT INTO TB_MEMBER (COMPANY_SEQ, ORGAN_SEQ, AUTH_SEQ, ID, PASSWORD, NAME, PHONE, EMAIL)
VALUES (1, 8, 0, 'korailguro', MD5('korail!@#$'), '구로역', '010-0000-0000', 'guro@korail.com');

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 1, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 2, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 3, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 4, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);


INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 5, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 6, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 7, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);

INSERT INTO TB_COUPON_ISSUANCE (COMPANY_SEQ, ORGAN_SEQ, MEMBER_SEQ, ISSUANCE_DATE, EXPIRE_DATE,
                                COUPON_NO,
                                ISSUANCE_AMOUNT, REMAIN_AMOUNT, REMAIN_COUNT, STATUS, SEND_TYPE,
                                SEND_INFO, SEND_COUNT)
VALUES (1, 8, 1, DATE_FORMAT(CURRENT_DATE(), '%Y%m%d'), '20241231', '1234567890123456',
        10000, 10000, 1, 'N', 'K',
        '010-1234-5678', 1);
