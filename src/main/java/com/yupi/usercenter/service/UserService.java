package com.yupi.usercenter.service;

import com.yupi.usercenter.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Youli
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-03-22 22:52:56
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);
}
