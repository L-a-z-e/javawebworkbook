package com.laze.bootex.repository.search;

import com.laze.bootex.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    Page<Board> search1(Pageable pageable);

    Page<Board> serachAll(String [] types, String keyword, Pageable pageable);

}
