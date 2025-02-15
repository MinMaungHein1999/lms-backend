package com.lms.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDto<T>{
    private List<T> data;
    private long numberOfPages;
    private boolean hasNextPage;
    private long totalRecords;
}
