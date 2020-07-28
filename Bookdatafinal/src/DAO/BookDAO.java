package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import VO.BookVO;
import VO.Book_diaryVO;
import VO.MembersVO;

public class BookDAO extends DbConnection {

	// å ���� �������� å������ �̾��ִ� dao
	public BookVO book_info(long isbn) {

		System.out.println(isbn + "isbn�� �� ���Գ��� ?");
		connect();
		String sql = "select * from BOOK where isbn = ?";
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);

			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				String name = rs.getString(2);
				String writer = rs.getString(3);
				String publisher = rs.getString(4);
				int total_page = rs.getInt(5);
				String keyword = rs.getString(6);
				isworking = false;

				return new BookVO(isbn, name, writer, publisher, total_page, keyword);
			}

			if (isworking == true) {
				System.out.println("�������� �ʽ��ϴ�.");
			}

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.");
		} finally {
			disConnect();

		}
		return null;

	}

	// å ���� �������� å������ �̾��ִ� dao : isbn����
	public ArrayList<BookVO> book_info_isbn(long isbn) {
		ArrayList<BookVO> book_info_result = new ArrayList<BookVO>();

		connect();
		String sql = "select * from BOOK where isbn = ?";
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);

			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				isbn = rs.getLong(1);
				String book_name = rs.getString(2);
				String writer = rs.getString(3);
				String publisher = rs.getString(4);
				int total_page = rs.getInt(5);
				String keyword = rs.getString(6);
				isworking = false;

				book_info_result.add(new BookVO(isbn, book_name, writer, publisher, total_page, keyword));////////////

			}
			return book_info_result;

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.");
		} finally {
			disConnect();

		}
		return null;

	}

	// å ���� �������� å������ �̾��ִ� dao : å��������
	public ArrayList<BookVO> book_info_name(String book_name) {
		ArrayList<BookVO> book_info_result = new ArrayList<BookVO>();

		connect();
		String sql = "select * from BOOK where BOOK_NAME like ?";
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + book_name + "%");

			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				Long isbn = rs.getLong(1);
				book_name = rs.getString(2);
				String writer = rs.getString(3);
				String publisher = rs.getString(4);
				int total_page = rs.getInt(5);
				String keyword = rs.getString(6);
				isworking = false;

				// return new BookVO(isbn, book_name, writer, publisher, total_page, keyword);
				book_info_result.add(new BookVO(isbn, book_name, writer, publisher, total_page, keyword));////////////

			}
			return book_info_result;

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.");
		} finally {
			disConnect();

		}
		return null;

	}

	// å ���� �������� å������ �̾��ִ� dao : �۰�������
	public ArrayList<BookVO> book_info_WRITER(String writer) {
		ArrayList<BookVO> book_info_result = new ArrayList<BookVO>();

		connect();
		String sql = "select * from BOOK where WRITER like ?";
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + writer + "%");

			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				long isbn = rs.getLong(1);
				String book_name = rs.getString(2);
				writer = rs.getString(3);
				String publisher = rs.getString(4);
				int total_page = rs.getInt(5);
				String keyword = rs.getString(6);
				isworking = false;

				book_info_result.add(new BookVO(isbn, book_name, writer, publisher, total_page, keyword));////////////

			}
			return book_info_result;

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.");
		} finally {
			disConnect();

		}
		return null;

	}

	// å ���� �������� å������ �̾��ִ� dao : ��ü��(���� ����)
	public ArrayList<BookVO> book_info_all(String all) {
		ArrayList<BookVO> book_info_result = new ArrayList<BookVO>();

		connect();
		String sql = "select * from BOOK where BOOK_NAME like ? or WRITER like ?";
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + all + "%");
			ps.setString(2, "%" + all + "%");

			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				long isbn = rs.getLong(1);
				String book_name = rs.getString(2);
				String writer = rs.getString(3);
				String publisher = rs.getString(4);
				int total_page = rs.getInt(5);
				String keyword = rs.getString(6);
				isworking = false;

				book_info_result.add(new BookVO(isbn, book_name, writer, publisher, total_page, keyword));////////////

			}
			return book_info_result;

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.");
		} finally {
			disConnect();

		}
		return null;

	}

	public MembersVO recommendMember(String id) {
		connect();
		String sql = "select * from MEMBERS where MEMBER_ID = ?";
		System.out.println("���̵�" + id);
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				String MEMBER_ID = rs.getString(1);
				String MEMBER_PW = rs.getString(2);
				String PHONE_NUMBER = rs.getString(3);
				String EMAIL = rs.getString(4);
				String NAME = rs.getString(5);
				int GRAPE = rs.getInt(6);
				String KEYWORD_1 = rs.getString(7);
				String KEYWORD_2 = rs.getString(8);
				String KEYWORD_3 = rs.getString(9);
				isworking = false;
				return new MembersVO(MEMBER_ID, MEMBER_PW, PHONE_NUMBER, EMAIL, NAME, GRAPE, GRAPE, KEYWORD_1,
						KEYWORD_2, KEYWORD_3);
			}
			if (isworking == true) {

			}

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.(���Ű���� ��)");
		} finally {
			disConnect();

		}
		return null;

	}

	public ArrayList<BookVO> recommendKeywordBOOK(String inputKeyword) {
		System.out.println("���ڸ��Ű���� �� : " + inputKeyword);
		ArrayList<BookVO> recommendSelect = new ArrayList<BookVO>();

		connect();
		String sql = "select * from BOOK where KEYWORD LIKE ?";
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + inputKeyword + "%");
			ResultSet rs = ps.executeQuery();
			boolean isworking = true;
			while (rs.next()) {

				long isbn = rs.getLong(1);
				System.out.println(1);
				String book_name = rs.getString(2);
				System.out.println(2);
				String writer = rs.getString(3);
				System.out.println(3);
				String publisher = rs.getString(4);
				System.out.println(4);
				int total_page = rs.getInt(5);
				System.out.println(5);
				String keyword = rs.getString(6);
				System.out.println(6);

				isworking = false;

				recommendSelect.add(new BookVO(isbn, book_name, writer, publisher, total_page, keyword));

			}
			return recommendSelect;

		} catch (SQLException e) {
			System.out.println("SQL���� �߸��Ǿ����ϴ�.(���ڸ��Ű����)");
		} finally {
			disConnect();

		}
		return null;

	}

	public ArrayList<Book_diaryVO> getReview(long isbn) {
		connect();
		String sql = "select * from book_diary where isbn = ? and review is not null";
		System.out.println(isbn + "isbn�� �� ���Գ��� ?");

		ArrayList<Book_diaryVO> arr = new ArrayList<Book_diaryVO>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int diary_no = rs.getInt(1);
				isbn = rs.getLong(2);
				Date start_date = rs.getDate(3);
				Date recent_date = rs.getDate(4);
				Date finish_date = rs.getDate(5);
				int rate = rs.getInt(6);
				String review = rs.getString(7);
				int progress = rs.getInt(8);
				int diary_like = rs.getInt(9);
				String member_id = rs.getString(10);
				arr.add(new Book_diaryVO(diary_no, isbn, start_date, recent_date, finish_date, rate, review, progress,
						diary_like, member_id));

			}
			return arr;

		} catch (SQLException e) {
			System.out.println("getRview������ SQL���� �߸��Ǿ����ϴ�.");
		}
		return null;
	}

}
