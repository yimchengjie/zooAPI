package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONArray;
import com.nextrt.zoo.service.DNSService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class DNSController {
    @Autowired
    DNSService dnsService;
    private Result result=new Result();

    @GetMapping(value = {"/DNS/Get"})
    @ResponseBody
    public String getDNS(@RequestParam String type,@RequestParam String name){
        Map<String,String> map=new HashMap<>();
        map.put("type",type);
        map.put("name",name);
        JSONArray jsonArray=dnsService.getDNSInfo(map);
        if (jsonArray!=null){
            result=new Result(1,"解析成功",jsonArray);
        }else{
            result=new Result(0,"解析失败",jsonArray);
        }
        System.out.println(JSONArray.toJSONString(jsonArray));
        return JSONArray.toJSONString(result);
    }
}
