package woo.siksin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class MemberSelectDetailController implements Controller{


private static Log log = LogFactory.getLog(MemberSelectDetailController.class);
	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		

		int memberNum = Integer.parseInt(request.getParameter("memberNum"));
		log.info("1 샐랙트디테일 컨드롤러: 맴버넘값 확인 "+memberNum);
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberNum(memberNum);
		log.info("2 샐랙트디테일 컨드롤러: 디티오값 확인 "+memberDTO);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDTO = memberDAO.siksinSelect(memberDTO);
		log.info("3 샐랙트디테일 컨드롤러: 디티오값 확인 "+memberDTO);
		
		request.setAttribute("memberDTO", memberDTO);
		
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		
		siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_select_detail_view.jsp");
		
		return siksinHandlerAdapter;
	}



}
