package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import VO.MembersVO;

public class MemberDao extends DbConnection {

	//ȸ������ 
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
			System.out.print("sql���� �� �� �Ǿ����ϴ�.");
		} finally {
			disConnect();// try�õ��ϴٰ� ���ܹ߻��ϸ� catch������� �Ѿ��,finally��
			// try���п��ο� ������� ������ finally�� ��.
		}

		return 0;

	}

	// �α��� ü ũ
	public String selectMember(String InputID, String InputPW) {

		String id = "";
		String pw = "";
		connect();

		// SELECT ������ �ۼ��Ѵ�. �ش��ϴ� ���̵��� �н����带 �˻��Ѵ�.
		String sql = "SELECT MEMBER_ID,MEMBER_PW from MEMBERS where MEMBER_ID=? and MEMBER_PW=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, InputID);
			ps.setString(2, InputPW);

			// executeQuery() �޼���� SELECT���� �����Ű�� ����� ResultSet ��ü�� �޴´�.
			ResultSet rs = ps.executeQuery();

			// ���ڵ尡 �ִ��� �˻�
			if (rs.next()) {
				//
				id = rs.getString(1);
				pw = rs.getString(2);

				System.out.println("�α��μ���! id:" + id + "pw:" + pw);

				if (id != null) {
					return id;

				}

			}

			if (InputPW != pw) {
				JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� ���� �ʽ��ϴ�.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;

	}
}