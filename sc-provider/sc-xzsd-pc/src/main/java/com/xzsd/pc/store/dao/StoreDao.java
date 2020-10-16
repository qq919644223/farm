package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreDao {
    /**
     * 统计营业执照或站点编号数量
     * @param storeInfo
     * @return
     */
    int countCode(StoreInfo storeInfo);

    /**
     * 新增站点信息
     * @param storeInfo
     * @return
     */
    int saveStore(StoreInfo storeInfo);

    /**
     * 获取所有站点信息
     * @param  storeInfo
     * @return 所有站点信息
     */
    List<StoreInfo> listStoreByPage(StoreInfo storeInfo);

    /**
     * 查询站点详情
     * @param storeCode 站点编号
     * @return 查询结果
     */
    StoreInfo getStoreByStoreCode(@Param("storeCode")String storeCode);

    /**
     * 修改站点信息
     * @param storeInfo 站点信息
     * @return 修改结果
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 查询输入的站点编号中是否有未完成的订单
     * @param listCode
     * @return
     */
    List<String> listOrder(@Param("listCode") List<String> listCode);

    /**
     * 删除站点
     * @param listStoreCode 选中的门店编号集合
     * @param Id 更新人
     * @return
     */
    int deleteStore(@Param("listStoreCode") List<String> listStoreCode, @Param("Id")String Id);

    /**
     * 查询省市区下拉列表
     * @param parentCode
     * @return 省市区列表信息
     */
    List<AreaInfo> listArea(@Param("parentCode") String parentCode);

    /**
     * 查询站长编码
     * @param storeInfo
     * @return
     */
    List<StoreInfo> listStoreBoss(StoreInfo storeInfo);

    /**
     * 获取登录角色的角色标记
     * @param userCode
     * @return
     */
    StoreInfo getUserRole(@Param("userCode") String userCode);
}
