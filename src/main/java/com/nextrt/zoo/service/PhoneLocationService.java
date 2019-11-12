package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface PhoneLocationService {
    JSONObject getPhoneLocationInfo(Map<String, String> queries);
}
