package com.liuz.bplan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Ajax请求结果
 */
public class AjaxResponse<T> {
    private boolean success;
    private String message;
    private T row;
    private List<T> rows;
    private long total;

    @Override
    public String toString() {
        return "AjaxResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", row=" + row +
                ", rows=" + rows +
                ", total=" + total +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRow() {
        return row;
    }

    public void setRow(T row) {
        this.row = row;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public static class AjaxResponseBuild<T> {
        private boolean success;
        private String message;
        private T row;
        private List<T> rows;
        private long total;

        public AjaxResponseBuild setMessage(String message) {
            this.message = message;
            return this;
        }

        public AjaxResponseBuild setData(T row) {
            this.row = row;
            return this;
        }

        public AjaxResponseBuild setTotal(long total) {
            this.total = total;
            return this;
        }

        public AjaxResponseBuild appendData(T row) {
            if (row == null) {
                return this;
            }
            if (this.rows == null) {
                this.rows = new ArrayList<T>();
            }
            this.rows.add(row);
            return this;
        }

        public AjaxResponseBuild appendData(List<T> dataList) {
            if (dataList == null) {
                return this;
            }
            if (this.rows == null) {
                this.rows = new ArrayList<T>();
            }
            this.rows.addAll(dataList);
            return this;
        }

        public AjaxResponse buildSuccess() {
            this.success = true;
            AjaxResponse<T> result = new AjaxResponse<T>();
            result.setSuccess(success);
            result.setRow(this.row);
            result.setTotal(this.total);
            result.setRows(this.rows);
            result.setMessage(message);
            return result;
        }

        public AjaxResponse buildError() {
            this.success = false;
            AjaxResponse<T> result = new AjaxResponse<T>();
            result.setSuccess(success);
            result.setRow(this.row);
            result.setTotal(this.total);
            result.setRows(this.rows);
            result.setMessage(message);
            return result;
        }

        public AjaxResponse buildError(String message) {
            this.success = false;
            AjaxResponse<T> result = new AjaxResponse<T>();
            result.setSuccess(success);
            result.setRow(this.row);
            result.setTotal(this.total);
            result.setRows(this.rows);
            result.setMessage(message);
            return result;
        }
    }
}
