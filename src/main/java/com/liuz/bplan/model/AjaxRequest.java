package com.liuz.bplan.model;

/**
 * 前台请求参数
 */
public class AjaxRequest {
    // 是否分页(0-不分页，1-分页)，如果不分页则返回全部数据,默认是分页的
    private Integer isPaging = 1;
    // 页索引
    private Integer pageIndex = 1;
    // 页大小，即每页显示的记录数量
    private Integer pageSize = 10;
    // 是否需要统计记录数(0-不 统计，1-统计)，默认统计
    private Integer isCount = 1;
    // 统计记录数
    private Integer totalCounts;
    // 排序字段
    private String sortName;
    // 排序类型
    private String sortOrder;

    public Integer getIsPaging() {
        return isPaging;
    }

    public void setIsPaging(Integer isPaging) {
        this.isPaging = isPaging;
    }

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

    public Integer getIsCount() {
        return isCount;
    }

    public void setIsCount(Integer isCount) {
        this.isCount = isCount;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
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
                "isPaging=" + isPaging +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", isCount=" + isCount +
                ", totalCounts=" + totalCounts +
                ", sortName='" + sortName + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
