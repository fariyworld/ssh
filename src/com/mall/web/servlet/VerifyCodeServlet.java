package com.mall.web.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.tools.VerifyCode;


/**
 * 图片验证码servlet
 */
@WebServlet(description = "verifyCode to Image", urlPatterns = { "/servlet/VerifyCodeServlet" })
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VerifyCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		response.reset();
		
		String vcode = VerifyCode.getVerifyCode(4);
		request.getSession().setAttribute("vcode", vcode);
		OutputStream os = response.getOutputStream();
		
		ImageIO.write(VerifyCode.getImage(vcode), "JPEG", os);
	}

}
