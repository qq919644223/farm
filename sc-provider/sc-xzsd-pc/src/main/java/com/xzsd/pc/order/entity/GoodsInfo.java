package com.xzsd.pc.order.entity;

/**
 * 商品实体类
 * 2020-08-26
 * zhong
 * @author 12533
 */
public class GoodsInfo {
    /**
     * 商品编码
    */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 成本价
     */
    private float costPrice;
    /**
     * 售价
     */
    private float salePrice;
    /**
     * 销售量
     */
    private int sumSale;
    /**
     * 商家名称
     */
    private String supplierName;
    /**
     * 分类编码
     */
    private String classCode;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 一级分类编码
     */
    private String classFirstCode;
    /**
     * 一级分类名称
     */
    private String classFirstName;
    /**
     * 二级分类编码
     */
    private String classSecondCode;
    /**
     * 二级分类名称
     */
    private String classSecondName;
    /**
     * 广告词
     */
    private String advertisement;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品状态 1下架  2上架（在售） 3未发布
     */
    private int goodsState ;
    /**
     * 上架时间
     */
    private String upTime;
    /**
     * 浏览量
     */
    private int browse;
    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 库存
     */
    private int stock;
    /**
     * 书号ISBN
     */
    private String isbn;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String publisher;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 购买数量
     */
    private String orderSum;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建者
     */
    private String createName;
    /**
     * 创建时间
     * @return
     */
    private String createTime;
    /**
     * 更新人
     * @return
     */
    private String updateName;
    /**
     * 更新时间
     * @return
     */
    private String updateTime;
    /**
     * 版本号
     * @return
     */
    private String version;

    /**
     * 页码
     * @return
     */
    private int pageSize;

    /**
     * 页数
     * @return
     */
    private int pageNum;


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

    public String getClassFirstName() {
        return classFirstName;
    }

    public void setClassFirstName(String classFirstName) {
        this.classFirstName = classFirstName;
    }

    public String getClassFirstCode() {
        return classFirstCode;
    }

    public void setClassFirstCode(String classFirstCode) {
        this.classFirstCode = classFirstCode;
    }

    public String getClassSecondCode() {
        return classSecondCode;
    }

    public void setClassSecondCode(String classSecondCode) {
        this.classSecondCode = classSecondCode;
    }

    public String getClassSecondName() {
        return classSecondName;
    }

    public void setClassSecondName(String classSecondName) {
        this.classSecondName = classSecondName;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getSumSale() {
        return sumSale;
    }

    public void setSumSale(int sumSale) {
        this.sumSale = sumSale;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public int getBrowse() {
        return browse;
    }

    public void setBrowse(int browse) {
        this.browse = browse;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(String orderSum) {
        this.orderSum = orderSum;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
