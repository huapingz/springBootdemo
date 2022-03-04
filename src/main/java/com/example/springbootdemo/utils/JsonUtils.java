package com.example.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
    public static JSONObject StringToJson(String str) {
        return JSONObject.parseObject(str);
    }

    public static void main(String[] args) {
        System.out.println(StringToJson("{\"result\": \"success\",\"msg\": \"登陆成功\"}"));
    }
}
