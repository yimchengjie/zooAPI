package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface OilPriceService {
    JSONObject getOilPriceToday(Map<String, String> queries, String city);
}
