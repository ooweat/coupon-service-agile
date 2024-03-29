package kr.co.ooweat.auth.mappers;

import kr.co.ooweat.auth.domain.Auth;
import kr.co.ooweat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    Member findAllByMember(String userId, String userPass);
    boolean findByUserId(String userId);
    void save(Member member);
    Auth findByCompanySeq(Long companySeq);
}
