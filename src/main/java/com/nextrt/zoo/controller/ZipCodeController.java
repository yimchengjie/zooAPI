package com.nextrt.zoo.controller;


import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ZipCodeService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "API")
public class ZipCodeController {
    @Autowired
    ZipCodeService zipCodeService;

    private Result result =new Result();

    @GetMapping(value = {"/ZipCodeFind/Get"})
    @ResponseBody
    public String zipcodefind(@RequestParam String postcode, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = zipCodeService.zipCodeSearch(postcode);
        result = new Result(1,"查找邮编号所在地区",jsonObject);
        return  JSONObject.toJSONString(result);
    }
}
