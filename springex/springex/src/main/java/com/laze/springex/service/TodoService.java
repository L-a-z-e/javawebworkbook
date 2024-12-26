package com.laze.springex.service;

import com.laze.springex.dto.PageRequestDTO;
import com.laze.springex.dto.PageResponseDTO;
import com.laze.springex.dto.TodoDTO;

public interface TodoService {

    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);

}
