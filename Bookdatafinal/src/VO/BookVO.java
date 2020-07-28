package VO;

public class BookVO {
	   private long isbn;
	   private String book_name;
	   private String writer;
	   private String publisher;
	   private int total_page;
	   private String keyword;
	   
	   public BookVO(long isbn, String book_name, String writer, String publisher, int total_page, String keyword) {
	      super();
	      this.isbn = isbn;
	      this.book_name = book_name;
	      this.writer = writer;
	      this.publisher = publisher;
	      this.total_page = total_page;
	      this.keyword = keyword;
	   }
	   public long getIsbn() {
	      return isbn;
	   }
	   public void setIsbn(int isbn) {
	      this.isbn = isbn;
	   }
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
	   public String getPublisher() {
	      return publisher;
	   }
	   public void setPublisher(String publisher) {
	      this.publisher = publisher;
	   }
	   public int getTotal_page() {
	      return total_page;
	   }
	   public void setTotal_page(int total_page) {
	      this.total_page = total_page;
	   }
	   public String getKeyword() {
	      return keyword;
	   }
	   public void setKeyword(String keyword) {
	      this.keyword = keyword;
	   }

	}
