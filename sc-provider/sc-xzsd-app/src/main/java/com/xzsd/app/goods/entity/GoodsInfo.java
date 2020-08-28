package com.xzsd.app.goods.entity;

public class GoodsInfo {
    /**
     * 产品编号
     */
    private String goodsCode;
    /**
     * 产品名称
     */
    private String goodsName;
    /**
     * 产品介绍
     */
    private String goodsIntroduce;
    /**
     * 站点编码
     */
    private String storeCode;
    /**
     * 站点名称
     */
    private String storeName;
    /**
     * 售价
     */
    private String salePrice;
    /**
     * 产品图片路径
     */
    private String imagePath;
    /**
     * 评价星级
     */
    private String appraiseLeve;
    /**
     * 库存
     */
    private String stock;
    /**
     * 购买数量
     */
    private String orderSum;
    /**
     * 版本号
     */
    private String version;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAppraiseLeve() {
        return appraiseLeve;
    }

    public void setAppraiseLeve(String appraiseLeve) {
        this.appraiseLeve = appraiseLeve;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(String orderSum) {
        this.orderSum = orderSum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
