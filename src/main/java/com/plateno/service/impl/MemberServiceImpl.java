package com.plateno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.plateno.dao.MemberInfoDao;
import com.plateno.pojo.MemberInfo;
import com.plateno.service.MemberService;

@Service("memberService")
//添加事务注解，并设置隔离级别和传播性
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberInfoDao memberDao;

	@Override
	public List<MemberInfo> findAll() {
		// TODO Auto-generated method stub
		return memberDao.selectAll();
	}

	@Override
	public MemberInfo find(Integer memberId) {
		// TODO Auto-generated method stub
		return memberDao.selectByPrimaryKey(memberId);
	}

	@Override
	public int add(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		return memberDao.insert(memberInfo);
	}

	@Override
	public int modify(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		return memberDao.update(memberInfo);
	}

}
