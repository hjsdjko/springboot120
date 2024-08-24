package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JingsaixiangmushenqingDao;
import com.cl.entity.JingsaixiangmushenqingEntity;
import com.cl.service.JingsaixiangmushenqingService;
import com.cl.entity.view.JingsaixiangmushenqingView;

@Service("jingsaixiangmushenqingService")
public class JingsaixiangmushenqingServiceImpl extends ServiceImpl<JingsaixiangmushenqingDao, JingsaixiangmushenqingEntity> implements JingsaixiangmushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingsaixiangmushenqingEntity> page = this.selectPage(
                new Query<JingsaixiangmushenqingEntity>(params).getPage(),
                new EntityWrapper<JingsaixiangmushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingsaixiangmushenqingEntity> wrapper) {
		  Page<JingsaixiangmushenqingView> page =new Query<JingsaixiangmushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingsaixiangmushenqingView> selectListView(Wrapper<JingsaixiangmushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingsaixiangmushenqingView selectView(Wrapper<JingsaixiangmushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
