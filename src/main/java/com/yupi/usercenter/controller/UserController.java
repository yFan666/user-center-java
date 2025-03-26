package com.yupi.usercenter.controller;

import com.yupi.usercenter.model.User;
import com.yupi.usercenter.model.request.UserLoginRequest;
import com.yupi.usercenter.model.request.UserRegiesterRequest;
import com.yupi.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 用户接口
 *
 * @author Youli
 */
@RestController("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegiesterRequest userRegiesterRequest) {
        if (userRegiesterRequest == null) {
            return null;
        }

        String userAccount = userRegiesterRequest.getUserAccount();
        String userPassword = userRegiesterRequest.getUserPassword();
        String checkPassword = userRegiesterRequest.getCheckPassword();

        if (StringUtils.isAnyEmpty(userAccount, userPassword, checkPassword)) {
            return null;
        }

        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public User userRegister(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }

        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        if (StringUtils.isAnyEmpty(userAccount, userPassword)) {
            return null;
        }

        return userService.doLogin(userAccount, userPassword, request);
    }

}
