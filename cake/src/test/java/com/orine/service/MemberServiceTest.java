package com.orine.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
//defaultRollback=true不改变数据库；false改变数据库
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
@Transactional
public class MemberServiceTest {

	@Resource
	private MemberService memberService;
	
	@Test
	public void findID(){
		System.out.println(memberService.findMemberList());
	}
}
