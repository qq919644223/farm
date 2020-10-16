package com.xzsd.pc.hotVillage.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotVillage.dao.HotVillageDao;
import com.xzsd.pc.hotVillage.entity.HotVillageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @Description 热门乡村实现类
 * @author jintian
 * @date 2020-08-23
 */
@Service
public class HotVillageService {
    @Resource
    private HotVillageDao hotVillageDao;
    /**
     * 新增热门乡村
     * @param hotVillageInfo
     * @return
     * @author jintian
     * @date 2020-08-23
     */
    public AppResponse saveHotVillage(HotVillageInfo hotVillageInfo){
        //校验排序序号是否大于0
        int hotId = hotVillageInfo.getHotId();
        if(hotId <= 0){
            return AppResponse.success("序号小于等于0，请重新输入");
        }
        //校验排序序号是否存在
        int counthotId = hotVillageDao.countHotId(hotVillageInfo);
        if(counthotId != 0){
            return AppResponse.success("序号或乡村重复已存在,请重试！");
        }
        hotVillageInfo.setHotCode(StringUtil.getCommonCode(2));
        hotVillageInfo.setIsDeleted(0);
        //新增热门乡村信息
        int count = hotVillageDao.saveHotVillage(hotVillageInfo);
        if(count == 0){
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功");
    }
    /**
     * 修改热门乡村
     * @param hotVillageInfo
     * @return
     * @author jintian
     * @date 2020-08-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotVillage(HotVillageInfo hotVillageInfo){
        //校验排序序号是否大于0
        int hotId = hotVillageInfo.getHotId();
        if(hotId <= 0){
            return AppResponse.success("序号小于等于0，请重新输入");
        }
        //校验排序序号是否存在
        int countHotId = hotVillageDao.countHotId(hotVillageInfo);
        if(countHotId != 0){
            return AppResponse.success("序号或乡村重复已存在,请重试！");
        }
        int count = hotVillageDao.updateHotVillage(hotVillageInfo);
        if(count == 0){
            return AppResponse.success("数据有变动，请刷新！");
        }
        return AppResponse.success("修改成功！");
    }
    /**
     * 查询热门乡村列表
     * @param hotVillageInfo
     * @return
     * @author jintian
     * @date 2020-08-23
     */
    public AppResponse listVillage(HotVillageInfo hotVillageInfo){
        List<HotVillageInfo> listHotVillage = hotVillageDao.listHotVillageByPage(hotVillageInfo);
        return AppResponse.success("查询成功！",getPageInfo(listHotVillage));
    }
    /**
     * 查询热门乡村详情
     * @param
     * @return
     * @author jintian
     * @date 2020-08-23
     */
    public AppResponse getHotVillageByHotCode(String hotCode){
        HotVillageInfo hotVillageInfo = hotVillageDao.getHotVillageByHotCode(hotCode);
        return AppResponse.success("查询成功！",hotVillageInfo);
    }
    /**
     * 删除热门乡村
     * @param hotCode
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotVillage(String hotCode,String userId){
        List<String> listCode = Arrays.asList(hotCode.split(","));
        //删除热门乡村信息
        int count = hotVillageDao.deleteHotVillage(listCode,userId);
        if(count == 0){
            return AppResponse.success("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
    /**
     * 查询乡村列表
     * @param
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    public AppResponse listVillageByPage(HotVillageInfo hotVillageInfo){
        List<HotVillageInfo> listVillage = hotVillageDao.listVillageByPage(hotVillageInfo);
        return AppResponse.success("查询成功！",getPageInfo(listVillage));
    }
    /**
     * 设置热门乡村展示数量
     * @param hotVillageInfo
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveShowNo(HotVillageInfo hotVillageInfo){
        int count = hotVillageDao.saveShowNo(hotVillageInfo);
        if(count == 0){
            return AppResponse.success("数据有变化，请刷新重试！");
        }
        return AppResponse.success("修改成功！");
    }
    /**
     * 查询热门乡村展示数量
     * @param
     * @return Appresponse
     * @author jintian
     * @date 2020-08-23
     */
    public AppResponse getShowNo(){
        HotVillageInfo hotVillageInfo = hotVillageDao.getShowNo();
        return AppResponse.success("查询成功！",hotVillageInfo);
    }
}
