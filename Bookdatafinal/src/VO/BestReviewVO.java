package VO;

public class BestReviewVO {
	int diary_no;
	private static String member_id;
	String review;
	
	public BestReviewVO(int diary_no, String member_id,String review) {
		super();
		this.diary_no = diary_no;
		this.review = review;
		this.member_id = member_id;
	}
	public int getDiary_no() {
		return diary_no;
	}
	public void setDiary_no(int diary_no) {
		this.diary_no = diary_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public static void setMember_id(String member_id) {
		BestReviewVO.member_id = member_id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
}
