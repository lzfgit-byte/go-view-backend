package cn.com.testData.controller;

import cn.com.v2.common.base.BaseController;
import cn.com.v2.common.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/goview/testData")
public class TestDataController extends BaseController {


    @GetMapping("/get")
    public AjaxResult getTestData(@RequestParam String projectId,HttpServletResponse response){
        Random random = new Random(System.currentTimeMillis());
        AtomicReference<Random> autoRandom = new AtomicReference<>();
        autoRandom.set(random);
        String rKey = "data" + random.nextInt(5);
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
}
