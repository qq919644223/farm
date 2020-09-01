package com.xzsd.app.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 商品管理实现类
 * @Author chenchaotao
 * @Date 2020-08-25
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;
    /**
     * getGoods 查询商品详情
     * @param goodsCode
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-25
     */
    public AppResponse getGoods(String goodsCode){
        GoodsInfo goodsInfo = goodsDao.getGoods(goodsCode);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * getGoodsAppraise 查询产品评价列表（分页）
     * @param goodsEvaluates
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-25
     */
    public AppResponse getGoodsAppraise(GoodsEvaluates goodsEvaluates){
        PageHelper.startPage(goodsEvaluates.getPageNum(), goodsEvaluates.getPageSize());
        List<GoodsEvaluates> goodsEvaluatesList = goodsDao.listGoodsEvaluatesByPage(goodsEvaluates);
        //包装Page对象
        PageInfo<GoodsEvaluates> pageData = new PageInfo<GoodsEvaluates>(goodsEvaluatesList);
        return AppResponse.success("查询成功",pageData);
    }


    /**
     * 查询一级分类接口
     * @date 2020-08-25
     * @author zhong
     * @param goodsClassInfo
     * @return
     */
    public AppResponse getFirstClass(GoodsClassInfo goodsClassInfo) {
        List<GoodsClassInfo> classFirstList = goodsDao.getFirstClass(goodsClassInfo);
        return AppResponse.success("查询列表成功！", classFirstList);
    }
    /**
     * 查询二级分类及商品接口
     * @date 2020-08-25
     * @author zhong
     * @param lastClassCode
     * @return
     */
    public AppResponse getSecondClass(String lastClassCode) {
        List<GoodsClassInfo> classSecondList = goodsDao.getSecondClass(lastClassCode);
        return AppResponse.success("查询列表成功！", classSecondList);
    }

    /**
     * listVillageByPage 查询乡村信息列表（分页）
     * @param  villageInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-23
     */
    public AppResponse listVillageByPage(VillageInfo villageInfo){
        PageHelper.startPage(villageInfo.getPageNum(), villageInfo.getPageSize());
        List<VillageInfo> villageInfoList = goodsDao.listVillageByPage(villageInfo);
        //包装Page对象
        PageInfo<VillageInfo> pageData = new PageInfo<VillageInfo>(villageInfoList);
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * listArea 查询省市区下拉列表
     * @param parentCode
     * @return AppResponse
     * @author chenchaotao
     * @date 2020-08-23
     */
    public AppResponse listArea(String parentCode){
        List<AreaInfo> areaInfoList = goodsDao.listArea(parentCode);
        return AppResponse.success("查询成功",areaInfoList);
    }
}
