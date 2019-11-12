package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.IdentityQuery;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class IdentityQueryController {
    @Autowired
    IdentityQuery identityQuery;

    private Result result = new Result();
    @GetMapping(value = {"/IdentityQuery/Get"})
    @ResponseBody
    public String queryIdentity(@RequestParam String id_card, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map = new HashMap<String,String>(){{
            put("cardno",id_card);
            put("dtype","");
            put("key","a8e6b8d26b072255b8d4901ad0522ef5");
        }};
        JSONObject result_info=identityQuery.getIdentityInfo(map);
        if(result_info==null){
            result=new Result(0,"输入参数错误！","");
        }else {
            result=new Result(1,"获得身份证信息成功！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
