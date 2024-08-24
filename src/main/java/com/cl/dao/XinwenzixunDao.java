package com.cl.dao;

import com.cl.entity.XinwenzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinwenzixunView;


/**
 * 新闻资讯
 * 
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface XinwenzixunDao extends BaseMapper<XinwenzixunEntity> {
	
	List<XinwenzixunView> selectListView(@Param("ew") Wrapper<XinwenzixunEntity> wrapper);

	List<XinwenzixunView> selectListView(Pagination page,@Param("ew") Wrapper<XinwenzixunEntity> wrapper);
	
	XinwenzixunView selectView(@Param("ew") Wrapper<XinwenzixunEntity> wrapper);
	

}
