package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionCustomer 客户管理实现类
 * @Author chenchaotao
 * @Date 2020-08-22
 */
@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    /**
     * listCustomerByPage 查询客户列表（分页）
     * @param customerInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-22
     */
    public AppResponse listCustomerByPage(CustomerInfo customerInfo){
        //查询当前登录人的的id
        String userId = SecurityUtils.getCurrentUserId();
        customerInfo.setCreateBy(userId);
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerInfo> customerInfoList = customerDao.listCustomerByPage(customerInfo);
        //包装Page对象
        PageInfo<CustomerInfo> pageData = new PageInfo<>(customerInfoList);
        return AppResponse.success("查询成功",pageData);
    }
}
