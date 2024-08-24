package com.cl.entity.view;

import com.cl.entity.JingsaixiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 竞赛项目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-31 16:20:40
 */
@TableName("jingsaixiangmu")
public class JingsaixiangmuView  extends JingsaixiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingsaixiangmuView(){
	}
 
 	public JingsaixiangmuView(JingsaixiangmuEntity jingsaixiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, jingsaixiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
