package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.PhoneLocationService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PhoneLocationServiceImpl implements PhoneLocationService {

    @Autowired
    OKHttpUtil okHttpUtil;

    @Override
    public JSONObject getPhoneLocationInfo(Map<String, String> queries) {
        String res=okHttpUtil.get("http://apis.juhe.cn/mobile/get",queries);
        JSONObject jsonObject=JSONObject.parseObject(res);
        String result=jsonObject.getString("result");
        JSONObject jsonResult=JSONObject.parseObject(result);
        return jsonResult;
    }
}
