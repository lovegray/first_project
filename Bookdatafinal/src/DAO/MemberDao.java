package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import VO.MembersVO;

public class MemberDao extends DbConnection {

	//회원가입 
	public int insert(String member_id, String member_pw, String phone_number, String email, String name, int grape,
			String keyword_1, String keyword_2, String keyword_3) {
		connect();
		String sql = "insert into members values(?,?,?,?,?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_id);
			ps.setString(2, member_pw);
			ps.setString(3, phone_number);
			ps.setString(4, email);
			ps.setString(5, name);
			ps.setInt(6, grape);
			ps.setString(7, keyword_1);
			ps.setString(8, keyword_2);
			ps.setString(9, keyword_3);
			cnt = ps.executeUpdate();
			if (cnt > 0) {
				return cnt;
			}

		} catch (SQLException e) {
			System.out.print("sql문이 잘 못 되었습니다.");
		} finally {
			disConnect();// try시도하다고 예외발생하면 catch블록으로 넘어가고,finally는
			// try실패여부에 상관없이 무조건 finally로 감.
		}

		return 0;

	}

	// 로그인 체 크
	public String selectMember(String InputID, String InputPW) {

		String id = "";
		String pw = "";
		connect();

		// SELECT 쿼리를 작성한다. 해당하는 아이디값의 패스워드를 검색한다.
		String sql = "SELECT MEMBER_ID,MEMBER_PW from MEMBERS where MEMBER_ID=? and MEMBER_PW=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, InputID);
			ps.setString(2, InputPW);

			// executeQuery() 메서드로 SELECT문의 실행시키고 결과로 ResultSet 객체를 받는다.
			ResultSet rs = ps.executeQuery();

			// 레코드가 있는지 검사
			if (rs.next()) {
				//
				id = rs.getString(1);
				pw = rs.getString(2);

				System.out.println("로그인성공! id:" + id + "pw:" + pw);

				if (id != null) {
					return id;

				}

			}

			if (InputPW != pw) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 맞지 않습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;

	}
}