package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingsaixiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingsaixiangmuView;


/**
 * 竞赛项目
 *
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface JingsaixiangmuService extends IService<JingsaixiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaixiangmuView> selectListView(Wrapper<JingsaixiangmuEntity> wrapper);
   	
   	JingsaixiangmuView selectView(@Param("ew") Wrapper<JingsaixiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaixiangmuEntity> wrapper);
   	

}

