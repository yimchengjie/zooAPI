package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.CookbookService;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "API")
public class CookbookController {
    @Autowired
    CookbookService cookbookService;
    private Result result=new Result();
    @GetMapping(value = {"/Cookbook/Get"})
    @ResponseBody
    public String getCookbook(@RequestParam String menu,
                              @RequestParam(required = false) String pn,
                              @RequestParam(required = false) String rn){
        Map<String,String> map=new HashMap<>();
        map.put("menu",menu);
        map.put("key","9086683af9d4d7654cb465f65f620491");
        map.put("dtype","");
        if(pn!=null||pn!=""){
            map.put("pn",pn);
        }else{
            map.put("pn","");
        }
        if(rn!=null||rn!=""){
            map.put("rn",rn);
        }else{
            map.put("rn","");
        }
        JSONObject jsonObject=cookbookService.getCookbook(map);

        if(jsonObject==null){
            result=new Result(0,"输入参数错误！","");
        }else {
            result=new Result(1,"获取菜谱成功！",jsonObject);
        }
        return JSONObject.toJSONString(result);
    }
}
