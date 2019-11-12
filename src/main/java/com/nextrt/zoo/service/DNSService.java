package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONArray;

import java.util.Map;

public interface DNSService {
    JSONArray getDNSInfo(Map<String,String> queries);
}
