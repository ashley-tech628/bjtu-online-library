package com.t11.web.house.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
*
*/
public interface HouseRegionService {

    Long count(HouseRegionParam houseRegionParam);
    List<HouseRegionEntity> list(HouseRegionParam houseRegionParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param houseRegionEntity
    * @return
    */
    boolean create(HouseRegionEntity houseRegionEntity);

    /**
    * 根据id更新
    */
    boolean update(HouseRegionEntity houseRegionEntity);
    boolean delete(HouseRegionParam houseRegionParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    HouseRegionEntity get(HouseRegionParam houseRegionParam);
  

    /**
    *列表-分页
    */
    PageResponse<HouseRegionEntity> page(HouseRegionParam houseRegionParam);
    CommonResult importHouseRegion(List<HouseRegionEntity> dataList, boolean isUpdateSupport);
    }
        
