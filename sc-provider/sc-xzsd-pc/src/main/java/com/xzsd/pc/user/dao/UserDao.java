package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description User
 * @Author chenchaotao
 * @Date 2020-08-22
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号或手机号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUser(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int saveUser(UserInfo userInfo);

    /**
     * 查出原加密密码
     * @param userInfo
     * @return 原加密密码
     */
    String findPwd(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);

    /**
     * 查询用户详情
     * @param userCode 用户编号
     * @return 查询结果
     */
    UserInfo getUserByUserCode(@Param("userCode")String userCode);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param listCode 选中的用户编号集合
     * @param Id 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("Id")String Id);
}
