package com.orine.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.orine.dao.AdminDao;
import com.orine.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	@Resource
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteAdmin(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Admin admin = new Admin();
		admin = (Admin) session.get(Admin.class, id);
		try {
			session.delete(admin);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(admin);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public Admin findAdminById(int id) {
		Session session = this.getSession();
		Admin admin = (Admin) session.get(Admin.class, id);
		return admin;
	}

	@Override
	public Admin findAdminByUN(String username) {
		Session session = this.getSession();
		String hql = "from Admin as a where a.username=?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		return (Admin) query.list().get(0);
	}

	@Override
	public boolean isAdmin(Admin admin) {
		Session session = this.getSession();
		String hql = "from Admin where username = ? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, admin.getUsername());
		query.setString(1, admin.getPassword());
		if(query.list().size() > 0){
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAdminList() {
		Session session = this.getSession();
		String hql = "from Admin";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
