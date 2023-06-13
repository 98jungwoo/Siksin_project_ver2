package woo.siksin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class MemberDeleteController implements Controller {


private static Log log = LogFactory.getLog(MemberDeleteController.class);
	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int memberNum = Integer.parseInt(request.getParameter("memberNum"));
		log.info("1딜리트 서블릿 :  memberNum 확인  " + memberNum);
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberNum(memberNum);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDTO = memberDAO.siksinDelete(memberDTO);
		log.info("3딜리트 서블릿 : memberDTO확인 - " + memberDTO);
		
		request.setAttribute("memberDTO", memberDTO);
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_delete_view.jsp");
		
		
		
		return siksinHandlerAdapter;
	}


}
