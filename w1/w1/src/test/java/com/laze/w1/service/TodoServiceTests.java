package com.laze.w1.service;

import com.laze.w1.todo.dto.TodoDTO;
import com.laze.w1.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void setUp() throws Exception {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("model mapper test")
                .dueDate(LocalDate.now())
                .build();

        log.info("----------");
        log.info(todoDTO);
        todoService.register(todoDTO);
    }
}
