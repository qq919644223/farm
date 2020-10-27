package com.xzsd.app.address.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.address.dao.AddressDao;
import com.xzsd.app.address.entity.AddressInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class AddressService {
    @Resource
    private AddressDao addressDao;

    int bETRUE = 0;
    /**
     * 新增地址
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveAddress(AddressInfo addressInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        addressInfo.setUserId(userId);
        addressInfo.setCreateName(userId);
        addressInfo.setIsDeleted(0);
        addressInfo.setAddressCode(StringUtil.getCommonCode(2));
        //加入地址
        int saveAddress = addressDao.saveAddress(addressInfo);
        if (0 == saveAddress){
            return AppResponse.bizError("加入失败！");
        }
        return AppResponse.success("加入成功！");
    }

    /**
     * 查询地址
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    public AppResponse getAddress(AddressInfo addressInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        addressInfo.setUserId(userId);
        List<AddressInfo> addressInfoList = addressDao.getAddress(addressInfo);
        //包装Page对象
        return AppResponse.success("查询成功",addressInfoList);
    }

    /**
     * 修改地址商品
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateAddSubAddress(AddressInfo addressInfo,String userId) {
        if (addressInfo.getBetrue() == bETRUE){
            int updateMoren = addressDao.updateMoren(userId);
        }
        //修改地址
        int updateAddSubAddress = addressDao.updateAddSubAddress(addressInfo);
        if (0 == updateAddSubAddress){
            return AppResponse.bizError("修改失败!");
        }else {
            return AppResponse.success("修改成功!");
        }
    }

    /**
     * 删除地址
     * @author zhong
     * @date 2020-08-25
     * @param addressCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteAddress(String addressCode, String userId) {
        AppResponse appResponse = AppResponse.success("删除成功");
        List<String> listCode = Arrays.asList(addressCode.split(","));
        //删除地址
        int deleteAddress = addressDao.deleteAddress(listCode,userId);
        if (0 == deleteAddress){
            return AppResponse.bizError("删除失败");
        }
        return appResponse;
    }

    /**
     * 查询地址详情
     * @param addressCode
     * @return
     */
    public AppResponse getAddressByAddressCode(String addressCode) {
        AddressInfo addressInfo = addressDao.getGoodsByGoodsCode(addressCode);
        return AppResponse.success("查询成功！",addressInfo);
    }
}
