package com.xzsd.pc.user.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户管理
 * @Author chenchaotao
 * @Date 2020-08-22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    /**
     * saveUser 新增用户
     * @param userInfo
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-03-24
     */
    @PostMapping("saveUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * listUsersByPage 用户列表（分页）
     * @param userInfo
     * @return AppReesponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @RequestMapping(value = "listUsersByPage")
    public AppResponse listUsersByPage(UserInfo userInfo){
        try{
            return userService.listUsersByPage(userInfo);
        }catch (Exception e){
            logger.error("查询用户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * getUserByUserCode 查询用户详情
     * @param userCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @RequestMapping(value = "getUserByUserCode")
    public AppResponse findUserById(String userCode){
        try{
            return userService.getUserByUserCode(userCode);
        }catch (Exception e){
            logger.error("用户查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * updateUser 修改用户信息
     * @param userInfo
     * @return AppResponse
     * @author chenchaotoa
     * @Date 2020-03-06
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            userInfo.setLastModifiedBy(userCode);
            return userService.updateUser(userInfo);
        }catch (Exception e){
            logger.error("修改用户信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * deleteUser 删除用户
     * @param userCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode){
        try{
            //获取用户id
            String Id = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userCode,Id);
        }catch (Exception e){
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
