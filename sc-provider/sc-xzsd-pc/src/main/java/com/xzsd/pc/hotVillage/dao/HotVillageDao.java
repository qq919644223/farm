package com.xzsd.pc.hotVillage.dao;

import com.xzsd.pc.hotVillage.entity.HotVillageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * @ClassName HotVillageDao
 * @Description hotVillage
 * @Author jintian
 * @Date 2020-03-25
 */
@Mapper
public interface HotVillageDao {
    /**
     * 校验排序序号是否存在
     * @param hotVillageInfo
     * @return
     */
    int countHotId(HotVillageInfo hotVillageInfo);
    /**
     * 新增热门乡村信息
     * @param hotVillageInfo
     * @return
     */
    int saveHotVillage(HotVillageInfo hotVillageInfo);
    /**
     *修改热门乡村信息
     * @param hotVillageInfo
     * @return
     */
    int updateHotVillage(HotVillageInfo hotVillageInfo);
    /**
     * 查询热门乡村列表
     * @param hotVillageInfo
     * @return
     */
    List<HotVillageInfo> listHotVillageByPage(HotVillageInfo hotVillageInfo);
    /**
     * 查询热门乡村详情
     * @param hotCode
     * @return
     */
    HotVillageInfo getHotVillageByHotCode(@Param("hotCode") String hotCode);
    /**
     * 删除热门乡村信息
     * @param listCode
     * @param userId
     * @return
     */
    int deleteHotVillage(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
     * 查询乡村信息列表
     * @param hotVillageInfo
     * @return
     */
    List<HotVillageInfo> listVillageByPage(HotVillageInfo hotVillageInfo);
    /**
     * 设置展示数量
     * @param hotVillageInfo
     * @return
     */
    int saveShowNo(HotVillageInfo hotVillageInfo);
    /**
     * 查询展示数量
     * @param
     * @return
     */
    HotVillageInfo getShowNo();
}
