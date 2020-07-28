package VIEW;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import DAO.DiaryDAO;
import VO.BookVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class NewdiaryGUI extends JDialog {
	// insert into 하는곳
	// 아이디 받아와야 해용
	String member_id;
	// 책이름, 읽기 시작한 날, (isbn은 검색해서 insert),(memberid);
	private final JPanel contentPanel = new JPanel();
	DiaryDAO dao = new DiaryDAO();
	private JPanel panel_1;
	private JTextField textField;
	static DefaultListModel<String> model = new DefaultListModel<String>();
	private JPanel panel_2;
	long isbn = 0;
	Calendar now = Calendar.getInstance(); // 현재 날짜
	SimpleDateFormat monthFomat = new SimpleDateFormat("MM");
	SimpleDateFormat dayFomat = new SimpleDateFormat("dd");
	String year = now.get(Calendar.YEAR) + "";
	String month = (now.get(Calendar.MONTH) + 1) + "";
	String date = now.get(Calendar.DATE) + "";
	String yearResult = 2019 + "";
	String monthResult = month + "";
	String dayResult = date + "";
	int cnty = 0;
	int cntm = 0;
	ArrayList<BookVO> result = new ArrayList<BookVO>();
	String bookNamerr = "";
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		try {
			NewdiaryGUI dialog = new NewdiaryGUI(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewdiaryGUI(String id) {
		this.member_id = id;
		setTitle("\uC0C8 \uCC45 \uCD94\uAC00\uD558\uAE30");
		setBounds(100, 100, 639, 347);
		getContentPane().setLayout(new BorderLayout());
		SpringLayout sl_total = new SpringLayout();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setPreferredSize(new Dimension(630, 380));
		contentPanel.setLayout(sl_total);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		{
			panel_1 = new JPanel();
			sl_total.putConstraint(SpringLayout.WEST, panel_1, 20, SpringLayout.WEST, contentPanel);
			sl_total.putConstraint(SpringLayout.SOUTH, panel_1, -224, SpringLayout.SOUTH, contentPanel);
			panel_1.setBackground(Color.WHITE);
			sl_total.putConstraint(SpringLayout.NORTH, panel_1, 27, SpringLayout.NORTH, contentPanel);
			contentPanel.add(panel_1);
		}
		{
			panel_2 = new JPanel();
			sl_total.putConstraint(SpringLayout.NORTH, panel_2, 27, SpringLayout.NORTH, contentPanel);
			sl_total.putConstraint(SpringLayout.EAST, panel_1, -11, SpringLayout.WEST, panel_2);
			panel_2.setBackground(Color.WHITE);
			sl_total.putConstraint(SpringLayout.WEST, panel_2, 146, SpringLayout.WEST, contentPanel);
			sl_total.putConstraint(SpringLayout.EAST, panel_2, -91, SpringLayout.EAST, contentPanel);
			contentPanel.add(panel_2);
			panel_2.setLayout(new CardLayout(0, 0));

			textField = new JTextField();
			textField.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
			panel_2.add(textField, "name_53954332769400");
			textField.setColumns(10);
		}

		JPanel panel = new JPanel();
		sl_total.putConstraint(SpringLayout.SOUTH, panel_2, -21, SpringLayout.NORTH, panel);
		sl_total.putConstraint(SpringLayout.WEST, panel, 37, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel, -22, SpringLayout.EAST, contentPanel);
		sl_total.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.SOUTH, panel_1);
		sl_total.putConstraint(SpringLayout.SOUTH, panel, -96, SpringLayout.SOUTH, contentPanel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(new CardLayout(0, 0));
		contentPanel.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JList list = new JList();

		panel.add(list, "name_54043711631000");

		// 이름에 해당 하는 책 가지고 오기
		// 검색 결과 출력
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String bookName = textField.getText();
				DiaryDAO d_dao = new DiaryDAO();
				 result = d_dao.findBook(bookName);
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				isbn = result.get(index).getIsbn();
				bookNamerr = result.get(index).getBook_name();
			}
		});

		// 리스트 스크롤 기능 추가
		JScrollPane scroll = new JScrollPane(list);

		panel.add(scroll, "Center");

		JPanel panel_3 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_3, 27, SpringLayout.NORTH, contentPanel);
		sl_total.putConstraint(SpringLayout.WEST, panel_3, 1, SpringLayout.EAST, panel_2);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_3, -21, SpringLayout.NORTH, panel);
		sl_total.putConstraint(SpringLayout.EAST, panel_3, -54, SpringLayout.EAST, contentPanel);
		panel_3.setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.WHITE);
		panel_1.add(lblNewLabel, "name_55287166364700");
		contentPanel.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\searchicon1.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String bookNmae = textField.getText();
				DiaryDAO d_dao = new DiaryDAO();
				ArrayList<BookVO> result = d_dao.findBook(bookNmae);

				model = new DefaultListModel<String>();

				for (int i = 0; i < result.size(); i++) {
					BookVO vo = result.get(i);
					model.addElement(vo.getBook_name() + "           " + vo.getWriter() + "          "
							+ vo.getPublisher() + "          " + vo.getIsbn());
				}

				list.setModel(model);

			}
		});
		
		// 기본 외곽선
		btnNewButton.setBorderPainted(false);
	      //클릭 했을때 테두리 사용 안함
		btnNewButton.setFocusPainted(false);
	      
		panel_3.add(btnNewButton, "name_55317633822400");

		JPanel panel_4 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_4, 15, SpringLayout.SOUTH, panel);
		sl_total.putConstraint(SpringLayout.WEST, panel_4, 58, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_4, -41, SpringLayout.SOUTH, contentPanel);
		panel_4.setBackground(Color.WHITE);
		contentPanel.add(panel_4);

		JPanel panel_5 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_5, 0, SpringLayout.NORTH, panel_4);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_5, -41, SpringLayout.SOUTH, contentPanel);
		panel_5.setBackground(Color.WHITE);
		panel_4.setLayout(new CardLayout(0, 0));

		JLabel label = new JLabel("\uBAA9\uD45C \uB0A0\uC9DC");
		label.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
		label.setBackground(Color.WHITE);
		panel_4.add(label, "name_90166080399000");
		contentPanel.add(panel_5);

		JPanel panel_6 = new JPanel();
		sl_total.putConstraint(SpringLayout.WEST, panel_5, 6, SpringLayout.EAST, panel_6);
		sl_total.putConstraint(SpringLayout.WEST, panel_6, 143, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_6, -349, SpringLayout.EAST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_4, -1, SpringLayout.WEST, panel_6);
		sl_total.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_4);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_6, -41, SpringLayout.SOUTH, contentPanel);
		panel_6.setBackground(Color.WHITE);
		panel_5.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uB144");
		lblNewLabel_1.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 17));
		lblNewLabel_1.setBackground(Color.WHITE);
		panel_5.add(lblNewLabel_1, "name_90301320635700");
		contentPanel.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));

		// 콤보박스 만들기
		String yearModel[] = new String[10];
		String monthModel[] = new String[12];
		String dayModel[] = new String[31];
		int j = 0;
		for (int i = now.get(Calendar.YEAR); i < now.get(Calendar.YEAR) + 10; i++) {
			yearModel[j] = i + "";
			j++;
		}

		for (int i = 1; i <= 12; i++) {
			if(i < 10) {
				monthModel[i - 1] = "0"+i;
			}else {
				monthModel[i - 1] = i + "";
			}
			
		}

		String strDate = year + "/" + month;
		int lastdate = Integer.parseInt(getLastDate(strDate));
		for (int i = 1; i <= 31; i++) {
			if(i<10) {
				dayModel[i - 1] = "0"+i ;
			}else {
				dayModel[i - 1] = i + "";
			}
			
		}

		JComboBox yyyy = new JComboBox();
		yyyy.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 17));
		yyyy.addItemListener(new ItemListener() {
			// 콤보박스 값 바뀔 때 수행되는거
			public void itemStateChanged(ItemEvent e) {

				int index = yyyy.getSelectedIndex();
				yearResult = (now.get(Calendar.YEAR) + index) + "";
				// System.out.println(yearResult);
				// cnty++;

			}
		});

		/*
		 * yyyy.addComponentListener(new ComponentAdapter() {
		 * 
		 * @Override public void componentMoved(ComponentEvent arg0) { int index =
		 * yyyy.getSelectedIndex(); yearResult=(now.get(Calendar.YEAR)+index)+"";
		 * System.out.println(yearResult); } });
		 */

		yyyy.setModel(new DefaultComboBoxModel(yearModel));
		panel_6.add(yyyy, "name_90297456751200");

		JPanel panel_7 = new JPanel();
		sl_total.putConstraint(SpringLayout.WEST, panel_7, 326, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_5, -6, SpringLayout.WEST, panel_7);
		sl_total.putConstraint(SpringLayout.NORTH, panel_7, 0, SpringLayout.NORTH, panel_4);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_7, -41, SpringLayout.SOUTH, contentPanel);
		panel_7.setBackground(Color.WHITE);
		contentPanel.add(panel_7);

		JPanel panel_8 = new JPanel();
		sl_total.putConstraint(SpringLayout.WEST, panel_8, 416, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_7, -6, SpringLayout.WEST, panel_8);
		sl_total.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel_4);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_8, -41, SpringLayout.SOUTH, contentPanel);
		panel_8.setBackground(Color.WHITE);
		panel_7.setLayout(new CardLayout(0, 0));

		JComboBox MM = new JComboBox();
		MM.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
		MM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = MM.getSelectedIndex();
				monthResult = (String) MM.getItemAt(index);
				// System.out.println(monthResult);
				// cntm++;
			}
		});
		MM.setModel(new DefaultComboBoxModel(monthModel));
		panel_7.add(MM, "name_90394616721500");
		contentPanel.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("\uC6D4");
		lblNewLabel_2.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		panel_8.add(lblNewLabel_2, "name_90398664525100");

		JPanel panel_9 = new JPanel();
		sl_total.putConstraint(SpringLayout.WEST, panel_9, 465, SpringLayout.WEST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_9, -71, SpringLayout.EAST, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_8, -6, SpringLayout.WEST, panel_9);
		sl_total.putConstraint(SpringLayout.NORTH, panel_9, 0, SpringLayout.NORTH, panel_4);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_9, -41, SpringLayout.SOUTH, contentPanel);
		panel_9.setBackground(Color.WHITE);
		contentPanel.add(panel_9);

		JPanel panel_10 = new JPanel();
		sl_total.putConstraint(SpringLayout.NORTH, panel_10, 0, SpringLayout.NORTH, panel_4);
		sl_total.putConstraint(SpringLayout.WEST, panel_10, 6, SpringLayout.EAST, panel_9);
		sl_total.putConstraint(SpringLayout.SOUTH, panel_10, -41, SpringLayout.SOUTH, contentPanel);
		sl_total.putConstraint(SpringLayout.EAST, panel_10, -22, SpringLayout.EAST, contentPanel);
		panel_10.setBackground(Color.WHITE);
		panel_9.setLayout(new CardLayout(0, 0));

		/*
		 * if (cnty > 0 && cntm > 0) { System.out.println(yearResult + monthResult);
		 * strDate = yearResult + "/" + monthResult; lastdate =
		 * Integer.parseInt(getLastDate(strDate)); for (int i = 1; i <= lastdate; i++) {
		 * dayModel[i - 1] = i + ""; MM.setModel(new DefaultComboBoxModel(monthModel));
		 * } }
		 */
		JComboBox dd = new JComboBox();
		dd.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
		dd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = dd.getSelectedIndex();
				dayResult = (String) dd.getItemAt(index);
			}
		});
		dd.setModel(new DefaultComboBoxModel(dayModel));
		panel_9.add(dd, "name_91354490574600");
		contentPanel.add(panel_10);
		panel_10.setLayout(new CardLayout(0, 0));

		JLabel label_1 = new JLabel("\uC77C");
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
		panel_10.add(label_1, "name_91327921211800");
		{
			okButton = new JButton("");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			sl_total.putConstraint(SpringLayout.WEST, okButton, -97, SpringLayout.EAST, contentPanel);
			sl_total.putConstraint(SpringLayout.EAST, okButton, 0, SpringLayout.EAST, panel_3);
			okButton.setBackground(Color.WHITE);
			okButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\small_check.png"));
			contentPanel.add(okButton);
			okButton.addMouseListener(new MouseAdapter() {
				// 확인 버튼 누를 때 값을 넘기면서 book 테이블에 인서트 해준다.
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String finish_date = yearResult +"-"+ monthResult +"-"+ dayResult;
					System.out.println(finish_date);
					dao.newDiary(isbn, member_id, finish_date);
					dispose();
				}

			});
			okButton.setActionCommand("OK");
			// 기본 외곽선
			okButton.setBorderPainted(false);
		      //클릭 했을때 테두리 사용 안함
			okButton.setFocusPainted(false);
		      
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			sl_total.putConstraint(SpringLayout.SOUTH, cancelButton, 0, SpringLayout.SOUTH, contentPanel);
			sl_total.putConstraint(SpringLayout.SOUTH, okButton, 0, SpringLayout.SOUTH, cancelButton);
			sl_total.putConstraint(SpringLayout.WEST, cancelButton, 17, SpringLayout.WEST, panel_10);
			sl_total.putConstraint(SpringLayout.EAST, cancelButton, 53, SpringLayout.WEST, panel_10);
			cancelButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\small_s_cancle.png"));
			contentPanel.add(cancelButton);
			cancelButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				
				}
			});
			// 기본 외곽선
			cancelButton.setBorderPainted(false);
			cancelButton.setFocusPainted(false);
			cancelButton.setActionCommand("Cancel");
			
					      
		}



	}

	// 월의 마지막날 구하기
	public static String getLastDate(String strDate) {

		String[] strs = strDate.split("/");

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, Integer.parseInt(strs[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(strs[1]) - 1);

		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		return String.valueOf(lastDate);
	}

}