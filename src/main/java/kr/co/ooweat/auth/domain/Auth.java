package kr.co.ooweat.auth.domain;

import kr.co.ooweat.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Auth extends BaseTimeEntity {
    private Long seq;
    private char roles;
}