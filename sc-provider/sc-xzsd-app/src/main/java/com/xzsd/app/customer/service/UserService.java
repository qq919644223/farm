package com.xzsd.app.customer.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.customer.dao.UserDao;
import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 实现类
 * @author zhong
 * @date 2020-08-24
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    /**
     * 注册用户
     * @param userInfo
     * @return
     * @author zhong
     * @date 2020-08-24
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse userRegister(UserInfo userInfo){
        //检验用户账号和手机号码是否存在
        int countUsers = userDao.countUsers(userInfo);
        if (0 != countUsers){
            return AppResponse.bizError("用户账号或手机号码已存在，请重新输入");
        }
        // 密码加密
        String password = PasswordUtils.generatePassword(userInfo.getUserPassword());
        userInfo.setUserPassword(password);
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        //新增客户信息到用户表
        int count = userDao.userRegister(userInfo);
        //新增客户信息到客户表
        int countTnCustomer = userDao.saveUserToCus(userInfo);
        if (0 == count && 0 ==countTnCustomer){
            return AppResponse.bizError("注册失败，请重试！");
        }
        return AppResponse.success("注册成功！");
    }

    /**
     * 修改密码
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserPassword(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改密码成功！");
        // 需要校验原密码是否正确
        if(null != userInfo.getUserPassword() && !"".equals(userInfo.getUserPassword())) {
                //获取用户id
                String userId = SecurityUtils.getCurrentUserId();
                userInfo.setUpdateName(userId);
                userInfo.setUserCode(userId);
                String oldPassword = userInfo.getUserPassword();
                //原密码已加密
                UserInfo user = userDao.getUser(userInfo.getUserCode());
                if(!PasswordUtils.Password(oldPassword,user.getUserPassword())) {
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
        }
        // 修改密码
        userInfo.setUserNewPassword(PasswordUtils.generatePassword(userInfo.getUserNewPassword()));
        int count = userDao.updateUserPassword(userInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 获取用户信息
     * @author zhong
     * @date 2020-08-24
     * @param userInfo
     * @return
     */
    public AppResponse getMyself(UserInfo userInfo) {
        UserInfo clientMessage = userDao.getMysef(userInfo);
        return AppResponse.success("查询成功！",clientMessage);
    }

}
