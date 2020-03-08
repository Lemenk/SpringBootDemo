package top.lemenk.springboot_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.lemenk.springboot_demo.domain.User;
import top.lemenk.springboot_demo.mapper.IUserMapper;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Resource
    IUserMapper iUserMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,User> userRedisTemplate;

    /**
     * 测试redis的数据类型
     */
    @Test
    public void test01(){
        //给key为msg的值追加hello。
        stringRedisTemplate.opsForValue().append("msg","hello");
    }

    @Test
    public void test02(){
        User userById = iUserMapper.getUserById(1);
        //redisTemplate.opsForValue().set("user-01",userById);

        //1.将数据以json方式保存
        userRedisTemplate.opsForValue().set("user-01",userById);

    }

    @Test
    void contextLoads() {
    }

}
