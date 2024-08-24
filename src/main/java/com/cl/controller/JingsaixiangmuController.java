package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JingsaixiangmuEntity;
import com.cl.entity.view.JingsaixiangmuView;

import com.cl.service.JingsaixiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@RestController
@RequestMapping("/jingsaixiangmu")
public class JingsaixiangmuController {
    @Autowired
    private JingsaixiangmuService jingsaixiangmuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaixiangmuEntity jingsaixiangmu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jingsaixiangmu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaixiangmuEntity> ew = new EntityWrapper<JingsaixiangmuEntity>();

		PageUtils page = jingsaixiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaixiangmuEntity jingsaixiangmu, 
		HttpServletRequest request){
        EntityWrapper<JingsaixiangmuEntity> ew = new EntityWrapper<JingsaixiangmuEntity>();

		PageUtils page = jingsaixiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaixiangmuEntity jingsaixiangmu){
       	EntityWrapper<JingsaixiangmuEntity> ew = new EntityWrapper<JingsaixiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaixiangmu, "jingsaixiangmu")); 
        return R.ok().put("data", jingsaixiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaixiangmuEntity jingsaixiangmu){
        EntityWrapper< JingsaixiangmuEntity> ew = new EntityWrapper< JingsaixiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaixiangmu, "jingsaixiangmu")); 
		JingsaixiangmuView jingsaixiangmuView =  jingsaixiangmuService.selectView(ew);
		return R.ok("查询竞赛项目成功").put("data", jingsaixiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaixiangmuEntity jingsaixiangmu = jingsaixiangmuService.selectById(id);
		jingsaixiangmu = jingsaixiangmuService.selectView(new EntityWrapper<JingsaixiangmuEntity>().eq("id", id));
        return R.ok().put("data", jingsaixiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaixiangmuEntity jingsaixiangmu = jingsaixiangmuService.selectById(id);
		jingsaixiangmu = jingsaixiangmuService.selectView(new EntityWrapper<JingsaixiangmuEntity>().eq("id", id));
        return R.ok().put("data", jingsaixiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaixiangmuEntity jingsaixiangmu, HttpServletRequest request){
    	jingsaixiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaixiangmu);
        jingsaixiangmuService.insert(jingsaixiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaixiangmuEntity jingsaixiangmu, HttpServletRequest request){
    	jingsaixiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaixiangmu);
        jingsaixiangmuService.insert(jingsaixiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaixiangmuEntity jingsaixiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaixiangmu);
        jingsaixiangmuService.updateById(jingsaixiangmu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JingsaixiangmuEntity> list = new ArrayList<JingsaixiangmuEntity>();
        for(Long id : ids) {
            JingsaixiangmuEntity jingsaixiangmu = jingsaixiangmuService.selectById(id);
            jingsaixiangmu.setSfsh(sfsh);
            jingsaixiangmu.setShhf(shhf);
            list.add(jingsaixiangmu);
        }
        jingsaixiangmuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaixiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
