package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description goodsInfo
 * @Author zhong
 * @Date 2020-08-22
 */
@Mapper
public interface GoodsDao {
    /**
     * 新增产品
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    int saveGoods(GoodsInfo goodsInfo);

    /**
     * 查询产品详情
     * @author zhong
     * @date 2020-08-22
     * @param goodsCode
     * @return
     */
    GoodsInfo getGoodsByGoodsCode(@Param("goodsCode") String goodsCode);

    /**
     * 查询产品列表
     * @author zhong
     * @date 2020-08-12
     * @param goodsInfo
     * @return
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);
    /**
     * 查询产品列表
     * @author zhong
     * @date 2020-08-12
     * @param goodsInfo
     * @return
     */
    List<GoodsInfo> listAuditGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 查询轮播图的商品
     * @author zhong
     * @date 2020-08-22
     * @param listCode
     * @return
     */
    List<String> listHotShow(@Param("listCode") List<String> listCode);
    /**
     * 删除产品
     * @author zhong
     * @date 2020-08-22
     * @param listGoodsCode
     * @param userId
     * @return
     */
    int deleteGoods(@Param("listGoodsCode") List<String> listGoodsCode, @Param("userId") String userId);

    /**
     * 修改产品
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 上架下架
     * @param listCode
     * @param goodsState
     * @param listVersion
     * @param userId
     * @return
     */
    int updateGoodsState(@Param("listCode") List<String> listCode, @Param("goodsState") int goodsState, @Param("listVersion") List<String> listVersion, @Param("userId") String userId);

    /**
     * 审核产品
     * @param listCode
     * @param audit
     * @param listVersion
     * @param userId
     * @return
     */
    int updateGoodsAudit(@Param("listCode") List<String> listCode, @Param("audit") int audit, @Param("listVersion") List<String> listVersion, @Param("userId") String userId);

    /**
     * 查询商品一级分类接口
     * @param goodsClassInfo
     * @author zhong
     * @Date 2020-08-22
     * @return
     */
    List<GoodsClassInfo> getFirstClass(GoodsClassInfo goodsClassInfo);

    /**
     * 查询商品二级分类接口
     * @author zhong
     * @date 2020-08-22
     * @param lastClassCode
     * @return
     */
    List<GoodsClassInfo> getSecondClass(@Param("lastClassCode") String lastClassCode);

    /**
     * 查询所有站点
     * @author zhong
     * @date 2020-08-25
     * @param storeInfo
     * @return
     */
    List<StoreInfo> getAllStore(StoreInfo storeInfo);


}
