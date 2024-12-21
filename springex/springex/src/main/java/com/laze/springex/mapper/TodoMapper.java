package com.laze.springex.mapper;

import com.laze.springex.domain.TodoVO;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);
}
