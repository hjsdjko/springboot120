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


import com.cl.dao.JingsaixiangmuDao;
import com.cl.entity.JingsaixiangmuEntity;
import com.cl.service.JingsaixiangmuService;
import com.cl.entity.view.JingsaixiangmuView;

@Service("jingsaixiangmuService")
public class JingsaixiangmuServiceImpl extends ServiceImpl<JingsaixiangmuDao, JingsaixiangmuEntity> implements JingsaixiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingsaixiangmuEntity> page = this.selectPage(
                new Query<JingsaixiangmuEntity>(params).getPage(),
                new EntityWrapper<JingsaixiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingsaixiangmuEntity> wrapper) {
		  Page<JingsaixiangmuView> page =new Query<JingsaixiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingsaixiangmuView> selectListView(Wrapper<JingsaixiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingsaixiangmuView selectView(Wrapper<JingsaixiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
