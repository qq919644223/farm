package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetailInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Class OrderDao
 * @Description Order
 * @author jintian
 * @date 2020-08-24
 */
@Mapper
public interface OrderDao {
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    List<OrderDetailInfo> getOrderByOrderCode(@Param("orderCode") String orderCode);
    /**
     * 订单列表（管理员）
     * @param orderInfo
     * @return
     */
    List<OrderInfo> listAdminOrderByPage(OrderInfo orderInfo);
    /**
     * 订单列表(站长)
     * @param orderInfo
     * @return
     */
    List<OrderInfo> listStoreOrderByPage(OrderInfo orderInfo);
    /**
     * 查询订单相关商品购买数量
     * @param listCode
     * @return
     */
    List<OrderDetailInfo> getListOrderDetail(@Param("listCode") List<String> listCode);
    /**
     * 回滚商品库存
     * @param listBuyNumber
     * @return
     */
    int updateStock(@Param("listBuyNumber") List<OrderDetailInfo> listBuyNumber);
    /**
     * 修改订单状态
     * @param listCode
     * @param orderState
     * @param listVersion
     * @param userId
     * @return
     */
    int updateOrderState(@Param("listCode") List<String> listCode, @Param("orderState") String orderState, @Param("listVersion") List<String> listVersion, @Param("userId") String userId);
}
