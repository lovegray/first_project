package VO;

import java.util.Date;

public class Book_diaryVO {
	private int diary_no;
	private long isbn;
	private Date start_date;
	private Date recent_date;
	private Date finish_date;
	private int rate;
	private String review;
	private int progress;
	private int diary_like;
	private String member_id;

	public Book_diaryVO(int diary_no, long isbn, Date start_date, Date recent_date, Date finish_date, int rate,
			String review, int progress, int diary_like, String member_id) {
		super();
		this.diary_no = diary_no;
		this.isbn = isbn;
		this.start_date = start_date;
		this.recent_date = recent_date;
		this.finish_date = finish_date;
		this.rate = rate;
		this.review = review;
		this.progress = progress;
		this.diary_like = diary_like;
		this.member_id = member_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getDiary_no() {
		return diary_no;
	}

	public void setDiary_no(int diary_no) {
		this.diary_no = diary_no;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getRecent_date() {
		return recent_date;
	}

	public void setRecent_date(Date recent_date) {
		this.recent_date = recent_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getDiary_like() {
		return diary_like;
	}

	public void setDiary_like(int diary_like) {
		this.diary_like = diary_like;
	}

}
