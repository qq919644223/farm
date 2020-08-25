package com.xzsd.app.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.GoodsEvaluates;
import com.xzsd.app.goods.entity.GoodsInfo;
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
}
