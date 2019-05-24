package com.springboot.dubboTest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.caimao.loginRefact.entity.LoginVO;
import com.caimao.loginRefact.service.AdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 模块名称：dubboTest com.springboot.dubboTest.controller
 * 功能说明：<br>
 * 开发人员：Luzx
 * 创建时间： 2019-05-08 16:23
 * 系统版本：1.0.0
 **/

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Reference(version = "1.0.0",timeout = 300)
    private AdminUserService adminUserService;

    @RequestMapping(value = "/loginTest")
    @ResponseBody
    public String loginTest(){
        List<LoginVO> list=adminUserService.testGetAll();
        return String.valueOf(list.size());
    }
}