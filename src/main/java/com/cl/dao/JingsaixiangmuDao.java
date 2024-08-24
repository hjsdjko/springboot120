package com.cl.dao;

import com.cl.entity.JingsaixiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingsaixiangmuView;


/**
 * 竞赛项目
 * 
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
public interface JingsaixiangmuDao extends BaseMapper<JingsaixiangmuEntity> {
	
	List<JingsaixiangmuView> selectListView(@Param("ew") Wrapper<JingsaixiangmuEntity> wrapper);

	List<JingsaixiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<JingsaixiangmuEntity> wrapper);
	
	JingsaixiangmuView selectView(@Param("ew") Wrapper<JingsaixiangmuEntity> wrapper);
	

}
