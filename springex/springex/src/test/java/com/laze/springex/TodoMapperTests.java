package com.laze.springex;

import com.laze.springex.domain.TodoVO;
import com.laze.springex.dto.PageRequestDTO;
import com.laze.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder()
                .title("스프링테스트")
                .dueDate(LocalDate.of(2024,12,22))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectone() {
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info(todoVO);
    }

    @Test
    public void testSelectList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t", "W"})
                .keyword("스프링")
                .finished(true)
                .from(LocalDate.of(2024,12,29))
                .to(LocalDate.of(2025,12,25))
                .build();


        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));

        log.info(todoMapper.getCount(pageRequestDTO));
    }
}
