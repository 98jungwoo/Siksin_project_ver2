package woo.siksin.member.dto;

public class MemberDTO {
	private int memberNum;
	private String memberName;
	private String nickName;
	private String password;
	private String memberBirth;
	private String gender;
	private String phoneNum;
	private String memberArea;
	private String agree;
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMemberArea() {
		return memberArea;
	}
	public void setMemberArea(String memberArea) {
		this.memberArea = memberArea;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberNum=" + memberNum + ", memberName=" + memberName + ", nickName=" + nickName
				+ ", password=" + password + ", memberBirth=" + memberBirth + ", gender=" + gender + ", phoneNum="
				+ phoneNum + ", memberArea=" + memberArea + ", agree=" + agree + "]";
	}
}
