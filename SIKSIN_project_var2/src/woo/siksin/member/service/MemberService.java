package woo.siksin.member.service;

import java.util.ArrayList;

import woo.siksin.member.dto.MemberDTO;

public interface MemberService {

	public ArrayList<MemberDTO> siksinSelectAll(int page, int limit);
	public MemberDTO siksinSelect(MemberDTO memberDTO);
	public MemberDTO siksinInsert(MemberDTO memberDTO);
	public MemberDTO siksinUpdate(MemberDTO memberDTO);
	public MemberDTO siksinDelete(MemberDTO memberDTO);
	public int siksinMemberNumber();
	public int siksinMemberCount();
	
	//MemberDTO 클래스 반환 자료형으로 로그인 데이터를 조회한다.
	public MemberDTO siksinMemberLogin(MemberDTO memberDTO);

	//MemberDTO 클래스 반환 자료형으로 비밀번호 데이터를 검색한다.
	public MemberDTO siksinMemberSearchPassword(String phoneNum);
}
