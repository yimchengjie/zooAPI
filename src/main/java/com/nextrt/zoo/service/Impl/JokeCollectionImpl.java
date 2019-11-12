package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.JokeCollection;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JokeCollectionImpl implements JokeCollection {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public JSONArray getJoke() {
        Map<String, String> queries=new HashMap<>();
        queries.put("key","01221d30a13e7fe8f60352b4b97e0f97");
        String res = okHttpUtil.get("http://v.juhe.cn/joke/randJoke.php",queries);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result  = jsonObject.getString("result");
        return JSONArray.parseArray(result);
    }
}
