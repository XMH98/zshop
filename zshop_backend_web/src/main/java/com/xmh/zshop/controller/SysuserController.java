package com.xmh.zshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 21:53
 * Description: <描述>
 */
@Controller
@RequestMapping("/backend/sysuser")
public class SysuserController {

    @RequestMapping("/login")
    public String login(){
        //处理登录操作

        return "main";
    }
}
