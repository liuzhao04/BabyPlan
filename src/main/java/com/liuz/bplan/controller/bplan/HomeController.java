package com.liuz.bplan.controller.bplan;

import com.github.pagehelper.Page;
import com.liuz.bplan.model.AjaxResponse;
import com.liuz.bplan.model.bplan.FeedRecord;
import com.liuz.bplan.model.bplan.FeedRecordRequest;
import com.liuz.bplan.service.impl.bplan.BplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 首页控制器
 */
@Controller
@RequestMapping(value = "/bplan")
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BplanService bplanService;

    @RequestMapping(value = "/index")
    public String index() {
        return "/bplan/index";
    }

    /**
     * 插入一条喂养记录
     *
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse<String> insert(@RequestBody FeedRecord record) {
        AjaxResponse.AjaxResponseBuild build = new AjaxResponse.AjaxResponseBuild();
        logger.info("start insert a feed record : {}", record.toString());
        try {
            int cnt = bplanService.insert(record);
            if (cnt == 1) {
                logger.info("insert a feed record success : {}", record.toString());
                return build.buildSuccess();
            } else {
                logger.info("insert a feed record fail : {}", record.toString());
                return build.buildError("fail to write db");
            }
        } catch (Exception e) {
            logger.error("insert a feed record exception : {}", record.toString(), e);
            build = new AjaxResponse.AjaxResponseBuild();
            return build.buildError("exception to write db");
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse<FeedRecord> list(@RequestBody FeedRecordRequest request) {
        AjaxResponse.AjaxResponseBuild build = new AjaxResponse.AjaxResponseBuild();
        logger.info("start list  feed records : {}", request.toString());
        try {
            Page<FeedRecord> list = bplanService.list(request);
            build.appendData(list);
            build.setTotal(list.getTotal());
            return build.buildSuccess();
        } catch (Exception e) {
            logger.error("list feed records exception : {}", request.toString(), e);
            build = new AjaxResponse.AjaxResponseBuild();
            return build.buildError("exception to list feed record from db");
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse<String> delete(@RequestBody List<FeedRecordRequest> records) {
        AjaxResponse.AjaxResponseBuild build = new AjaxResponse.AjaxResponseBuild();
        logger.info("start delete a feed record : {}", records.toString());
        try {
            int cnt = bplanService.delete(records);
            if (cnt > 0 ) {
                logger.info("delete records success : {}", records.toString());
                return build.buildSuccess();
            } else {
                logger.info("delete records fail : {}", records.toString());
                return build.buildError("fail to delete db");
            }
        } catch (Exception e) {
            logger.error("delete records exception : {}", records.toString(), e);
            build = new AjaxResponse.AjaxResponseBuild();
            return build.buildError("exception to delete db");
        }
    }
}
