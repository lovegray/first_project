package VO;

import java.util.Date;

public class Book_diary_finishVO {
	long isbn;
	Date start_date;
	Date finish_date;
	String review;
	String book_name;
	String writer;

	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Book_diary_finishVO(long isbn, Date start_date, Date finish_date, String review, String book_name,
			String writer) {
		super();
		this.isbn = isbn;
		this.start_date = start_date;
		this.finish_date = finish_date;
		this.review = review;
		this.book_name = book_name;
		this.writer = writer;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
