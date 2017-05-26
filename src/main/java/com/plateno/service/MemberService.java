package com.plateno.service;

import java.util.List;

import com.plateno.pojo.MemberInfo;

public interface MemberService {
	
	List<MemberInfo> findAll();
	
	MemberInfo find(Integer memberId);
	
	int add(MemberInfo memberInfo);

}
