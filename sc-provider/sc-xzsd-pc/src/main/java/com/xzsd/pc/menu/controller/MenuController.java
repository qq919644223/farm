package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单的增删查改
 * @author zhong
 * @date 2020-08-22
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * 新增菜单
     * @author zhong
     * @date 2020-08-22
     * @param menuInfo
     * @return
     */
    @PostMapping("saveMenu")
    public AppResponse saveMenu(MenuInfo menuInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setCreateName(userId);
            AppResponse appResponse = menuService.saveMenu(menuInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("菜单新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单列表
     * @author zhong
     * @date 2020-08-22
     * @param menuInfo
     * @return
     */
    @PostMapping("listMenus")
    public AppResponse listMenus(MenuInfo menuInfo){
        try {
            return menuService.listMenus(menuInfo);
        }catch (Exception e){
            logger.error("查询全部菜单成功");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单
     * @author zhong
     * @date 2020-08-22
     * @param menuInfo
     * @return
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setUpdateName(userId);
            return menuService.updateMenu(menuInfo);
        }catch (Exception e){
            logger.error("修改菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @author zhong
     * @date 2020-08-22
     * @param menuCode
     * @return
     */
    @PostMapping("/deleteMenu")
    public AppResponse deleteMenu(String menuCode){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode,userId);
        }catch (Exception e){
            logger.error("菜单删除失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     * @author zhong
     * @date 2020-08-22
     * @param menuCode
     * @return
     */
    @PostMapping(value = "getMenuByCode")
    public AppResponse getMenuByCode(String menuCode){
        try {
            return menuService.getMenuByCode(menuCode);
        }catch (Exception e){
            logger.error("菜单查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询菜单列表
     * @author zhong
     * @date 2020-08-22
     * @param menuInfo
     * @return
     */
    @PostMapping("listMenuHome")
    public AppResponse listMenuHome(MenuInfo menuInfo){
        try {
            return menuService.listMenuHome(menuInfo);
        }catch (Exception e){
            logger.error("查询全部菜单成功");
            System.out.println(e.toString());
            throw e;
        }
    }
}
