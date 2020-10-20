package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.AppraiseOrderInfo;
import com.xzsd.app.clientOrder.entity.CartOrderInfo;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsAppraiseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientOrderDao {

    /**
     * 修改订单状态
     * @date 2020-08-26
     * @author zhong
     * @param clientOrderInfo
     * @return
     */
    int updateOrderState(ClientOrderInfo clientOrderInfo);

    /**
     * 查询订单的商品编码 购买数量 商品的库存
     * @author zhong
     * @date 2020-08-26
     * @param orderCode
     * @return
     */
    List<ClientOrderInfo> getOrder(@Param("orderCode") String orderCode);
    /**
     * 修改商品的库存
     */
    int updateStock(@Param("clientOrderInfoList") List<ClientOrderInfo> clientOrderInfoList);
    /**
     * 修改商品的销售量
     */
    int updateSumSale(@Param("clientOrderInfoList") List<ClientOrderInfo> clientOrderInfoList);
    /**
     * 客户查询订单列表
     * @author zhong
     * @date 2020-08-26
     * @param clientOrderInfo
     * @return
     */
    List<ClientOrderInfo> getOrdersList(ClientOrderInfo clientOrderInfo);

    /**
     * 客户端查询订单详情
     * @author zhong
     * @date 2020-08-26
     * @param orderCode
     * @return
     */
    ClientOrderInfo getOrdersByCode(@Param("orderCode") String orderCode);

    //-----订单评价-----------------------------------------------------------------------
    /**
     * 新增订单评价
     * @author zhong
     * @date 2020-04-23
     * @param goodsAppraiseInfoList
     * @return
     */
    int saveOrdersAppraise(@Param("goodsAppraiseInfoList") List<GoodsAppraiseInfo> goodsAppraiseInfoList);
    /**
     * 更新商品的评价等级
     * @author zhong
     * @date 2020-08-26
     * @param levelList
     * @return
     */
    int updateGoodsLevel(@Param("levelList") List<ClientOrderInfo> levelList);
    /**
     * 查询当前下单商品的评价等级
     * @author zhong
     * @date 2020-08-26
     * @param listGoods
     * @return
     */
    List<ClientOrderInfo> countLevel(@Param("listGoods") List<String> listGoods);

    //----新增订单--------------------------------------------------------------
    /**
     * 新增订单到订单表
     * @param orderCode
     * @param userId
     * @param orderMoney
     * @return
     */
    int saveCartOrder(@Param("orderCode") String orderCode, @Param("userId") String userId, @Param("orderMoney") float orderMoney, @Param("sumGoods") int sumGoods,@Param("addressCode") String addressCode);

    /**
     * 新增订单到订单详细表
     * @author zhong
     * @date 2020-08-26
     * @param cartOrderInfoList
     * @return
     */
    int saveCartOrderDetail(@Param("cartOrderInfoList") List<CartOrderInfo> cartOrderInfoList);

    /**
     * 删除新增订单后购物车的商品
     * @author zhong
     * @date 2020-08-26
     * @param listCart
     * @return
     */
    int updateCartGoods(@Param("listCart") List<String> listCart, @Param("userId") String userId);

    /**
     * 查询下单商品的库存
     * @author zhong
     * @date 2020-08-26
     * @param listGoods
     * @return
     */
    List<Integer> countGoodsStock(@Param("listGoods") List<String> listGoods);

    /**
     * 查询下单商品的当前销售量
     * @author zhong
     * @date 2020-08-26
     * @param listGoods
     * @return
     */
//    List<Integer> countSumSale(@Param("listGoods")List<String> listGoods);

    /**
     * 更新下单商品的库存和销量
     * @author zhong
     * @date 2020-08-26
     * @param cartOrderInfoList
     * @return
     */
    int updateGoodsStock(@Param("cartOrderInfoList") List<CartOrderInfo> cartOrderInfoList);

    /**
     * 新增评价  json
     * @param appraiseOrderInfo
     * @return
     */
    int saveAppraise(AppraiseOrderInfo appraiseOrderInfo);

    /**
     * 更新商品的星级
     * @author zhong
     * @date 2020-08-26
     * @param appraiseOrderInfo
     * @return
     */
    int updateLevel(AppraiseOrderInfo appraiseOrderInfo);
    /**
     * 查询当前评价商品的星级
     * @author zhong
     * @date 2020-08-26
     * @param appraiseOrderInfo
     * @return
     */
    List<String> countGoodsLevel(AppraiseOrderInfo appraiseOrderInfo);



}
