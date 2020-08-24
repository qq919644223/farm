package com.xzsd.pc.hotVillage.entity;

/**
 * @Description 热门乡村实体类
 * @author jintian
 * @date 2020-08-23
 */
public class HotVillageInfo {
    /**
     * 热门乡村编号
     */
    private String hotCode;
    /**
     * 乡村编号
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
     * 排序序号
     */
    private int hotId;
    /**
     * 展示数量
     */
    private int showNo;
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
     * 版本号
     */
    private String version;

    public void setHotCode(String hotCode) {
        this.hotCode = hotCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public void setVillageIntroduce(String villageIntroduce) {
        this.villageIntroduce = villageIntroduce;
    }

    public void setHotId(int hotId) {
        this.hotId = hotId;
    }

    public void setShowNo(int showNo) {
        this.showNo = showNo;
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

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHotCode() {
        return hotCode;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getVillageIntroduce() {
        return villageIntroduce;
    }

    public int getHotId() {
        return hotId;
    }

    public int getShowNo() {
        return showNo;
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

    public String getVersion() {
        return version;
    }
}
