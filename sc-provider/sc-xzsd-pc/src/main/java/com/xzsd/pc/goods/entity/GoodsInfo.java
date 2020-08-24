package com.xzsd.pc.goods.entity;

/**
 * 产品的对象
 * @author zhong
 * @date 2020-08-22
 *
 */
public class GoodsInfo {
    /**
     * 产品名称
     */
    private String goodsName;
    /**
     * 产品编码
     */
    private String goodsCode;
    /**
     * 一级分类编码
     */
    private String classFirstCode;
    /**
     * 二级分类编码
     */
    private String classSecondCode;
    /**
     * 广告
     */
    private String advertisement;
    /**
     * 产品介绍
     */
    private String goodsIntroduce;
    /**
     * 供应商编码
     */
    private String userCode;
    /**
     * 库存
     */
    private String stock;
    /**
     * 成本价
     */
    private String costPrice;
    /**
     * 售价
     */
    private String salePrice;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 保质期
     */
    private String qualityDate;
    /**
     * 出品地址
     */
    private String goodsAddress;
    /**
     * 产品的状态
     */
    private String goodsState;
    /**
     * 审核状态
     */
    private int audit;
    /**
     * 作废标记 0保留 1删除
     */
    private int isDeleted;
    /**
     * 用户角色标记
     */
    private int role;
    /**
     * 当前登录人id
     */
    private String userId;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateName;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本号
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
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

    public String getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(String qualityDate) {
        this.qualityDate = qualityDate;
    }

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
