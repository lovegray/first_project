package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	public Connection conn;
	public PreparedStatement ps;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("����̹��ε��Ϸ�!!");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pw = "hr";

			conn = DriverManager.getConnection(url, id, pw);
			if (conn != null) {
				// System.out.println("���Ἲ���̿�~!");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�..");
		} catch (SQLException e) {
			System.out.println("SQL������ �߸��Ǿ����ϴ�..");
		}
	}

	public void disConnect() {

		if (ps != null) {
			try {
				ps.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
