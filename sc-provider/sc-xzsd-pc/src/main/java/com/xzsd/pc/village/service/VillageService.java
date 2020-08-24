package com.xzsd.pc.village.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.village.dao.VillageDao;
import com.xzsd.pc.village.entity.VillageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description  乡村信息管理实现类
 * @Author chenchaotao
 * @Date 2020-08-23
 */
@Service
public class VillageService {
      @Resource
      private VillageDao villageDao;
    /**
     * saveVillage 乡村信息新增
     * @param villageInfo
     * @return AppResponse
     * @author chenchaotao
     * @date 2020-08-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveVillage(VillageInfo villageInfo) {
        villageInfo.setVillageCode(StringUtil.getCommonCode(2));
        villageInfo.setIsDeleted(0);
        // 新增乡村
        int count = villageDao.saveVillage(villageInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
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
        List<VillageInfo> villageInfoList = villageDao.listVillageByPage(villageInfo);
        //包装Page对象
        PageInfo<VillageInfo> pageData = new PageInfo<VillageInfo>(villageInfoList);
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * getVillageByVillageCode 查询门店详情
     * @param villageCode
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-04-11
     */
    public AppResponse getVillageByVillageCode(String villageCode){
        VillageInfo villageInfo = villageDao.getVillageByVillageCode(villageCode);
        return AppResponse.success("查询成功！",villageInfo);
    }

    /**
     * updateVillage 修改门店信息
     * @param villageInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateVillage(VillageInfo villageInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改门店信息
        int count = villageDao.updateVillage(villageInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据无变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * deleteVillage 删除乡村
     * @param villageCode
     * @param Id
     * @return AppResponse
     * @Author chenchaotao
     * @Data 2020-08-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteVillage(String villageCode,String Id){
        List<String> listCode = Arrays.asList(villageCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //删除乡村
        int count = villageDao.deleteVillage(listCode,Id);
        if (0 == count){
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * listArea 查询省市区下拉列表
     * @param parentCode
     * @return AppResponse
     * @author chenchaotao
     * @date 2020-08-23
     */
    public AppResponse listArea(String parentCode){
        List<AreaInfo> areaInfoList = villageDao.listArea(parentCode);
        return AppResponse.success("查询成功",areaInfoList);
    }
}
