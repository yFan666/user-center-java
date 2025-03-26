package com.yupi.usercenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@SpringBootTest
class UserCenterApplicationTests {

    @Test
    void testDesigest() throws Exception {
        // MessageDigest md5 = MessageDigest.getInstance("MD5");
        // byte[] bytes = md5.digest("abcd".getBytes(StandardCharsets.UTF_8));
        String newPwd = DigestUtils.md5DigestAsHex(("abdc" + "mypassword").getBytes());
        System.out.println(newPwd);
    }


    @Test
    void contextLoads() {
    }
}
