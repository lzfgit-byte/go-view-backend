package cn.com.collect.controller;

import cn.com.collect.mapper.CollectMapper;
import cn.com.collect.model.Collect;
import cn.com.collect.service.ICollectService;
import cn.com.collect.service.impl.ICollectServiceImpl;
import cn.com.v2.common.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goview/collect")
public class CollectController {

    @Autowired
    ICollectService iCollectService;

    @PostMapping("/addCollect")
    public AjaxResult addCollect(Collect collect){
        return null;
    }

    @GetMapping("/listCollect")
    public AjaxResult getCollect(){
        return null;
    }
}
