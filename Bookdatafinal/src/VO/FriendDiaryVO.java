package VO;

import java.util.Date;

public class FriendDiaryVO {
	// 날짜, 책이름,작가, 별점
	int diary_no;
	long isbn;
	Date date;
	String bookName;
	String writer;
	int rate;

	public FriendDiaryVO(int diary_no, long isbn, Date date, String bookName, String writer, int rate) {
		super();
		this.diary_no = diary_no;
		this.isbn = isbn;
		this.date = date;
		this.bookName = bookName;
		this.writer = writer;
		this.rate = rate;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
