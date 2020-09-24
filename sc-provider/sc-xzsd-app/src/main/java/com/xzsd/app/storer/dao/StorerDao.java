package com.xzsd.app.storer.dao;

import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.storer.entity.StorerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className StorerDao
 * @Description storer
 * @author jintian
 * @date 2020-08-31
 */
@Mapper
public interface StorerDao {
    /**
     * @param userId
     * @return
     */
    UserInfo getStoreByCode(@Param("userId")String userId);
    /**
     * 查询区域供应商信息（站长端）
     * @param userCode
     * @return
     */
    List<StorerInfo> getStoreSupplierByCode(@Param("userCode")String userCode);
}
