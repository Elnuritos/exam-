package com.example.demoexam.rest.dto;

import java.util.List;

public class PaginationDTO<T> {
    private int offset;
    private int limit;
    private long totalCount;
    private List<T> data;

    public PaginationDTO(int offset, int limit, long totalElements, List<T> content) {
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public List<T> getData() {
        return data;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
