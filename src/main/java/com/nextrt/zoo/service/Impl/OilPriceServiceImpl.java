package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.OilPriceService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class OilPriceServiceImpl implements OilPriceService {

    @Autowired
    OKHttpUtil okHttpUtil;

    @Override
    public JSONObject getOilPriceToday(Map<String, String> queries,String city) {
        String res=okHttpUtil.get("http://apis.juhe.cn/cnoil/oil_city",queries);
        JSONObject jsonObject=JSONObject.parseObject(res);
        String result=jsonObject.getString("result");
        result=result.replaceAll("92h", "h92");
        result=result.replaceAll("95h", "h95");
        result=result.replaceAll("98h", "h98");
        result=result.replaceAll("0h", "h0");
        JSONArray jsonResult=JSONArray.parseArray(result);
        for (int i=0;i<jsonResult.size();i++){
            if(jsonResult.getJSONObject(i).get("city").equals(city)){
                jsonResult.getJSONObject(i).remove("b90");
                jsonResult.getJSONObject(i).remove("b93");
                jsonResult.getJSONObject(i).remove("b97");
                jsonResult.getJSONObject(i).remove("b0");

                return jsonResult.getJSONObject(i);
            }
        }
        return null;
    }
}
