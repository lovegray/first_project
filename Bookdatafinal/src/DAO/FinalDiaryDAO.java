package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import VO.BestReviewVO;
import VO.Book_diaryVO;
import VO.Daily_book_diaryVO;
import VO.Diary_maxVO;
import VO.Guest_boardVO;

public class FinalDiaryDAO extends DbConnection {
	// diary_no에 해당하는 다이어리vo가져오는기
	public Book_diaryVO selectDiary(int diary_no) {
		connect();
		String sql = "select * from book_diary where diary_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 글번호 isbn,시작날짜,최근날짜,완독날짜,별점,총서평,진행률,좋아요

				long isbn = rs.getLong(2);
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
			System.out.println("SQL문 ㅡㅡ");
		} finally {
			disConnect();
		}
		return null;
	}

	// 좋아요!
	public int updateLike(int cnt, int diary_no) {
		connect();
		String sql = "update book_diary set diary_like = ?+1 where diary_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cnt);
			ps.setInt(2, diary_no);

			int result = ps.executeUpdate();
			//System.out.println("dao restult:" + result);
			if (result > 0) {
				// cnt = 1;
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}

	// 데일리 기록
	public ArrayList<Daily_book_diaryVO> selectDaily(int diary_no) {
		connect();
		ArrayList<Daily_book_diaryVO> arr = new ArrayList<Daily_book_diaryVO>();
		String sql = "select * from DAILY_BOOK_DIARY where diary_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int daily_diary_no = rs.getInt(1);
				diary_no = rs.getInt(2);
				Date reporting_date = rs.getDate(3);
				String content = rs.getString(4);

				Daily_book_diaryVO dailyvo = new Daily_book_diaryVO(daily_diary_no, diary_no, reporting_date, content);
				arr.add(dailyvo);
				//System.out.println("확인여이이이" + arr);
				return arr;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// 베스트 서평 가져오기
	public Diary_maxVO selectMax() {
		connect();
		String sql = "select max(diary_like) from book_diary";
		try {
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int diary_like = rs.getInt(1);
				Diary_maxVO maxVO = new Diary_maxVO(diary_like);
				return maxVO;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public BestReviewVO searchMax(int diary_like) {
		connect();
		String sql = "select diary_no, member_id, review from book_diary where diary_like = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, diary_like);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int diary_no = rs.getInt(1);
				String member_id = rs.getString(2);
				String review = rs.getString(3);

				BestReviewVO vo = new BestReviewVO(diary_no, member_id, review);
				return vo;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
