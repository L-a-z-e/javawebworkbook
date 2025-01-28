package com.laze.bootex.service;

import com.laze.bootex.dto.BoardDTO;
import com.laze.bootex.dto.PageRequestDTO;
import com.laze.bootex.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

}
