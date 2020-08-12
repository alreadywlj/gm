package com.gm.content.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo {

    private Integer totalPages;

    private List<?> data;

    private long totalElements;

    private Object pageable;


}
