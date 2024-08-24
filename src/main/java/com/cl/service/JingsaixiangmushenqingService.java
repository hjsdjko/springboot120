package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingsaixiangmushenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingsaixiangmushenqingView;


/**
 * 竞赛项目申请
 *
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface JingsaixiangmushenqingService extends IService<JingsaixiangmushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaixiangmushenqingView> selectListView(Wrapper<JingsaixiangmushenqingEntity> wrapper);
   	
   	JingsaixiangmushenqingView selectView(@Param("ew") Wrapper<JingsaixiangmushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaixiangmushenqingEntity> wrapper);
   	

}

