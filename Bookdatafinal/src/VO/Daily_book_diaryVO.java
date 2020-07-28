package VO;

import java.util.Date;

public class Daily_book_diaryVO {
	private int daily_diary_no;
	private int diary_no;
	private Date reporting_date;
	private String content;
	
	public Daily_book_diaryVO(int daily_diary_no, int diary_no, Date reporting_date, String content) {
		this.daily_diary_no = daily_diary_no;
		this.diary_no = diary_no;
		this.reporting_date = reporting_date;
		this.content = content;
	}

	public int getDaily_diary_no() {
		return daily_diary_no;
	}

	public void setDaily_diary_no(int daily_diary_no) {
		this.daily_diary_no = daily_diary_no;
	}

	public int getDiary_no() {
		return diary_no;
	}

	public void setDiary_no(int diary_no) {
		this.diary_no = diary_no;
	}

	public Date getReporting_date() {
		return reporting_date;
	}

	public void setReporting_date(Date reporting_date) {
		this.reporting_date = reporting_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
