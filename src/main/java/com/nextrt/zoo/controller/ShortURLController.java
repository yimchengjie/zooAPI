package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ShortURLQuery;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class ShortURLController {
    @Autowired
    ShortURLQuery shortURLQuery;

    private Result result = new Result();
    @GetMapping(value = {"/ShortURL/Get"})
    @ResponseBody
    public String shortURL(@RequestParam String long_url, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map = new HashMap<String,String>(){{
            put("long_url",long_url);
            put("appkey","d69d7fb50a8368f9cde042f06cc03101");
            put("sign","4c13a6cea0e3f1cbf1e51bcf35194074");
        }};
        JSONObject result_info=shortURLQuery.getShortURLInfo(map);
        if(result_info==null){
            result=new Result(0,"未知错误！","");
        }else {
            result=new Result(1,"获得短网址成功！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
