package com.plateno.service;

import java.util.List;

import com.plateno.common.pager.Pager;
import com.plateno.pojo.FindConditionVo;
import com.plateno.pojo.MemberInfo;

public interface MemberService {
	
	List<MemberInfo> findAll();
	
	MemberInfo find(Integer memberId);
	
	int add(MemberInfo memberInfo);
	
	int modify(MemberInfo memberInfo);
	
	Pager<MemberInfo> findByCondition(FindConditionVo condition); 

}
