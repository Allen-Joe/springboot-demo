package com.plateno.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plateno.common.config.ResultCode;
import com.plateno.common.util.StringUtil;
import com.plateno.pojo.MemberInfo;
import com.plateno.pojo.Result;
import com.plateno.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
    private MemberService memberService;
	
	@RequestMapping(value="/getMemberInfo",method=RequestMethod.GET)
	@ResponseBody
	public Result<MemberInfo> getMemberInfo(String memberId){
		Result<MemberInfo> result=new Result<MemberInfo>();
		if(!StringUtil.isInteger(memberId)){
			result.setCode(ResultCode.ERROR_PARAM_ILLGAL.getCode());
			result.setMsg(ResultCode.ERROR_PARAM_ILLGAL.getMsg());
			return result;
		}
		MemberInfo member=memberService.find(Integer.parseInt(memberId));
		result.setCode(ResultCode.SUCCESS.getCode());
		result.setMsg(ResultCode.SUCCESS.getMsg());
		result.setData(member);
		return result;		
	}
	
	@RequestMapping(value="/getMemberInfoList",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<MemberInfo>> getMemberInfoList(){
		Result<List<MemberInfo>> result=new Result<List<MemberInfo>>();
		List<MemberInfo> members=memberService.findAll();
		result.setCode(ResultCode.SUCCESS.getCode());
		result.setMsg(ResultCode.SUCCESS.getMsg());
		result.setData(members);
		return result;
	}
	
	@RequestMapping(value="/addMemberInfo",method=RequestMethod.POST)
	@ResponseBody
	public Result<Integer> addMemberInfo(@RequestBody MemberInfo memberInfo){
		Result<Integer> result=new Result<Integer>();
		if(!paramValidate(memberInfo)){
			result.setCode(ResultCode.ERROR_PARAM_ILLGAL.getCode());
			result.setMsg(ResultCode.ERROR_PARAM_ILLGAL.getMsg());
			return result;
		}
		try {
			int cnt = memberService.add(memberInfo);
			if (cnt==1) {
				result.setCode(ResultCode.SUCCESS.getCode());
				result.setMsg(ResultCode.SUCCESS.getMsg());
			}else{
				result.setCode(ResultCode.ERROR_ADD_FAILURE.getCode());
				result.setMsg(ResultCode.ERROR_ADD_FAILURE.getMsg());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setCode(ResultCode.ERROR_SYSTEM.getCode());
			result.setMsg(ResultCode.ERROR_SYSTEM.getMsg());
		}
		return result;
	}
	
	@RequestMapping(value="/modifyMemberInfo",method=RequestMethod.POST)
	@ResponseBody
	public Result<Integer> modifyMemberInfo(@RequestBody MemberInfo memberInfo){
		Result<Integer> result=new Result<Integer>();
		if(!paramValidate(memberInfo)){
			result.setCode(ResultCode.ERROR_PARAM_ILLGAL.getCode());
			result.setMsg(ResultCode.ERROR_PARAM_ILLGAL.getMsg());
			return result;
		}
		try {
			int cnt=memberService.modify(memberInfo);
			if (cnt==1) {
				result.setCode(ResultCode.SUCCESS.getCode());
				result.setMsg(ResultCode.SUCCESS.getMsg());
			}else{
				result.setCode(ResultCode.ERROR_MODIFY_FAILURE.getCode());
				result.setMsg(ResultCode.ERROR_MODIFY_FAILURE.getMsg());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setCode(ResultCode.ERROR_SYSTEM.getCode());
			result.setMsg(ResultCode.ERROR_SYSTEM.getMsg());
		}
		return result;		
	}
	
	private boolean paramValidate(MemberInfo param){
		if(param==null)
			return false;
		return true;
	}
	

}
