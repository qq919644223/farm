package com.xzsd.app.address.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.address.entity.AddressInfo;
import com.xzsd.app.address.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 地址
 * @author zhong
 * @date 2020-08-25
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    /**
     * 新增地址
     * @date 2020-08-25
     * @author zhong
     * @param addressInfo
     * @return
     */
    @PostMapping("saveAddress")
    private AppResponse saveAddress(AddressInfo addressInfo){
        try{
            return addressService.saveAddress(addressInfo);
        }catch (Exception e){
            logger.error("新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询地址详情
     * @author zhong
     * @date 2020-08-22
     * @param
     * @return
     */
    @PostMapping("getAddressByAddressCode")
    public AppResponse getAddressByAddressCode(String AddressCode){
        try{
            return addressService.getAddressByAddressCode(AddressCode);
        }catch (Exception e){
            logger.error("地址查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询地址
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    @PostMapping("getAddress")
    private AppResponse getAddress(AddressInfo addressInfo){
        try{
            return addressService.getAddress(addressInfo);
        }catch (Exception e){
            logger.error("查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改地址
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    @PostMapping("updateAddSubAddress")
    private AppResponse updateAddSubAddress(AddressInfo addressInfo){
        try {
            //获取当前登录的用户编码
            String userId = SecurityUtils.getCurrentUserId();
            addressInfo.setUpdateName(userId);
            return addressService.updateAddSubAddress(addressInfo,userId);
        }catch (Exception e){
            logger.error("修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除地址
     * @author zhong
     * @date 22020-08-25
     * @param addressCode
     * @return
     */
    @PostMapping("deleteAddress")
    private AppResponse deleteAddress(String addressCode){
        try{
            //获取当前登录的用户编码
            String userId = SecurityUtils.getCurrentUserId();
            return addressService.deleteAddress(addressCode,userId);
        }catch (Exception e){
            logger.error("删除失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
