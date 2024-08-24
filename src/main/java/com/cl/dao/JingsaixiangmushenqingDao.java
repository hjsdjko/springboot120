package com.cl.dao;

import com.cl.entity.JingsaixiangmushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingsaixiangmushenqingView;


/**
 * 竞赛项目申请
 * 
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface JingsaixiangmushenqingDao extends BaseMapper<JingsaixiangmushenqingEntity> {
	
	List<JingsaixiangmushenqingView> selectListView(@Param("ew") Wrapper<JingsaixiangmushenqingEntity> wrapper);

	List<JingsaixiangmushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<JingsaixiangmushenqingEntity> wrapper);
	
	JingsaixiangmushenqingView selectView(@Param("ew") Wrapper<JingsaixiangmushenqingEntity> wrapper);
	

}
