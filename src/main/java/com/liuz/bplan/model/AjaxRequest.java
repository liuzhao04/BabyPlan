package com.liuz.bplan.model;

/**
 * 前台请求参数
 */
public class AjaxRequest {
    // 页索引
    private Integer pageIndex = 1;
    // 页大小，即每页显示的记录数量
    private Integer pageSize = 10;
    // 排序字段
    private String sortName;
    // 排序类型
    private String sortOrder;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "AjaxRequest{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortName='" + sortName + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
