package top.lemenk.springboot_demo.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.lemenk.springboot_demo.domain.User;
import top.lemenk.springboot_demo.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.config
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/2 21:11
 * @Description: User控制类
 */

@Api(value = "用户controller",tags = "用户操作接口")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //查询所有
    @ApiOperation(value = "获取用户列表",notes = "获取所有用户信息")
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //根据id查询
    @ApiOperation(value = "获取用户详情",notes = "根据url的id来获取用户基本信息")
    @GetMapping("user/{id}")
    @ApiModelProperty(name = "id",value = "用户ID",example = "1")//@ApiParam("用户id")
    public ResponseEntity<String> getUser(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        if (user != null){
            return ResponseEntity.ok(user.toString());
        }else {
            return ResponseEntity.status(500).body("此用户不存在");
        }
    }

    //添加用户
    @ApiOperation(value ="添加用户")
    @ResponseBody
    @PostMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="用户id",dataType = "java.lang.Integer", paramType = "query",example = "1"),
            @ApiImplicitParam(name = "username",value = "用户名",dataType = "string",paramType = "query",example="张三"),
            @ApiImplicitParam(name = "sex",value = "性别",dataType = "string",paramType = "query",example="男"),
            @ApiImplicitParam(name = "birthday",value = "生日",dataType = "java.util.Date",paramType = "query",example = "2010/01/01"),
            @ApiImplicitParam(name = "address",value = "住址",dataType = "string",paramType = "query",example="中国北京")
    })
    public User saveUser(User user){
        userService.saveUser(user);
        return user;
    }

    //更新
    @ApiOperation(value ="更新用户")
    @ResponseBody
    @PutMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="用户id",dataType = "java.lang.Integer", paramType = "query",example = "1"),
            @ApiImplicitParam(name = "username",value = "用户名",dataType = "string",paramType = "query",example="张三"),
            @ApiImplicitParam(name = "sex",value = "性别",dataType = "string",paramType = "query",example="男"),
            @ApiImplicitParam(name = "birthday",value = "生日",dataType = "data",paramType = "query",example="2010/01/01"),
            @ApiImplicitParam(name = "address",value = "住址",dataType = "string",paramType = "query",example="中国北京")
    })
    public ResponseEntity<String> updateUser(User user){
        Integer i = userService.updateUser(user);
        if (i == 1){
            return ResponseEntity.ok("更新"+user.getId()+"成功");
        }else {
            return ResponseEntity.status(500).body("更新"+user.getId()+"失败");
        }
    }

    //删除
    @ApiOperation(value ="删除用户")
    @ResponseBody
    @DeleteMapping("/user/{id}")
    @ApiModelProperty(name = "id",value = "用户ID",example = "1")//@ApiParam("用户id")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Integer id){
        Integer i = userService.deleteUser(id);
        if (i == 1){
            return ResponseEntity.ok("更新用户"+id+"成功");
        }else {
            return ResponseEntity.status(500).body("更新用户"+id+"失败,此用户可能不存在");
        }
    }
}
