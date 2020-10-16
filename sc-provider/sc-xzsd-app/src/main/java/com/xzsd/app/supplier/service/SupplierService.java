package com.xzsd.app.supplier.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.supplier.dao.SupplierDao;
import com.xzsd.app.supplier.entity.GoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @Description 供应商app实现类
 * @author jintian
 * @date 2020-08-31
 */
@Service
public class SupplierService {
    @Resource
    private SupplierDao supplierDao;

    public AppResponse getStoreBySupplier(String userCode) {
        List<UserInfo> getStoreBySupplier = supplierDao.getStoreBySupplier(userCode);
        return AppResponse.success("查询成功！",getPageInfo(getStoreBySupplier));
    }
    /**
     * 查询自己提交的产品信息
     * @param userCode
     * @return
     * @author jintian
     * @date 2020-04-24
     */
    public AppResponse getMyGoods(GoodsInfo goodsInfo){
        //查询当前登录人的的id
        String userId = SecurityUtils.getCurrentUserId();
        goodsInfo.setUserCode(userId);
        GoodsInfo sdd = supplierDao.getRole(userId);
        int role = sdd.getRole();
        goodsInfo.setRole(role);
        List<GoodsInfo> getMyGoods = supplierDao.getMyGoods(goodsInfo);
        return AppResponse.success("查询成功！",getPageInfo(getMyGoods));
    }
    /**
     * 查询供应商信息
     * @param userId
     * @return
     * @author jintian
     * @date 2020-04-21
     */
    public AppResponse getMyself(String userId){
        UserInfo supplierInfo = supplierDao.getMyself(userId);
        return AppResponse.success("查询成功！",supplierInfo);
    }


}
