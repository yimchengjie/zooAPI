package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface ShortURLQuery {
    JSONObject getShortURLInfo(Map<String, String> map);
}
