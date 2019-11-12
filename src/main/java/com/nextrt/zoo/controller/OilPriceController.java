package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.OilPriceService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class OilPriceController {
    @Autowired
    OilPriceService oilPriceService;
    private Result result=new Result();
    @GetMapping(value = {"/OilPrice/Get"})
    @ResponseBody
    public String oilPrice(@RequestParam String city){
        Map<String,String> map=new HashMap<>();
        map.put("dtype","");
        map.put("key","56c8661f3be3cb2a56943f1e6063d675");
        String citynew=city;
        if(city.length()>=3){
            citynew= city.substring(0,2);
        }
        JSONObject result_info=oilPriceService.getOilPriceToday(map,citynew);
        if(result_info==null){
            result=new Result(0,"获得今日油价失败！","");
        }else{

            result=new Result(1,"获得今日油价成功！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
