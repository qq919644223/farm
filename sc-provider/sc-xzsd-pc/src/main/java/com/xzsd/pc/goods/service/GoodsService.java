package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @classname GoodsService
 * @author zhong
 * @date 2020-08-22
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 新增产品
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        //随机生产产品编码
        goodsInfo.setGoodsCode(StringUtil.getCommonCode(2));
        goodsInfo.setIsDeleted(0);
        //新增产品
        int saveToGoods = goodsDao.saveGoods(goodsInfo);
        if (0 == saveToGoods){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询商品的详情
     * @author zhong
     * @date 2020-08-22
     * @param goodsCode
     * @return
     */
    public AppResponse getGoodsByGoodsCode(String goodsCode) {
        GoodsInfo goodsInfo = goodsDao.getGoodsByGoodsCode(goodsCode);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * 查询商品列表
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    public AppResponse listGoodsByPage(GoodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(),goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        //包装Page对象
        PageInfo<GoodsInfo> pageData = new PageInfo<>(goodsInfoList);
        return AppResponse.success("查询列表成功！",pageData);
    }
    /**
     * 查询审核商品列表
     * @author zhong
     * @date 2020-08-22
     * @param goodsInfo
     * @return
     */
    public AppResponse listAuditGoodsByPage(GoodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(),goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listAuditGoodsByPage(goodsInfo);
        //包装Page对象
        PageInfo<GoodsInfo> pageData = new PageInfo<>(goodsInfoList);
        return AppResponse.success("查询列表成功！",pageData);
    }
    /**
     * 删除产品
     * @author zhong
     * @date 2020-08-22
     * @param goodsCode
     * @param userId
     * @return
     */
    public AppResponse deleteGoods(String goodsCode, String userId) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //获取轮播图的list
        List<String> goodsCodeList = goodsDao.listHotShow(listCode);
        //排除处于轮播图的商品编码
        ArrayList listGoodsCode = new ArrayList<>(listCode);
        listGoodsCode.removeAll(goodsCodeList);
        //商品存在轮播图中，删除失败
        if (0 == listGoodsCode.size()){
            return AppResponse.bizError("商品存在轮播图，删除失败，请重试！");
        }
        //删除商品
        int deleteGood = goodsDao.deleteGoods(listGoodsCode,userId);
        if (goodsCodeList.size() != 0 && listGoodsCode.size() != 0 && 0 != deleteGood){
            return AppResponse.success("删除成功，商品编码为"+ goodsCodeList+"的商品存在轮播图，无法删除" );
        }

        return appResponse;
    }
    /**
     * 修改商品
     * @return
     * @author zhong
     * @date 2020--8-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        //修改商品信息
        int updateGood = goodsDao.updateGoods(goodsInfo);
        if (0 == updateGood){
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 上架下架
     * @param goodsCode
     * @param goodsState
     * @param version
     * @param userId
     * @author zhong
     * @serialData 2020-08-22
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsState(String goodsCode,int goodsState,String version,String userId) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        AppResponse appResponse = AppResponse.success("修改成功");
        //修改商品上架下架
        int updateState = goodsDao.updateGoodsState(listCode,goodsState,listVersion,userId);
        if (0 == updateState){
            appResponse = AppResponse.bizError("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * 审核产品
     * @param goodsCode
     * @param audit
     * @param version
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsAudit(String goodsCode, int audit, String version, String userId) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        AppResponse appResponse = AppResponse.success("修改成功");
        //审核产品
        int updateState = goodsDao.updateGoodsAudit(listCode,audit,listVersion,userId);
        if (0 == updateState){
            appResponse = AppResponse.bizError("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * 查询一级分类接口
     * @date 2020-08-22
     * @author zhong
     * @param goodsClassInfo
     * @return
     */
    public AppResponse getFirstClass(GoodsClassInfo goodsClassInfo) {
        List<GoodsClassInfo> classFirstList = goodsDao.getFirstClass(goodsClassInfo);
        return AppResponse.success("查询列表成功！", classFirstList);
    }
    /**
     * 查询二级分类接口
     * @date 2020-08-22
     * @author zhong
     * @param lastClassCode
     * @return
     */
    public AppResponse getSecondClass(String lastClassCode) {
        List<GoodsClassInfo> classSecondList = goodsDao.getSecondClass(lastClassCode);
        return AppResponse.success("查询列表成功！", classSecondList);
    }

    /**
     * 查询所有的站点
     * @author zhong
     * @date 2020-08-25
     * @param storeInfo
     * @return
     */
    public AppResponse getAllStore(StoreInfo storeInfo) {
        List<StoreInfo> storeInfoList = goodsDao.getAllStore(storeInfo);
        return AppResponse.success("查询列表成功！",storeInfoList);
    }


}
