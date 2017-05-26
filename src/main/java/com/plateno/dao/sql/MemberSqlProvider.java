package com.plateno.dao.sql;

import static org.apache.ibatis.jdbc.SqlBuilder.AND;
import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.plateno.common.util.StringUtil;
import com.plateno.pojo.FindConditionVo;

public class MemberSqlProvider {
	
	@SuppressWarnings("deprecation")
	public String getSelectByConditionSql(Map<String, Object> parameter){
		FindConditionVo condition=(FindConditionVo) parameter.get("condition");
		BEGIN();
		SELECT("id, name, sex, age");
		FROM("member_info");
		WHERE(" 1=1 ");
		if(!StringUtil.isBlank(condition.getMemberName())){
			AND();
			WHERE("name like \"%\"#{condition.memberName,javaType=string,jdbcType=VARCHAR}\"%\" ");
		}
		if(!StringUtil.isBlank(condition.getMemberSex())){
			AND();
			WHERE("sex=#{condition.memberSex,javaType=string,jdbcType=VARCHAR}");
		}
		ORDER_BY(" id asc limit #{condition.startIndex},#{condition.pageSize}");
		return SQL();
	}
	
	@SuppressWarnings("deprecation")
	public String getSelectByConditionCountSql(Map<String, Object> parameter){
		FindConditionVo condition=(FindConditionVo) parameter.get("condition");
		BEGIN();
		SELECT("count(*)");
		FROM("member_info");
		WHERE(" 1=1 ");
		if(!StringUtil.isBlank(condition.getMemberName())){
			AND();
			WHERE("name like \"%\"#{condition.memberName,javaType=string,jdbcType=VARCHAR}\"%\" ");
		}
		if(!StringUtil.isBlank(condition.getMemberSex())){
			AND();
			WHERE("sex=#{condition.memberSex,javaType=string,jdbcType=VARCHAR}");
		}
		return SQL();
	}

}
