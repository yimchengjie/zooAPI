package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ZipCodeService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {
    @Autowired
    OKHttpUtil okHttpUtil;

    @Override
    public JSONObject zipCodeSearch(String postcode) {
        Map<String,String> params = new HashMap<String, String>(){{
            put("key","c578ba77c042d31a9df161dc7201b4ba");
            put("postcode",postcode);

        }};
        String res = okHttpUtil.get("http://v.juhe.cn/postcode/query",params);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result = jsonObject.getString("result");
        JSONObject jsonResult = JSONObject.parseObject(result);
        return jsonResult;
    }
}
