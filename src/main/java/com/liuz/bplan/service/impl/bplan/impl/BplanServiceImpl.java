package com.liuz.bplan.service.impl.bplan.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuz.bplan.dao.bplan.BplanDao;
import com.liuz.bplan.model.User;
import com.liuz.bplan.model.bplan.FeedRecord;
import com.liuz.bplan.model.bplan.FeedRecordRequest;
import com.liuz.bplan.service.impl.bplan.BplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BplanServiceImpl implements BplanService {

    @Autowired
    private BplanDao bplanDao;

    @Override
    public int insert(FeedRecord record) {
        return bplanDao.insert(record);
    }

    public Page<FeedRecord> list(FeedRecordRequest query){
        Page<FeedRecord> result = PageHelper.startPage(query.getPageIndex(),query.getPageSize());
        bplanDao.list(query);
        return result;
    }
}
