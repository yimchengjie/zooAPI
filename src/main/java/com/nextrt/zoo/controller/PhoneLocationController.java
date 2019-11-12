package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.PhoneLocationService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class PhoneLocationController {
    @Autowired
    PhoneLocationService phoneLocationService;

    private Result result=new Result();

    @GetMapping(value = {"/PhoneLocation/Get"})
    @ResponseBody
    public String phoneLocation(@RequestParam String phone, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("phone",phone);
        map.put("dtype","");
        map.put("key","4fc123d08cf2437bec303de598493f75");
        JSONObject result_info=phoneLocationService.getPhoneLocationInfo(map);
        if (result_info!=null){
            result=new Result(1,"获得手机号归属地信息成功！",result_info);
        }
        else{
            result=new Result(0,"获得手机号归属地信息失败！",result_info);
        }
        return  JSONObject.toJSONString(result);
    }
}
