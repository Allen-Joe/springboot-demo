package com.plateno.common.util;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

/**
 * 过虑不转换为json的字段
 * 创建人：MoChunrun 
 * 创建时间：2016年1月13日 下午2:45:48
 * 描述：
 * @version v1.0
 */
public class ExcludesProFilter implements PropertyPreFilter {

    private final Set<String> excludes = new HashSet<String>();

    public ExcludesProFilter(){
    	super();
    }
    public ExcludesProFilter(String... properties){
    	super();
        for (String item : properties) {
            if (item != null) {
                this.excludes.add(item);
            }
        }
    }

    public Set<String> getExcludes() {
        return excludes;
    }
    
    public void addExclude(String name){
    	excludes.add(name);
    }

    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if (this.excludes.contains(name)) {
            return false;
        }
        return true;
    }
    
}
