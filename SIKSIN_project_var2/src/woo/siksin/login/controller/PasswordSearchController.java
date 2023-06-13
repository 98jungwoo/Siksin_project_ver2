package woo.siksin.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class PasswordSearchController implements Controller {
	private static Log log = LogFactory.getLog(PasswordSearchController.class);

	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String phoneNum= request.getParameter("phoneNum");
		log.info(phoneNum);
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setPhoneNum(phoneNum);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDTO=memberDAO.siksinMemberSearchPassword(phoneNum);
		log.info(memberDTO);
		request.setAttribute("password", memberDTO.getPassword());
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/login/password_search_view.jsp");
		
		
		return siksinHandlerAdapter;
	}


}
