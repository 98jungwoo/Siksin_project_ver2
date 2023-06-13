package woo.siksin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class MemberUpdateController implements Controller{


private static Log log = LogFactory.getLog(MemberUpdateController.class);
	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1 업데이트 컨드롤러 : 들어옴");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMemberNum(Integer.parseInt(request.getParameter("memberNum")));
		log.info("2 업데이트 컨트롤러: memberDTO " +memberDTO);
		log.info("3 업데이트 컨트롤러: memberDTO " +memberDTO.getMemberNum());
		memberDTO = memberDAO.siksinSelect(memberDTO);
		log.info("4 업데이트 컨트롤러: memberDTO " +memberDTO);
		
		
		request.setAttribute("memberDTO", memberDTO);
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_update.jsp");
		
		return siksinHandlerAdapter;
	}


}
