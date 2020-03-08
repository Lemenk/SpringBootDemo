package top.lemenk.springboot_demo.service;

import top.lemenk.springboot_demo.domain.User;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.service
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/8 16:38
 * @Description: todo
 */
public interface IMyRedisDemo {



    //网站总访问量
    public int myRedis();

    String getUserById(Integer id);
}
