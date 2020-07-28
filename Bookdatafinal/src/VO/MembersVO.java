package VO;

public class MembersVO {
	private static String member_id;
	private String member_pw;
	private String phone_number;
	private String email;
	private String name;
	private int grape;
	private String keyword_1;
	private String keyword_2;
	private String keyword_3;

	public MembersVO(String member_id, String member_pw, String phone_number, String email, String name, int keyword_no,
			int grape, String keyword_1, String keyword_2, String keyword_3) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.phone_number = phone_number;
		this.email = email;
		this.name = name;
		this.grape = grape;

		this.keyword_1 = keyword_1;
		this.keyword_2 = keyword_2;
		this.keyword_3 = keyword_3;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrape() {
		return grape;
	}

	public void setGrape(int grape) {
		this.grape = grape;
	}

	public String getKeyword_1() {
		return keyword_1;
	}

	public void setKeyword_1(String keyword_1) {
		this.keyword_1 = keyword_1;
	}

	public String getKeyword_2() {
		return keyword_2;
	}

	public void setKeyword_2(String keyword_2) {
		this.keyword_2 = keyword_2;
	}

	public String getKeyword_3() {
		return keyword_3;
	}

	public void setKeyword_3(String keyword_3) {
		this.keyword_3 = keyword_3;
	}

}
