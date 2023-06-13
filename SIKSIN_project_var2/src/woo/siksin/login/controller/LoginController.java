package woo.siksin.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class LoginController implements Controller {


private static Log log = LogFactory.getLog(LoginController.class);
	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String phoneNum = request.getParameter("phoneNum");
		String password = request.getParameter("password");
		String save = request.getParameter("save");
		log.info(save);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setPhoneNum(phoneNum);
		memberDTO.setPassword(password);
		log.info(memberDTO);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDTO= memberDAO.siksinMemberLogin(memberDTO);
		log.info("로그인 서블릿: 로그인 내용" + memberDTO);
		request.setAttribute("memberName", memberDTO.getMemberName());
		request.setAttribute("memberDTO", memberDTO);
		
		if (!memberDTO.getPhoneNum().equals("") & !memberDTO.getPassword().equals("")) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("phoneNum", memberDTO.getPhoneNum());
			httpSession.setAttribute("memberName", memberDTO.getMemberName());
			Cookie cookie = new Cookie("phoneNum", memberDTO.getPhoneNum());
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/");
			response.addCookie(cookie);
			
		}
		
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/login/login_check.jsp");
		return siksinHandlerAdapter;
	}

}
