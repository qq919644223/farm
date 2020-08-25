package com.xzsd.app.goods.entity;

import java.util.List;

public class GoodsEvaluates {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 评价编号
     */
    private String appraiseCode;
    /**
     * 客户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品等级(差评按钮传值为1，中评为3，好评为5)
     */
    private int appraiseLevel;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String appraiseDetai;
    /**
     * 评价图片列表
     */
    private List<EvaluateImage> imageInfoList;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private String gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;

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

    public String getAppraiseCode() {
        return appraiseCode;
    }

    public void setAppraiseCode(String appraiseCode) {
        this.appraiseCode = appraiseCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getAppraiseLevel() {
        return appraiseLevel;
    }

    public void setAppraiseLevel(int appraiseLevel) {
        this.appraiseLevel = appraiseLevel;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getAppraiseDetai() {
        return appraiseDetai;
    }

    public void setAppraiseDetai(String appraiseDetai) {
        this.appraiseDetai = appraiseDetai;
    }

    public List<EvaluateImage> getImageInfoList() {
        return imageInfoList;
    }

    public void setImageInfoList(List<EvaluateImage> imageInfoList) {
        this.imageInfoList = imageInfoList;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}