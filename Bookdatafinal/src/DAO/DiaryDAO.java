package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import VO.BookVO;
import VO.Book_diaryVO;
import VO.Daily_book_diaryVO;
import VO.FriendDiaryVO;

public class DiaryDAO extends DbConnection {

	// ���ο� å�� ���� ���̾ �߰�
	// å�̸�, �б� ������ ��, (isbn�� �˻��ؼ� insert),(memberid);
	public void newDiary(long isbn, String member_id, String finish_date) {
		connect();
		String sql = "insert into book_diary (diary_no,isbn,start_date,RECENT_DATE,finish_date,member_id) values(book_diary_seq.nextval,?,sysdate,sysdate,?,?)";

		try {
			System.out.println(isbn + "  " + finish_date + "  " + member_id);

			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);
			ps.setString(2, finish_date);
			ps.setString(3, member_id);

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL.. insert��");

		} finally {
			disConnect();
		}
	}

	// diary_no�� �ش��ϴ� ���̾vo�������±�
	public Book_diaryVO selectDiary(int diary_no) {
		connect();

		String sql = "select * from book_diary where diary_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long isbn = rs.getLong(2);

				System.out.println("isbn"+isbn);
				Date start_date = rs.getDate(3);
				Date recent_date = rs.getDate(4);
				Date finish_date = rs.getDate(5);
				int rate = rs.getInt(6);
				String review = rs.getString(7);
				int progress = rs.getInt(8);
				int diary_like = rs.getInt(9);
				String member_id = rs.getString(10);

				return new Book_diaryVO(diary_no, isbn, start_date, recent_date, finish_date, rate, review, progress,
						diary_like, member_id);
			}

		} catch (SQLException e) {
			System.out.println("SQL�� �Ѥ�");
		} finally {
			disConnect();
		}
		return null;
	}

	// ���̾(������)���� ���� �Է� ������Ʈ �ϱ�(���̾ ���̺�, ������Ʈ ���̺�)
	public void updateDiary(int diary_no, int progress) {
		// ������Ʈ �� ������ �ֱ����� ��¥, �����
		// rate�� �������������� ������������ �޾Ƽ� ����ؼ� �����ּ���
		connect();
		//System.out.println(progress);
		String sql = "update BOOK_DIARY set recent_date = sysdate, progress = ? where diary_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, progress);
			ps.setInt(2, diary_no);

			ps.executeUpdate();
			System.out.println("������Ʈ �ƾ��");
		} catch (SQLException e) {
			System.out.println("SQL������");
		} finally {
			disConnect();
		}

	}

	public void updateDailyDiary(int diary_no, String contents) {
		// ������Ʈ �� ������ �ֱ����� ��¥, �����
		// updateDiary�ȿ��� �����Ұű� ������ connect�� ���� �ʴ¤���.
		connect();
		String sql = "insert into daily_book_diary values (daily_book_diary_seq.nextval, ?, sysdate,?)";

		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);
			ps.setString(2, contents);
			ps.executeUpdate(); // ������Ʈ �����ϱ�

		} catch (SQLException e) {
			System.out.println("SQL�� �̻�");
		} finally {
			disConnect();
		}

	}

	// å �˻� ���� �� isbn �������� �޼���
	public ArrayList<BookVO> findBook(String bookName) {
		connect();
		String sql = "select * from book where book_name LIKE ?";

		ArrayList<BookVO> arr = new ArrayList<BookVO>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + bookName + "%");

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {

				long isbn = rs.getLong(1);
				String book_name = rs.getString(2);
				String writer = rs.getString(3);
				String publisher = rs.getString(4);
				int total_page = rs.getInt(5);
				String keyword = rs.getString(6);

				arr.add(new BookVO(isbn, book_name, writer, publisher, total_page, keyword));
			}
			return arr;

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.");
		} finally {
			disConnect();
		}

		return arr;
	}

	// ���̾�� �ش��ϴ� ���ϸ� ���̾ ����Ʈ ����Ʈ �� �̾��ֱ�
	public ArrayList<Daily_book_diaryVO> selectAlldaily(int diary_no) {
		connect();
		ArrayList<Daily_book_diaryVO> arr = new ArrayList<Daily_book_diaryVO>();
		String sql = "select * from daily_book_diary where diary_no = ? order by daily_diary_no desc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int daily_diary_no = rs.getInt(1);
				Date reporting_date = rs.getDate(3);
				String content = rs.getString(4);
				arr.add(new Daily_book_diaryVO(daily_diary_no, daily_diary_no, reporting_date, content));
			}
			return arr;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disConnect();
		}
		return null;

	}

	// �������� å ��� �����ֱ�
	public ArrayList<Book_diaryVO> selectAllbookNow(String id) {
		connect();
		String sql = "select * from book_diary where member_id = ? and progress < 100 order by diary_no desc";
		ArrayList<Book_diaryVO> arrayList = new ArrayList<Book_diaryVO>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int diary_no = rs.getInt(1);
				long isbn = rs.getLong(2);
				Date start_date = rs.getDate(3);
				Date recent_date = rs.getDate(4);
				Date finish_date = rs.getDate(5);
				int rate = rs.getInt(6);
				String review = rs.getString(7);
				int progress = rs.getInt(8);
				int diary_like = rs.getInt(9);
				String member_id = rs.getString(10);

				arrayList.add(new Book_diaryVO(diary_no, isbn, start_date, recent_date, finish_date, rate, review,
						progress, diary_like, member_id));
			}
			return arrayList;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}

		return arrayList;
	}

	public String[] searchBook(long isbn) {
		connect();
		String[] arr = new String[2];
		//System.out.println(isbn);
		String sql = "select book_name,writer from book where isbn = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				arr[0] = rs.getString(1);
				arr[1] = rs.getString(2);
				// System.out.println(arr[0]);

				return arr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// diary_no���� å �̸� ã��
	public String searchBookname(int diary_no) {
		connect();

		String sql = "Select b.book_name from book b, BOOK_DIARY d where d.isbn = b.isbn AND d.diary_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String book_name = rs.getString(1);
				return book_name;
			}
		} catch (SQLException e) {
			System.out.println("SQL�� �̻��ؿ�..");
		} finally {
			disConnect();
		}
		return null;
	}

	// ����, �Ѽ���, ������ ��¥ insert
	public void lastUpdateDiary(String review, int rate, int diary_no) {

		String sql = "update book_diary set review = ?,rate = ?, finish_date = sysdate where diary_no = ? ";
		connect();
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, review);
			ps.setInt(2, rate);
			ps.setInt(3, diary_no);

			int cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL..");
		} finally {
			disConnect();
		}
	}
	
	
	
	//��������  å ��� �����ֱ�
	   public ArrayList<FriendDiaryVO> selectAllbook(String id){
	      connect();
	      //System.out.println("������ dao" + id);
	      String sql = "select * from book_diary where member_id = ? and progress < 100 ";
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
	            System.out.println("�̰� "+isbn);
	            String bookName = arr[0];

	            //System.out.println("Ȯ��"+arr[0]);
	            String writer = arr[1];
	            Date date = rs.getDate(5);
	            int rate = rs.getInt(6);
	            FriendDiaryVO vo = new FriendDiaryVO(diary_no, isbn, date, bookName, writer, rate);
	            arrayList.add(vo);
	            
	            
	            
	         }
	      } catch (SQLException e) {
	         
	         e.printStackTrace();
	      } finally {
	         disConnect();
	      }
	      
	      return arrayList;
	   }

}
