package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

public interface ConversionService {
    JSONObject translateCommon(String word, String type);
    JSONObject exchangeRate();
}
