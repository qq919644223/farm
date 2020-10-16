package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 站点信息管理
 * @author chenchaotao
 * @time 2020-08-22
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;

    /**
     * saveStore 站点信息新增
     * @param  storeInfo
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @PostMapping("saveStore")
    public AppResponse saveStore(StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userId);
            AppResponse appResponse = storeService.saveStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("站点信息新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * listStoreByPage 站点信息列表
     * @param storeInfo
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @RequestMapping(value = "listStoreByPage")
    public AppResponse listStoreByPage(StoreInfo storeInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUserCode(userId);
            return storeService.listStoreByPage(storeInfo);
        }catch (Exception e){
            logger.error("查询站点信息列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * getStoreByStoreCode 查询站点详情
     * @param storeCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @RequestMapping(value = "getStoreByStoreCode")
    public AppResponse getStoreByStoreCode(String storeCode){
        try{
            return storeService.getStoreByStoreCode(storeCode);
        }catch (Exception e){
            logger.error("站点详情查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * updateStore 修改站点信息
     * @param storeInfo
     * @return AppResponse
     * @author chenchaotao
     * @Data 2020-08-22
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setLastModifiedBy(userId);
            return storeService.updateStore(storeInfo);
        }catch (Exception e){
            logger.error("修改站点信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * deleteStore 删除站点
     * @param storeCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-22
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeCode){
        try{
            //获取用户id
            String Id = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeCode,Id);
        }catch (Exception e){
            logger.error("站点删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * listArea 省市区列表下拉查询
     * @param parentCode
     * @return AppResponse
     * @author chenchaotao
     * @date 2020-08-23
     */
    @PostMapping("listArea")
    public AppResponse listArea(String parentCode){
        try{
            return storeService.listArea(parentCode);
        }catch (Exception e){
            logger.error("查询区列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *
     * @param storeInfo
     * @return
     */
    @RequestMapping(value = "listStoreBoss")
    public AppResponse listStoreBoss(StoreInfo storeInfo){
        try{
            return storeService.listStoreBoss(storeInfo);
        } catch (Exception e) {
            logger.error("查询失败失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
