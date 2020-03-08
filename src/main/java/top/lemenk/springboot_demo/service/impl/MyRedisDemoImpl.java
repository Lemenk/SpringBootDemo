package top.lemenk.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.lemenk.springboot_demo.domain.User;
import top.lemenk.springboot_demo.mapper.IUserMapper;
import top.lemenk.springboot_demo.service.IMyRedisDemo;

import javax.annotation.Resource;
import java.util.List;


/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.service.impl
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/8 16:39
 * @Description: todo
 */
@Service
public class MyRedisDemoImpl implements IMyRedisDemo {

    @Resource
    private IUserMapper iUserMapper;

    @Autowired
    RedisTemplate<Object, User> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> myRedisTemplate;

    //网站总访问量
    @Override
    public int myRedis() {
        try{
            stringRedisTemplate.opsForValue().increment("page:view",1);
            String s = stringRedisTemplate.boundValueOps("page:view").get(0, -1);
            return Integer.valueOf(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //从数据库中得到指定id的用户信息。如果redis中没有，则从数据库中查找，然后放进redis中
    @Override
    public String getUserById(Integer id) {

        if (myRedisTemplate.hasKey("user00"+id)){
            List<Object> list = myRedisTemplate.opsForHash().values("user00"+id);
            System.out.println(list);
            return list.toString();
        }else {
            User user = iUserMapper.getUserById(id);
            //存入redis
            myRedisTemplate.opsForHash().put("user00"+id,"id",user.getId());
            myRedisTemplate.opsForHash().put("user00"+id,"username",user.getUsername());
            myRedisTemplate.opsForHash().put("user00"+id,"sex",user.getSex());
            myRedisTemplate.opsForHash().put("user00"+id,"birthday",user.getBirthday());
            myRedisTemplate.opsForHash().put("user00"+id,"address",user.getAddress());
            //redisTemplate.opsForHash("user00"+id,user.getId(),user.getUsername());
            return user.toString();
        }
    }
}
