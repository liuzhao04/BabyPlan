package com.liuz.bplan.model.bplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liuz.bplan.model.AjaxRequest;

import java.util.Date;

/**
 * 前台请求参数对象
 */
public class FeedRecordRequest extends AjaxRequest {
    private Integer id;
    private int volume;
    private boolean feedDha;
    private boolean feedVd3;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh", timezone = "GMT+8")
    private Date feedTimeStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh", timezone = "GMT+8")
    private Date feedTimeEnd;
    private Date createTime;
    private Date updateTime;
    private String nutrition;

    @Override
    public String toString() {
        return "FeedRecordRequest{" +
                "id=" + id +
                ", volume=" + volume +
                ", feedDha=" + feedDha +
                ", feedVd3=" + feedVd3 +
                ", feedTimeStart=" + feedTimeStart +
                ", feedTimeEnd=" + feedTimeEnd +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", nutrition='" + nutrition + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isFeedDha() {
        return feedDha;
    }

    public void setFeedDha(boolean feedDha) {
        this.feedDha = feedDha;
    }

    public boolean isFeedVd3() {
        return feedVd3;
    }

    public void setFeedVd3(boolean feedVd3) {
        this.feedVd3 = feedVd3;
    }

    public Date getFeedTimeStart() {
        return feedTimeStart;
    }

    public void setFeedTimeStart(Date feedTimeStart) {
        this.feedTimeStart = feedTimeStart;
    }

    public Date getFeedTimeEnd() {
        return feedTimeEnd;
    }

    public void setFeedTimeEnd(Date feedTimeEnd) {
        this.feedTimeEnd = feedTimeEnd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }
}
