package com.cyw.TalkRobot.controller;

import com.cyw.TalkRobot.service.TalkService;
import com.cyw.TalkRobot.util.HttpUtil;
import com.cyw.TalkRobot.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talk")
public class TalkController {

    @Autowired
    private TalkService talkService;

    /**
     * 用户说的话
     * @param str
     * @return
     */
    @RequestMapping("/say")
    public R say(String str){
        //获取当前用户信息

        return R.ok(talkService.say(str));
    }
}
