package woo.siksin.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/DBCP")
public class DBCP extends HttpServlet {
	private static Log log = LogFactory.getLog(DBCP.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("DBCP 들어옴: ");
		Connection connection = null;
		try {
			Context context = new InitialContext();
			// 연결할 정보의 이름을 검색하고 할당한다.
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			// 커넥션 객체를 생성한다.
			connection = dataSource.getConnection();
			log.info(connection);
			log.info("DBCP: 데이터베이스와 연결되었습니다.");
		} catch (Exception e) {
			log.info("DBCP: 데이터베이스 연결 실패-" + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
