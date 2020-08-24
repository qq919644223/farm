package com.xzsd.pc.order.entity;

/**
 * @Description 订单实体类
 * @author jintian
 * @date 2020-08-24
 */
public class OrderInfo {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态(0已下单，1已取消，2已到货，3已取货，4已完成未评价，5已完成已评价)
     */
    private String orderState;
    /**
     * 站点编号
     */
    private String storeCode;
    /**
     * 下单人编号
     */
    private String userCode;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人手机
     */
    private String phone;
    /**
     * 订单总金额
     */
    private double orderMoney;
    /**
     * 支付时间（下单时间）
     */
    private String payTime;
    /**
     * 支付时间（查询）
     */
    private String startPayTime;
    /**
     * 支付时间（查询）
     */
    private String endPayTime;
    /**
     * 订单地址
     */
    private String orderAddress;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 角色(1 管理员 2 店长 3 司机 4 客户)
     */
    private String role;
    /**
     * 角色编号
     */
    private String roleCode;
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

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public void setStartPayTime(String startPayTime) {
        this.startPayTime = startPayTime;
    }

    public void setEndPayTime(String endPayTime) {
        this.endPayTime = endPayTime;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

    public String getOrderCode() {
        return orderCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public String getPayTime() {
        return payTime;
    }

    public String getStartPayTime() {
        return startPayTime;
    }

    public String getEndPayTime() {
        return endPayTime;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getRole() {
        return role;
    }

    public String getRoleCode() {
        return roleCode;
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
