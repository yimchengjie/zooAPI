package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

public interface TodayService {
    String[] todayInHistory(String today);
    JSONObject todayWeather(String city);
    JSONObject todayStarFate(String star);
}
