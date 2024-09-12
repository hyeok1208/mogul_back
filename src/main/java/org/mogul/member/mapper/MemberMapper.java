package org.mogul.member.mapper;

import org.mogul.member.dto.ChangePasswordDTO;
import org.mogul.security.account.domain.AuthVO;
import org.mogul.security.account.domain.MemberVO;

public interface MemberMapper {
    MemberVO get(String username);

    MemberVO findByUsername(String username); // id 중복 체크시 사용

    int insert(MemberVO member); // 회원 정보 추가

    int insertAuth(AuthVO auth); // 회원 권한 정보 추가

    int update(MemberVO member);

    int updatePassword(ChangePasswordDTO changePasswordDTO);
}