package com.orine.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orine.model.Member;
import com.orine.service.MemberService;

/**
 * 
 * @author OrineK
 *
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Resource
	private MemberService memberService;
	
	/**
	 * 登录用户检测
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Map<String, Object> login(Member member){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean loginResult = memberService.isMember(member);
		map.put("loginResult", loginResult);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public Map<String, Object> register(Member member){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean Result = memberService.addMember(member);
		map.put("Result", Result);
		return map;
	}
}
