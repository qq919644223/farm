package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @classname MenuDao
 * @author zhong
 * @date 2020-04-11
 */
@Mapper
public interface MenuDao {
    /**
     * 新增菜单
     * @author zhong
     * @date 2020-04-11
     * @param menuInfo
     * @return
     */
    int saveMenu(MenuInfo menuInfo);

    /**
     * 校验新增菜单时 菜单名称和路由是否重复
     * @author zhong
     * @date 2020-04-11
     * @param menuInfo
     * @return
     */
    int countMenu(MenuInfo menuInfo);
    /**
     * 查询菜单列表
     * @author zhong
     * @date 2020-04-11
     * @param menuInfo
     * @return
     */
    List<MenuInfo> listMenus(MenuInfo menuInfo);

    /**
     * 修改菜单
     * @author zhong
     * @date 2020-04-11
     * @param menuInfo
     * @return
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 删除菜单
     * @author zhong
     * @date 2020-04-11
     * @param menuCode
     * @param userId
     * @return
     */
    int deleteMenu(@Param("menuCode") String menuCode, @Param("userId") String userId);

    /**
     * 查询菜单详情
     * @author zhong
     * @date 2020-04-11
     * @param menuCode
     * @return
     */
    MenuInfo getMenuByCode(@Param("menuCode") String menuCode);

    /**
     * 获取当前登录人的角色
     * @author zhong
     * @date 2020-04-11
     * @param userId
     * @return
     */
    int getUserRole(@Param("userId") String userId);

    /**
     * 根据角色查询菜单列表
     * @author zhong
     * @date 2020-04-13
     * @param menuInfo
     * @return
     */
    List<MenuInfo> listMenuHome(MenuInfo menuInfo);


}
