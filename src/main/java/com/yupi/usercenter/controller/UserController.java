package com.yupi.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.usercenter.contant.UserConstant;
import com.yupi.usercenter.model.User;
import com.yupi.usercenter.model.request.UserLoginRequest;
import com.yupi.usercenter.model.request.UserRegiesterRequest;
import com.yupi.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.yupi.usercenter.contant.UserConstant.URL_LOGIN_STATE;


/**
 * 用户接口
 *
 * @author Youli
 */
@RestController()
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param userRegiesterRequest
     * @return
     * @author Youli
     * @date 2025/3/23 14:57
     */
    @PostMapping("register")
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

    /**
     *
     * @param userLoginRequest
     * @param request
     * @return
     *
     * @author Youli
     * @date 2025/3/23 15:11
     */
    @PostMapping("login")
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

    /**
     * 用户查询
     * @param username
     * @return
     * @author Youli
     * @date 2025/3/23 15:16
     */
    @GetMapping("search")
    public List<User> userSearch(String username, HttpServletRequest request) {

        // 偷个懒 直接调用service层

        // 仅管理员可查询
        if (!isAdmin(request)) {
            return new ArrayList<>();
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("username", username);
        }
        List<User> userList = userService.list(queryWrapper);

        userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());

        return userList;
    }
    /**
     * 用户注销
     * @param id
     * @return
     * @author Youli
     * @date 2025/3/23 15:20
     */
    @PostMapping("/delete")
    public Boolean deleteUser(@RequestBody Long id, HttpServletRequest request) {
        if (!isAdmin(request)) {
            return false;
        }

        if (id <= 0 ) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     * 是否为管理员
     * @param request
     * @return
     */
    private boolean isAdmin(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(URL_LOGIN_STATE);
        User user = (User) userObj;

        return user != null && user.getUserRole() == UserConstant.ADMIN_ROLE;
    }
}
