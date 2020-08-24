package com.xzsd.pc.order.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetailInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @Description 订单实现类
 * @author jintian
 * @date 2020-08-24
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    //管理员
    private static String adminRole = "1";
    //店长
    private static String managerRole = "2";
    //订单状态
    private static String state = "1";
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     * @author jintian
     * date 2020-04-13
     */
    public AppResponse getOrderByOrderCode(String orderCode){
        List<OrderDetailInfo> listOrderDetail = orderDao.getOrderByOrderCode(orderCode);
        return AppResponse.success("查询成功！",getPageInfo(listOrderDetail));
    }
    /**
     * 订单列表
     * @param orderInfo
     * @param roleCode
     * @return
     * @author jintian
     * @date 2020-04-14
     */
    public AppResponse listOrderByPage(OrderInfo orderInfo, String roleCode){
        String role = orderInfo.getRole();
        if(adminRole.equals(role)){
            List<OrderInfo> listAdminOrder = orderDao.listAdminOrderByPage(orderInfo);
            return AppResponse.success("查询成功！",getPageInfo(listAdminOrder));
        }else if(managerRole.equals(role)){
            orderInfo.setRoleCode(roleCode);
            List<OrderInfo> listStoreOrder = orderDao.listStoreOrderByPage(orderInfo);
            return AppResponse.success("查询成功！",getPageInfo(listStoreOrder));
        }else{
            return AppResponse.success("角色输入错误或权限不足，请重新输入！");
        }
    }
    /**
     * 修改订单状态
     * @param orderCode
     * @param orderState
     * @param version
     * @param userId
     * @author jintian
     * @date 2020-04-14
     */
    public AppResponse updateOrderState(String orderCode, String orderState, String version, String userId){
        List<String> listCode = Arrays.asList(orderCode.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        //修改订单状态为1取消订单时,回滚库存
        if(state.equals(orderState)){
            //查询订单的购买数量
            List<OrderDetailInfo> listOrderSum = orderDao.getListOrderDetail(listCode);
            //回滚相关商品库存
            int updateStock = orderDao.updateStock(listOrderSum);
            if (updateStock == 0 && updateStock != listOrderSum.size()){
                return AppResponse.bizError("修改商品库存失败");
            }
        }
        //修改订单状态
        int count = orderDao.updateOrderState(listCode,orderState,listVersion,userId);
        if (count == 0){
            return AppResponse.success("数据有变化，请更新后重试！");
        }
        return AppResponse.success("修改成功！");
    }
}
