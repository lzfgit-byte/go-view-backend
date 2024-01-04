package cn.com.collect.controller;

import cn.com.collect.mapper.CollectMapper;
import cn.com.collect.model.Collect;
import cn.com.collect.service.ICollectService;
import cn.com.collect.service.impl.ICollectServiceImpl;
import cn.com.v2.common.domain.AjaxResult;
import cn.com.v2.util.SaTokenUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goview/collect")
public class CollectController {

    @Autowired
    ICollectService iCollectService;

    @PostMapping("/addCollect")
    public AjaxResult addCollect(@RequestBody Collect collect){
        collect.setId(IdWorker.getIdStr());
        collect.setUserId("1");
        iCollectService.save(collect);
        return AjaxResult.success();
    }

    @GetMapping("/listCollect")
    public AjaxResult getCollect(){
        LambdaQueryWrapper<Collect> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Collect::getUserId,"1");
        List<Collect> list = iCollectService.list(lqw);
        return AjaxResult.successData(200,list);
    }
    @PostMapping("/deleteCollect")
    public AjaxResult deleteCollect(@RequestBody Collect collect){
        LambdaQueryWrapper<Collect> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Collect::getUserId,"1");
        lqw.eq(Collect::getValue,collect.getValue());
        boolean remove = iCollectService.remove(lqw);
        return remove ? AjaxResult.success() : AjaxResult.error();
    }
}
