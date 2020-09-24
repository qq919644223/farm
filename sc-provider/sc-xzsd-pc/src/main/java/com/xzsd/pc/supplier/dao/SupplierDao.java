package com.xzsd.pc.supplier.dao;

import com.xzsd.pc.supplier.entity.SupplierInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description DriverDao
 * @author jintian
 * @date 2020-08-24
 */
@Mapper
public interface SupplierDao {
    /**
     * 校验供应商信息是否存在
     * @param supplierInfo
     * @return
     */
    int countAcct(SupplierInfo supplierInfo);
    /**
     * 新增用户表供应商信息
     * @param supplierInfo
     * @return
     */
    int addSupplierToUser(SupplierInfo supplierInfo);
    /**
     * 新增供应商信息
     * @param supplierInfo
     * @return
     */
    int addSupplier(SupplierInfo supplierInfo);
    /**
     * 查询供应商详情
     * @param userCode
     * @return
     */
    SupplierInfo getSupplierByCode(@Param("userCode")String userCode);
    /**
     * 查询用户密码
     * @param supplierInfo
     * @return
     */
    String getUserPwd(SupplierInfo supplierInfo);
    /**
     * 修改用户供应商信息
     * @param supplierInfo
     * @return
     */
    int updateUser(SupplierInfo supplierInfo);
    /**
     * 修改供应商信息
     * @param supplierInfo
     * @return
     */
    int updateSupplier(SupplierInfo supplierInfo);
    /**
     * 查询供应商列表
     * @param supplierInfo
     * @return
     */
    List<SupplierInfo> listSupplierByPage(SupplierInfo supplierInfo);
    /**
     * 删除用户表信息
     * @param listCode
     * @param userId
     * @return
     */
    int deleteUser(@Param("listCode")List<String> listCode, @Param("userId") String userId);
    /**
     * 删除供应商表信息
     * @param listCode
     * @param userId
     * @return
     */
    int deleteSupplier(@Param("listCode")List<String> listCode, @Param("userId") String userId);
}
