package com.yupi.usercenter.service.impl;
import java.util.Date;

import com.yupi.usercenter.model.User;
import com.yupi.usercenter.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author Youli
 */
@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("");
        user.setUserAccount("aogYupi");
        user.setAvatarUrl("https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKhOqyiahbWybPMINia0hJbTDoZbs1ACTb9ldJS99dIE3ckBSjT3z7icVJzXol7BpFoyibESEWqYFagXg/132");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("110120119");
        user.setEmail("123123@gmail.com");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

}