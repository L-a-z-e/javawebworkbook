package com.laze.w1.dao;

import com.laze.w1.todo.dao.TodoDAO;
import com.laze.w1.todo.dto.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTest {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {

        todoDAO = new TodoDAO();

    }

    @Test
    public void testTime() throws Exception {

        System.out.println(todoDAO.getTime());

    }

    @Test
    public void testTime2() throws Exception {

        System.out.println(todoDAO.getTime2());

    }

    @Test
    public void testInsert() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .title("insert test title")
                .dueDate(LocalDate.of(2024,12,14))
                .build();

        todoDAO.insert(todoVO);

    }

    @Test
    public void testSelectAll() throws Exception {

        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(System.out::println);

    }

    @Test
    public void testSelectOne() throws Exception {

        Long tno = 4L;

        TodoVO todoVO = todoDAO.selectOne(tno);
        System.out.println(todoVO);

    }

    @Test
    public void testUpdate() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .tno(4L)
                .title("sample title update test")
                .dueDate(LocalDate.of(2025,1,1))
                .finished(false)
                .build();

        todoDAO.updateOne(todoVO);

    }

    @Test
    public void testDelete() throws Exception {

        Long tno = 4L;

        todoDAO.deleteOne(tno);

    }

}
