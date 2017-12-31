package com.mall.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet工具类
 */
@WebServlet(description = "With Ajax and Servlet3", urlPatterns = { "/servlet/ServletUtils" })
public class ServletUtils extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
    public ServletUtils() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = "";
		
		String idt  = request.getParameter("idt");
		
		switch(idt){
			
			case "1": msg = verifyCode(request, response); 			break;//验证图片验证码
			case "2": msg = verifyUserName(request, response);  	break;//验证用户名合法性 
			
		}
		response.getWriter().write(msg);//传回给Ajax请求的回调函数
	}
	
	
	private String verifyCode(HttpServletRequest request,HttpServletResponse response) {
		
		String msg = "";
		
		String icode = request.getParameter("icode");
		
		String scode = (String) request.getSession().getAttribute("vcode");
			
		if( !icode.equalsIgnoreCase(scode)){
			msg = "Verification code error";
		}
		return msg;
	}
	
	/*验证用户名合法性*/
	private String verifyUserName(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		String userName = request.getParameter("userName");
		if( userName == null || userName.equals("")){
			msg = "用户名不能为空~";
		}else{
			String regex = "^.{6,20}$";
			if( !userName.matches(regex) ){
				msg = "长度只能在6-20个字符之间";
			}
		}
		return msg;
	}

}
