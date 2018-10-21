package com.liuz.bplan.model.bplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.thymeleaf.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class FeedRecord implements Serializable {
    private Integer id;
    private int volume;
    private boolean feedDha;
    private boolean feedVd3;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",locale = "zh", timezone = "GMT+8")
    private Date feedTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date updateTime;
    private String nutrition; // 营养类型：dha , vd3

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
        if(feedDha){
            this.nutrition = "dha";
        }
    }

    public boolean isFeedVd3() {
        return feedVd3;
    }

    public void setFeedVd3(boolean feedVd3) {
        this.feedVd3 = feedVd3;
        if(feedVd3){
            this.nutrition="vd3";
        }
    }

    public Date getFeedTime() {
        return feedTime;
    }

    public void setFeedTime(Date feedTime) {
        this.feedTime = feedTime;
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
        if(!StringUtils.isEmpty(nutrition)){
            if("dha".equalsIgnoreCase(nutrition)){
                feedDha = true;
            }else if("vd3".equalsIgnoreCase(nutrition)){
                feedVd3 = true;
            }
        }else{
            feedDha = false;
            feedVd3 = false;
        }
    }

    @Override
    public String toString() {
        return "FeedRecord{" +
                "id=" + id +
                ", volume=" + volume +
                ", feedDha=" + feedDha +
                ", feedVd3=" + feedVd3 +
                ", feedTime=" + feedTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", nutrition='" + nutrition + '\'' +
                '}';
    }
}
