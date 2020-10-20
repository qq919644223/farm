package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * 订单实体类
 * @author zhong
 * @date 2020-04-14
 */
public class ClientOrderInfo {
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 付款时间
     */
    private String createTime;
    /**
     * 订单详情编码
     */
    private String detailCode;
    /**
     * 客户编码
     */
    private String userCode;
    /**
     * 订单总价
     */
    private float orderMoney;
    /**
     * 选择商品的数量
     */
    private int sumOrder;
    /**
     * 购买数量
     */
    private int orderSum;
    /**
     * 订单状态  订单状态 0取消订单 1到货 2取消到货 3已取货 4取消已取货 5已完成（已完成未评价） 6取消已完成 7已付款 8已完成已评价
     */
    private int orderState;
    /**
     * 该订单购买是商品总数量
     */
    private int sumGoods;
    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 收件人
     */
    private String getName;
    /**
     * 省份名称
     */
    private String provinceName;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 区名称
     */
    private String areaName;
    /**
     * 详情地址
     */
    private String address;

    /**
     * 商品集合
     */
    private List<GoodsInfo> goodsList;
    /**
     * 下单人
     */
    private String userName;
    /**
     * 下单人手机号码
     */
    private String phone;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品的平均星级
     */
    private String avgLevel;
    /**
     * 当前商品的库存
     */
    private int stock;
    /**
     * 销售量
     */
    private int sumSale;

    /**
     * 商品售价
     */
    private float salePrice;
    /**
     * 商品成本价
     */
    private float costPrice;

    /**
     * 付款时间区间
     */
    private String startPayTime;
    private String endPayTime;
    /**
     * 角色 1管理员  2客户 3店长 4司机
     */
    private int role;
    /**
     * 店铺邀请码
     */
    private String inviteCode;
    /**
     * 当前登录人id
     */
    private String userId;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 商品图片
     */
    private String imagePath;

    /**
     * 评价内容
     */
    private String appraiseDetail;
    /**
     * 评价星级
     */
    private int appraiseLevel;
    /**
     * 图片顺序
     */
    private int imageNum;
    /**
     * 创建人
     */
    private String createName;
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

    /**
     * 商品集合
     * @return
     */
    private List<GoodsInfo> goodsInfoList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public float getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(float orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartPayTime() {
        return startPayTime;
    }

    public void setStartPayTime(String startPayTime) {
        this.startPayTime = startPayTime;
    }

    public String getEndPayTime() {
        return endPayTime;
    }

    public void setEndPayTime(String endPayTime) {
        this.endPayTime = endPayTime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getSumGoods() {
        return sumGoods;
    }

    public void setSumGoods(int sumGoods) {
        this.sumGoods = sumGoods;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppraiseDetail() {
        return appraiseDetail;
    }

    public void setAppraiseDetail(String appraiseDetail) {
        this.appraiseDetail = appraiseDetail;
    }

    public int getAppraiseLevel() {
        return appraiseLevel;
    }

    public void setAppraiseLevel(int appraiseLevel) {
        this.appraiseLevel = appraiseLevel;
    }

    public int getImageNum() {
        return imageNum;
    }

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(int sumOrder) {
        this.sumOrder = sumOrder;
    }

    public int getSumSale() {
        return sumSale;
    }

    public void setSumSale(int sumSale) {
        this.sumSale = sumSale;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public String getAvgLevel() {
        return avgLevel;
    }

    public void setAvgLevel(String avgLevel) {
        this.avgLevel = avgLevel;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }
}
