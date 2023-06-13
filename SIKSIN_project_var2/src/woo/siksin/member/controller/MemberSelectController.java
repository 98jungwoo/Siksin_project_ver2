package woo.siksin.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.member.dao.MemberDAO;
import woo.siksin.member.dto.MemberDTO;

public class MemberSelectController implements Controller {

	private static Log log = LogFactory.getLog(MemberSelectController.class);

	@Override
	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		log.info(memberDTO);
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit") != null && !request.getParameter("limit").equals("")) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		arrayList = memberDAO.siksinSelectAll(page, limit);
		log.info("맴버샐랙트 컨트롤러에서 arrayList: "+arrayList);
		
		int listCount = memberDAO.siksinMemberCount();
		int maxpage = (int) ((double) listCount / limit + 0.9);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage) {
			endpage = maxpage;
		}
		
		request.setAttribute("arrayList", arrayList);
		request.setAttribute("limit", limit);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listCount", listCount);
		SiksinHandlerAdapter siksinHandlerAdapter = new SiksinHandlerAdapter();
		log.info("멤버셀랙트컨트롤러 : 전체조회정보 조회");
		siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_select_view.jsp");

		return siksinHandlerAdapter;
	}

}
