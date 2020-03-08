package top.lemenk.springboot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import top.lemenk.springboot_demo.domain.User;
import top.lemenk.springboot_demo.service.impl.MyRedisDemoImpl;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.controller
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/8 17:16
 * @Description: todo
 */
@Controller
public class RedisController {

    @Autowired
    MyRedisDemoImpl myRedisDemo;

    //redis
    @RequestMapping("/redis")
    public String redisDemo(Model model){

        int i = myRedisDemo.myRedis();
        model.addAttribute("increment",i);
        return "redistest";
    }

    @RequestMapping("/redis/{id}")
    public String getUserById(@PathVariable("id") Integer id,Model model ){
        this.redisDemo(model);
        String info = myRedisDemo.getUserById(id);
        model.addAttribute("user_info",info);
        return "redistest";
    }
}
