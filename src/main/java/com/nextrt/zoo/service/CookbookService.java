package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface CookbookService {
    JSONObject getCookbook(Map<String,String> queries);
}
