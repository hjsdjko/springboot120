package com.cl.dao;

import com.cl.entity.JingsaijieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingsaijieguoView;


/**
 * 竞赛结果
 * 
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface JingsaijieguoDao extends BaseMapper<JingsaijieguoEntity> {
	
	List<JingsaijieguoView> selectListView(@Param("ew") Wrapper<JingsaijieguoEntity> wrapper);

	List<JingsaijieguoView> selectListView(Pagination page,@Param("ew") Wrapper<JingsaijieguoEntity> wrapper);
	
	JingsaijieguoView selectView(@Param("ew") Wrapper<JingsaijieguoEntity> wrapper);
	

}
