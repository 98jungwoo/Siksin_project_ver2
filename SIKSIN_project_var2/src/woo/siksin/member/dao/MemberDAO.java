package woo.siksin.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import woo.siksin.member.dto.MemberDTO;
import woo.siksin.member.service.MemberService;

public class MemberDAO implements MemberService {

	private static Log log = LogFactory.getLog(MemberDAO.class);

	@Override
	public ArrayList<MemberDTO> siksinSelectAll(int page, int limit) {
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "select * from (select memberNum, memberName, nickName, password, to_char(memberBirth, 'YYYY-MM-DD')memberBirth, gender, phoneNum, memberArea, agree ";
			sql += "from siksinMember order by memberNum desc)";

			log.info("디에이오 샐랙트 올 SQL 확인 - " + sql);

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMemberNum(resultSet.getInt("memberNum"));
				memberDTO.setMemberName(resultSet.getString("memberName"));
				memberDTO.setNickName(resultSet.getString("nickName"));
				memberDTO.setPassword(resultSet.getString("password"));
				memberDTO.setMemberBirth(resultSet.getString("memberBirth"));
				memberDTO.setGender(resultSet.getString("gender"));
				memberDTO.setPhoneNum(resultSet.getString("phoneNum"));
				memberDTO.setMemberArea(resultSet.getString("memberArea"));
				memberDTO.setAgree(resultSet.getString("agree"));

				arrayList.add(memberDTO);
				log.info("디에이오 샐랙트 올: 조회 데이터 확인" + memberDTO);
			}

			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 부서가 없습니다. 부서를 등록해 주세요.");
			}
		} catch (Exception e) {
			log.info("디에이오 샐랙트 올: 전체 부서 조회 실패" + e);

		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public MemberDTO siksinSelect(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "select memberNum, memberName, nickName, password, to_char(memberBirth, 'YYYY-MM-DD')memberBirth, gender, phoneNum, memberArea, agree from siksinMember ";
			sql += " where memberNum = ? ";
			log.info("1디에이오 샐랙트: SQL - " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, memberDTO.getMemberNum());
			resultSet = preparedStatement.executeQuery();
			log.info("2 디에이오 샐랙트 : 조회 데이터 확인" + memberDTO);

			if (resultSet.next()) {
				log.info("3 디에이오 샐랙트: 번호 확인" + resultSet.getInt("memberNum"));

				memberDTO.setMemberNum(resultSet.getInt("memberNum"));
				memberDTO.setMemberName(resultSet.getString("memberName"));
				memberDTO.setNickName(resultSet.getString("nickName"));
				memberDTO.setPassword(resultSet.getString("password"));
				memberDTO.setMemberBirth(resultSet.getString("memberBirth"));
				memberDTO.setGender(resultSet.getString("gender"));
				memberDTO.setPhoneNum(resultSet.getString("phoneNum"));
				memberDTO.setMemberArea(resultSet.getString("memberArea"));
				memberDTO.setAgree(resultSet.getString("agree"));

			}
		} catch (Exception e) {
			log.info("3디에이오 샐랙트: 개별조회 실패" + e);

		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return memberDTO;
	}

	@Override
	public MemberDTO siksinInsert(MemberDTO memberDTO) {
		log.info("1 인설트 DAO: 들어오기만함");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.info("2 인설트 DAO: 커낵션이랑, 프리패어드 선언만함 ");
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			System.out.println("3 인설트 DAO: 데이터소스 선언만 함");

			String sql = "insert into siksinMember (memberNum, memberName, nickname, password, memberBirth, gender, phoneNum,memberArea, agree) ";

			sql += " values(?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ? )"; // %03d

			log.info("4 인설트DAO - SQL 확인 : " + sql);
			preparedStatement = connection.prepareStatement(sql);
			log.info("5 인설트DAO - SQL 확인 : " + sql);

			preparedStatement.setInt(1,  memberDTO.getMemberNum());
			preparedStatement.setString(2, memberDTO.getMemberName());
			preparedStatement.setString(3, memberDTO.getNickName());
			preparedStatement.setString(4, memberDTO.getPassword());
			preparedStatement.setString(5, memberDTO.getMemberBirth());
			preparedStatement.setString(6, memberDTO.getGender());
			preparedStatement.setString(7, memberDTO.getPhoneNum());
			preparedStatement.setString(8, memberDTO.getMemberArea());
			preparedStatement.setString(9, memberDTO.getAgree());
			log.info("6 인설트DAO  get으로 저장: " + memberDTO);

			int count = preparedStatement.executeUpdate();
			log.info("7 인설트DAO executeUpdate 실행: " + count);
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}

		} catch (Exception e) {
			log.info("회원입력 실패" + e);

		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO siksinUpdate(MemberDTO memberDTO) {
		log.info("1 업데이트DAO: 들어옴");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.info("2 업데이트DAO: " + memberDTO);

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "update siksinMember set  nickName = ?, password = ?, phoneNum = ?, memberArea = ?, agree = ? ";

			sql += " where memberNum = ? ";

			log.info("3 업데이트 DAO - SQL 확인 : " + sql);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, memberDTO.getNickName());
			preparedStatement.setString(2, memberDTO.getPassword());
			preparedStatement.setString(3, memberDTO.getPhoneNum());
			preparedStatement.setString(4, memberDTO.getMemberArea());
			preparedStatement.setString(5, memberDTO.getAgree());
			preparedStatement.setInt(6, memberDTO.getMemberNum());
			log.info("4 업데이트 DAO : memberDTO값 확인" + memberDTO);

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}

		} catch (Exception e) {
			log.info("회원정보 수정 실패" + e);

		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return memberDTO;
	}

	@Override
	public MemberDTO siksinDelete(MemberDTO memberDTO) {
		log.info("1 딜리트 DAO : 들어옴");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from siksinMember ";
			sql += " where memberNum = ?";

			log.info("2 딜리트 DAO - SQL 확인 : " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, memberDTO.getMemberNum());
			int count = preparedStatement.executeUpdate();
			log.info("3 딜리트 DAO : 디티오에 저장하고 값 확인 " + memberDTO);
			if (count >0 ) {
				connection.commit();
				log.info("4 딜리트 DAO : 커밋되었습니다.");
			}else {
				connection.rollback();
				log.info("5 딜리트 DAO : 롤백되었습니다.");
			}
			
			
		} catch (Exception e) {
			log.info("6 딜리트 DAO : 회원 삭제 실패" + e);

		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public int siksinMemberNumber() {
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select max(memberNum) from siksinMember";
			log.info(" 넘버순차입력 DAO - SQL 확인 : " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			if (resultSet.next()) {
				i = resultSet.getInt("max(memberNum)");
			}
		} catch (Exception e) {
			log.info("최대 회원 번호 검색 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public int siksinMemberCount() {
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select count(*) from siksinMember where memberName != 'admin'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (Exception e) {
			log.info("현재 회원 수 검색 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}



	@Override
	public MemberDTO siksinMemberLogin(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select * from siksinmember ";
			sql += "where phoneNum = ?";
			log.info("로그인 DAO : SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getPhoneNum());
			resultSet = preparedStatement.executeQuery( );
			if (resultSet.next()) {
				memberDTO.setMemberName(resultSet.getString("memberName"));
				memberDTO.setPhoneNum(resultSet.getString("phoneNum"));
				log.info("로그인 DAO :  전화번호 확인" + resultSet.getString("phoneNum"));
				
				if (resultSet.getString("password").equals(memberDTO.getPassword())) {
					memberDTO.setPassword(resultSet.getString("password"));
					log.info("로그인 DAO : 비밀번호 확인 - " + resultSet.getString("password"));
				}else {
					memberDTO.setPassword("");
				}
				
			}else {
				memberDTO.setPhoneNum("");
			}
			
		}catch(Exception e){
			log.info("로그인 DAO : 로그인 실패 - " + e);
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}


	@Override
	public MemberDTO siksinMemberSearchPassword(String phoneNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MemberDTO memberDTO = new MemberDTO( );
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select * from siksinMember where phoneNum = ?";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phoneNum);
			resultSet = preparedStatement.executeQuery( );
			while(resultSet.next( )) {
				memberDTO.setMemberNum(resultSet.getInt("memberNum"));
				memberDTO.setPhoneNum(resultSet.getString("phoneNum"));
				memberDTO.setMemberName(resultSet.getString("memberName"));
				memberDTO.setPassword(resultSet.getString("password"));
				log.info("조회 데이터 확인" + memberDTO);
			}
		} catch(Exception e) {
			log.info("비밀번호 찾기 실패 - " + e);
		} finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );
			} catch(Exception e) {
				e.printStackTrace( );
			}
		}
		return memberDTO;
	}

}
