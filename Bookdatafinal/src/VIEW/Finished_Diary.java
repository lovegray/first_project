package VIEW;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DAO.BookDAO;
import DAO.DiaryDAO;
import DAO.FinalBook_diaryno_DAO;
import DAO.FinalDiaryDAO;
import DAO.FriendDiaryDAO;
//import DAO.DiaryDAO;
import VO.BookVO;
import VO.Book_diaryVO;
import VO.Book_diary_finishVO;
import VO.Daily_book_diaryVO;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Finished_Diary extends JDialog {

	private JFrame frame;

//   DiaryDAO d_dao = new DiaryDAO();
	BookDAO b_dao = new BookDAO();
	FriendDiaryDAO f_d_dao = new FriendDiaryDAO();
	FinalDiaryDAO final_dao = new FinalDiaryDAO();
	FinalBook_diaryno_DAO diaryno_dao = new FinalBook_diaryno_DAO();
	DiaryDAO dao = new DiaryDAO();

	static DefaultListModel<String> model;

	int diary_no;
	int cnt;

	/**
	 * Launch the application.
	 */
	public static void main(int diary_no) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finished_Diary window = new Finished_Diary(diary_no);

					System.out.println("diary_no : " + diary_no);

					window.frame.setVisible(true);
					window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Finished_Diary(int diary_no) {
		this.diary_no = diary_no;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 766, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		SpringLayout panel_1 = new SpringLayout();
		panel.setLayout(panel_1);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		// 페이지 넘어올 때 isbn 가지고 넘어오기
		Book_diaryVO diary_like = final_dao.selectDiary(diary_no);
		// int isbn = 1;

		// BookVO book = b_dao.book_info(isbn);
		// System.out.println("들어왓나?");

		JPanel panel_2 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_2, 20, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_2, 35, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -440, SpringLayout.SOUTH, panel);
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JLabel lb_book_name = new JLabel(dao.searchBookname(diary_no));
		lb_book_name.setForeground(new Color(105, 105, 105));
		lb_book_name.setBackground(new Color(255, 255, 255));
		lb_book_name.setHorizontalAlignment(SwingConstants.LEFT);
		lb_book_name.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 28));
		panel_2.add(lb_book_name, "name_1654373378320900");

		// 제묵 변경
		ArrayList<Book_diary_finishVO> title = diaryno_dao.searchDiary(diary_no);
		lb_book_name.setText(title.get(0).getBook_name());

		JPanel panel_3 = new JPanel();
		panel_1.putConstraint(SpringLayout.EAST, panel_2, -49, SpringLayout.WEST, panel_3);
		panel_1.putConstraint(SpringLayout.EAST, panel_3, -111, SpringLayout.EAST, panel);
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		ImageIcon img = new ImageIcon(
				"C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\" + diary_like.getRate() + ".png");
		Image hh = img.getImage();
		Image wg = hh.getScaledInstance(162, 47, java.awt.Image.SCALE_SMOOTH);

		JLabel lb_rate = new JLabel("");
		lb_rate.setForeground(new Color(105, 105, 105));
		lb_rate.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		lb_rate.setBackground(new Color(255, 255, 255));
		lb_rate.setIcon(new ImageIcon(wg));
		lb_rate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lb_rate);
		// panel_3.add(lb_rate, "name_1228517128373900");

		/*
		 * JLabel lb_recommendImage1 = new JLabel(""); lb_recommendImage1.setIcon(new
		 * ImageIcon(resizeimageok1));
		 * lb_recommendImage1.setHorizontalAlignment(SwingConstants.CENTER);
		 * recommendImage1.add(lb_recommendImage1);
		 */

		JPanel panel_9 = new JPanel();
		panel_1.putConstraint(SpringLayout.EAST, panel_9, -538, SpringLayout.EAST, panel);
		panel_9.setBackground(new Color(255, 255, 255));
		panel.add(panel_9);
		panel_9.setLayout(new CardLayout(0, 0));

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(105, 105, 105), null,
				new Color(211, 211, 211), null));
		panel_1.putConstraint(SpringLayout.NORTH, panel_12, 215, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_12, -166, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_9, 0, SpringLayout.WEST, panel_12);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_9, -6, SpringLayout.NORTH, panel_12);
		panel.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));

		JLabel label_7 = new JLabel("\uB370\uC77C\uB9AC \uAE30\uB85D");
		label_7.setForeground(new Color(70, 130, 180));
		label_7.setIcon(new ImageIcon("C:\\Users\\smhrd16\\Desktop\\icon\\write3.PNG"));
		label_7.setBackground(new Color(255, 255, 255));
		panel_9.add(label_7, "name_1231026527315600");
		panel_1.putConstraint(SpringLayout.WEST, label_7, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, label_7, -326, SpringLayout.SOUTH, panel);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(105, 105, 105), null,
				new Color(211, 211, 211), null));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_1.putConstraint(SpringLayout.WEST, panel_12, 0, SpringLayout.WEST, panel_11);
		panel_1.putConstraint(SpringLayout.EAST, panel_12, 0, SpringLayout.EAST, panel_11);
		panel_1.putConstraint(SpringLayout.WEST, panel_11, 41, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_11, -42, SpringLayout.EAST, panel);

		JList list = new JList();
		list.setForeground(new Color(102, 102, 102));
		panel_12.add(list, "name_1230586728414100");

		// 데일리 기록
		// DAILY_BOOK_DIARY

		ArrayList<Daily_book_diaryVO> arr = final_dao.selectDaily(diary_no);
		model = new DefaultListModel<String>();
		for (int i = 0; i < arr.size(); i++) {
			model.addElement(arr.get(i).getReporting_date() + "          " + arr.get(i).getContent());
		}
		list.setModel(model);

		list.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
		panel.add(panel_11);
		panel_11.setLayout(new CardLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_1.putConstraint(SpringLayout.WEST, panel_3, 26, SpringLayout.EAST, panel_4);
		panel_1.putConstraint(SpringLayout.EAST, panel_4, -299, SpringLayout.EAST, panel);
		panel_1.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_2);
		panel_1.putConstraint(SpringLayout.WEST, panel_4, 121, SpringLayout.WEST, panel);
		panel_4.setBackground(new Color(255, 255, 255));
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lb_writer = new JLabel("\uC791\uAC00");
		lb_writer.setForeground(new Color(105, 105, 105));
		lb_writer.setBackground(new Color(255, 255, 255));
		lb_writer.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 20));
		lb_writer.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lb_writer);

		// 작가 추가
		ArrayList<Book_diary_finishVO> diary_writer = diaryno_dao.searchDiary(diary_no);
		lb_writer.setText(diary_writer.get(0).getWriter());

		JPanel panel_5 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -24, SpringLayout.NORTH, panel_5);
		panel_5.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(119, 136, 153)));
		panel_1.putConstraint(SpringLayout.NORTH, panel_9, 6, SpringLayout.SOUTH, panel_5);
		panel_1.putConstraint(SpringLayout.NORTH, panel_5, 126, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -342, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_5, 41, SpringLayout.WEST, panel);
		panel_5.setBackground(new Color(255, 255, 255));
		panel.add(panel_5);

		JPanel panel_10 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_10, 24, SpringLayout.SOUTH, panel_4);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_10, -50, SpringLayout.NORTH, panel_12);
		panel_10.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(119, 136, 153)));
		panel_10.setForeground(new Color(255, 255, 255));
		panel_1.putConstraint(SpringLayout.EAST, panel_5, -23, SpringLayout.WEST, panel_10);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_1.putConstraint(SpringLayout.WEST, panel_10, 394, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_10, 0, SpringLayout.EAST, panel_12);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);

		JLabel lblNewLabel_1 = new JLabel("\uC77D\uAE30\uC2DC\uC791\uD55C \uB0A0\uC9DC");
		lblNewLabel_1.setForeground(new Color(119, 136, 153));
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, panel_5);
		lblNewLabel_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 39, SpringLayout.NORTH, panel_5);
		panel_5.add(lblNewLabel_1);

		JLabel lb_start_date = new JLabel("New label");
		lb_start_date.setForeground(new Color(105, 105, 105));
		lb_start_date.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		sl_panel_5.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, lb_start_date);
		sl_panel_5.putConstraint(SpringLayout.EAST, lb_start_date, 0, SpringLayout.EAST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, lb_start_date, 130, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.NORTH, lb_start_date, 0, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lb_start_date, 39, SpringLayout.NORTH, panel_5);
		panel_5.add(lb_start_date);
		panel.add(panel_10);

		// 일기 시작한 날짜
		ArrayList<Book_diary_finishVO> diarystart = diaryno_dao.searchDiary(diary_no);
		lb_start_date.setText(diarystart.get(0).getStart_date().toString());
		SpringLayout sl_panel_10 = new SpringLayout();
		panel_10.setLayout(sl_panel_10);

		JLabel lblNewLabel_3 = new JLabel("\uC644\uB3C5\uD55C \uB0A0\uC9DC");
		lblNewLabel_3.setForeground(new Color(119, 136, 153));
		sl_panel_10.putConstraint(SpringLayout.EAST, lblNewLabel_3, 100, SpringLayout.WEST, panel_10);
		lblNewLabel_3.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
		sl_panel_10.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 39, SpringLayout.NORTH, panel_10);
		panel_10.add(lblNewLabel_3);

		JLabel lb_finish_date = new JLabel("New label");
		lb_finish_date.setForeground(new Color(105, 105, 105));
		lb_finish_date.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
		sl_panel_10.putConstraint(SpringLayout.NORTH, lb_finish_date, 0, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, lb_finish_date, 6, SpringLayout.EAST, lblNewLabel_3);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, lb_finish_date, 39, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, lb_finish_date, 314, SpringLayout.WEST, panel_10);
		panel_10.add(lb_finish_date);

		// 완독 날짜
		ArrayList<Book_diary_finishVO> diary_finish_date = diaryno_dao.searchDiary(diary_no);

		lb_finish_date.setText(diary_finish_date.get(0).getFinish_date().toString());

		JPanel panel_13 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_11, 6, SpringLayout.SOUTH, panel_13);
		panel_1.putConstraint(SpringLayout.EAST, panel_13, -581, SpringLayout.EAST, panel);
		panel_1.putConstraint(SpringLayout.NORTH, panel_13, 6, SpringLayout.SOUTH, panel_12);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_13, -117, SpringLayout.SOUTH, panel);
		panel_13.setBackground(new Color(255, 255, 255));
		panel_1.putConstraint(SpringLayout.WEST, panel_13, 0, SpringLayout.WEST, panel_11);

		JLabel lb_review = new JLabel("New label");
		lb_review.setForeground(new Color(102, 102, 102));
		lb_review.setBackground(new Color(255, 255, 255));
		lb_review.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
		panel_11.add(lb_review, "name_1231241078316900");

		// 총 서평
		ArrayList<Book_diary_finishVO> diary_finish_review = diaryno_dao.searchDiary(diary_no);

		lb_review.setText(diary_finish_review.get(0).getReview());
		panel.add(panel_13);
		panel_13.setLayout(new CardLayout(0, 0));

		JLabel label = new JLabel("\uCD1D \uC11C\uD3C9");
		label.setForeground(new Color(70, 130, 180));
		label.setIcon(new ImageIcon("C:\\Users\\smhrd16\\Desktop\\icon\\write3.PNG"));
		label.setBackground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
		panel_13.add(label, "name_1231217893743100");

		JPanel panel_6 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_11, -15, SpringLayout.NORTH, panel_6);
		panel_1.putConstraint(SpringLayout.NORTH, panel_6, 458, SpringLayout.NORTH, panel);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_1.putConstraint(SpringLayout.WEST, panel_6, 352, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_6, -10, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_6, -347, SpringLayout.EAST, panel);
		panel.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));

		JButton button = new JButton("");
		button.setBackground(new Color(255, 255, 255));
		button.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\ok.png"));
		// 기본 외곽선
		button.setBorderPainted(false);
		// 클릭 했을때 테두리 사용 안함
		button.setFocusPainted(false);
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}

		});
		button.setFont(new Font("돋움체", Font.PLAIN, 13));
		panel_6.add(button, "name_1582915401964700");

		JPanel panel_7 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_7);
		panel_1.putConstraint(SpringLayout.WEST, panel_7, 657, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_7, -42, SpringLayout.EAST, panel);
		panel_1.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel_7);
		panel_1.putConstraint(SpringLayout.NORTH, panel_7, 35, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_7, -44, SpringLayout.NORTH, panel_10);
		panel.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));

		JButton btn_like = new JButton("");
		btn_like.setIcon(
				new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\finised_like4.PNG"));
		btn_like.setBackground(new Color(255, 255, 255));
		// 기본 외곽선
		btn_like.setBorderPainted(false);
		// 클릭 했을때 테두리 사용 안함
		btn_like.setFocusPainted(false);

		btn_like.addMouseListener(new MouseAdapter() {

			@Override
			// 좋아요 클릭시 카운트 +1
			public void mouseClicked(MouseEvent arg0) {
				// ++cnt ;

				diary_like.getDiary_like();
				int result = final_dao.updateLike(diary_like.getDiary_like(), diary_no);

				System.out.println("좋아요!:" + result);
				btn_like.setEnabled(false); // 버튼 비활성화
			}
		});

		panel_7.add(btn_like, "name_1645109699108000");
		panel_1.putConstraint(SpringLayout.WEST, btn_like, 13, SpringLayout.EAST, panel_4);
		panel_1.putConstraint(SpringLayout.SOUTH, btn_like, -6, SpringLayout.NORTH, panel_3);
	}
}