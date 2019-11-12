package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ExpressService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class ExpressController {
    @Autowired
    ExpressService expressService;
    private Result result=new Result();
    @GetMapping(value = {"/Express/Get"})
    @ResponseBody
    public String getExpress(@RequestParam String com,
                             @RequestParam String no,
                             @RequestParam(required = false) String senderPhone,
                             @RequestParam(required = false) String receiverPhone){
        Map<String,String> map=new HashMap<>();
        map.put("com",com);
        map.put("no",no);
        if(senderPhone!=null||senderPhone!=""){
            map.put("senderPhone",senderPhone);
        }else{
            map.put("senderPhone","");
        }
        if(receiverPhone!=null||receiverPhone!="") {
            map.put("receiverPhone", receiverPhone);
        }else{
            map.put("receiverPhone","");
        }
        map.put("dtype","");
        map.put("key","ce5a373417dcade9f0b859da72154e6a");
        JSONObject result_info=expressService.getExpressInfo(map);
        if(result_info==null){
            result=new Result(0,"快递查询失败！","");
        }else {
            result=new Result(1,"快递查询成功！",result_info);
        }
        return JSONObject.toJSONString(result);
    }

}
