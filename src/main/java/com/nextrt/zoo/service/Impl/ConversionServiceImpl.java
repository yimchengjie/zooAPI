package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.ConversionService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {
    @Autowired
    OKHttpUtil okHttpUtil;

    @Override
    public JSONObject translateCommon(String word,String type) {
        Map<String,String> params = new HashMap<String, String>(){{
            put("doctype","json");
            put("type",type);
            put("i",word);

        }};
        String res = okHttpUtil.get("http://fanyi.youdao.com/translate",params);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result = jsonObject.getString("translateResult");
        String a=result.replace("[","").replace("]","");
        JSONObject jsonResult = JSONObject.parseObject(a);
        return jsonResult;
    }

    @Override
    public JSONObject exchangeRate() {
        Map<String,String> params = new HashMap<String, String>(){{
            put("key","6960d30fe497902c0feddbfa1621d8fe");
        }};
        String res = okHttpUtil.get("http://op.juhe.cn/onebox/exchange/query",params);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result = jsonObject.getString("result");
        JSONObject jsonResult = JSONObject.parseObject(result);
        return jsonResult;
    }
}
