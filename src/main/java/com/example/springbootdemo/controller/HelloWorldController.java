package com.example.springbootdemo.controller;
import com.example.springbootdemo.data.ResultData;
import com.example.springbootdemo.data.TestData;
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
@Api(tags="helloWorld类测试")
@RestController
public class HelloWorldController {

    @ApiOperation("测试方法POST")
    @RequestMapping(value = "/helloWorld",method = RequestMethod.POST,produces = "application/json")
    public ResultData helloWorld(@RequestBody TestData helloWorld){
        System.out.println(helloWorld.toString());
        return new ResultData("1","success",helloWorld);
    }

    @ApiOperation("测试方法 GET")
    @RequestMapping(value = "/helloWorld",method = RequestMethod.GET,produces = "application/json")
    public ResultData helloWorld2(TestData helloWorld){
        System.out.println(helloWorld.toString());
        return new ResultData("1","success",helloWorld);
    }

}

