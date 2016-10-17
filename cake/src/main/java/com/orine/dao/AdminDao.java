package com.orine.dao;

import java.util.List;

import com.orine.model.Admin;

/**
 * 
 * @author OrineK
 *
 */

public interface AdminDao {
	
	public void addAdmin(Admin admin);
	
	public void deleteAdmin(int id);
	
	public void updateAdmin(Admin admin);
	
	public Admin findAdminById(int id);
	
	public Admin findAdminByUN(String username);
	
	public boolean isAdmin(Admin admin);
	
	public List<Admin> findAdminList();
}
