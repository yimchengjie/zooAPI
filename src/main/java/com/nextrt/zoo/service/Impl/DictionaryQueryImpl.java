package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.DictionaryQuery;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryQueryImpl implements DictionaryQuery {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public JSONObject getDictionaryInfo(Map<String,String> map) {
        String res = okHttpUtil.get("http://v.juhe.cn/xhzd/query",map);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result  = jsonObject.getString("result");
        JSONObject jsonResult = JSONObject.parseObject(result);
        jsonResult.remove("id");
        jsonResult.remove("py");
        jsonResult.remove("wubi");
        return jsonResult;
    }
}
