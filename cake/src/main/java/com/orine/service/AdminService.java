package com.orine.service;

import java.util.List;

import com.orine.model.Admin;

public interface AdminService {
	
	public boolean addAdmin(Admin admin);
	
	public boolean deleteAdmin(int id);
	
	public boolean updateAdmin(Admin admin);
	
	public Admin findAdminById(int id);
	
	public Admin findAdminByUN(String username);
	
	public boolean isAdmin(Admin admin);
	
	public List<Admin> findAdminList();
}
