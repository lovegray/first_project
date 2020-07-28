package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;

import DAO.DbConnection;
import DAO.FriendDiaryDAO;
import DAO.VisitDAO;
import VO.Book_diaryVO;
import VO.FriendDiaryVO;
import VO.Guest_boardVO;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FriendGUI extends JDialog {
	// private DbConnection dao = new VisitDAO();

	// �޾ƿ���!!
	// String id;
	VisitDAO v_dao = new VisitDAO();
	FriendDiaryDAO f_d_dao = new FriendDiaryDAO();
	private JFrame frame;
	private JTextField tf_visit_contents;
	static DefaultListModel<String> model;
	String friend_id, id;

	/**
	 * Launch the application.
	 */
	public static void main(String friend_id, String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendGUI window = new FriendGUI(friend_id, id);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param friend_id
	 */
	public FriendGUI(String friend_id, String id) {
		this.friend_id = friend_id;
		this.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		SpringLayout panel_1 = new SpringLayout();
		panel.setLayout(panel_1);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_2, -475, SpringLayout.EAST, panel);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lb_memberID = new JLabel(friend_id);

		lb_memberID.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_memberID.setFont(new Font("����", Font.BOLD, 20));
		panel_2.add(lb_memberID);

		// ģ���� ���̾ �� ����
		// String member_id = "test";
		
		lb_memberID.setText(friend_id);
		
		JLabel label = new JLabel("\uB2D8\uC758 \uB2E4\uC774\uC5B4\uB9AC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����������_ac ExtraBold", Font.BOLD, 20));
		panel_2.add(label);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.putConstraint(SpringLayout.NORTH, panel_3, 63, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_3);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel_3);
		panel_1.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_3, -14, SpringLayout.EAST, panel);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, panel_4);
		panel_1.putConstraint(SpringLayout.NORTH, panel_4, 98, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -197, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_4, -14, SpringLayout.EAST, panel);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel label_1 = new JLabel("\uB0A0\uC9DC");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("����������_ac Bold", Font.BOLD, 18));
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("\uCC45 \uC81C\uBAA9");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("����������_ac Bold", Font.BOLD, 18));
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("\uC791\uAC00");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("����������_ac Bold", Font.BOLD, 18));
		panel_3.add(label_3);

		JLabel label_4 = new JLabel("\uBCC4\uC810");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("����������_ac Bold", Font.BOLD, 18));
		panel_3.add(label_4);
		panel.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		JList list_2 = new JList();
		list_2.setFont(new Font("����������_ac", Font.PLAIN, 15));
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {
					"2019-11-31       \uC88B\uC544\uD558\uAC70\uB098 \uC9C0\uCCE4\uAC70\uB098       \uAE00\uBC30\uC6B0      4.5" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_4.add(list_2, "name_2235577353400558");

		// ģ�� å ��� ����Ʈ ��ü
		// �α��ο��� �޾ƿ���
		// String id= "test"; //ģ�� ���̵� �޾ƿ;��Ѵ�.
		ArrayList<FriendDiaryVO> friendVO = f_d_dao.selectAllbook(friend_id);

		model = new DefaultListModel<String>();
		for (int i = 0; i < friendVO.size(); i++) {
			model.addElement(friendVO.get(i).getDate() + "          " + friendVO.get(i).getBookName() + "          "
					+ friendVO.get(i).getWriter() + "          " + friendVO.get(i).getRate());

			System.out.println(friendVO.get(i).getBookName() + friendVO.get(i).getWriter() + friendVO.get(i).getDate()
					+ friendVO.get(i).getRate());
			System.out.println("����");
		}
		list_2.setModel(model);

		// �ι� Ŭ���ؼ� ���̾ ����
		list_2.addMouseListener(new MouseAdapter() {

			ArrayList<FriendDiaryVO> friendVO = f_d_dao.selectAllbook(friend_id);

			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					System.out.println("Ȯ�δ��̾ ��ȣ : " + friendVO.get(index).getDiary_no());

					Finished_Diary.main(friendVO.get(index).getDiary_no());
				} else if (evt.getClickCount() == 3) {

					// Triple-click detected
					int index = list.locationToIndex(evt.getPoint());
				}
			}
		});

		// ��ũ�� �߰�
		JScrollPane scroll = new JScrollPane(list_2);

		panel_4.add(scroll, "Center"); // JScrooPane�� ���� JList�� ��Ÿ���� ���� ��ġ�Ѵ�.

//		public static void main(String s[]) {
//			 ShowList sl = new ShowList();
//			 }
//		

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, panel_4);
		panel_1.putConstraint(SpringLayout.WEST, panel_5, 187, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_5, 494, SpringLayout.WEST, panel);
		panel.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));

		JLabel label_5 = new JLabel("\uBC29\uBA85\uB85D");
		label_5.setBackground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("����������_ac Bold", Font.BOLD, 18));
		panel_5.add(label_5, "name_2236251674000703");

		JPanel panel_6 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -6, SpringLayout.NORTH, panel_6);
		panel_1.putConstraint(SpringLayout.NORTH, panel_6, 359, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_6, -64, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_6, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_6, 739, SpringLayout.WEST, panel);
		panel.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_7, 14, SpringLayout.SOUTH, panel_6);
		panel_1.putConstraint(SpringLayout.WEST, panel_7, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_7, -13, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_7, 654, SpringLayout.WEST, panel);

		JList list = new JList();
		list.setFont(new Font("����������_ac", Font.PLAIN, 13));
		panel_6.add(list, "name_2236485240588348");
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "   \uC544\uC601\uB2D8 : \uD37C\uAC00\uC5EC ~ \u2661",
					"\uC870\uBBF8\uB2C8\uB2D8 : \uD37C\uAC00\uC5EC !  ~ \u2661" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		// ���� ����Ʈ �ҷ�����
		ArrayList<Guest_boardVO> result = v_dao.selectVisit(friend_id);

		model = new DefaultListModel<String>();

		for (int i = 0; i < result.size(); i++) {
			model.addElement(result.get(i).getMember_id() + "          " + result.get(i).getContents() + "          "
					+ result.get(i).getDate().toString());
		}
		list.setModel(model);
		// ����Ʈ ��ũ�� ��� �߰�
		JScrollPane scroll2 = new JScrollPane(list);

		panel_6.add(scroll2, "Center"); // JScrooPane�� ���� JList�� ��Ÿ���� ���� ��ġ�Ѵ�.

		panel.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));

		tf_visit_contents = new JTextField();
		tf_visit_contents.setFont(new Font("����������_ac", Font.PLAIN, 12));
		panel_7.add(tf_visit_contents, "name_2250873616066635");
		tf_visit_contents.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_8, 14, SpringLayout.SOUTH, panel_6);
		panel_1.putConstraint(SpringLayout.WEST, panel_8, 6, SpringLayout.EAST, panel_7);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_8, -13, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_8, -14, SpringLayout.EAST, panel);
		panel.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));

		JButton btn_visit_save = new JButton("\uC800\uC7A5");
		btn_visit_save.setBackground(Color.WHITE);
		btn_visit_save.addMouseListener(new MouseAdapter() {
			@Override

			// ���� �����ư ��������
			public void mouseClicked(MouseEvent arg0) {

				// ���� dao �� ����
				String contents = tf_visit_contents.getText();
				String member_id = login.now_id;
				String friend = friend_id;

				v_dao.insertVisit(member_id, friend, contents);

				// ���� Ȯ��
				ArrayList<Guest_boardVO> result = new ArrayList<Guest_boardVO>();
				result = v_dao.selectVisit(friend_id);

				// ���� ���
				// FriendGUI.getContentPane().add(friend,contents);

				// ok �������� ��ĭ �����
				tf_visit_contents.setText("");

				//model = new DefaultListModel<String>();
				model.addElement(login.now_id + "          " + contents+ "          "
						);

				list.setModel(model);

			}

		});
		btn_visit_save.setFont(new Font("����������_ac ExtraBold", Font.BOLD, 15));
		// �⺻ �ܰ���
		btn_visit_save.setBorderPainted(false);
		// Ŭ�� ������ �׵θ� ��� ����
		btn_visit_save.setFocusPainted(false);
		panel_8.add(btn_visit_save, "name_2251027820413935");

		JPanel panel_9 = new JPanel();
		panel_1.putConstraint(SpringLayout.WEST, panel_9, -60, SpringLayout.EAST, panel_3);
		panel_9.setBackground(Color.WHITE);
		panel_1.putConstraint(SpringLayout.NORTH, panel_9, 10, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_9, 47, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_9, -14, SpringLayout.EAST, panel);
		panel.add(panel_9);
		panel_9.setLayout(new CardLayout(0, 0));

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\small_cancle.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();

			}
		});
		btnNewButton.setFont(new Font("����������_ac", Font.BOLD, 17));
		// �⺻ �ܰ���
		btnNewButton.setBorderPainted(false);
		// Ŭ�� ������ �׵θ� ��� ����
		btnNewButton.setFocusPainted(false);
		panel_9.add(btnNewButton, "name_115332359935100");
	}

	// �߰� �޼���
	protected static void add(String friend, String contents) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		model.addElement(friend + "          " + contents + "          " + format1.format(time));

	}
}
