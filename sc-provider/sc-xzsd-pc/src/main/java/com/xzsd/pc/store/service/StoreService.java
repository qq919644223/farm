package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description  站点信息管理实现类
 * @Author chenchaotao
 * @Date 2020-08-22
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    /**
     * saveStore 门店信息新增
     * @param storeInfo
     * @return AppResponse
     * @author chenchaotao
     * @date 2020-08-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveStore(StoreInfo storeInfo) {
        //检验营业执照或站点编号是否已存在
        int countCode = storeDao.countCode(storeInfo);
        if (0 != countCode){
            return AppResponse.bizError("新增站点失败,营业执照或站点编号已存在！");
        }
        storeInfo.setStoreCode(StringUtil.getCommonCode(2));
        storeInfo.setIsDeleted(0);
        // 新增门店
        int count = storeDao.saveStore(storeInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * listStoreByPage 查询站点信息列表（分页）
     * @param  storeInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-22
     */
    public AppResponse listStoreByPage(StoreInfo storeInfo){
        StoreInfo sto = storeDao.getUserRole(storeInfo.getUserCode());
        storeInfo.setRole(sto.getRole());
        PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
        List<StoreInfo> storeInfoList = storeDao.listStoreByPage(storeInfo);
        //包装Page对象
        PageInfo<StoreInfo> pageData = new PageInfo<StoreInfo>(storeInfoList);
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * getStoreByStoreCode 查询站点详情
     * @param storeCode
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-22
     */
    public AppResponse getStoreByStoreCode(String storeCode){
        StoreInfo storeInfo = storeDao.getStoreByStoreCode(storeCode);
        return AppResponse.success("查询成功！",storeInfo);
    }

    /**
     * updateStore 修改站点信息
     * @param storeInfo
     * @return AppResponse
     * @Author chenchaotao
     * @Date 2020-08-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        //检验营业执照是否已存在
        int countLicenseCode = storeDao.countCode(storeInfo);
        if (0 != countLicenseCode){
            return AppResponse.bizError("修改站点信息失败，营业执照已存在");
        }
        // 修改站点信息
        int count = storeDao.updateStore(storeInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据无变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * deleteStore 删除站点
     * @param storeCode
     * @param Id
     * @return AppResponse
     * @Author chenchaotao
     * @Data 2020-08-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeCode,String Id){
        List<String> listCode = Arrays.asList(storeCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //查询输入的站点编号中是否有未完成的订单
        List<String> storeCodeList = storeDao.listOrder(listCode);
        ArrayList listStoreCode = new ArrayList<String>(listCode);
        //排除处于有未完成订单的站点编号
        listStoreCode.removeAll(storeCodeList);
        if (listStoreCode.size() == 0){
            return AppResponse.bizError("站点删除失败，站点编号"+listCode+"有未完成的订单，无法删除");
        }
        //删除门店
        int count = storeDao.deleteStore(listStoreCode,Id);
        if (0 == count){
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        if (storeCodeList.size() != 0 && listStoreCode.size() != 0) {
            return AppResponse.success("部分站点删除成功，站点编号为" + storeCodeList + "的站点有未完成的订单，无法删除");
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
        List<AreaInfo> areaInfoList = storeDao.listArea(parentCode);
        return AppResponse.success("查询成功",areaInfoList);
    }

    /**
     *
     * @param storeInfo
     * @return
     */
    public AppResponse listStoreBoss(StoreInfo storeInfo) {
        List<StoreInfo> storeInfos = storeDao.listStoreBoss(storeInfo);
        return AppResponse.success("查询成功",storeInfos);
    }
}
