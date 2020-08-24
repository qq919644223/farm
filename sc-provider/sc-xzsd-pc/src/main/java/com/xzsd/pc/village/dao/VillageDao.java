package com.xzsd.pc.village.dao;

import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.village.entity.VillageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface VillageDao {
    /**
     * 新增乡村
     * @param villageInfo 乡村信息
     * @return
     */
    int saveVillage(VillageInfo villageInfo);

    /**
     * 获取所有乡村信息
     * @param  villageInfo
     * @return 所有乡村信息
     */
    List<VillageInfo> listVillageByPage(VillageInfo villageInfo);

    /**
     * 查询乡村详情
     * @param villageCode 乡村编号
     * @return 查询结果
     */
    VillageInfo getVillageByVillageCode(@Param("villageCode")String villageCode);

    /**
     * 修改乡村信息
     * @param villageInfo 乡村信息
     * @return 修改结果
     */
    int updateVillage(VillageInfo villageInfo);

    /**
     * 删除乡村
     * @param listCode 选中的乡村编号集合
     * @param Id 更新人
     * @return
     */
    int deleteVillage(@Param("listCode") List<String> listCode, @Param("Id")String Id);

    /**
     * 查询省市区下拉列表
     * @param parentCode
     * @return 省市区列表信息
     */
    List<AreaInfo> listArea(@Param("parentCode") String parentCode);
}
