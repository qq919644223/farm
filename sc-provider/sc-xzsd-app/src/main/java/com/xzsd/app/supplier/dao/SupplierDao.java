package com.xzsd.app.supplier.dao;

import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.supplier.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className SupplierDao
 * @Description supplier
 * @author jintian
 * @date 2020-08-31
 */
@Mapper
public interface SupplierDao {
    /**
     * 查询所属站点（供应商端）
     * @param userCode
     * @return
     */
    List<UserInfo> getStoreBySupplier(@Param("userCode")String userCode);
    /**
     * 查询供应商个人信息
     * @param userId
     * @return
     */
    UserInfo getMyself(@Param("userId")String userId);

    /**
     * 获取提交的产品信息
     * @param goodsInfo
     * @return
     */
    List<GoodsInfo> getMyGoods(GoodsInfo goodsInfo);

    /**
     * 获取登录人的角色
     * @param userId
     * @return
     */
    GoodsInfo getRole(@Param("userId") String userId);
}
