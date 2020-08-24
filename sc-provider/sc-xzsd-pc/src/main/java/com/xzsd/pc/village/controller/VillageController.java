package com.xzsd.pc.village.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.village.entity.VillageInfo;
import com.xzsd.pc.village.service.VillageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 乡村信息管理
 * @author chenchaotao
 * @time 2020-08-23
 */
@RestController
@RequestMapping("/village")
public class VillageController {
    private static final Logger logger = LoggerFactory.getLogger(VillageController.class);
    @Resource
    private VillageService villageService;
    /**
     * saveVillage 乡村信息新增
     * @param  villageInfo
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-23
     */
    @PostMapping("saveVillage")
    public AppResponse saveVillage(VillageInfo villageInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            villageInfo.setCreateBy(userId);
            AppResponse appResponse = villageService.saveVillage(villageInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("乡村信息新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * listVillageByPage 乡村信息列表
     * @param villageInfo
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-23
     */
    @RequestMapping(value = "listVillageByPage")
    public AppResponse listVillageByPage(VillageInfo villageInfo){
        try{
            return villageService.listVillageByPage(villageInfo);
        }catch (Exception e){
            logger.error("查询乡村信息列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * getVillageByVillageCode 查询乡村详情
     * @param villageCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-04-11
     */
    @RequestMapping(value = "getVillageByVillageCode")
    public AppResponse getVillageByVillageCode(String villageCode){
        try{
            return villageService.getVillageByVillageCode(villageCode);
        }catch (Exception e){
            logger.error("乡村详情查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * updateVillage 修改乡村信息
     * @param villageInfo
     * @return AppResponse
     * @author chenchaotao
     * @Data 2020-08-23
     */
    @PostMapping("updateVillage")
    public AppResponse updateVillage(VillageInfo villageInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            villageInfo.setLastModifiedBy(userId);
            return villageService.updateVillage(villageInfo);
        }catch (Exception e){
            logger.error("修改乡村信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * deleteVillage 删除门店
     * @param villageCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-23
     */
    @PostMapping("deleteVillage")
    public AppResponse deleteVillage(String villageCode){
        try{
            //获取用户id
            String Id = SecurityUtils.getCurrentUserId();
            return villageService.deleteVillage(villageCode,Id);
        }catch (Exception e){
            logger.error("乡村信息删除错误", e);
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
            return villageService.listArea(parentCode);
        }catch (Exception e){
            logger.error("查询区列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
