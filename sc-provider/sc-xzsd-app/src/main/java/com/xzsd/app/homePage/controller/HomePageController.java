package com.xzsd.app.homePage.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.homePage.service.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description app客户端
 * @author jintian
 * @date 2020-08-31
 */
@RestController
@RequestMapping("/homePage")
public class HomePageController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
    @Resource
    private HomePageService homePageService;
    /**
     * 查询首页轮播图
     * @param
     * @return AppResponse
     * @author jintian
     * @date 2020-04-22
     */
    @RequestMapping(value = "getPictureShow")
    public AppResponse getPictureShow(){
        try{
            return homePageService.getPictureShow();
        } catch (Exception e) {
            logger.error("查询失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门乡村
     * @param
     * @return AppResponse
     * @author jintian
     * @date 2020-04-22
     */
    @RequestMapping(value = "getHotVillage")
    public AppResponse getHotVillage(){
        try{
            return homePageService.getHotVillage();
        } catch (Exception e) {
            logger.error("查询失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @author zhong
     * @date 2020-08-31
     * @param villageCode
     * @return
     */
    @RequestMapping(value = "getVillageAndGoods")
    public AppResponse getVillageAndGoods(String villageCode) {
        try {
            return homePageService.getVillageAndGoods(villageCode);
        } catch (Exception e) {
            logger.error("查询乡村和商品失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
