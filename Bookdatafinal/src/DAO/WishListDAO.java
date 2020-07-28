package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.WishListVO;


public class WishListDAO extends DbConnection {

	// isbn, id�޾ƿͼ� wishlist�� �߰��ϴ� insert��
	public void wishlist(long isbn, String member_id) {
		connect();
		String sql = "insert into WISHLIST values(wishlist_SEQ.nextval,?,?,sysdate)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, isbn);
			ps.setString(2, member_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// id�� ������ ���ø���Ʈ�� å�� �̾Ƴ�.
	public ArrayList<WishListVO> getwishlist(String member_id) {
		connect();
		String sql = "select * from WISHLIST where member_id = ?";

		try {
			ps = conn.prepareStatement(sql); // ����� ps�� ���
			ps.setString(1, member_id); // 1��°�� name�� ����

			ArrayList<WishListVO> arr = new ArrayList<WishListVO>();
			ResultSet rs = ps.executeQuery(); // ����� �����޾ƾ� �ϴϱ� executeQuery

			// while(rs.next()) { //���� while�� �ȵ����� �� ������ ���� �ϳ�
			while (rs.next()) {
				int wishlist_no = rs.getInt(1);
				long isbn = rs.getLong(2);
				member_id = rs.getString(3);
				String add_date = rs.getString(4);

				arr.add(new WishListVO(wishlist_no, isbn, member_id, add_date));
				// return new contactVO(name, age, phoneNum);
			}return arr;
		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;

	}
	public int deleteWishlist(int wishlist_no) {
	      connect();
	      String sql="delete wishlist where wishlist_no=?";
	      int cnt=0;
	      try {
	         ps=conn.prepareStatement(sql);
	         ps.setInt(1, wishlist_no);
	         cnt=ps.executeUpdate();
	         if(cnt>0) {
	            return cnt;
	            
	         }
	      } catch (SQLException e) {
	         System.out.println("sql���� �� �� �Ǿ����ϴ�.");
	      }finally {
	         disConnect();
	      }
	      return 0;
	      
	      
	   }

}
