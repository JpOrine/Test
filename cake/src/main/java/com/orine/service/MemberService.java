package com.orine.service;

import java.util.List;

import com.orine.model.Member;

/**
 * 
 * @author OrineK
 *
 */
public interface MemberService {
	//增加会员
	public boolean addMember(Member member);
	
	//删除会员
	public boolean deleteMember(int id);
	
	//更新会员
	public boolean updateMember(Member member);
	
	//判断会员是否存在
	public boolean isMember(Member member);
	
	//根据id查询会员信息
	public Member findMemberInfoById(int id);
	
	//根据username获取信息
	public Member findMemberByUN(String username);
	
	//查询会员列表
	public List<Member> findMemberList();
}
