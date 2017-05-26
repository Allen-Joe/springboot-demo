package com.plateno.common.util;

import java.lang.reflect.Field;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 * json转换工具类
 * 创建人：MoChunrun 
 * 创建时间：2016年1月11日 下午5:57:05
 * 描述：
 * @version v1.0
 */
public class JsonUtil {

	/**
	 * javabean转换为json字符串
	 * @作者 MoChunrun
	 * @创建时间：2016年1月11日 下午5:57:05
	 * @param t
	 * @return
	 */
	public static <T> String beanToJson(T t){
		return beanToJson(t, null);
	}
	
	/**
	 * 是否过虑空值
	 * 创建人：MoChunrun 
	 * 创建时间：2016年1月14日 上午10:09:00
	 * 描述：
	 * @version v1.0
	 * @param t
	 * @param filterNunnVal
	 * @return
	 */
	public static <T> String beanToJson(T t,boolean filterNunnVal){
		if(filterNunnVal){
			ExcludesProFilter filter = new ExcludesProFilter();
			Field [] fields = t.getClass().getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				try {
					Object val = f.get(t);
					if(val==null){
						filter.addExclude(f.getName());
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			return beanToJson(t, filter);
		}else{
			return beanToJson(t, null);
		}
	}
	
	public static <T> String beanToJson(T t,SerializeFilter filter){
		SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
			SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
		};
		if(filter==null){
			return JSON.toJSONString(t,features);
		}else{
			return JSON.toJSONString(t,filter,features);
		}
	}
	
	/**
	 * json转换为javabean
	 * @作者 MoChunrun
	 * @创建时间：2016年1月11日 下午5:57:05
	 * @param src
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T jsonToBean(String src,Class clazz){
		return (T) JSON.parseObject(src, clazz);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<?> jsonToArray(String src, Class clazz){
		return JSON.parseArray(src, clazz);
	}
}
