package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ISBNQuery;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ISBNQueryImpl implements ISBNQuery {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public JSONObject getISBNInfo(Map<String,String> map) {
        String res = okHttpUtil.get("http://feedback.api.juhe.cn/ISBN",map);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result  = jsonObject.getString("result");
        if(result.equals("")){
            return null;
        }
        JSONObject jsonResult = JSONObject.parseObject(result);
        jsonResult.remove("subtitle");
        jsonResult.remove("origin_title");
        jsonResult.remove("pages");
        jsonResult.remove("images_medium");
        jsonResult.remove("images_large");
        return jsonResult;
    }
}
