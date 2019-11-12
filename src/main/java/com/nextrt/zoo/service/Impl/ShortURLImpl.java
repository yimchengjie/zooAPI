package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ShortURLQuery;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShortURLImpl implements ShortURLQuery {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public JSONObject getShortURLInfo(Map<String,String> map) {
        String res = okHttpUtil.get("http://www.mynb8.com/api/dwz",map);
        JSONObject jsonObject = JSONObject.parseObject(res);
        return jsonObject;
    }
}
