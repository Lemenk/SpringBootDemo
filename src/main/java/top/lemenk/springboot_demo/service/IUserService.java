package top.lemenk.springboot_demo.service;

import top.lemenk.springboot_demo.domain.User;

import java.util.List;

/**
 * @BelongsProject: SpringBootDemo
 * @BelongsPackage: top.lemenk.springboot_demo.service
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/3 13:21
 * @Description: service接口
 */
public interface IUserService {

    List<User> getAllUser();

    User getUserById(Integer id);

    void saveUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

}
