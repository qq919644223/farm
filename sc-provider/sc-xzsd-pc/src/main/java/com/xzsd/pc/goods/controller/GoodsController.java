package com.xzsd.pc.goods.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 产品的增删查改
 * @author zhong
 * @date 2020-08-22
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 新增产品
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    @PostMapping("saveGoods")
    public AppResponse saveGoods(GoodsInfo goodsInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateName(userId);
            AppResponse appResponse = goodsService.saveGoods(goodsInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("商品新增失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询产品详情
     * @author zhong
     * @date 2020-08-22
     * @param goodsCode
     * @return
     */
    @PostMapping("getGoodsByGoodsCode")
    public AppResponse getGoodsByGoodsCode(String goodsCode){
        try{
            return goodsService.getGoodsByGoodsCode(goodsCode);
        }catch (Exception e){
            logger.error("产品查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询产品列表
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    @PostMapping("listGoodsByPage")
    public AppResponse listGoodsByPage(GoodsInfo goodsInfo){
        try{
            return goodsService.listGoodsByPage(goodsInfo);
        }catch (Exception e){
            logger.error("查询列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询审核产品列表
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    @PostMapping("listAuditGoodsByPage")
    public AppResponse listAuditGoodsByPage(GoodsInfo goodsInfo){
        try{
            return goodsService.listAuditGoodsByPage(goodsInfo);
        }catch (Exception e){
            logger.error("查询列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除产品
     * @author zhong
     * @date 2020-08-22
     * @param goodsCode
     * @return
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode){
        try{
            //获取当前登录角色
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("产品删除失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品
     * @param goodsInfo
     * @author Zhong
     * @date 2020-08-22
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setUpdateName(userId);
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品修改上架下架状态
     * @param goodsCode
     * @author zhong
     * @date 2020-08-22
     * @return
     */
    @PostMapping("updateGoodsState")
    public AppResponse updateGoodsState(String goodsCode,int goodsState,String version) {
        try {
            //     获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.updateGoodsState(goodsCode,goodsState,version,userId);
        } catch (Exception e) {
            logger.error("产品修改状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 审核产品
     * @author zhong
     * @date 2020-08-24
     */
    @PostMapping("updateGoodsAudit")
    public AppResponse updateGoodsAudit(String goodsCode,int audit,String version){
        try {
            //     获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.updateGoodsAudit(goodsCode,audit,version,userId);
        } catch (Exception e) {
            logger.error("审核错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询查询商品一级分类接口
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    @RequestMapping(value = "getFirstClass")
    public AppResponse getFirstClass(GoodsClassInfo goodsClassInfo) {
        try {
            return goodsService.getFirstClass(goodsClassInfo);
        } catch (Exception e) {
            logger.error("一级分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级分类
     * @author zhong
     * @date 2020-08-22
     * @param lastClassCode
     * @return
     */
    @RequestMapping(value = "getSecondClass")
    public AppResponse getSecondClass(String lastClassCode) {
        try {
            return goodsService.getSecondClass(lastClassCode);
        } catch (Exception e) {
            logger.error("二级分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 获取所有站点
     * @author zhong
     * @date 2020-08-25
     * @param storeInfo
     * @return
     */
    @RequestMapping(value = "getAllStore")
    public AppResponse getAllStore (StoreInfo storeInfo){
        try{
            return goodsService.getAllStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
