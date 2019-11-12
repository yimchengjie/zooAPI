package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.IdiomQuery;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class IdiomQueryController {
    @Autowired
    IdiomQuery idiomQuery;

    private Result result = new Result();
    @GetMapping(value = {"/IdiomQuery/Get"})
    @ResponseBody
    public String queryIdentity(@RequestParam String word, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map = new HashMap<String,String>(){{
            put("word",word);
            put("dtype","");
            put("key","d45f1c49d1fbce92a74ef6d1244f5d83");
        }};
        JSONObject result_info=idiomQuery.getIdiomInfo(map);
        if(result_info==null){
            result=new Result(0,"输入的成语查询结果不存在！","");
        }else {
            result=new Result(1,"获得成语信息成功！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
