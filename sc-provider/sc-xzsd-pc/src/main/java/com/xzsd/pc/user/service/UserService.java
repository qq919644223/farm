package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 用户管理实现类
 * @Author chenchaotao
 * @Date 2020-08-22
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    /**
     * saveUser 新增用户
     * @param userInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(UserInfo userInfo) {
        // 校验账号是否存在
        int countUser = userDao.countUser(userInfo);
        if(0 != countUser) {
            return AppResponse.bizError("用户账号或手机号已存在，请重新输入！");
        }
        //密码加密
        if (userInfo.getUserPassword() != null) {
            //查出数据库里原加密密码，如果不修改密码，密码无需再次加密
            String password = userDao.findPwd(userInfo);
            if (!userInfo.getUserPassword().equals(password)){
                String pwd = PasswordUtils.generatePassword(userInfo.getUserPassword());
                userInfo.setUserPassword(pwd);
            }
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        // 新增用户
        int count = userDao.saveUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * listUsersByPage 查询用户列表（分页）
     * @param userInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-22
     */
    public AppResponse listUsersByPage(UserInfo userInfo){
        PageHelper.startPage(userInfo.getPageNum(),userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        //包装对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * getUserByUserCode 查询用户详情
     * @param userCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    public AppResponse getUserByUserCode(String userCode){
        UserInfo userInfo = userDao.getUserByUserCode(userCode);
        return AppResponse.success("查询成功！",userInfo);
    }

    /**
     * updateUser 修改用户信息
     * @param userInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号或手机号是否存在
        int countUser = userDao.countUser(userInfo);
        if(0 != countUser) {
            return AppResponse.bizError("用户账号或手机号已存在，请重新输入！");
        }
        //将新密码加密
        if(userInfo.getUserPassword() != null){
            String password = userDao.findPwd(userInfo);
            if (!userInfo.getUserPassword().equals(password)) {
                String pwd = PasswordUtils.generatePassword(userInfo.getUserPassword());
                userInfo.setUserPassword(pwd);
            }
        }
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据无变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * deleteUser 删除用户
     * @param userCode
     * @param Id
     * @return AppResponse
     * @Author chenchaotao
     * @Data 2020-03-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode,String Id){
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //删除用户
        int count = userDao.deleteUser(listCode,Id);
        if (0 == count){
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
