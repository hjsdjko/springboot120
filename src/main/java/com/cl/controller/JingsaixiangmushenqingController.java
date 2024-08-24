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

import com.cl.entity.JingsaixiangmushenqingEntity;
import com.cl.entity.view.JingsaixiangmushenqingView;

import com.cl.service.JingsaixiangmushenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛项目申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@RestController
@RequestMapping("/jingsaixiangmushenqing")
public class JingsaixiangmushenqingController {
    @Autowired
    private JingsaixiangmushenqingService jingsaixiangmushenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaixiangmushenqingEntity jingsaixiangmushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jingsaixiangmushenqing.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jingsaixiangmushenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaixiangmushenqingEntity> ew = new EntityWrapper<JingsaixiangmushenqingEntity>();

		PageUtils page = jingsaixiangmushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixiangmushenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaixiangmushenqingEntity jingsaixiangmushenqing, 
		HttpServletRequest request){
        EntityWrapper<JingsaixiangmushenqingEntity> ew = new EntityWrapper<JingsaixiangmushenqingEntity>();

		PageUtils page = jingsaixiangmushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixiangmushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaixiangmushenqingEntity jingsaixiangmushenqing){
       	EntityWrapper<JingsaixiangmushenqingEntity> ew = new EntityWrapper<JingsaixiangmushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaixiangmushenqing, "jingsaixiangmushenqing")); 
        return R.ok().put("data", jingsaixiangmushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaixiangmushenqingEntity jingsaixiangmushenqing){
        EntityWrapper< JingsaixiangmushenqingEntity> ew = new EntityWrapper< JingsaixiangmushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaixiangmushenqing, "jingsaixiangmushenqing")); 
		JingsaixiangmushenqingView jingsaixiangmushenqingView =  jingsaixiangmushenqingService.selectView(ew);
		return R.ok("查询竞赛项目申请成功").put("data", jingsaixiangmushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaixiangmushenqingEntity jingsaixiangmushenqing = jingsaixiangmushenqingService.selectById(id);
		jingsaixiangmushenqing = jingsaixiangmushenqingService.selectView(new EntityWrapper<JingsaixiangmushenqingEntity>().eq("id", id));
        return R.ok().put("data", jingsaixiangmushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaixiangmushenqingEntity jingsaixiangmushenqing = jingsaixiangmushenqingService.selectById(id);
		jingsaixiangmushenqing = jingsaixiangmushenqingService.selectView(new EntityWrapper<JingsaixiangmushenqingEntity>().eq("id", id));
        return R.ok().put("data", jingsaixiangmushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaixiangmushenqingEntity jingsaixiangmushenqing, HttpServletRequest request){
    	jingsaixiangmushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaixiangmushenqing);
        jingsaixiangmushenqingService.insert(jingsaixiangmushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaixiangmushenqingEntity jingsaixiangmushenqing, HttpServletRequest request){
    	jingsaixiangmushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaixiangmushenqing);
        jingsaixiangmushenqingService.insert(jingsaixiangmushenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaixiangmushenqingEntity jingsaixiangmushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaixiangmushenqing);
        jingsaixiangmushenqingService.updateById(jingsaixiangmushenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JingsaixiangmushenqingEntity> list = new ArrayList<JingsaixiangmushenqingEntity>();
        for(Long id : ids) {
            JingsaixiangmushenqingEntity jingsaixiangmushenqing = jingsaixiangmushenqingService.selectById(id);
            jingsaixiangmushenqing.setSfsh(sfsh);
            jingsaixiangmushenqing.setShhf(shhf);
            list.add(jingsaixiangmushenqing);
        }
        jingsaixiangmushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaixiangmushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
