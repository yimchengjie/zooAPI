package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface IdentityQuery {
    JSONObject getIdentityInfo(Map<String,String> map);
}
