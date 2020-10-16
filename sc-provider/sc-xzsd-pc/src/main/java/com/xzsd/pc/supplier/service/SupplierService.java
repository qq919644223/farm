package com.xzsd.pc.supplier.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.supplier.dao.SupplierDao;
import com.xzsd.pc.supplier.entity.SupplierInfo;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @Description 供应商实现类
 * @author jintian
 * @date 2020-08-24
 */
@Service
public class SupplierService {
    @Resource
    public SupplierDao supplierDao;
    /**
     * 新增供应商
     * @param supplierInfo
     * @return Appresponse
     * @author jintian
     * @date 2020-04-13
     */
    public AppResponse saveSupplier(SupplierInfo supplierInfo){
        //校验供应商账号是否存在
        int countAcct = supplierDao.countAcct(supplierInfo);
        if(countAcct != 0){
            return AppResponse.success("供应商账号已存在，请重新输入！");
        }
        supplierInfo.setUserCode(StringUtil.getCommonCode(2));
        supplierInfo.setIsDeleted(0);
        //密码加密
        supplierInfo.setUserPassword(PasswordUtils.generatePassword(supplierInfo.getUserPassword()));
        //新增供应商信息（用户表）
        int countUser = supplierDao.addSupplierToUser(supplierInfo);
        if(countUser == 0){
            return AppResponse.success("新增用户表失败，请重试！");
        }
        //新增供应商表信息
        int countDriver = supplierDao.addSupplier(supplierInfo);
        if(countDriver == 0){
            return AppResponse.success("新增供应商表失败，请重试");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 查询供应商详情
     * @param userCode
     * @return Appresponse
     * @author jintian
     * @date 2020-04-13
     */
    public AppResponse getSupplierByCode(String userCode){
        SupplierInfo supplierInfo = supplierDao.getSupplierByCode(userCode);
        return AppResponse.success("查询成功！",supplierInfo);
    }
    /**
     * 修改供应商信息
     * @param supplierInfo
     * @return Appresponse
     * @Author jintian
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSupplier(SupplierInfo supplierInfo) {
        //校验供应商账号是否存在
        int countAcct = supplierDao.countAcct(supplierInfo);
        if(countAcct != 0){
            return AppResponse.success("供应商账号已存在，请重新输入！");
        }
        //查询原密码
        String userOldPwd = supplierDao.getUserPwd(supplierInfo);
        //校验密码是否相同
        if(!userOldPwd.equals(supplierInfo.getUserPassword())){
            if(!PasswordUtils.passwordMatch(supplierInfo.getUserPassword(),userOldPwd)){
                //密码加密
                supplierInfo.setUserPassword(PasswordUtils.generatePassword(supplierInfo.getUserPassword()));
            }else{
                //如果传入密码与原密码相同，将加密过原密码替代传入密码
                supplierInfo.setUserPassword(userOldPwd);
            }
        }
        // 修改用户表供应商信息
        int countUser = supplierDao.updateUser(supplierInfo);
        if (0 == countUser) {
            return AppResponse.versionError("用户表数据有变化，请刷新！");
        }
        // 修改供应商表信息
        int countDriver = supplierDao.updateSupplier(supplierInfo);
        if (0 == countDriver) {
            return AppResponse.versionError("供应商表数据有变化，请刷新！");
        }
        return AppResponse.success("修改成功！");
    }
    /**
     * 查询供应商列表
     * @param supplierInfo
     * @return
     * @author jintian
     * @date 2020-04-13
     */
    public AppResponse listSupplierByPage(SupplierInfo supplierInfo){
        String roleCode = SecurityUtils.getCurrentUserId();
        supplierInfo.setRoleCode(roleCode);
        List<SupplierInfo> listDriver = supplierDao.listSupplierByPage(supplierInfo);
        return AppResponse.success("查询成功！",getPageInfo(listDriver));
    }
    /**
     *删除供应商
     * @param userCode
     * @param userId
     * @return
     * @Author jintian
     * @Date 2020-08-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSupplier(String userCode, String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        // 删除用户表供应商
        int countUser = supplierDao.deleteUser(listCode, userId);
        if (0 == countUser) {
            return AppResponse.bizError("删除用户表失败，请重试！");
        }
        // 删除供应商表供应商
        int countDriver = supplierDao.deleteSupplier(listCode, userId);
        if (0 == countDriver) {
            return AppResponse.bizError("删除供应商表失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

}
