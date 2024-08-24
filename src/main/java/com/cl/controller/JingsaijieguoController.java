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

import com.cl.entity.JingsaijieguoEntity;
import com.cl.entity.view.JingsaijieguoView;

import com.cl.service.JingsaijieguoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛结果
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@RestController
@RequestMapping("/jingsaijieguo")
public class JingsaijieguoController {
    @Autowired
    private JingsaijieguoService jingsaijieguoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaijieguoEntity jingsaijieguo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jingsaijieguo.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jingsaijieguo.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaijieguoEntity> ew = new EntityWrapper<JingsaijieguoEntity>();

		PageUtils page = jingsaijieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaijieguo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaijieguoEntity jingsaijieguo, 
		HttpServletRequest request){
        EntityWrapper<JingsaijieguoEntity> ew = new EntityWrapper<JingsaijieguoEntity>();

		PageUtils page = jingsaijieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaijieguo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaijieguoEntity jingsaijieguo){
       	EntityWrapper<JingsaijieguoEntity> ew = new EntityWrapper<JingsaijieguoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaijieguo, "jingsaijieguo")); 
        return R.ok().put("data", jingsaijieguoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaijieguoEntity jingsaijieguo){
        EntityWrapper< JingsaijieguoEntity> ew = new EntityWrapper< JingsaijieguoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaijieguo, "jingsaijieguo")); 
		JingsaijieguoView jingsaijieguoView =  jingsaijieguoService.selectView(ew);
		return R.ok("查询竞赛结果成功").put("data", jingsaijieguoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaijieguoEntity jingsaijieguo = jingsaijieguoService.selectById(id);
		jingsaijieguo = jingsaijieguoService.selectView(new EntityWrapper<JingsaijieguoEntity>().eq("id", id));
        return R.ok().put("data", jingsaijieguo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaijieguoEntity jingsaijieguo = jingsaijieguoService.selectById(id);
		jingsaijieguo = jingsaijieguoService.selectView(new EntityWrapper<JingsaijieguoEntity>().eq("id", id));
        return R.ok().put("data", jingsaijieguo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaijieguoEntity jingsaijieguo, HttpServletRequest request){
    	jingsaijieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaijieguo);
        jingsaijieguoService.insert(jingsaijieguo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaijieguoEntity jingsaijieguo, HttpServletRequest request){
    	jingsaijieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaijieguo);
        jingsaijieguoService.insert(jingsaijieguo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaijieguoEntity jingsaijieguo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaijieguo);
        jingsaijieguoService.updateById(jingsaijieguo);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaijieguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
