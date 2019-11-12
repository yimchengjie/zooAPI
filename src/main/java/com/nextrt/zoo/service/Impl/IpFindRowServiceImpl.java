package com.nextrt.zoo.service.Impl;


import com.nextrt.zoo.service.IpFindRowService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IpFindRowServiceImpl implements IpFindRowService {
    @Autowired
    OKHttpUtil okHttpUtil;

    public String findCityByIp(String ip){
        Map<String,String> map = new HashMap<String, String>();
        map.put("ip",ip);
        String result = okHttpUtil.get("http://freeapi.ipip.net/",map);
        if (result.equals("notfound")){
            return "notfound";
        }
        String str = result.replace("\"", "");
        String[] arr = str.split(",");
        return arr[1]+","+arr[2];
    }
}
