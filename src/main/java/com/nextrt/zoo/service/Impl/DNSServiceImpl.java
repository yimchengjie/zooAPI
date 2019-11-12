package com.nextrt.zoo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.DNSService;
import com.nextrt.zoo.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DNSServiceImpl implements DNSService {
    @Autowired
    OKHttpUtil okHttpUtil;


    @Override
    public JSONArray getDNSInfo(Map<String, String> queries) {
        queries.put("ct","application/dns-json");
        String res = okHttpUtil.get("https://dns.233py.com/dns-query",queries);
        JSONObject jsonObject=JSONObject.parseObject(res);

        String Question=jsonObject.getString("Question");
        JSONArray QuestionJson=JSONArray.parseArray(Question);
        String typetemp=QuestionJson.getJSONObject(0).getString("type");

        String Answer=jsonObject.getString("Answer");
        JSONArray AnswerArray=JSONArray.parseArray(Answer);

        String Authority;
        JSONArray AuthorityArray=null;
        if (jsonObject.getString("Authority")!=null||jsonObject.getString("Authority")!=""){
            Authority=jsonObject.getString("Authority");
            AuthorityArray=JSONArray.parseArray(Authority);
        }
        if(AnswerArray.size()>0) {
            if (AuthorityArray!=null){
                AnswerArray.addAll(AuthorityArray);
            }
        }
        return AnswerArray;
    }
}
