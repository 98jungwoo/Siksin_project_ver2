package woo.siksin.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;

public class LogoutController implements Controller{


private static Log log = LogFactory.getLog(LogoutController.class);
	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession( );
		String phoneNum = (String) httpSession.getAttribute("phoneNum");
		request.setAttribute("phoneNum", phoneNum);

		httpSession.invalidate( );
		Cookie[ ] cookies = request.getCookies( );
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName( ).equals("phoneNum")) {
					log.info(cookie.getName( ).equals("phoneNum"));
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}

		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/login/logout.jsp");
		return siksinHandlerAdapter;
	}

}
