package com.xzsd.app.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.entity.GoodsClassInfo;
import com.xzsd.app.goods.entity.GoodsEvaluates;
import com.xzsd.app.goods.entity.VillageInfo;
import com.xzsd.app.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 商品管理
 * @author chenchaotao
 * @time 2020-08-25
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    /**
     * getGoods 查询商品详情
     * @param goodsCode
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-25
     */
    @RequestMapping(value = "getGoods")
    public AppResponse getGoods(String goodsCode){
        try{
            return goodsService.getGoods(goodsCode);
        }catch (Exception e){
            logger.error("商品查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * getGoodsAppraise 查询产品评价列表
     * @param goodsEvaluates
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-25
     */
    @RequestMapping(value = "getGoodsAppraise")
    public AppResponse getGoodsAppraise(GoodsEvaluates goodsEvaluates){
        try{
            return goodsService.getGoodsAppraise(goodsEvaluates);
        }catch (Exception e){
            logger.error("查询商品评价列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询查询商品一级分类接口
     * @author zhong
     * @date 2020-08-25
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
     * @date 2020-08-25
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
     * getVillageList 乡村信息列表
     * @param villageInfo
     * @return AppResponse
     * @author chenchaotao
     * @Date 2020-08-23
     */
    @RequestMapping(value = "getVillageList")
    public AppResponse listVillageByPage(VillageInfo villageInfo){
        try{
            return goodsService.listVillageByPage(villageInfo);
        }catch (Exception e){
            logger.error("查询乡村信息列表异常",e);
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
            return goodsService.listArea(parentCode);
        }catch (Exception e){
            logger.error("查询区列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
