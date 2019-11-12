package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface IdiomQuery {
    JSONObject getIdiomInfo(Map<String, String> map);
}
