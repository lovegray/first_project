package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import VO.BookVO;
import VO.Book_diary_finishVO;
import VO.FriendDiaryVO;

public class FinalBook_diaryno_DAO extends DbConnection{
	
	//diary_no 을 다이어리 채우기
	public ArrayList<Book_diary_finishVO> searchDiary(int diary_no) {
		connect();
		ArrayList<Book_diary_finishVO> arrayList = new ArrayList<Book_diary_finishVO>();
		String sql = "select * from book_diary where diary_no = ?";
		try {
			String[] arr = new String[2];
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				long isbn = rs.getLong(2);
				arr = searchIsbn(isbn);
				Date start_date = rs.getDate(3);
				Date finish_date = rs.getDate(5);
				String review = rs.getString(7);
				String book_name = arr[0];
				//System.out.println("arr[0] : "+arr[0]);
				String writer = arr[1];
				//System.out.println("arr[1] : "+arr[1]);
				Book_diary_finishVO diaryVO = new Book_diary_finishVO(isbn,start_date, finish_date, review,book_name,writer);
				arrayList.add(diaryVO);
				return arrayList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	private String[] searchIsbn(long isbn) {
		connect();

		System.out.println("searchIsbn"+isbn);
		String sql = "select *  from book where isbn = ?";
		
		try {
			String[] arr = new String[2];
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				arr[0] = rs.getString(2);
				arr[1] = rs.getString(3);
				return arr;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	

}
