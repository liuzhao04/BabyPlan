package com.liuz.bplan.dao.bplan;

import com.liuz.bplan.annotation.MyBatisDao;
import com.liuz.bplan.model.bplan.FeedRecord;
import com.liuz.bplan.model.bplan.FeedRecordRequest;

import java.util.List;

@MyBatisDao
public interface BplanDao {
    public int insert(FeedRecord record);

    public List<FeedRecord> list(FeedRecordRequest query);
}
