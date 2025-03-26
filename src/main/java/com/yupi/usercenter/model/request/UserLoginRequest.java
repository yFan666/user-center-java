package com.yupi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Youli
 */
@Data
public class UserLoginRequest implements Serializable {

    // 不同的序列化
    private static final long serialVersionUID = -2358150331001097675L;

    private String userAccount;

    private String userPassword;
}
