package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.CookbookService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CookbookServiceImpl implements CookbookService {
    @Autowired
    OKHttpUtil okHttpUtil;

    @Override
    public JSONObject getCookbook(Map<String, String> queries) {
        String res=okHttpUtil.get("http://apis.juhe.cn/cook/query",queries);
        JSONObject jsonObject=JSONObject.parseObject(res);
        String result=jsonObject.getString("result");
        JSONObject jsonResult=JSONObject.parseObject(result);
        if(jsonResult.getString("data").equals("[]")){
            return null;
        }
        return jsonResult;
    }
}
