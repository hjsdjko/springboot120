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

import com.cl.entity.XinwenzixunEntity;
import com.cl.entity.view.XinwenzixunView;

import com.cl.service.XinwenzixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 新闻资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@RestController
@RequestMapping("/xinwenzixun")
public class XinwenzixunController {
    @Autowired
    private XinwenzixunService xinwenzixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinwenzixunEntity xinwenzixun,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<XinwenzixunEntity> ew = new EntityWrapper<XinwenzixunEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = xinwenzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinwenzixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinwenzixunEntity xinwenzixun, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<XinwenzixunEntity> ew = new EntityWrapper<XinwenzixunEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = xinwenzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinwenzixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinwenzixunEntity xinwenzixun){
       	EntityWrapper<XinwenzixunEntity> ew = new EntityWrapper<XinwenzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinwenzixun, "xinwenzixun")); 
        return R.ok().put("data", xinwenzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinwenzixunEntity xinwenzixun){
        EntityWrapper< XinwenzixunEntity> ew = new EntityWrapper< XinwenzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinwenzixun, "xinwenzixun")); 
		XinwenzixunView xinwenzixunView =  xinwenzixunService.selectView(ew);
		return R.ok("查询新闻资讯成功").put("data", xinwenzixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinwenzixunEntity xinwenzixun = xinwenzixunService.selectById(id);
		xinwenzixun = xinwenzixunService.selectView(new EntityWrapper<XinwenzixunEntity>().eq("id", id));
        return R.ok().put("data", xinwenzixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinwenzixunEntity xinwenzixun = xinwenzixunService.selectById(id);
		xinwenzixun = xinwenzixunService.selectView(new EntityWrapper<XinwenzixunEntity>().eq("id", id));
        return R.ok().put("data", xinwenzixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinwenzixunEntity xinwenzixun, HttpServletRequest request){
    	xinwenzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinwenzixun);
        xinwenzixunService.insert(xinwenzixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinwenzixunEntity xinwenzixun, HttpServletRequest request){
    	xinwenzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinwenzixun);
        xinwenzixunService.insert(xinwenzixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinwenzixunEntity xinwenzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinwenzixun);
        xinwenzixunService.updateById(xinwenzixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinwenzixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
