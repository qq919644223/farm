package com.xzsd.app.supplier.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.supplier.entity.GoodsInfo;
import com.xzsd.app.supplier.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Descripition 供应商
 * @author jintian
 * @date 2020-08-31
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
    @Resource
    private SupplierService supplierService;
    /**
     * 查询所属站点（供应商端）
     * @param
     * @return AppResponse
     * @author jintian
     * @date 2020-04-24
     */
    @RequestMapping(value = "getStoreBySupplier")
    public AppResponse getStoreBySupplier(){
        try{
            //获取当前用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return supplierService.getStoreBySupplier(userCode);
        } catch (Exception e) {
            logger.error("查询失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "getMyGoods")
    public AppResponse getMyGoods(GoodsInfo goodsInfo){
        try{
            return supplierService.getMyGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("查询失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询供应商信息
     * @param
     * @return AppResponse
     * @author jintian
     * @date 2020-08-31
     */
    @PostMapping("getMySelf")
    private AppResponse getMyself(){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return supplierService.getMyself(userId);
        }catch (Exception e){
            logger.error("查询店长门店信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
