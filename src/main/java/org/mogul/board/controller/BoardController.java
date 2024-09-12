package org.mogul.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mogul.board.domain.BoardAttachmentVO;
import org.mogul.board.dto.BoardDTO;
import org.mogul.board.service.BoardService;
import org.mogul.common.UploadFiles;
import org.mogul.common.pagination.Page;
import org.mogul.common.pagination.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService service;


    @GetMapping("")
    public ResponseEntity<Page> getList(PageRequest pageRequest) {
        return ResponseEntity.ok(service.getPage(pageRequest));
    }

//    @GetMapping("")
//    public ResponseEntity<List<BoardDTO>> getList() {
//
//        ResponseEntity<List<BoardDTO>> response = ResponseEntity.ok(service.getList());
//
//        return response;
////        return ResponseEntity.ok(service.getList());
//    }

    @GetMapping("/{no}") // 15
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    @PostMapping("")
    public ResponseEntity<BoardDTO> create(BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, BoardDTO board) {
        board.setNo(no);
        return ResponseEntity.ok(service.update(board));
    }

    @DeleteMapping("/{no}") // 11
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }

    @GetMapping("/download/{no}") // 7
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attachment = service.getAttachment(no);
        File file = new File(attachment.getPath());
        UploadFiles.download(response, file, attachment.getFilename());
    }

    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no) throws Exception {
        return ResponseEntity.ok(service.deleteAttachment(no));
    }
}