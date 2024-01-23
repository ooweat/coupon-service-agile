package kr.co.ooweat.mappers;

import kr.co.ooweat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    Member findAllByMember(String userId, String userPass);
}
