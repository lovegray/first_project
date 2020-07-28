package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import VO.Guest_boardVO;

public class VisitDAO extends DbConnection{
	
	//방명록 리스트
	public ArrayList<Guest_boardVO> selectVisit(String id) {
		connect();
		//페이지 주인 test
		String sql = "select * from guest_board where guest_id = ? order by guest_board_no desc";
		ArrayList<Guest_boardVO> arrayList = new ArrayList<Guest_boardVO> ();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//작성자, 내용, 날짜
				int guest_board_no = rs.getInt(1);
				String member_id = rs.getString(2);
				String friend_id = rs.getString(3);
				String contents = rs.getString(4);
				Date b_date = rs.getDate(5);
				Guest_boardVO guestVO = new Guest_boardVO(guest_board_no, member_id, friend_id, contents, b_date);
				
				arrayList.add(guestVO);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return arrayList;
	}
	
	public ArrayList<Guest_boardVO> mySelectVisit(String id) {
		connect();
		//페이지 주인 test
		String sql = "select * from guest_board where member_id = ? order by guest_board_no desc";
		ArrayList<Guest_boardVO> arrayList = new ArrayList<Guest_boardVO> ();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//작성자, 내용, 날짜
				int guest_board_no = rs.getInt(1);
				String member_id = rs.getString(2);
				String friend_id = rs.getString(3);
				String contents = rs.getString(4);
				Date b_date = rs.getDate(5);
				Guest_boardVO guestVO = new Guest_boardVO(guest_board_no, member_id, friend_id, contents, b_date);
				
				arrayList.add(guestVO);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return arrayList;
	}
	
	public int insertVisit(String member_id, String friend, String contents) {
		connect();
		//페이지 주인 test
		String sql = "insert into guest_board values(guest_board_SEQ.nextval,?,?,?,sysdate)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member_id);
			ps.setString(2, friend);
			ps.setString(3, contents);
			
			int cnt = ps.executeUpdate();
			
			if(cnt>0) {
				return cnt;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	

}
