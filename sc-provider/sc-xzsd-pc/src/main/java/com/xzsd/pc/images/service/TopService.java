package com.xzsd.pc.images.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.images.dao.TopDao;
import com.xzsd.pc.images.entity.TopInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 顶部导航栏实现类
 * @Author jintian
 * @Date 2020-08-22
 */
@Service
public class TopService {

    @Resource
    private TopDao topDao;
    /**
     * 查询顶部导航栏
     * @param userCode
     * @return
     * @Author jintian
     * @Date 2020-08-22
     */
    public AppResponse uploadImage(String userCode){
        TopInfo topInfo = topDao.getInfoByCode(userCode);
        return AppResponse.success("查询成功！",topInfo);
    }
}
