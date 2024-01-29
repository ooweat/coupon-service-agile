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

INSERT INTO TB_COUPON_CONFIG (SEQ, COMPANY_SEQ, ORGAN_SEQ, ISSUANCE_MAX_COUNT, ISSUANCE_MAX_AMOUNT,
                              ISSUANCE_LIMIT_DAYS, FIXED_USABLE_COUNT, FIXED_ISSUANCE_AMOUNT,
                              MERCHANT_NAME, BIN_CODE, USE_YN, CREATE_DATE)
VALUES (1, 1, 1, 100, 10000, 90, 1, 10000, 'ooweat', '525252', 'Y', NOW());

INSERT INTO TB_MEMBER (COMPANY_SEQ, ORGAN_SEQ, AUTH_SEQ, ID, PASSWORD, NAME, PHONE, EMAIL)
VALUES (1, 1, 0, 'ooweat', MD5('ooweat!@#$'), 'ooweat', '010-0000-0000', 'ooweat@kakao.com');

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
