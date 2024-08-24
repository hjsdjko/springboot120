package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 竞赛项目
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@TableName("jingsaixiangmu")
public class JingsaixiangmuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JingsaixiangmuEntity() {
		
	}
	
	public JingsaixiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 竞赛名称
	 */
					
	private String jingsaimingcheng;
	
	/**
	 * 竞赛图片
	 */
					
	private String jingsaitupian;
	
	/**
	 * 竞赛学科
	 */
					
	private String jingsaixueke;
	
	/**
	 * 竞赛人数
	 */
					
	private String jingsairenshu;
	
	/**
	 * 竞赛规则
	 */
					
	private String jingsaiguize;
	
	/**
	 * 竞赛时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jingsaishijian;
	
	/**
	 * 竞赛详情
	 */
					
	private String jingsaixiangqing;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：竞赛名称
	 */
	public void setJingsaimingcheng(String jingsaimingcheng) {
		this.jingsaimingcheng = jingsaimingcheng;
	}
	/**
	 * 获取：竞赛名称
	 */
	public String getJingsaimingcheng() {
		return jingsaimingcheng;
	}
	/**
	 * 设置：竞赛图片
	 */
	public void setJingsaitupian(String jingsaitupian) {
		this.jingsaitupian = jingsaitupian;
	}
	/**
	 * 获取：竞赛图片
	 */
	public String getJingsaitupian() {
		return jingsaitupian;
	}
	/**
	 * 设置：竞赛学科
	 */
	public void setJingsaixueke(String jingsaixueke) {
		this.jingsaixueke = jingsaixueke;
	}
	/**
	 * 获取：竞赛学科
	 */
	public String getJingsaixueke() {
		return jingsaixueke;
	}
	/**
	 * 设置：竞赛人数
	 */
	public void setJingsairenshu(String jingsairenshu) {
		this.jingsairenshu = jingsairenshu;
	}
	/**
	 * 获取：竞赛人数
	 */
	public String getJingsairenshu() {
		return jingsairenshu;
	}
	/**
	 * 设置：竞赛规则
	 */
	public void setJingsaiguize(String jingsaiguize) {
		this.jingsaiguize = jingsaiguize;
	}
	/**
	 * 获取：竞赛规则
	 */
	public String getJingsaiguize() {
		return jingsaiguize;
	}
	/**
	 * 设置：竞赛时间
	 */
	public void setJingsaishijian(Date jingsaishijian) {
		this.jingsaishijian = jingsaishijian;
	}
	/**
	 * 获取：竞赛时间
	 */
	public Date getJingsaishijian() {
		return jingsaishijian;
	}
	/**
	 * 设置：竞赛详情
	 */
	public void setJingsaixiangqing(String jingsaixiangqing) {
		this.jingsaixiangqing = jingsaixiangqing;
	}
	/**
	 * 获取：竞赛详情
	 */
	public String getJingsaixiangqing() {
		return jingsaixiangqing;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
