package com.orine.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orine.model.Admin;
import com.orine.service.AdminService;
import com.orine.util.CodeUtil;


/**
 * 
 * @author OrineK
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static Logger LOGGER = Logger.getLogger(AdminController.class);

	@Resource
	private AdminService adminService;
	
	/**
	 * ajax验证 验证码
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public Map<String, Object> code(HttpServletRequest request, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		String loginCode = (String) session.getAttribute("loginCode");
		String code = request.getParameter("Code");
		if(code.equals(loginCode)){
			map.put("codeResult", true);
		}else{
			map.put("codeResult", false);
		}
		return map;
	}
	
	/**
	 * 登录验证
	 * @param admin
	 * @param httpSession
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Map<String, Object> login(Admin admin, HttpSession httpSession, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
		if(admin.getUsername()!=""&&admin.getUsername()!=null&&admin.getPassword()!=""&&admin.getPassword()!=null){
			result = adminService.isAdmin(admin);
		}
		map.put("result", result);
		if(result == true){
			httpSession.setAttribute("currentAdmin", admin);
			httpSession.setAttribute("UserName", admin.getUsername());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		session.removeAttribute("currentAdmin");
		session.removeAttribute("UserName");
		try {
			request.getRequestDispatcher("../admin.jsp").forward(request, response);
		} catch (Exception e) {
			LOGGER.error(" 'response.sendRedirect' ERROR");
		}
	}
	
	/**
	 * 验证码动态生成
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/loginCode", method=RequestMethod.GET)
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		//生成随机字符串
		String verifyCode = CodeUtil.generateVerifyCode(4);  
		//存入会话session
		HttpSession session = request.getSession(true);
		session.setAttribute("loginCode", verifyCode.toLowerCase());
		//生成图片
		int w = 75, h = 36;
		CodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode, response);
	}
}
