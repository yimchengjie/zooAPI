package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.JokeCollection;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "API")
public class JokeCollectionController {
    @Autowired
    JokeCollection jokeCollection;

    private Result result = new Result();

    @GetMapping(value = {"/JokeCollection/Get"})
    @ResponseBody
    public String queryJoke(){
        JSONArray result_info=jokeCollection.getJoke();
        result=new Result(1,"获得信息成功！",result_info);
        return  JSONObject.toJSONString(result);
    }
}
