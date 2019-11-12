package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface DictionaryQuery {
    JSONObject getDictionaryInfo(Map<String, String> map);
}
