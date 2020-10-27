package com.xzsd.app.address.dao;

import com.xzsd.app.address.entity.AddressInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressDao {
    /**
     * 新增地址
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    int saveAddress(AddressInfo addressInfo);

    /**
     * 查询地址  分页
     * @date 2020-08-25
     * @author zhong
     * @param addressInfo
     * @return
     */
    List<AddressInfo> getAddress(AddressInfo addressInfo);

    /**
     * 修改数据库里是默认的为不默认
     * @param userId
     * @return
     */
    int updateMoren(@Param("userId") String userId);
    
    /**
     * 修改地址商品数量
     * @author zhong
     * @date 2020-08-25
     * @param addressInfo
     * @return
     */
    int updateAddSubAddress(AddressInfo addressInfo);


    /**
     * 删除地址
     * @author zhong
     * @date 2020-08-25
     * @param listCode
     * @param userId
     * @return
     */
    int deleteAddress(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 查询地址详情
     * @param addressCode
     * @return
     */
    AddressInfo getGoodsByGoodsCode(@Param("addressCode") String addressCode);



}
