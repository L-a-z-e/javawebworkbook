package com.laze.w2.todo.service;

import com.laze.w2.todo.dao.TodoDAO;
import com.laze.w2.todo.dto.TodoDTO;
import com.laze.w2.todo.dto.TodoVO;
import com.laze.w2.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    public void register(TodoDTO todoDTO) throws Exception {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info("TodoService > register");
        log.info(todoVO);

        dao.insert(todoVO);

    }

    public List<TodoDTO> getTodoList() {

        List<TodoDTO> todoDTOList = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setTno((long)i);
            todoDTO.setTitle("Todo.." + i);
            todoDTO.setDueDate(LocalDate.now());

            return todoDTO;
        }).collect(Collectors.toList());

        return todoDTOList;
    }

    public TodoDTO get(Long tno) throws Exception {

        log.info("TodoService > get > tno : " + tno);
//        todoDTO.setTno(tno);
//        todoDTO.setTitle("Sample Todo");
//        todoDTO.setDueDate(LocalDate.now());
//        todoDTO.setFinished(true);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info("listAll > voList");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public void remove(Long tno) throws Exception {

        log.info("TodoService > remove > tno : " + tno);
        dao.deleteOne(tno);

    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("TodoService > modify > todoDTO : " + todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }
}
