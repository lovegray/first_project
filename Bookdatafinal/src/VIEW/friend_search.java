package VIEW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;

import DAO.FriendDiaryDAO;
import DAO.FriendsDAO;
import VO.FriendDiaryVO;

import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class friend_search extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_friends;
	FriendsDAO friends = new FriendsDAO();
	FriendDiaryDAO f_d_dao = new FriendDiaryDAO();
	
	String id;

	static DefaultListModel<String> model = new DefaultListModel<String>();
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		try {
			friend_search dialog = new friend_search(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public friend_search(String id) {
		getContentPane().setBackground(Color.WHITE);
		this.id = id;
		setTitle("\uCE5C\uAD6C\uCC3E\uAE30");
		setBounds(100, 100, 639, 393);
		getContentPane().setLayout(new BorderLayout());
		SpringLayout sl_total = new SpringLayout();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setPreferredSize(new Dimension(630, 380));
		contentPanel.setLayout(sl_total);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);

		JPanel panel = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPanel);
		sl_total.putConstraint(SpringLayout.WEST, panel, 187, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.SOUTH, panel, 47, SpringLayout.NORTH, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel, -189, SpringLayout.EAST, contentPanel);
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel);

		JPanel panel_1 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_1, 21, SpringLayout.SOUTH, panel);
		sl_total.putConstraint(SpringLayout.WEST, panel_1, 178, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_1, -209, SpringLayout.EAST, contentPanel);
		contentPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_2, 46, SpringLayout.SOUTH, panel_1);
		sl_total.putConstraint(SpringLayout.WEST, panel_2, 30, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_2, -74, SpringLayout.NORTH, panel_1);
		sl_total.putConstraint(SpringLayout.EAST, panel_2, -346, SpringLayout.EAST, contentPanel);
		contentPanel.add(panel_2);

		JPanel panel_4 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_4, 21, SpringLayout.SOUTH, panel);
		sl_total.putConstraint(SpringLayout.WEST, panel_4, 1, SpringLayout.EAST, panel_1);
		sl_total.putConstraint(SpringLayout.EAST, panel_4, -163, SpringLayout.EAST, contentPanel);
		panel_4.setBackground(Color.WHITE);
		panel_1.setLayout(new CardLayout(0, 0));

		tf_friends = new JTextField();
		panel_1.add(tf_friends, "name_1488656491463000");
		tf_friends.setColumns(10);
		contentPanel.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		JButton btnSearch = new JButton("");
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\searchicon1.png"));
		btnSearch.addMouseListener(new MouseAdapter() {
			
			// 친구 검색 하고 버튼 눌렀을때
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model.clear();

				String member_id = tf_friends.getText();

				tf_friends.setText("");
				ArrayList<String[]> arraylist2 = new ArrayList<String[]>();
				System.out.println("member" + member_id);
				arraylist2 = friends.getFreind(member_id);

				for (int i = 0; i < arraylist2.size(); i++) {
					model.addElement(arraylist2.get(i)[0]
							+ "                                                                     "
							+ arraylist2.get(i)[1]);
					System.out.println("확인!!" + arraylist2.get(i)[0] + arraylist2.get(i)[1]);

				}

			}
		});
		//
		panel_4.add(btnSearch, "name_1488839889821600");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 15));

		JScrollPane scrollPane = new JScrollPane();
		sl_total.putConstraint(SpringLayout.SOUTH, scrollPane, -64, SpringLayout.SOUTH, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, scrollPane, -56, SpringLayout.EAST, contentPanel);
		panel_2.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uB0B4 \uCE5C\uAD6C \uBAA9\uB85D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1, "name_1488690441697800");
		panel.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel = new JLabel("\uC0C8\uCE5C\uAD6C \uCC3E\uAE30");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, "name_1488629397115200");
		contentPanel.add(scrollPane);

		JList friendlist = new JList();
		friendlist.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 15));
//		friendlist.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent arg0) {
//				System.out.println("리스트 선택");
//
//			}
//		});
		/*
		 * friendlist.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override
		 * 
		 * public void mouseClicked(MouseEvent e) { int index=0; String friend_id="";
		 * JList list=(JList)e.getSource(); if(e.getClickCount()==2) {
		 * 
		 * //리스트 더블클릭한 위치 찾기 index=list.locationToIndex(e.getPoint());
		 * System.out.println(index);
		 * System.out.println(list.getSelectedValue().toString());
		 * friend_id=list.getSelectedValue().toString().substring(0,19);
		 * System.out.println("dddd : " +
		 * list.getSelectedValue().toString().substring(0,19)); }
		 * System.out.println(friend_id+"if문 바깥");
		 * 
		 * friends.insertFriend("test", friend_id); System.out.println("삽입확인");
		 * JOptionPane.showMessageDialog(null, "친구추가하였습니다.", "Message",
		 * JOptionPane.INFORMATION_MESSAGE); } });
		 */

//		friendlist.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent arg0)
//
//			{
//				if (!arg0.getValueIsAdjusting()) {
//					// 리스트 선택시 선택사항이 변하지 않을 때
//					System.out.println(friendlist.getSelectedValue().toString()); // 리스트에서 선택된 사항을
//				} // toString(문자변환)한 것을 콘솔에 출력 }
//
//			}
//		});
		model.clear();
		ArrayList<String[]> arraylist = friends.getSearch(id);
		
		// 맨처음 내 친구목록 다 나오는 리스트
		for (int i = 0; i < arraylist.size(); i++) {
			// 내 친구목록의 친구 아이디와 이름
			model.addElement(arraylist.get(i)[0]+"                               "
			+arraylist.get(i)[1]);
			System.out.println("확인!!" + arraylist.get(i)[0]);
		}
		friendlist.setModel(model);

		// 두번 클릭해서 다이어리 들어가기
		friendlist.addMouseListener(new MouseAdapter() {
			
			ArrayList<FriendDiaryVO> friendVO = f_d_dao.selectAllbook(id);

			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					System.out.println("확인다이어리 번호 : " + index);
					
					//id를 가지고 friendID 를 가지고 friendGUI로 가야해
					
					System.out.println(arraylist.get(index)[0]);
					String friend_id = arraylist.get(index)[0];
					FriendGUI.main(friend_id,id);
					
					//Finished_Diary.main(friendVO.get(index).getDiary_no());

//					Finished_Diary.main(friendVO.get(index).getDiary_no());
//					System.out.println(friendVO.get(index).getDiary_no());
				} else if (evt.getClickCount() == 3) {

					// Triple-click detected
					int index = list.locationToIndex(evt.getPoint());
				}
			}
		});

		friendlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(friendlist);
		
				JPanel panel_3 = new JPanel();
				sl_total.putConstraint(SpringLayout.NORTH, panel_3, 122, SpringLayout.NORTH, contentPanel);
				sl_total.putConstraint(SpringLayout.SOUTH, panel_1, -21, SpringLayout.NORTH, panel_3);
				sl_total.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, panel_3);
				sl_total.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel_3);
				sl_total.putConstraint(SpringLayout.WEST, panel_3, 53, SpringLayout.WEST, contentPanel);
				sl_total.putConstraint(SpringLayout.EAST, panel_3, -56, SpringLayout.EAST, contentPanel);
				sl_total.putConstraint(SpringLayout.SOUTH, panel_4, -21, SpringLayout.NORTH, panel_3);
				panel_3.setBackground(Color.WHITE);
				contentPanel.add(panel_3);
				panel_3.setPreferredSize(new Dimension(300, 26));
				panel_3.setLayout(new GridLayout(0, 2, 0, 0));
				
						JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
						lblNewLabel_2.setBackground(Color.WHITE);
						lblNewLabel_2.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						panel_3.add(lblNewLabel_2);
						
								JLabel lblNewLabel_3 = new JLabel("\uC774\uB984");
								lblNewLabel_3.setBackground(Color.WHITE);
								lblNewLabel_3.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
								lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
								panel_3.add(lblNewLabel_3);
		{
			okButton = new JButton("");
			sl_total.putConstraint(SpringLayout.WEST, okButton, 465, SpringLayout.WEST, contentPanel);
			sl_total.putConstraint(SpringLayout.SOUTH, okButton, 0, SpringLayout.SOUTH, contentPanel);
			sl_total.putConstraint(SpringLayout.EAST, okButton, -91, SpringLayout.EAST, contentPanel);
			okButton.setBackground(Color.WHITE);
			contentPanel.add(okButton);
			
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			okButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\check.PNG"));
			okButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String friend_id = friendlist.getSelectedValue().toString().substring(0, 19).trim();
					System.out.println("친구아이디출력" + friend_id);
					friends.insertFriend(id, friend_id);
					System.out.println("삽입확인");
					JOptionPane.showMessageDialog(null, "친구추가하였습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			// 기본 외곽선
		    okButton.setBorderPainted(false);
		    //클릭 했을때 테두리 사용 안함
		    okButton.setFocusPainted(false);
		}
		{
			JButton cancelButton = new JButton("");
			sl_total.putConstraint(SpringLayout.WEST, cancelButton, 0, SpringLayout.EAST, okButton);
			sl_total.putConstraint(SpringLayout.SOUTH, cancelButton, 0, SpringLayout.SOUTH, okButton);
			sl_total.putConstraint(SpringLayout.EAST, cancelButton, -27, SpringLayout.EAST, contentPanel);
			cancelButton.setBackground(Color.WHITE);
			contentPanel.add(cancelButton);
			
			cancelButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\cancle.PNG"));
			cancelButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			// 기본 외곽선
			cancelButton.setBorderPainted(false);
			//클릭 했을때 테두리 사용 안함
			cancelButton.setFocusPainted(false);
		}
	}
}
