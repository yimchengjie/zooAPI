package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ConversionService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "API")
public class ConversionController {
    @Autowired
    ConversionService conversionService;

    private Result result = new Result();
    @GetMapping(value = {"/Conversion/Translate/Get"})
    @ResponseBody
    public String translate(@RequestParam String word,@RequestParam String type, HttpServletRequest request, HttpServletResponse response){
        String translatetype = null;
        switch(type) {
            case "CE":
                translatetype = "ZH_CN2EN";
                break;
            case "CJ":
                translatetype = "ZH_CN2JA";
                break;
            case "CK":
                translatetype = "ZH_CN2KR";
                break;
            case "CF":
                translatetype = "ZH_CN2FR";
                break;
            case "CR":
                translatetype = "ZH_CN2RU";
                break;
            case "CS":
                translatetype = "ZH_CN2SP";
                break;
            case "EC":
                translatetype = "EN2ZH_CN";
                break;
            case "JC":
                translatetype = "JA2ZH_CN";
                break;
            case "KC":
                translatetype = "KR2ZH_CN";
                break;
            case "FC":
                translatetype = "FR2ZH_CN";
                break;
            case "RC":
                translatetype = "RU2ZH_CN";
                break;
            case "SC":
                translatetype = "SP2ZH_CN";
                break;
            default:
                translatetype = "AUTO";
        }
        JSONObject target = conversionService.translateCommon(word,translatetype);
        result = new Result(1,"翻译",target);
        return JSONObject.toJSONString(result);
    }

    @GetMapping(value = {"/Conversion/ChangeRate/Get"})
    @ResponseBody
    public String IpFindRow(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = conversionService.exchangeRate();
        result = new Result(1,"获得当前汇率",jsonObject);
        return JSONObject.toJSONString(result);
    }

}
