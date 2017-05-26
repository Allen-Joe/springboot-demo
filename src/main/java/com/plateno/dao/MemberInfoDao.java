package com.plateno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.plateno.pojo.MemberInfo;

@Mapper
public interface MemberInfoDao {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(MemberInfo record);
//
//    int insertSelective(MemberInfo record);
//
//    int updateByPrimaryKeySelective(MemberInfo record);
//
//    int updateByPrimaryKey(MemberInfo record);
    
    @Select("select * from member_info")
    List<MemberInfo> selectAll();
    
    @Select("select * from member_info where id=#{id}")
    MemberInfo selectByPrimaryKey(Integer id);
    
    @Insert("insert into member_info (id, name, sex, age)"+
    "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insert(MemberInfo memberInfo);
    
}