package com.cl.entity.view;

import com.cl.entity.JingsaijieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 竞赛结果
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@TableName("jingsaijieguo")
public class JingsaijieguoView  extends JingsaijieguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingsaijieguoView(){
	}
 
 	public JingsaijieguoView(JingsaijieguoEntity jingsaijieguoEntity){
 	try {
			BeanUtils.copyProperties(this, jingsaijieguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
