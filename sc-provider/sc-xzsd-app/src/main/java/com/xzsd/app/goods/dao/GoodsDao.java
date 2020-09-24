package com.xzsd.app.goods.dao;

import com.xzsd.app.goods.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 查询产品信息
     * @param goodsCode 产品编码
     * @return 查询结果
     */
    GoodsInfo getGoods(@Param("goodsCode")String goodsCode);

    /**
     * 查询产品评价列表
     * @param goodsEvaluates
     * @return 产品评价列表
     */
    List<GoodsEvaluates> listGoodsEvaluatesByPage(GoodsEvaluates goodsEvaluates);

    /**
     * 一级分类
     * @author zhong
     * @date 2020-08-25
     * @param goodsClassInfo
     * @return
     */
    List<GoodsClassInfo> getFirstClass(GoodsClassInfo goodsClassInfo);

    /**
     * 二级分类
     * @author zhong
     * @date 2020-08-25
     * @param lastClassCode
     * @return
     */
    List<GoodsClassInfo> getSecondClass(@Param("lastClassCode") String lastClassCode);

    /**
     * 获取所有乡村信息
     * @param  villageInfo
     * @return 所有乡村信息
     */
    List<VillageInfo> listVillageByPage(VillageInfo villageInfo);

    /**
     * 查询省市区下拉列表
     * @param parentCode
     * @return 省市区列表信息
     */
    List<AreaInfo> listArea(@Param("parentCode") String parentCode);
}
