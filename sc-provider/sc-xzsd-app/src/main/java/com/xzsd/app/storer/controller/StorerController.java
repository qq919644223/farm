package com.xzsd.app.storer.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.storer.service.StorerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 站长信息和首页
 * @author jintian
 * @date 2020-08-31
 */
@RestController
@RequestMapping("/storer")
public class StorerController {
    private static final Logger logger = LoggerFactory.getLogger(StorerController.class);
    @Resource
    private StorerService storerService;
    /**
     * 查询站长个人信息
     * @param
     * @return AppResponse
     * @author jintian
     * @date 2020-08-31
     */
    @PostMapping("getStoreByCode")
    private AppResponse getStoreByCode(){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return storerService.getStoreByCode(userId);
        }catch (Exception e){
            logger.error("查询店长门店信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询区域供应商信息（站长端）
     * @param
     * @return AppResponse
     * @author jintian
     * @date 2020-8-31
     */
    @RequestMapping(value = "getStoreSupplierByCode")
    public AppResponse getStoreSupplierByCode(){
        try{
            //获取当前用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return storerService.getStoreSupplierByCode(userCode);
        } catch (Exception e) {
            logger.error("查询失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
