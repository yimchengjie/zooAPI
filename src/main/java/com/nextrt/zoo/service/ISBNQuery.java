package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface ISBNQuery {
    JSONObject getISBNInfo(Map<String, String> map);
}
