package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DAO.BookDAO;
import DAO.WishListDAO;
import VO.BookVO;
import VO.Book_diaryVO;
import oracle.jdbc.driver.DBConversion;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class BOOK_info extends JDialog {
	BookDAO dao = new BookDAO();
	WishListDAO wish_dao = new WishListDAO();
	String member_id = login.now_id;
	long isbn;
	static DefaultListModel<String> model;
	private JFrame frame;
	// 임의로 isbn지정 페이지넘오올때 isbn 보내줘야한다.

	/**
	 * Launch the application.
	 */
	public static void main(long isbn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BOOK_info window = new BOOK_info(isbn);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BOOK_info(long isbn) {
		this.isbn = isbn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 690, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		BookVO book = dao.book_info(isbn);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		frame.getContentPane().add(panel);

		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 25, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 298, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -339, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JLabel lb_bookname = new JLabel(book.getBook_name());
		lb_bookname.setHorizontalAlignment(SwingConstants.LEFT);
		lb_bookname.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 20));
		panel_2.add(lb_bookname, "name_1746500126887600");

		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -304, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, panel);
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);

		panel_3.setLayout(new CardLayout(0, 0));

		JLabel lb_writer = new JLabel(book.getWriter());
		lb_writer.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 17));
		lb_writer.setHorizontalAlignment(SwingConstants.LEFT);
		lb_writer.setBackground(Color.WHITE);
		panel_3.add(lb_writer, "name_1746513678314800");

		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -269, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, -10, SpringLayout.EAST, panel);
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);

		JPanel panel_6 = new JPanel();
		sl_panel.putConstraint(SpringLayout.EAST, panel_6, -17, SpringLayout.WEST, panel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6, 42, SpringLayout.WEST, panel);
		panel_6.setBackground(Color.WHITE);
		panel.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel = new JLabel("New label");
		// "C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata\\image\\" + book.getIsbn()+
		// ".jpg"
		// file:///C:/Users/smhrd04/Desktop/javaStudy/Bookdata/image/9788954748414.jpg

		System.out.println(book.getIsbn());
		ImageIcon img = new ImageIcon(
				"C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata\\image\\" + book.getIsbn() + ".jpg");
		Image hh = img.getImage();
		Image wg = hh.getScaledInstance(239, 315, java.awt.Image.SCALE_SMOOTH);

		lblNewLabel.setIcon(new ImageIcon(wg));
		panel_6.add(lblNewLabel, "name_62063575839600");

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel_4);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel_3);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel_2);
		panel_1.setBackground(Color.WHITE);
		panel_4.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel(book.getPublisher());
		lblNewLabel_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblNewLabel_1, "name_1746737230579800");
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel(book.getKeyword());
		lblNewLabel_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_2, "name_1746773404832700");

		JPanel panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 17, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, -49, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6, -20, SpringLayout.SOUTH, panel_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -48, SpringLayout.NORTH, panel_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, -41, SpringLayout.SOUTH, panel);
		

		panel.add(panel_5);

		JPanel panel_7 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_7, 17, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.EAST, panel_7, -295, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, panel_7);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_7, 180, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_7, -192, SpringLayout.SOUTH, panel);
		panel_7.setBackground(Color.WHITE);
		panel.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("\uB9AC\uBDF0");
		lblNewLabel_3.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
		panel_7.add(lblNewLabel_3, "name_1746856013564400");

		JPanel panel_8 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_8, 173, SpringLayout.WEST, panel);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_8, 6, SpringLayout.SOUTH, panel_6);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_8, -20, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_8, -16, SpringLayout.WEST, panel_5);
		panel_8.setBackground(Color.WHITE);
		panel_5.setLayout(new CardLayout(0, 0));

		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setForeground(Color.BLACK);
		list.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));

//		// 리스트 스크롤 기능 추가
//	    JScrollPane scroll = new JScrollPane(list);
//
//	    panel_5.add(scroll, "Center"); // JScrooPane에 담은 JList를 나타내기 위해 배치한다.

		ArrayList<Book_diaryVO> reviewARR = new ArrayList<>();

		model = new DefaultListModel<String>();
		model.clear();

		try {
			reviewARR = dao.getReview(isbn);
			for (int i = 0; i < reviewARR.size(); i++) {
				String contents = reviewARR.get(i).getMember_id() + "  :  " + reviewARR.get(i).getReview();
				System.out.println(contents);
				model.addElement(contents);

			}
			list.setModel(model);

		} catch (Exception e) {
			String contents = "리뷰가 없습니다.";
			model.addElement(contents);
			list.setModel(model);
		}

		list.setBackground(Color.WHITE);
		panel_5.add(list, "name_1747399009496500");
		panel.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));
//		// 리스트 스크롤 기능 추가
	    JScrollPane scroll = new JScrollPane(list);
//
	    panel_5.add(scroll, "Center"); // JScrooPane에 담은 JList를 나타내기 위해 배치한다.

		JButton button = new JButton("\uC704\uC2DC\uB9AC\uC2A4\uD2B8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBackground(Color.WHITE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//위시리스트 추가해주는거 
			wish_dao.wishlist(isbn, member_id);
			JOptionPane.showMessageDialog(null, "추가되었습니다.");
			}
		});
		button.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 15));
		 // 기본 외곽선
		button.setBorderPainted(false);
	      //클릭 했을때 테두리 사용 안함
		button.setFocusPainted(false);
		panel_8.add(button, "name_1746987114089000");

		JPanel panel_9 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 8, SpringLayout.EAST, panel_9);
		panel_9.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_9, 6, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_9, 0, SpringLayout.WEST, panel_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_9, 35, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_9, 0, SpringLayout.EAST, panel_7);
		panel.add(panel_9);

		JPanel panel_10 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_10, 17, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.EAST, panel_10, -293, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 6, SpringLayout.EAST, panel_10);
		panel_10.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_10, 6, SpringLayout.SOUTH, panel_9);
		panel_9.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("\uC791\uAC00");
		lblNewLabel_4.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 17));
		panel_9.add(lblNewLabel_4, "name_1748629586043400");
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_10, -269, SpringLayout.SOUTH, panel);
		panel.add(panel_10);

		JPanel panel_11 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_11, 17, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.EAST, panel_11, -6, SpringLayout.WEST, panel_1);
		panel_11.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_11, 6, SpringLayout.SOUTH, panel_10);
		panel_10.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_5.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 17));
		panel_10.add(lblNewLabel_5, "name_1748647967829400");
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_11, -13, SpringLayout.NORTH, panel_7);
		panel.add(panel_11);
		panel_11.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel("\uD0A4\uC6CC\uB4DC");
		lblNewLabel_6.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 17));
		panel_11.add(lblNewLabel_6, "name_1748658638845000");
		
		JPanel panel_12 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_12, 6, SpringLayout.SOUTH, panel_5);
		sl_panel.putConstraint(SpringLayout.WEST, panel_12, 566, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_12, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_12, 0, SpringLayout.EAST, panel_5);
		panel_12.setBackground(Color.WHITE);
		panel.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\small_cancle.png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 15));
		 // 기본 외곽선
		btnNewButton.setBorderPainted(false);
	      //클릭 했을때 테두리 사용 안함
		btnNewButton.setFocusPainted(false);
		
		panel_12.add(btnNewButton, "name_1750715125175200");

		// lb_bookname.setText(BookVO.getName());

	}
}
