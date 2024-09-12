package org.mogul.board.service;

import org.mogul.board.domain.BoardAttachmentVO;
import org.mogul.board.dto.BoardDTO;
import org.mogul.common.pagination.Page;
import org.mogul.common.pagination.PageRequest;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    public BoardDTO create(BoardDTO board);

    public BoardDTO update(BoardDTO board);

    public BoardDTO delete(Long no);

    public BoardAttachmentVO getAttachment(Long no);

    public boolean deleteAttachment(Long no);

    Page<BoardDTO> getPage(PageRequest pageRequest);
}
