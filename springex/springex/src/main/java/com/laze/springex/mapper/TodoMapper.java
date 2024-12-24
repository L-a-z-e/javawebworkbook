package com.laze.springex.mapper;

import com.laze.springex.domain.TodoVO;
import com.laze.springex.dto.PageRequestDTO;
import com.laze.springex.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
