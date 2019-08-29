package com.city.management.collection.model.query;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PageQuery implements Serializable {
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;
    @ApiModelProperty(value = "页数",required = true)
    private Integer pageNo;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getOffset() {
        if(null != pageSize && null != pageNo) {
            return pageSize * (pageNo - 1);
        }
        return 0;
    }
}
