package com.nextrt.zoo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nextrt.zoo.service.Impl.IpFindRowServiceImpl;
import com.nextrt.zoo.service.Impl.TodayServiceImpl;
import com.nextrt.zoo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "API")
public class TodayController {
    @Autowired
    TodayServiceImpl todayService;
    @Autowired
    IpFindRowServiceImpl ipFindRowService;

    private Result result = new Result();
    boolean CheckNull(String str){
        return (str == "" || str == null);
    }
    @GetMapping(value={"/TodayInHistory/GET"})
    @ResponseBody
        public String todayInHistory(HttpServletRequest request, HttpServletResponse response){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        String[] event;
        event = todayService.todayInHistory(dateString);
        int i = (int) (Math.random()*event.length+1);
        while (event[i]==null){
            i = (int) (Math.random()*event.length+1);
        }
        String afterdo ="{"+event[i]+"}";
        System.out.println(afterdo);
        JSONObject jsonObject = JSONObject.parseObject(afterdo);
        result = new Result(1,"获得历史上的今天信息",jsonObject);
        return JSONObject.toJSONString(result);
    }

    @GetMapping(value = {"/TodayWeather/GET"})
    @ResponseBody
    public String todayWeather(HttpServletRequest request, HttpServletResponse response ){


        String ip = request.getHeader("x-forwarded-for");
        if (request.getHeader("x-forwarded-for") == null) {
           ip = request.getRemoteAddr();
        } //获得访问者的ip地址、因为postman和网页测试ip不能使用，先使用杭州ip代替
        System.out.println(ip);
        String[] city1 =  ipFindRowService.findCityByIp("61.153.0.130").split(",");
        for (int i=0;i<city1.length;i++){
            System.out.println(city1[i]);
        }
        JSONObject jsonObject = todayService.todayWeather(city1[1]);
        result = new Result(1,"获得今天以及未来的天气预报",jsonObject);
        return JSONObject.toJSONString(result);
    }

    @GetMapping(value = {"/TodayWeather/Search"})
    @ResponseBody
    public String todayWeatherSearch(String city,HttpServletRequest request, HttpServletResponse response ){

        JSONObject jsonObject = todayService.todayWeather(city);
        if (jsonObject==null){
            return JSONObject.toJSONString(new Result(0,"不支持该城市",null));
        }
        result = new Result(1,"获得今天以及未来的天气预报",jsonObject);
        return JSONObject.toJSONString(result);
    }

    @GetMapping(value = {"/TodayStarFate/GET"})
    @ResponseBody
    public String todayStarFate(@RequestParam String star,HttpServletRequest request, HttpServletResponse response ){
        JSONObject jsonObject = todayService.todayStarFate(star);
        result = new Result(1,"获得今天的星座运势",jsonObject);
        if (jsonObject==null){
            result = new Result(0,"星座名称错误",jsonObject);
        }
        return JSONObject.toJSONString(result);
    }
}
