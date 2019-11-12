package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.TodayService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TodayServiceImpl implements TodayService {
    @Autowired
    OKHttpUtil okHttpUtil;
    @Override
    public String[] todayInHistory(String today) {
        String[] arr = today.split("-");
        Map<String,String> params = new HashMap<String, String>(){{
            put("key", "3be240a1be7a3a0e10c553fcb85c82dd");
            put("v", "1.0");
            put("month", arr[1]);
            put("day", arr[2]);
        }};
        String res = okHttpUtil.get("http://api.juheapi.com/japi/toh",params);
        JSONObject jsonObject = JSONObject.parseObject(res);
        JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("result"));
        int i=0;
        String[] arr2 = new String[100];
        arr2= jsonArray.toString().split("\\},\\{");
        return arr2;
    }


    @Override
    public JSONObject todayWeather(String city) {
        Map<String,String> params = new HashMap<String, String>(){{
            put("key", "57aa559991cc7df163df59d603d0435d");
            put("city", city);
        }};
        String res = okHttpUtil.get("http://apis.juhe.cn/simpleWeather/query",params);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String result = jsonObject.getString("result");
        if (result==null){
            return null;
        }
        JSONObject jsonResult = JSONObject.parseObject(result);
        return jsonResult;
    }

    @Override
    public JSONObject todayStarFate(String star) {
        Map<String,String> params = new HashMap<String, String>(){{
            put("key", "d95e8714ede4e2f4ea74d9a2b5bb141d");
            put("consName", star);
            put("type","today");
        }};
        String res = okHttpUtil.get("http://web.juhe.cn:8080/constellation/getAll",params);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String errorcode = jsonObject.getString("error_code");
        if(errorcode.equals("0")){
            return jsonObject;
        }
        return null;
    }
}
