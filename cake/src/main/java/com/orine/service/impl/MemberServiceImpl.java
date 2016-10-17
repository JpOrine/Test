package com.orine.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orine.dao.MemberDao;
import com.orine.model.Member;
import com.orine.service.MemberService;

/**
 * 
 * @author OrineK
 *
 */
@Transactional
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberDao memberDao;
	
	@Override
	public boolean addMember(Member member) {
		if(memberDao.isMember(member) == true){
			return false;
		}else{
			member.setCreate_time(new Date().getTime());
			memberDao.addMember(member);
			return true;
		}
	}

	@Override
	public boolean deleteMember(int id) {
		memberDao.deleteMember(id);
		return true;
	}

	@Override
	public boolean updateMember(Member member) {
		memberDao.updateMember(member);
		return true;
	}

	@Override
	public boolean isMember(Member member) {
		return memberDao.isMember(member);
	}

	@Override
	public Member findMemberInfoById(int id) {
		return memberDao.findMemberInfoById(id);
	}

	@Override
	public Member findMemberByUN(String username) {
		return memberDao.findMemberByUN(username);
	}

	@Override
	public List<Member> findMemberList() {
		return memberDao.findMemberList();
	}

}
