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


import com.cl.dao.XinwenzixunDao;
import com.cl.entity.XinwenzixunEntity;
import com.cl.service.XinwenzixunService;
import com.cl.entity.view.XinwenzixunView;

@Service("xinwenzixunService")
public class XinwenzixunServiceImpl extends ServiceImpl<XinwenzixunDao, XinwenzixunEntity> implements XinwenzixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinwenzixunEntity> page = this.selectPage(
                new Query<XinwenzixunEntity>(params).getPage(),
                new EntityWrapper<XinwenzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinwenzixunEntity> wrapper) {
		  Page<XinwenzixunView> page =new Query<XinwenzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinwenzixunView> selectListView(Wrapper<XinwenzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinwenzixunView selectView(Wrapper<XinwenzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
