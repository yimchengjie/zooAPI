package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.DictionaryQuery;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class DictionaryQueryController {
    @Autowired
    DictionaryQuery dictionaryQuery;

    private Result result = new Result();
    @GetMapping(value = {"/DictionaryQuery/Get"})
    @ResponseBody
    public String queryIdentity(@RequestParam String word, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map = new HashMap<String,String>(){{
            put("word",word);
            put("dtype","");
            put("key","0e1fa0b2638ba1a7457d1a1aafa79f41");
        }};
        JSONObject result_info=dictionaryQuery.getDictionaryInfo(map);
        if(result_info==null){
            result=new Result(0,"输入参数错误！","");
        }else {
            result=new Result(1,"获得信息成功！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
