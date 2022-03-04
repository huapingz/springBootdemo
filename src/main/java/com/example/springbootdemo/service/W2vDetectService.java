package com.example.springbootdemo.service;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class W2vDetectService {
    public static Map<String, String> searchByW2v(String url) throws Exception {
    // 创建Httpclient对象,相当于打开了浏览器
        String content="";
        Map<String,String> result=new HashMap<>();
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建HttpGet请求，相当于在浏览器输入地址
        HttpGet httpGet = new HttpGet("http://huojing.net.cn:8001/phish/"+url);

        CloseableHttpResponse response = null;
        try {
            // 执行请求，相当于敲完地址后按下回车。获取响应
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
                String res=content.split(",")[1].split(":")[1].split("}")[0].toString();
                result.put("url",url);
                result.put("isphish",res);
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                // 关闭资源
                response.close();
            }
            // 关闭浏览器
            httpclient.close();
        }
        return result;
    }
}
