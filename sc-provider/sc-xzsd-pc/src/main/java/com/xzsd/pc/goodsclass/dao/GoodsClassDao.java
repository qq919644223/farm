package com.xzsd.pc.goodsclass.dao;
import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @classname GoodsClassDao
 * @author zhong
 * @date 2020-08-22
 */
@Mapper
public interface GoodsClassDao {
    /**
     * 新增商品分类
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    int saveGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 修改商品分类
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    int updateGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 查询分类详情
     * @author
     * @date 2020-08-22
     * @param classCode
     * @return
     */
    GoodsClassInfo getClassByClassCode(@Param("classCode") String classCode);

    /**
     * 查询商品分类列表
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    List<GoodsClassInfo> listGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 删除商品分类
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    int deleteGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 检验新增的商品分类名称是否已存在
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    int countClassName(GoodsClassInfo goodsClassInfo);

    /**
     * 校验删除的商品分类是否存在二级分类
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    int countSecondClass(GoodsClassInfo goodsClassInfo);

    /**
     * 检验删除的商品分类下是否存在商品
     * @author zhong
     * @date 2020-08-22
     * @param goodsClassInfo
     * @return
     */
    int countSecondGoods(GoodsClassInfo goodsClassInfo);
}
