package com.nextrt.zoo.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class Tool {
    //获取用户iP（传入request）,返回用户IP
    public  String getClientIp(HttpServletRequest request) {
        String ip=request.getHeader("X-FORWARDED-FOR");
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("X-Real-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
        }
        return ip;
    }

    public boolean CheckEmail(String email) {
        if (email == null || "".equals(email)) return false;
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }

    //手机短信随机六位数字验证码
    public int phoneRandom(){
        return (int) ((Math.random() * 9 + 1) * 100000);
    }

    //26个字母和数字组成数组
    public static char[] charArray(){
        int i = 1234567890;
        String s ="qwertyuiopasdfghjklzxcvbnmn";
        String S=s.toUpperCase();
        String word=s+S+i;
        char[] c=word.toCharArray();

        return c;
    }


    //邮箱随机字母数字验证码
    public String emailRandom() {
        char[] c= charArray();//获取包含26个字母大小写和数字的字符数组
        Random rd = new Random();
        String code="";
        for (int k = 0; k < 6; k++) {
            int index = rd.nextInt(c.length);//随机获取数组长度作为索引
            code+=c[index];//循环添加到字符串后面
        }
        return code;
    }

    //特殊字符过滤，传入字符串 返回过滤后的字符串
    public static String StringFilter(String str){
        if(str == "" || str ==null)
            return "";
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }



    public String GetDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        return date;
    }
    public String GetDate1(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());
        return date;
    }

}
