package com.nextrt.zoo.controller;


import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.Impl.IpFindRowServiceImpl;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "API")
public class IpFindRowController {
    @Autowired
    IpFindRowServiceImpl ipFindRowService;

    private Result result = new Result();
    boolean CheckNull(String str){
        return (str == "" || str == null);
    }

    @GetMapping(value = {"/IpFindRow/GET"})
    @ResponseBody
    public String IpFindRow(@RequestParam String ip , HttpServletRequest request, HttpServletResponse response){
        String address = ipFindRowService.findCityByIp(ip);
        if (address.equals("notfound")){
            result = new Result(0,"未找到Ip对应地址",null);
            return JSONObject.toJSONString(result);
        }
        result = new Result(1,"通过ip获得所在城市",address);
        return JSONObject.toJSONString(result);
    }

}
