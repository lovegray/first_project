package VO;

import java.util.Date;

public class Guest_boardVO {
	private int guest_board_no;
	private String member_id;
	private String friend;
	private String contents;
	private Date date;
	
	public Guest_boardVO(int guest_board_no, String member_id, String friend, String contents, Date date) {
		
		this.guest_board_no = guest_board_no;
		this.member_id = member_id;
		this.friend = friend;
		this.contents = contents;
		this.date = date;
	}

	public int getGuest_board_no() {
		return guest_board_no;
	}

	public void setGuest_board_no(int guest_board_no) {
		this.guest_board_no = guest_board_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
