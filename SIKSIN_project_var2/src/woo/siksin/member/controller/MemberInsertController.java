package woo.siksin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class MemberInsertController implements Controller {
	private static Log log = LogFactory.getLog(MemberInsertController.class);

	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		log.info("인설트 서블릿: 들어옴 ");
		System.out.println("인설트 서블릿 들어옴 ");
		
		String memberName = request.getParameter("memberName");
		log.info(memberName);
		String nickName = request.getParameter("nickName");
		log.info(nickName);
		String password = request.getParameter("password");
		log.info(password);
		String memberBirth = request.getParameter("memberBirth");
		log.info(memberBirth);
		String gender = request.getParameter("gender");
		log.info(gender);
		String phoneNumArea = request.getParameter("phoneNumArea");
		log.info(phoneNumArea);
		String phoneNum = request.getParameter("phoneNum");
		log.info(phoneNum);
		String phoneNum2 = request.getParameter("phoneNum2");
		log.info(phoneNum2);
		
		
		String[] agreeAarray = request.getParameterValues("agree");
		String agree = "";
		for (int i = 0; i < agreeAarray.length; i++) {
			agree += agreeAarray[i] + " | ";
		}
		log.info("인설트 서블릿: " + agree);
		
		
		String memberArea = request.getParameter("memberArea");
		log.info("인설트 서블릿: " + memberArea);
		
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		int siksinMemberNumber = memberDAO.siksinMemberNumber();
		
		memberDTO.setMemberNum(siksinMemberNumber + 1);
		
		memberDTO.setMemberName(memberName);
		memberDTO.setNickName(nickName);
		memberDTO.setPassword(password);
		memberDTO.setMemberBirth(memberBirth);
		memberDTO.setGender(gender);
		memberDTO.setPhoneNum(phoneNum);
		memberDTO.setAgree(agree);
		memberDTO.setMemberArea(memberArea);
		
		memberDTO = memberDAO.siksinInsert(memberDTO); 
		log.info(memberDTO);
		request.setAttribute("memberName", memberName);
		log.info("인설트 서블릿: 회원가입 정보등록");
		
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_insert_view.jsp");
		
		return siksinHandlerAdapter;
	}

}
