package com.xzsd.pc.supplier.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.supplier.entity.SupplierInfo;
import com.xzsd.pc.supplier.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 供应商管理
 * @author jintian
 * @date 2020-08-24
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    public static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
    @Resource
    public SupplierService supplierService;
    /**
     * 新增供应商信息
     * @param supplierInfo
     * @return AppResponse
     * @author jintian
     * @date 2020-04-13
     */
    @PostMapping("saveSupplier")
    public AppResponse saveSupplier(SupplierInfo supplierInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            supplierInfo.setCreateName(userId);
            return supplierService.saveSupplier(supplierInfo);
        } catch (Exception e) {
            logger.error("新增失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询供应商详情
     * @param userCode
     * @return AppResponse
     * @author jintian
     * @date 2020-04-13
     */
    @RequestMapping(value = "getSupplierByUserCode")
    public AppResponse getSupplierByUserCode(String userCode){
        try{
            return supplierService.getSupplierByCode(userCode);
        } catch (Exception e) {
            logger.error("查询失败失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改供应商信息
     * @param supplierInfo
     * @return AppResponse
     * @author jintian
     * @date 2020-08-25
     */
    @PostMapping("updateSupplier")
    public AppResponse updateSupplier(SupplierInfo supplierInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            supplierInfo.setCreateName(userId);
            return supplierService.updateSupplier(supplierInfo);
        } catch (Exception e) {
            logger.error("修改失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询供应商列表
     * @param supplierInfo
     * @return AppResponse
     * @author jintian
     * @date 2020-08-25
     */
    @RequestMapping(value = "listSupplierByPage")
    public AppResponse listSupplierByPage(SupplierInfo supplierInfo){
        try{
            return supplierService.listSupplierByPage(supplierInfo);
        } catch (Exception e) {
            logger.error("查询失败失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除供应商
     * @param userCode
     * @return AppResponse
     * @author jintian
     * @date 2020-08-25
     */
    @PostMapping("deleteSupplier")
    public AppResponse deleteSupplier(String userCode){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return supplierService.deleteSupplier(userCode, userId);
        } catch (Exception e) {
            logger.error("删除失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
