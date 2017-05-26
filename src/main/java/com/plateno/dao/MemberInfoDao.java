package com.plateno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.plateno.dao.sql.MemberSqlProvider;
import com.plateno.pojo.FindConditionVo;
import com.plateno.pojo.MemberInfo;

@Mapper
public interface MemberInfoDao {
	
    @Select("select * from member_info")
    List<MemberInfo> selectAll();
    
    @Select("select * from member_info where id=#{id}")
    MemberInfo selectByPrimaryKey(Integer id);
    
    @Insert("insert into member_info (id, name, sex, age)"+
    "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insert(MemberInfo memberInfo);
    
    @Update("update member_info"+
    " set name = #{name,jdbcType=VARCHAR},"+
      "sex = #{sex,jdbcType=VARCHAR},"+
      "age = #{age,jdbcType=INTEGER}"+
    " where id = #{id,jdbcType=INTEGER}")
    int update(MemberInfo memberInfo);
    
    @SelectProvider(type=MemberSqlProvider.class,method="getSelectByConditionSql")
    List<MemberInfo> selectByCondition(@Param("condition")FindConditionVo condition);
    
    @SelectProvider(type=MemberSqlProvider.class,method="getSelectByConditionCountSql")
    int selectCountOfRecords(@Param("condition")FindConditionVo condition);
    
}