package com.xzsd.app.homePage.entity;

import java.util.List;

/**
 * @description app首页实体类
 * @author jintian
 * @date 2020-08-31
 */
public class HomePageInfo {
    /**
     * 轮播图路径
     */
    private String chartRoute;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 乡村编码
     */
    private String villageCode;
    /**
     * 乡村名称
     */
    private String villageName;
    /**
     * 乡村介绍
     */
    private String villageIntroduce;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 展示数量
     */
    private int showNumber;
    /**
     * 版本号
     */
    private String version;

    /**
     * List
     * @param chartRoute
     */
    private List<HomePageInfo> homePageInfoList;

    public void setChartRoute(String chartRoute) {
        this.chartRoute = chartRoute;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChartRoute() {
        return chartRoute;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getVillageIntroduce() {
        return villageIntroduce;
    }

    public void setVillageIntroduce(String villageIntroduce) {
        this.villageIntroduce = villageIntroduce;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getShowNumber() {
        return showNumber;
    }

    public String getVersion() {
        return version;
    }

    public List<HomePageInfo> getHomePageInfoList() {
        return homePageInfoList;
    }

    public void setHomePageInfoList(List<HomePageInfo> homePageInfoList) {
        this.homePageInfoList = homePageInfoList;
    }
}
