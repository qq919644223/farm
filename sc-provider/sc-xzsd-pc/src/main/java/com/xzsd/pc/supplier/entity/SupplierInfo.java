package com.xzsd.pc.supplier.entity;

/**
 * @Description 供应商实体类
 * @Author jintian
 * @date 2020-08-23
 */
public class SupplierInfo {
    /**
     * 供应商编号
     */
    private String userCode;
    /**
     * 供应商姓名
     */
    private String userName;
    /**
     * 角色
     */
    private String role;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 省编号
     */
    private String provinceCode;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市编号
     */
    private String cityCode;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区编号
     */
    private String areaCode;
    /**
     * 区名称
     */
    private String areaName;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创造时间
     */
    private String createTime;
    /**
     * 创建者
     */
    private String createName;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新者
     */
    private String updateName;
    /**
     * 版本号(用户表)
     */
    private String userVersion;
    /**
     * 版本号（供应商表）
     */
    private String supplierVersion;

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public void setUserVersion(String userVersion) {
        this.userVersion = userVersion;
    }

    public void setSupplierVersion(String supplierVersion) {
        this.supplierVersion = supplierVersion;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public String getUserVersion() {
        return userVersion;
    }

    public String getSupplierVersion() {
        return supplierVersion;
    }
}
