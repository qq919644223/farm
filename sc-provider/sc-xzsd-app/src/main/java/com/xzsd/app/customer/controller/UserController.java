package com.xzsd.app.customer.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.customer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 增删查改
 * @author zhong
 * @date 2020-08-24
 */
@RestController
@RequestMapping("/client")
public class UserController {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    /**
     * 注册用户
     * @param userInfo
     * @return
     * @author zhong
     * @date 2020-08-24
     */
    @PostMapping("userRegister")
    public AppResponse userRegister(UserInfo userInfo){
        try {
            AppResponse appResponse = userService.userRegister(userInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("用户注册失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改密码
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(UserInfo userInfo) {
        try {
            return userService.updateUserPassword(userInfo);
        } catch (Exception e) {
            logger.error("修改异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询客户信息
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    @PostMapping("getMyself")
    private AppResponse getMyself(UserInfo userInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setUserId(userId);
            return userService.getMyself(userInfo);
        }catch (Exception e){
            logger.error("查询客户信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
