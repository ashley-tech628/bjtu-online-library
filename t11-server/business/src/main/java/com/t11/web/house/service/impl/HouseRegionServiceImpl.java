/**
 */
package com.t11.web.house.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import com.t11.web.house.dao.HouseRegionDao;
import com.t11.web.house.service.HouseRegionService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;

import jakarta.annotation.Resource;
import java.util.*;



/***
 * Title: Service-HouseRegionServiceImpl
 */
@Slf4j
@Service
public class HouseRegionServiceImpl implements HouseRegionService {

    @Resource
    private UserContext userContext;
    @Resource
    private HouseRegionDao houseRegionDao;

    @Override
    public Long count(HouseRegionParam houseRegionParam){
        //BeanUtils.setPropertiesNullIfEmpty(houseRegionParam);
        try {
            Long count = houseRegionDao.selectCount(houseRegionParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<HouseRegionEntity> list(HouseRegionParam houseRegionParam){
        //BeanUtils.setPropertiesNullIfEmpty(houseRegionParam);
        try {
            List<HouseRegionEntity> res = houseRegionDao.selectList(houseRegionParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(HouseRegionEntity houseRegionEntity) {
        houseRegionEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        houseRegionEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(houseRegionEntity);
        try{
            houseRegionDao.insert(houseRegionEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public HouseRegionEntity get(HouseRegionParam houseRegionParam){
        try{
            return houseRegionDao.selectOne(houseRegionParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(HouseRegionParam houseRegionParam){
        try{
            houseRegionDao.delete(houseRegionParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(HouseRegionEntity houseRegionEntity) {
        try{
            String id = houseRegionEntity.getId();
            HouseRegionParam houseRegionParam = new HouseRegionParam();
            houseRegionParam.setId(id);
            HouseRegionEntity entity = get(houseRegionParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(houseRegionEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            houseRegionDao.update(entity, houseRegionParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     @Override
     public PageResponse<HouseRegionEntity> page(HouseRegionParam houseRegionParam){
        try {
            List<HouseRegionEntity> list = houseRegionDao.selectList(houseRegionParam);
            Long count = houseRegionDao.selectCount(houseRegionParam);
            return new PageResponse<>(houseRegionParam.getPageNo(), houseRegionParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
     }
     @Override
    public CommonResult importHouseRegion(List<HouseRegionEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (HouseRegionEntity houseRegionEntity : dataList) {
            try {
                // 是否已经存在
                HouseRegionEntity existHouseRegionEntity = this.get(houseRegionEntity);
                if (null == existHouseRegionEntity) {
                    // 创建用户
                    this.create(houseRegionEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    houseRegionEntity.setId(houseRegionEntity.getId());
                    this.update(houseRegionEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s更新成功",
                            successNum));
                } else {
                    throw new BusinessException(String.format("已存在"));
                }
            } catch (Exception e) {
                log.error("导入数据错误：", e);
                failNum++;
                failureMsg.append(String.format("<br/>%s导入失败：%s",
                        failNum, e.getMessage()));
            }
        }
        // 返回信息
        return CommonResult.result(successNum, failNum, successMsg, failureMsg);
    }
    private HouseRegionEntity get(HouseRegionEntity houseRegionEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }
}