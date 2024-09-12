package org.mogul.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mogul.common.UploadFiles;
import org.mogul.member.dto.ChangePasswordDTO;
import org.mogul.member.dto.MemberDTO;
import org.mogul.member.dto.MemberJoinDTO;
import org.mogul.member.dto.MemberUpdateDTO;
import org.mogul.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    // /api/member/checkusername/sangyeop0715
    final MemberService service;

    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) { // unsername = sangyeop0715
        return ResponseEntity.ok().body(service.checkDuplicate(username)); // sangyeop0715
    }

    @PostMapping("")
    //   데이터를 받아먹는 다고 맹목적으로 @RequestBody을 달아버리면 안된다. 이 경우에는 json이 아니라 멀티파트+폼 데이터이기 때문
    // 그리고 클라이언트에서 멀티파트폼 데이터로 제대로 보내줘야, 받아먹을 수 있다. axios.post 요청 날리는 부분 참고
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member) {
        MemberDTO memberDTo = service.join(member);
        return ResponseEntity.ok(memberDTo);
//        return ResponseEntity.ok(service.join(member));
    }

    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response) {
        String avatarPath = "c:/upload/avatar/" + username + ".png";
        File file = new File(avatarPath);
        if (!file.exists()) { // 아바타 등록이 없는 경우, 디폴트 아바타 이미지 사용
            file = new File("C:/upload/avatar/unknown.png");
        }
        UploadFiles.downloadImage(response, file);
    }

    @PutMapping("/{username}")
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {
        return ResponseEntity.ok(service.update(member));
    }

    @PutMapping("/{username}/changepassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        service.changePassword(changePasswordDTO);
        return ResponseEntity.ok().build();
    }


}