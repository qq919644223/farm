package com.xzsd.pc.order.entity;

public class OrderDetailInfo {
    /**
     * 订单详情编号
     */
    private String orderDetailCode;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 购买数量
     */
    private int orderSum;
    /**
     * 售价
     */
    private double salePrice;
    /**
     * 总金额
     */
    private double orderMoney;
    /**
     * 手机
     */
    private String phone;
    /**
     * 付款时间
     */
    private String  payTime;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新者
     */
    private String updateName;
    /**
     * 版本号
     */
    private String version;

    public void setOrderDetailCode(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOrderDetailCode() {
        return orderDetailCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getOrderSum() {
        return orderSum;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public String getPhone() {
        return phone;
    }

    public String getPayTime() {
        return payTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public String getVersion() {
        return version;
    }
}
