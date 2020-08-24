package com.xzsd.pc.images.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.images.service.TopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 顶部导航栏
 * @Author jintian
 * @Date 2020-08-22
 */
@RestController
@RequestMapping("/user")
public class TopController {

    private static final Logger logger = LoggerFactory.getLogger(TopController.class);

    @Resource
    private TopService topService;

    /**
     * 查询顶部导航栏信息
     * @Author jintian
     * @Date 2020-08-22
     */
    @PostMapping("getUserUrl")
    public AppResponse uploadImage(){
        try{
            //获取当前登录用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return topService.uploadImage(userCode);
        } catch (Exception e) {
            logger.error("顶部栏查询错误",e);
            System.out.println(e.toString());
            throw e ;
        }
    }
}
