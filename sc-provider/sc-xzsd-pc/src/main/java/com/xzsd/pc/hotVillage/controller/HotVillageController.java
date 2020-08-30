package com.xzsd.pc.hotVillage.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotVillage.entity.HotVillageInfo;
import com.xzsd.pc.hotVillage.service.HotVillageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 热门乡村管理
 * @Author jintian
 * @Date 2020-08-23
 */
@RestController
@RequestMapping("/hotVillage")
public class HotVillageController {
    private static final Logger logger = LoggerFactory.getLogger(HotVillageController.class);

    @Resource
    private HotVillageService hotVillageService;
    /**
     * 新增热门乡村
     * @param hotVillageInfo
     * @return Appresponse
     * @author jintian
     * @Date 2020-08-23
     */
    @PostMapping("saveHotVillage")
    public AppResponse saveHotVillage(HotVillageInfo hotVillageInfo){
        try{
            //获取当前用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotVillageInfo.setCreateName(userId);
            return hotVillageService.saveHotVillage(hotVillageInfo);
        } catch (Exception e) {
            logger.error("新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改热门乡村
     * @param hotVillageInfo
     * @return Appresponse
     * @author jintian
     * @Date 2020-08-23
     */
    @PostMapping("updateHotVillage")
    public AppResponse updateHotVillage(HotVillageInfo hotVillageInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotVillageInfo.setUpdateName(userId);
            return hotVillageService.updateHotVillage(hotVillageInfo);
        } catch (Exception e) {
            logger.error("修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门乡村列表
     * @param hotVillageInfo
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @PostMapping("listHotVillageByPage")
    public AppResponse listHotVillageByPage(HotVillageInfo hotVillageInfo){
        try{
            return hotVillageService.listVillage(hotVillageInfo);
        } catch (Exception e) {
            logger.error("查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门乡村详情
     * @param hotCode
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @RequestMapping(value = "getHotVillageByHotCode")
    public AppResponse getHotVillageByHotCode(String hotCode){
        try{
            return hotVillageService.getHotVillageByHotCode(hotCode);
        } catch (Exception e) {
            logger.error("查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除热门乡村
     * @param hotCode
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @PostMapping("deleteHotVillage")
    public AppResponse deleteHotVillage(String hotCode){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            return hotVillageService.deleteHotVillage(hotCode,userId);
        } catch (Exception e) {
            logger.error("删除失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询乡村信息列表
     * @param hotVillageInfo
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @PostMapping("listVillageByPage")
    public AppResponse listVillageByPage(HotVillageInfo hotVillageInfo){
        try{
            return hotVillageService.listVillageByPage(hotVillageInfo);
        } catch (Exception e) {
            logger.error("查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 设置展示热门乡村数量
     * @param hotVillageInfo
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @PostMapping("saveShowNo")
    public AppResponse saveShowNo(HotVillageInfo hotVillageInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotVillageInfo.setUpdateName(userId);
            return hotVillageService.saveShowNo(hotVillageInfo);
        } catch (Exception e) {
            logger.error("修改失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门乡村展示数量
     * @param
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @RequestMapping(value = "getShowNo")
    public AppResponse getShowNo(){
        try{
            return hotVillageService.getShowNo();
        } catch (Exception e) {
            logger.error("查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
