package cn.com.testData.controller;

import cn.com.v2.common.base.BaseController;
import cn.com.v2.common.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/goview/testData")
public class TestDataController extends BaseController {

    private int count  = 0;
    @GetMapping("/get")
    public AjaxResult getTestData(@RequestParam String projectId,HttpServletResponse response){
        Random random = new Random(System.currentTimeMillis());
        AtomicReference<Random> autoRandom = new AtomicReference<>();
        autoRandom.set(random);
        List<Map<String, Object>> collect = Stream.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").map(item -> {
            Map<String, Object> temp = new HashMap<>();
            temp.put("product", item);
            temp.put("data1", autoRandom.get().nextInt(10));
            temp.put("data2", autoRandom.get().nextInt(10));
            return temp;
        }).collect(Collectors.toList());
        System.out.println(projectId);
        return AjaxResult.successData(200,collect);
    }
    @GetMapping("/get2")
    public AjaxResult getTestData2(@RequestParam String projectId,HttpServletResponse response){
        //{ xAxis: ['12:16:04', 5], series: [143, 9.6] }
        if(this.count >= 100){
            this.count = 0;
        }
        Random random = new Random(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Map<String,List<Object>> res = new HashMap<>();
        res.put("xAxis",Arrays.asList(sdf.format(new Date()),this.count++));
        res.put("series",Arrays.asList(random.nextInt(1200),random.nextInt(30)));
        return AjaxResult.successData(200,res);
    }
}
