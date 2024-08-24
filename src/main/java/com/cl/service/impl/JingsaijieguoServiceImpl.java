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


import com.cl.dao.JingsaijieguoDao;
import com.cl.entity.JingsaijieguoEntity;
import com.cl.service.JingsaijieguoService;
import com.cl.entity.view.JingsaijieguoView;

@Service("jingsaijieguoService")
public class JingsaijieguoServiceImpl extends ServiceImpl<JingsaijieguoDao, JingsaijieguoEntity> implements JingsaijieguoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingsaijieguoEntity> page = this.selectPage(
                new Query<JingsaijieguoEntity>(params).getPage(),
                new EntityWrapper<JingsaijieguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingsaijieguoEntity> wrapper) {
		  Page<JingsaijieguoView> page =new Query<JingsaijieguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingsaijieguoView> selectListView(Wrapper<JingsaijieguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingsaijieguoView selectView(Wrapper<JingsaijieguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
