package top.lemenk.springboot_demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.lemenk.springboot_demo.domain.User;

import java.util.List;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.mapper
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/2 21:07
 * @Description: 用户Mapper接口
 */
@Mapper
public interface IUserMapper {

    //查询所有用户
    List<User> findAll();

    //根据id查询用户
    User getUserById(Integer id);

    //添加用户
    void insertUser(User user);

    //更新用户
    Integer updateUser(User user);

    //根据Id删除用户
    Integer deleteUser(Integer userId);

}
