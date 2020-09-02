package com.xzsd.app.supplier.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.supplier.dao.SupplierDao;
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
    /**
     * 查询所属站点（供应商端）
     * @param userCode
     * @return
     * @author jintian
     * @date 2020-04-24
     */
    public AppResponse getStoreBySupplier(String userCode){
        List<UserInfo> getStoreByPage = supplierDao.getStoreBySupplier(userCode);
        return AppResponse.success("查询成功！",getPageInfo(getStoreByPage));
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
