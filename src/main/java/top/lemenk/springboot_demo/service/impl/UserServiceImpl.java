package top.lemenk.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemenk.springboot_demo.domain.User;
import top.lemenk.springboot_demo.mapper.IUserMapper;
import top.lemenk.springboot_demo.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.service
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/2 21:08
 * @Description: Service实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper iUserMapper;

    //查询所有用户
    public List<User> getAllUser(){
        return iUserMapper.findAll();
    }

    //根据id查询用户
    public User getUserById(Integer id){
        return iUserMapper.getUserById(id);
    }

    //添加
    public void saveUser(User user){
        iUserMapper.insertUser(user);
    }

    //删除
    @Override
    public Integer deleteUser(Integer id) {
        return iUserMapper.deleteUser(id);
    }

    //更新
    public Integer updateUser(User user){
        return iUserMapper.updateUser(user);
    }


}
