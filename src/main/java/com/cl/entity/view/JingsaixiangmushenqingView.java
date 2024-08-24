package com.cl.entity.view;

import com.cl.entity.JingsaixiangmushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 竞赛项目申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@TableName("jingsaixiangmushenqing")
public class JingsaixiangmushenqingView  extends JingsaixiangmushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingsaixiangmushenqingView(){
	}
 
 	public JingsaixiangmushenqingView(JingsaixiangmushenqingEntity jingsaixiangmushenqingEntity){
 	try {
			BeanUtils.copyProperties(this, jingsaixiangmushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
