package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinwenzixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinwenzixunView;


/**
 * 新闻资讯
 *
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface XinwenzixunService extends IService<XinwenzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinwenzixunView> selectListView(Wrapper<XinwenzixunEntity> wrapper);
   	
   	XinwenzixunView selectView(@Param("ew") Wrapper<XinwenzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinwenzixunEntity> wrapper);
   	

}

