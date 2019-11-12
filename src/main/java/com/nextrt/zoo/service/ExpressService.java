package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface ExpressService {
    JSONObject getExpressInfo(Map<String, String> queries);
}
