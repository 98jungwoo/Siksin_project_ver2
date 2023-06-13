package woo.siksin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class MemberUpdateViewController implements Controller {


private static Log log = LogFactory.getLog(MemberUpdateViewController.class);
	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1 업데이트  View 컨드롤러 : 들어옴");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMemberNum(Integer.parseInt(request.getParameter("memberNum")));
		System.out.println("2 업데이트 View 컨드롤러 : 번호 저장");
		
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setNickName(request.getParameter("nickName"));
		memberDTO.setPassword(request.getParameter("password"));
		memberDTO.setMemberBirth(request.getParameter("memberBirth"));
		memberDTO.setGender(request.getParameter("gender"));
		memberDTO.setPhoneNum(request.getParameter("phoneNum"));
		memberDTO.setMemberArea(request.getParameter("memberArea"));
		
		String[] agreeAarray = request.getParameterValues("agree");
		String agree = "";
		for (int i = 0; i < agreeAarray.length; i++) {
			agree += agreeAarray[i] + " | ";
		}
		log.info("3 업데이트 View 컨드롤러 : " + agree);
		memberDTO.setAgree(agree);
		//배열을 어떻게 보내주지 ,,,,??
		
		
		log.info("5업데이트 View 컨트롤러: memberDTO " +memberDTO);
		
		memberDTO = memberDAO.siksinUpdate(memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_update_view.jsp");
		
		return siksinHandlerAdapter;
	}

}
