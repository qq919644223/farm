package com.xzsd.app.storer.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.entity.UserInfo;
import com.xzsd.app.storer.dao.StorerDao;
import com.xzsd.app.storer.entity.StorerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @Description 站长信息实现类
 * @author jintian
 * @date 2020-08-31
 */
@Service
public class StorerService {
    @Resource
    private StorerDao storerDao;

    /**
     * 查询站长信息
     * @param userId
     * @return
     */
    public AppResponse getStoreByCode(String userId) {
        UserInfo sotrerInfo = storerDao.getStoreByCode(userId);
        return AppResponse.success("查询成功！",sotrerInfo);
    }
    /**
     * 查询区域供应商信息（站长端）
     * @param userCode
     * @return
     * @author jintian
     * @date 2020-04-24
     */
    public AppResponse getStoreSupplierByCode(String userCode){
        List<StorerInfo> getSupplierByPage = storerDao.getStoreSupplierByCode(userCode);
        return AppResponse.success("查询成功！",getPageInfo(getSupplierByPage));
    }
}
