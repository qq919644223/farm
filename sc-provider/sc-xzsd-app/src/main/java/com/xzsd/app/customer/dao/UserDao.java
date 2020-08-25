package com.xzsd.app.customer.dao;

import com.xzsd.app.customer.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UsersDao
 * @author zhong
 * @date 2020-08-24
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @author zhong
     * @date 2020-08-24
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);
    /**
     * 校验用户手机号码是否存在
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    int countUserPhone(UserInfo userInfo);
    /**
     * 校验用户邮箱是否存在
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    int countEmail(UserInfo userInfo);

    /**
     * 校验用户账号和手机号码是否重复
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    int countUsers(UserInfo userInfo);

    /**
     * 新增客户信息用户客户表
     * @author zhong
     * @date 2020-08-24
     *  @param userInfo 用户信息
     * @return
     */
    int userRegister(UserInfo userInfo);

    /**
     * 新增用户信息到客户表
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    int saveUserToCus(UserInfo userInfo);

    /**
     * 获取用户信息
     * @author zhong
     * @date 2020-08-24
     * @param userCode
     * @return
     */
    UserInfo getUserById(@Param("userCode") String userCode);
    /**
     * 获取用户密码
     * @author zhong
     * @date 2020-08-24
     * @param userCode
     * @return
     */
    UserInfo getUser(@Param("userCode") String userCode);
    /**
     * 修改密码
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    int updateUserPassword(UserInfo userInfo);

    /**
     * 获取用户信息
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    UserInfo getMysef(UserInfo userInfo);




}
