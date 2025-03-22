package com.yupi.usercenter;

import com.yupi.usercenter.mapper.UserMapper;
import com.yupi.usercenter.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SampleTest {

    // Autowired 类名来注入
    @Resource // 按照java Bean名称来注入
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

}