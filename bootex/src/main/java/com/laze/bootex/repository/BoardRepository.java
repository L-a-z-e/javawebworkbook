package com.laze.bootex.repository;

import com.laze.bootex.domain.Board;
import com.laze.bootex.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
//
//{
//    Page<Board> findByTitleContainingOrderByBnoDesc(String keyword, Pageable pageable);
//
//    @Query("select b from Board b where b.title like concat('%', :keyword, '%')")
//    Page<Board> findKeyword(String keyword, Pageable pageable);
//
//    @Query(value = "select now()", nativeQuery = true)
//    String getTime();
//}
