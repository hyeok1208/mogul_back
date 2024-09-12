package org.mogul.security.account.mapper;

import org.mogul.security.account.domain.MemberVO;

public interface UserDetailsMapper {
    public MemberVO get(String username);
}
