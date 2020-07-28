package VO;

public class WishListVO {

	private int wishlist_no;
	private long isbn;
	private String member_id;
	private String add_date;

	public WishListVO(int wishlist_no, long isbn, String member_id, String add_date) {
		super();
		this.wishlist_no = wishlist_no;
		this.isbn = isbn;
		this.member_id = member_id;
		this.add_date = add_date;
	}

	public int getWishlist_no() {
		return wishlist_no;
	}

	public void setWishlist_no(int wishlist_no) {
		this.wishlist_no = wishlist_no;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

}
