package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.IdentityQuery;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IdentityQueryImpl implements IdentityQuery {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public JSONObject getIdentityInfo(Map<String,String> map) {
        String res = okHttpUtil.get("http://apis.juhe.cn/idcard/index",map);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result  = jsonObject.getString("result");
        JSONObject jsonResult = JSONObject.parseObject(result);
        return jsonResult;
    }
}
