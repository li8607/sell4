package com.imooc.sell4.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    @GetMapping("/authorize")
    public void authorize(@RequestParam(value = "returnUrl") String returnUrl) {
//        WxMpService wxMpService = new
    }

}
