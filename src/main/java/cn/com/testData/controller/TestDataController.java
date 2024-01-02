package cn.com.testData.controller;

import cn.com.v2.common.base.BaseController;
import cn.com.v2.common.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/goview/testData")
public class TestDataController extends BaseController {


    @GetMapping("/get")
    public AjaxResult getTestData(@RequestParam String projectId){
        Random random = new Random(System.currentTimeMillis());
        List<Map<String, Object>> collect = Stream.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").map(item -> {
            Map<String, Object> temp = new HashMap<>();
            temp.put("product", item);
            temp.put("data1", random.nextInt(10));
            temp.put("data2", random.nextInt(10));
            return temp;
        }).collect(Collectors.toList());
        System.out.println(projectId);
        return AjaxResult.successData(200,collect);
    }
}
