package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ExpressService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    OKHttpUtil okHttpUtil;

    @Override
    public JSONObject getExpressInfo(Map<String, String> queries) {
        String res=okHttpUtil.get("http://v.juhe.cn/exp/index",queries);
        JSONObject jsonObject=JSONObject.parseObject(res);
        String result=jsonObject.getString("result");
        JSONObject jsonResult=JSONObject.parseObject(result);
        return jsonResult;
    }
}
