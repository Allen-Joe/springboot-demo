package com.plateno.pojo;

import com.plateno.common.pager.Pager;

public class FindConditionVo extends Pager<MemberInfo>{
	
	private String memberName;
	
	private String memberSex;
	
	private Integer beginAge;
	
	private Integer endAge;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public Integer getBeginAge() {
		return beginAge;
	}

	public void setBeginAge(Integer beginAge) {
		this.beginAge = beginAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}
	
	

}
