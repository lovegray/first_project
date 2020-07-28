package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import DAO.MemberDao;
import java.awt.Color;
import javax.swing.SwingConstants;

public class JoinGUI extends JFrame{
//메소드 실행 안 될때 상속여부 확인하기.끄기 dispose() 함수 적용하기 위해 상
	private JFrame membership_frame;
	private JPanel panel1;
	private JTextField tf_id;
	private JTextField tf_phonenum;
	private JTextField tf_name;
	private JTextField tf_email;
	private JCheckBox[] book_keyword = new JCheckBox[8];// 체크박스 배열
	private String[] names = { "소설", "취미", "동화", "인문", "경제", "과학", "역사", "참고서적" };// 체크박스 문자열로 사용할 문자열 배열
	private ArrayList<String> keyword = new ArrayList<String>();
	MemberDao dao = new MemberDao();
	private JTextField tf_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinGUI window = new JoinGUI();
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					//
					window.membership_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JoinGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		membership_frame = new JFrame();
		membership_frame.setBounds(100, 100, 715, 519);
		membership_frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

		JPanel panel;
		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		SpringLayout sl_panel1 = new SpringLayout();
		panel1.setLayout(sl_panel1);
		membership_frame.getContentPane().add(panel1, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		sl_panel1.putConstraint(SpringLayout.NORTH, panel_2, 43, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.WEST, panel_2, 45, SpringLayout.WEST, panel1);
		sl_panel1.putConstraint(SpringLayout.SOUTH, panel_2, -198, SpringLayout.SOUTH, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, panel_2, -32, SpringLayout.EAST, panel1);
		panel1.add(panel_2);
		panel_2.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);

		tf_id = new JTextField();
		tf_id.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		panel_2.add(tf_id);
		tf_id.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("PW");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_3);
		
		tf_pw = new JTextField();
		tf_pw.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
		panel_2.add(tf_pw);
		tf_pw.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_4);

		tf_phonenum = new JTextField();
		tf_phonenum.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		panel_2.add(tf_phonenum);
		tf_phonenum.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\uC774\uB984");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_5);

		tf_name = new JTextField();
		tf_name.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		panel_2.add(tf_name);
		tf_name.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_6);

		tf_email = new JTextField();
		tf_email.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		panel_2.add(tf_email);
		tf_email.setColumns(10);

		JButton btnNewButton = new JButton("\uAC00\uC785");
		btnNewButton.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
		btnNewButton.setBackground(Color.WHITE);
		sl_panel1.putConstraint(SpringLayout.WEST, btnNewButton, 45, SpringLayout.WEST, panel1);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String member_id = tf_id.getText();
				String member_pw = tf_pw.getText();
				String phone_number = tf_phonenum.getText();
				String name = tf_name.getText();
				String email = tf_email.getText();

				for (int i = 0; i < book_keyword.length; i++) {
					// 체크박스 선택 건 텍스트 받아와서 dbtable에 삽입하기.
					if (book_keyword[i].isSelected()) {
						keyword.add(book_keyword[i].getText());
					}
				} // book_keyword(체크박스 배열)에 선택된 거 있으면 keyword arraylist배열에 추가.

				// keyword_1;
				// keyword_2;
				// keyword_3;

				dao.insert(member_id, member_pw, phone_number, email, name, 0, keyword.get(0), keyword.get(1),
						keyword.get(2));
				JOptionPane.showMessageDialog(null, "축하합니다.가입완료되었습니다.", "Message", JOptionPane.CLOSED_OPTION);
				membership_frame.dispose();
				
				

			}

		});
		sl_panel1.putConstraint(SpringLayout.NORTH, btnNewButton, 433, SpringLayout.NORTH, panel1);
		panel1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		sl_panel1.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -18, SpringLayout.SOUTH, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, btnNewButton, -73, SpringLayout.WEST, btnNewButton_1);
		btnNewButton_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				membership_frame.dispose();
			}
		});
		sl_panel1.putConstraint(SpringLayout.WEST, btnNewButton_1, 427, SpringLayout.WEST, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, btnNewButton_1, -30, SpringLayout.EAST, panel1);
		panel1.add(btnNewButton_1);

		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		sl_panel1.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.WEST, label, 313, SpringLayout.WEST, panel1);
		sl_panel1.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, panel_2);
		sl_panel1.putConstraint(SpringLayout.EAST, label, -306, SpringLayout.EAST, panel1);
		label.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 20));
		panel1.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_panel1.putConstraint(SpringLayout.NORTH, panel_1, 288, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel_2);
		sl_panel1.putConstraint(SpringLayout.SOUTH, panel_1, 38, SpringLayout.SOUTH, panel_2);
		sl_panel1.putConstraint(SpringLayout.EAST, panel_1, -32, SpringLayout.EAST, panel1);
		panel1.add(panel_1);

		JLabel lb_like = new JLabel("\uAD00\uC2EC\uC0AC");
		lb_like.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 20));
		panel_1.add(lb_like);

		JPanel ck_panel = new JPanel();
		sl_panel1.putConstraint(SpringLayout.NORTH, ck_panel, 6, SpringLayout.SOUTH, panel_1);
		sl_panel1.putConstraint(SpringLayout.SOUTH, ck_panel, -53, SpringLayout.SOUTH, panel1);
		sl_panel1.putConstraint(SpringLayout.NORTH, btnNewButton_1, 2, SpringLayout.SOUTH, ck_panel);
		ck_panel.setBackground(Color.WHITE);
		sl_panel1.putConstraint(SpringLayout.WEST, ck_panel, 0, SpringLayout.WEST, panel_2);
		sl_panel1.putConstraint(SpringLayout.EAST, ck_panel, -32, SpringLayout.EAST, panel1);
		panel1.add(ck_panel);
		ck_panel.setLayout(new GridLayout(2, 4, 0, 0));

		MyItemListener listener = new MyItemListener();
		for (int i = 0; i < book_keyword.length; i++) {
			book_keyword[i] = new JCheckBox(names[i]);
			book_keyword[i].setBorderPainted(true);
			ck_panel.add(book_keyword[i]);
			book_keyword[i].addItemListener(listener);

		}
		membership_frame.setVisible(true);

	}

	class MyItemListener implements ItemListener {
//	

		private int count = 0;// 체크박스 선택개수 세기

		public void itemStateChanged(ItemEvent e) {

			/*
			 * while(count<3) { if (e.getStateChange() == ItemEvent.SELECTED) {// 체크박스 선택할
			 * 경우 for (int i = 0; i < book_keyword.length; i++) { if (e.getItem() ==
			 * book_keyword[count]) { System.out.println(count); count++;
			 * 
			 * 
			 * } } } else if(e.getStateChange() == ItemEvent.DESELECTED){ for (int i = 0; i
			 * < book_keyword.length; i++) { if (e.getItem() == book_keyword[count]) {
			 * count--; } } }
			 * 
			 * }
			 */
			if (e.getStateChange() == ItemEvent.SELECTED) {

				for (int i = 0; i < book_keyword.length; i++) {
					if (e.getItem() == book_keyword[i]) {

						count += 1;

					}
				}

			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				for (int i = 0; i < book_keyword.length; i++) {
					if (e.getItem() == book_keyword[i]) {
						count -= 1;
						System.out.println(count);
					}
				}
			}
			if (count >= 4) {
				JOptionPane.showMessageDialog(null, "3개 초과하여 선택할 수 없습니다.", "Message", JOptionPane.ERROR_MESSAGE);
				for (int i = 0; i < book_keyword.length; i++) {
					book_keyword[i].disable();
				}

			}

			// System.out.println("확인"+count);
			// count=0;

		}
	}

}
