package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.FriendsVO;
import oracle.net.aso.f;

public class FriendsDAO extends DbConnection {

	public ArrayList<String[]> getSearch(String member_id) {
		connect();
		String sql = "select f.friend_id, m.name from members m , friends f where f.friend_id = m.member_id and f.member_id = ?";

		try {

			ps = conn.prepareStatement(sql);
			System.out.println(" 다음" + member_id);
			ps.setString(1, member_id);

			ResultSet rs = ps.executeQuery();
			System.out.println("rs 다음");
			boolean isRunning = false;

			ArrayList<String[]> arraylist = new ArrayList<String[]>();

			while (rs.next()) {
				String[] arr = new String[2];
				arr[0] = rs.getString(1); // 친구 아이디
				System.out.println(arr[0]);
				arr[1] = rs.getString(2); // 친구 이름
				System.out.println(arr[1]);
				isRunning = true;

				arraylist.add(arr);
			}
			return arraylist;
		} catch (SQLException e) {
			System.out.println("sql문이 잘못 되었습니다.1");
		} finally {
			disConnect();
		}
		return null;
	}

	public ArrayList<String[]> getFreind(String member_id) {
		connect();
		String sql = "select member_id,name from members where member_id like ?";

		try {

			ps = conn.prepareStatement(sql);
			System.out.println(" f다음" + member_id);
			ps.setString(1, "%" + member_id + "%");

			ResultSet rs = ps.executeQuery();
			System.out.println("rsf 다음");
			boolean isRunning = false;

			ArrayList<String[]> arraylist2 = new ArrayList<String[]>();

			while (rs.next()) {
				String[] arr1 = new String[2];
				arr1[0] = rs.getString(1); // 멤버아이디
				System.out.println(arr1[0]);
				arr1[1] = rs.getString(2); // 멤버이름이름
				System.out.println(arr1[1]);
				isRunning = true;

				arraylist2.add(arr1);
				System.out.println("asdf");
			}

			return arraylist2;
		} catch (SQLException e) {
			System.out.println("sql문이 잘못 되었습니다.1");
		} finally {
			disConnect();
		}
		return null;
	}

	public int insertFriend(String member_id, String friend_id) {
		connect();
		String sql = "insert into friends values(friends_seq.nextval,?,?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_id);
			ps.setString(2, friend_id);
			ps.executeUpdate();
			System.out.println("출력! executeupdate");
			if (cnt > 0) {
				return cnt;
			}
			System.out.println("cnt확인" + cnt);
			System.out.println("확인 insertfriends set");
		} catch (SQLException e) {
			System.out.println("sql문이 잘 못 되었습니다.friend_insert");
		} finally {
			disConnect();
		}

		return 0;

	}
}
