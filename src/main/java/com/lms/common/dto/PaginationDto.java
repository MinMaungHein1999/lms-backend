package com.lms.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationDto<T>{
    private List<T> data;
    private long numberOfPages;
}
