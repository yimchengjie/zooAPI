package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.IdiomQuery;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IdiomQueryImpl implements IdiomQuery {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public JSONObject getIdiomInfo(Map<String,String> map) {
        String res = okHttpUtil.get("http://v.juhe.cn/chengyu/query",map);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result  = jsonObject.getString("result");
        JSONObject jsonResult = JSONObject.parseObject(result);
        jsonResult.remove("bushou");
        jsonResult.remove("head");
        jsonResult.remove("ciyujs");
        return jsonResult;
    }
}
