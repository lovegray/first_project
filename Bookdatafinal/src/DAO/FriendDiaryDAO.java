package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import VO.BookVO;
import VO.Book_diaryVO;
import VO.FriendDiaryVO;

public class FriendDiaryDAO extends DbConnection{
	//ģ���� ���� å ��� �����ֱ�
	public ArrayList<FriendDiaryVO> selectAllbook(String id){
		connect();
		
		String sql = "select * from book_diary where member_id = ? and progress = 100 order by diary_no desc";
		ArrayList<FriendDiaryVO> arrayList = new ArrayList<FriendDiaryVO>();
		//ArrayList<Book_diaryVO> arrayList2 = new ArrayList<Book_diaryVO>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			String arr[] = new String[2];
			while(rs.next()) {
				//��¥, å�̸�,�۰�, ����
				int diary_no = rs.getInt(1);
				long isbn = rs.getLong(2);
				arr = searchBook(isbn);
				String bookName = arr[0];

				System.out.println("Ȯ��"+arr[0]);
				String writer = arr[1];
				Date date = rs.getDate(5);
				int rate = rs.getInt(6);
				FriendDiaryVO vo = new FriendDiaryVO(diary_no, isbn, date, bookName, writer, rate);
				arrayList.add(vo);
				
				
				
			}
		} catch (SQLException e) {
			
			System.out.println("FriendDiaryDAO SQL��");
		} finally {
			disConnect();
		}
		
		return arrayList;
	}

	public String[] searchBook(long isbn) {
		connect();
		String[] arr = new String[2];
		System.out.println(isbn);
		String sql = "select book_name,writer from book where isbn = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				arr[0] = rs.getString(1);
				arr[1] = rs.getString(2);
				System.out.println(arr[0]);
				
				return arr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
