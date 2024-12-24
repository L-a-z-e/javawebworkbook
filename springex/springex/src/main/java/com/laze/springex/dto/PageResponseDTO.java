package com.laze.springex.dto;

import lombok.Builder;

import java.util.List;

public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    private int start;
    private int end;
    private boolean prev;
    private boolean next;
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;
    }
}
