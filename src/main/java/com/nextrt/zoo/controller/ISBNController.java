package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ISBNQuery;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class ISBNController {
    @Autowired
    ISBNQuery isbnQuery;

    private Result result = new Result();
    @GetMapping(value = {"/ISBNQuery/Get"})
    @ResponseBody
    public String queryIdentity(@RequestParam String sub, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map = new HashMap<String,String>(){{
            put("sub",sub);
            put("key","92efb1b5f9400698f83504772d256709");
        }};
        JSONObject result_info=isbnQuery.getISBNInfo(map);
        if(result_info==null){
            result=new Result(0,"输入参数错误！","");
        }else {
            result=new Result(1,"获得ISBN信息成功！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
