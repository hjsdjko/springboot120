package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingsaijieguoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingsaijieguoView;


/**
 * 竞赛结果
 *
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface JingsaijieguoService extends IService<JingsaijieguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaijieguoView> selectListView(Wrapper<JingsaijieguoEntity> wrapper);
   	
   	JingsaijieguoView selectView(@Param("ew") Wrapper<JingsaijieguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaijieguoEntity> wrapper);
   	

}

