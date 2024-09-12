package org.mogul.member.service;

import org.mogul.member.dto.ChangePasswordDTO;
import org.mogul.member.dto.MemberDTO;
import org.mogul.member.dto.MemberJoinDTO;
import org.mogul.member.dto.MemberUpdateDTO;

public interface MemberService {
    boolean checkDuplicate(String username);

    MemberDTO get(String username);

    MemberDTO join(MemberJoinDTO member);

    MemberDTO update(MemberUpdateDTO member);

    void changePassword(ChangePasswordDTO changePassword);
}