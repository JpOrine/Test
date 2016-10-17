package com.orine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orine.dao.AdminDao;
import com.orine.model.Admin;
import com.orine.service.AdminService;

/**
 * 
 * @author OrineK
 *
 */
@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;
	
	@Override
	public boolean addAdmin(Admin admin) {
		if(adminDao.isAdmin(admin) == true){
			return false;
		}else{
			adminDao.addAdmin(admin);
			return true;
		}
	}

	@Override
	public boolean deleteAdmin(int id) {
		adminDao.deleteAdmin(id);
		return true;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
		return true;
	}

	@Override
	public Admin findAdminById(int id) {
		return adminDao.findAdminById(id);
	}

	@Override
	public Admin findAdminByUN(String username) {
		return adminDao.findAdminByUN(username);
	}

	@Override
	public boolean isAdmin(Admin admin) {
		return adminDao.isAdmin(admin);
	}

	@Override
	public List<Admin> findAdminList() {
		return adminDao.findAdminList();
	}

}
