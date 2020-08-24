package com.xzsd.pc.images.dao;

import com.xzsd.pc.images.entity.TopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName topDao
 * @Description top
 * @Author jintian
 * @Date 2020-08-22
 */
@Mapper
public interface TopDao {
    /**
     * 获取用户信息（顶部导航栏）
     * @param userCode
     * @return
     */
    TopInfo getInfoByCode(@Param("userCode") String userCode);
}
