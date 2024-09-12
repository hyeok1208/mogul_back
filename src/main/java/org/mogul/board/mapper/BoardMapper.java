package org.mogul.board.mapper;

import org.mogul.board.domain.BoardAttachmentVO;
import org.mogul.board.domain.BoardVO;
import org.mogul.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {

    public List<BoardVO> getList();

    public BoardVO get(Long no);

    public void create(BoardVO board);

    public int update(BoardVO board);

    public int delete(Long no);

    public void createAttachment(BoardAttachmentVO attach);

    public List<BoardAttachmentVO> getAttachmentList(Long bno);

    public BoardAttachmentVO getAttachment(Long no);

    public int deleteAttachment(Long no);

    int getTotalCount();

    List<BoardVO> getPage(PageRequest pageRequest);

}
