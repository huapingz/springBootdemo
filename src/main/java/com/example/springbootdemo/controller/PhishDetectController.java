package com.example.springbootdemo.controller;

import com.example.springbootdemo.data.ResultData;
import com.example.springbootdemo.data.TestData;
import com.example.springbootdemo.service.W2vDetectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanhp
 * @company Pencheng Laboratory
 * @create 2022-03-01 17:46
 */
@Api(tags="钓鱼网址检测类测试")
@RestController
public class PhishDetectController {
    @ApiOperation("W2V快速检测")
    @RequestMapping(value = "/detect2v",method = RequestMethod.GET,produces = "application/json")
    public ResultData helloWorld(String url){
        System.out.println(url);
        Object res="";
        try {
            res=W2vDetectService.searchByW2v(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultData("1","success",res);
    }
}
