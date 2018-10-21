package com.liuz.bplan.service.impl.bplan;

import com.github.pagehelper.Page;
import com.liuz.bplan.model.bplan.FeedRecord;
import com.liuz.bplan.model.bplan.FeedRecordRequest;

import java.util.List;

/**
 * Bplan服务接口定义
 */
public interface BplanService {
    public int insert(FeedRecord record);
    public Page<FeedRecord> list(FeedRecordRequest query);
}
