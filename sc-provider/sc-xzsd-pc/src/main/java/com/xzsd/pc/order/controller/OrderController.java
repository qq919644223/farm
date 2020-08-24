package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 订单管理
 * @author jintian
 * @date 2020-08-24
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;
    /**
     * 查询订单详情
     * @param orderCode
     * @return Appresponse
     * @author jintian
     * @date 2020-08-24
     */
    @RequestMapping(value = "getOrderByOrderCode")
    public AppResponse getOrderByOrderCode(String orderCode){
        try{
            return orderService.getOrderByOrderCode(orderCode);
        } catch (Exception e) {
            logger.error("查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询订单列表
     * @param orderInfo
     * @return AppResponse
     * @author jintian
     * @date 2020-04-13
     */
    @RequestMapping(value = "listOrderByPage")
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        try{
            //获取用户id
            String roleCode = SecurityUtils.getCurrentUserId();
            return orderService.listOrderByPage(orderInfo,roleCode);
        } catch (Exception e) {
            logger.error("查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改订单状态
     * @param orderCode
     * @param orderState
     * @param version
     * @return AppResponse
     * @author jintian
     * @date 2020-04-13
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderCode, String orderState, String version){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(orderCode,orderState,version,userId);
        } catch (Exception e) {
            logger.error("修改失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
