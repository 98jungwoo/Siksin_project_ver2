package woo.siksin.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.control.Controller;
import woo.siksin.hander.SiksinHandlerAdapter;
import woo.siksin.login.controller.LoginController;
import woo.siksin.login.controller.LogoutController;
import woo.siksin.login.controller.PasswordSearchController;
import woo.siksin.member.controller.MemberDeleteController;
import woo.siksin.member.controller.MemberInsertController;
import woo.siksin.member.controller.MemberSelectController;
import woo.siksin.member.controller.MemberSelectDetailController;
import woo.siksin.member.controller.MemberUpdateController;
import woo.siksin.member.controller.MemberUpdateViewController;



public class SiksinDispatcherServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(SiksinDispatcherServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contexPath = request.getContextPath();
		String pathURI = requestURI.substring(contexPath.length());
		log.info("디스패쳐서블릿 service : 매핑명 조회- " + pathURI);
		SiksinHandlerAdapter siksinHandlerAdapter= null;
		Controller controller = null;

		if (pathURI.equals("/SiksinSelect.do")) {
			controller = new MemberSelectController();
			siksinHandlerAdapter = controller.execute(request, response);
			log.info("댑트셀렉트로 이동 + 부서 조회 확인-" + siksinHandlerAdapter);
		
		} else if (pathURI.equals("/SiksinSelectDetail.do")) {
			controller = new MemberSelectDetailController();
			siksinHandlerAdapter = controller.execute(request, response);
			log.info("디스패처 : 셀렉트디테일 로 이동 + 상세 조회 확인-" + siksinHandlerAdapter);

		} else if (pathURI.equals("/SiksinInsertView.do")) {
			System.out.println("디스패처 : 핸들러어댑터로 이동한다.");
			siksinHandlerAdapter = new SiksinHandlerAdapter();
			siksinHandlerAdapter.setPath("/WEB-INF/view/member/member_insert.jsp");
			log.info("디스패처 : 회원 등록 화면 뷰확인-" + siksinHandlerAdapter);

		} else if (pathURI.equals("/SiksinInsert.do")) {
			controller = new MemberInsertController();
			siksinHandlerAdapter = controller.execute(request, response);
			log.info("디스패처 : 회원등록 확인" + siksinHandlerAdapter);

		} else if (pathURI.equals("/SiksinUpdate.do")) {
			controller = new MemberUpdateController();
			siksinHandlerAdapter = controller.execute(request, response);
			log.info("디스패처 : 회원수정수정 화면 확인" + siksinHandlerAdapter);

		} else if (pathURI.equals("/SiksinUpdateView.do")) {
			controller = new MemberUpdateViewController();
			siksinHandlerAdapter = controller.execute(request, response);
			log.info("디스패처 : 회원수정 뷰 확인" + siksinHandlerAdapter);
			
		} else if (pathURI.equals("/SiksinDelete.do")) {
			controller = new MemberDeleteController();
			siksinHandlerAdapter = controller.execute(request, response);
			log.info("디스패처 : 회원 삭제 화면 확인" + siksinHandlerAdapter);
		
	} else if(pathURI.equals("/LoginView.do")) {
		siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/login/login.jsp");
		log.info("로그인 화면 뷰 확인 - " + siksinHandlerAdapter);
	} else if(pathURI.equals("/Login.do")) {
		controller = new LoginController();
		siksinHandlerAdapter = controller.execute(request, response);
		log.info("로그인 확인 - " + siksinHandlerAdapter);
	} else if(pathURI.equals("/Logout.do")) {
		controller = new LogoutController( );
		siksinHandlerAdapter = controller.execute(request, response);
		log.info("로그아웃 확인 - " + siksinHandlerAdapter);
	} else if(pathURI.equals("/PasswordSearchView.do")) {
		siksinHandlerAdapter = new SiksinHandlerAdapter();
		siksinHandlerAdapter.setPath("/WEB-INF/view/login/password_search.jsp");
		log.info("비밀번호 찾기 화면 뷰 확인 - " + siksinHandlerAdapter);
	} else if(pathURI.equals("/PasswordSearch.do")) {
		controller = new PasswordSearchController( );
		siksinHandlerAdapter = controller.execute(request, response);
		log.info("비밀번호 찾기 확인 - " + siksinHandlerAdapter);
	}
		

		
		
		
		
		if (siksinHandlerAdapter != null) {
			log.info("디스패처 끝?");
			if (siksinHandlerAdapter.isRedirect()) {
				response.sendRedirect(siksinHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(siksinHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}}
