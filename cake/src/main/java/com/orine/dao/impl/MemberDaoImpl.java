package com.orine.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.orine.dao.MemberDao;
import com.orine.model.Member;

/**
 * 
 * @author OrineK
 *
 */
@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addMember(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(member);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteMember(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Member member = new Member();
		member = (Member) session.get(Member.class, id);
		try {
			session.delete(member);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public void updateMember(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(member);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public boolean isMember(Member member) {
		Session session = this.getSession();
		String hql = "from Member where username = ? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, member.getUsername());
		query.setString(1, member.getPassword());
		if(query.list().size() > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Member findMemberInfoById(int id) {
		Session session = this.getSession();
		Member member = (Member) session.get(Member.class, id);
		return member;
	}

	@Override
	public Member findMemberByUN(String username) {
		Session session = this.getSession();
		String hql = "from Member as m where m.username=?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		return (Member) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findMemberList() {
		Session session = this.getSession();
		String hql = "from Member";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
