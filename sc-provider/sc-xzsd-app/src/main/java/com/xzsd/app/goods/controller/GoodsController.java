package com.xzsd.app.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.entity.GoodsEvaluates;
import com.xzsd.app.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


}
