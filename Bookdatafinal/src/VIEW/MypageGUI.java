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

import DAO.DbConnection;
import DAO.DiaryDAO;
import DAO.FriendDiaryDAO;
import DAO.VisitDAO;
import VO.Book_diaryVO;
import VO.Book_diary_finishVO;
import VO.FriendDiaryVO;
import VO.Guest_boardVO;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class MypageGUI {
   // private DbConnection dao = new VisitDAO();

   private JFrame frame;
   static DefaultListModel<String> model;
   private JTextField tf_search_diary;
   private String id;
   FriendDiaryDAO f_d_dao = new FriendDiaryDAO();
   VisitDAO v_dao = new VisitDAO();
   DiaryDAO d_dao = new DiaryDAO();

   /**
    * Launch the application.
    */
   public static void main(String id) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {

               MypageGUI window = new MypageGUI(id);
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
   public MypageGUI(String id) {
      this.id = id;
      initialize();

   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 675, 645);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      SpringLayout panel_1 = new SpringLayout();
      panel.setLayout(panel_1);
      frame.getContentPane().add(panel, BorderLayout.CENTER);

      JPanel panel_2 = new JPanel();
      panel_2.setBorder(null);
      panel_1.putConstraint(SpringLayout.WEST, panel_2, 35, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 58, SpringLayout.NORTH, panel);
      panel_2.setBackground(new Color(255, 255, 255));
      panel.add(panel_2);

      JPanel panel_3 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_3, 28, SpringLayout.SOUTH, panel_2);
      panel_3.setBackground(new Color(255, 255, 255));
      panel.add(panel_3);

      JPanel panel_4 = new JPanel();
      panel_1.putConstraint(SpringLayout.WEST, panel_4, 35, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -4, SpringLayout.NORTH, panel_4);
      panel_1.putConstraint(SpringLayout.NORTH, panel_4, 112, SpringLayout.NORTH, panel);
      panel_3.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel = new JLabel("\uC9C4\uD589\uC911\uC778 \uB3C4\uC11C");
      lblNewLabel.setForeground(new Color(47, 79, 79));
      lblNewLabel.setBackground(new Color(255, 255, 255));
      lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
      panel_3.add(lblNewLabel, "name_1238126486013900");
      panel.add(panel_4);

      JPanel panel_5 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_5, 19, SpringLayout.SOUTH, panel_4);
      panel_5.setBackground(new Color(255, 255, 255));
      panel_4.setLayout(new CardLayout(0, 0));
      SpringLayout sl_panel_2 = new SpringLayout();
      panel_2.setLayout(sl_panel_2);
      panel.add(panel_5);

      JPanel panel_6 = new JPanel();
      panel_1.putConstraint(SpringLayout.WEST, panel_6, 35, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -6, SpringLayout.NORTH, panel_6);

      JList list_2 = new JList();
      list_2.setForeground(new Color(102, 102, 102));
      list_2.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      list_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), null, new Color(128, 128, 128), null));
      panel_4.add(list_2, "name_1239491851881400");

      // 진행중 도서

      ArrayList<Book_diaryVO> arr = d_dao.selectAllbookNow(id);

      model = new DefaultListModel<String>();
      // 출력할 내용 책이름 작가명 진행퍼센트 최근읽은 날짜
      for (int i = 0; i < arr.size(); i++) {
         String contents = d_dao.searchBookname(arr.get(i).getDiary_no()) + "      " + arr.get(i).getProgress()
               + "%   " + arr.get(i).getRecent_date();
         
         model.addElement(contents);

      }
      list_2.setModel(model);

      // 두번 클릭해서 다이어리 들어가기
      list_2.addMouseListener(new MouseAdapter() {

        

         public void mouseClicked(MouseEvent evt) {
            JList list = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {

               // Double-click detected
               int index = list.locationToIndex(evt.getPoint());
               System.out.println("진행 확인다이어리 번호 : " + arr.get(index).getDiary_no());

               DiaryNow.main(arr.get(index).getDiary_no());
               frame.dispose();
            } else if (evt.getClickCount() == 3) {

               // Triple-click detected
               int index = list.locationToIndex(evt.getPoint());
            }
         }
      });

      //
      panel_5.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_1 = new JLabel("\uC644\uB3C5 \uB3C4\uC11C");
      lblNewLabel_1.setForeground(new Color(105, 105, 105));
      lblNewLabel_1.setBackground(new Color(255, 255, 255));
      lblNewLabel_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 17));
      panel_5.add(lblNewLabel_1, "name_1238212064423600");
      panel.add(panel_6);

      panel_6.setLayout(new CardLayout(0, 0));

      JList list_1 = new JList();
      // 리스트 스크롤 기능 추가
      // JScrollPane scroll2 = new JScrollPane(list_1);

      JList list = new JList();
      // panel.add(list);
      // panel_4.add(list, "name_1237447547328300");

      JPanel panel_7 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_7, 20, SpringLayout.SOUTH, panel_6);
      panel_1.putConstraint(SpringLayout.WEST, panel_7, 0, SpringLayout.WEST, panel_3);
      panel_1.putConstraint(SpringLayout.EAST, panel_7, -518, SpringLayout.EAST, panel);
      panel_7.setBackground(new Color(255, 255, 255));

      JList list_6 = new JList();
      list_6.setForeground(new Color(102, 102, 102));
      list_6.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      list_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(220, 220, 220), null, new Color(169, 169, 169), null));
      panel_6.add(list_6, "name_1238605725713800");
      JScrollPane scroll2 = new JScrollPane(list_6);
      panel_6.add(scroll2, "Center"); // JScrooPane에 담은 JList를 나타내기 위해 배치한다.

      // 완독도서

      ArrayList<FriendDiaryVO> final_book = f_d_dao.selectAllbook(id);

      model = new DefaultListModel<String>();
      for (int i = 0; i < final_book.size(); i++) {
         model.addElement(final_book.get(i).getDate() + "          " + final_book.get(i).getBookName() + "          "
               + final_book.get(i).getWriter() + "          " + final_book.get(i).getRate());

         // System.out.println(final_book.get(i).getBookName() +
         // final_book.get(i).getWriter() + final_book.get(i).getDate()
         // + final_book.get(i).getRate());

      }
      list_6.setModel(model);

      // 두번 클릭해서 다이어리 들어가기
      list_6.addMouseListener(new MouseAdapter() {

         ArrayList<FriendDiaryVO> friendVO = f_d_dao.selectAllbook(id);

         public void mouseClicked(MouseEvent evt) {
            JList list = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {

               // Double-click detected
               int index = list.locationToIndex(evt.getPoint());
               System.out.println("확인다이어리 번호 : " + friendVO.get(index).getDiary_no());

               Finished_Diary.main(friendVO.get(index).getDiary_no());
               System.out.println(friendVO.get(index).getDiary_no());
            } else if (evt.getClickCount() == 3) {

               // Triple-click detected
               int index = list.locationToIndex(evt.getPoint());
            }
         }
      });
      panel.add(panel_7);
      panel_7.setLayout(new CardLayout(0, 0));

      JLabel label = new JLabel("\uBC1C\uC790\uCDE8 ");
      label.setForeground(new Color(105, 105, 105));
      label.setBackground(new Color(255, 255, 255));
      label.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 17));
      panel_7.add(label, "name_1238265130136600");

      JPanel panel_8 = new JPanel();
      panel_1.putConstraint(SpringLayout.SOUTH, panel_7, -6, SpringLayout.NORTH, panel_8);
      panel_1.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel_4);
      panel_1.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.WEST, panel_2);
      panel_1.putConstraint(SpringLayout.NORTH, panel_8, 464, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_8, -41, SpringLayout.SOUTH, panel);
      panel.add(panel_8);
      panel_8.setLayout(new CardLayout(0, 0));

      JList list_8 = new JList();
      list_8.setForeground(new Color(102, 102, 102));
      list_8.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      list_8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, new Color(169, 169, 169), null));
      panel_8.add(list_8, "name_1238603101359300");
      // 발자취 추가

      // 방명록 리스트 불러오기
      ArrayList<Guest_boardVO> result = v_dao.mySelectVisit(id);

      model = new DefaultListModel<String>();

      for (int i = 0; i < result.size(); i++) {
         model.addElement(result.get(i).getFriend() + "          " + result.get(i).getContents() + "          "
               + result.get(i).getDate().toString());
      }
      list_8.setModel(model);
      // 리스트 스크롤 기능 추가
      JScrollPane scroll = new JScrollPane(list_8);

      panel_8.add(scroll, "Center"); // JScrooPane에 담은 JList를 나타내기 위해 배치한다.

      JPanel panel_9 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_9, 25, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_9, -548, SpringLayout.SOUTH, panel);
      panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_9);
      panel_1.putConstraint(SpringLayout.EAST, panel_2, -32, SpringLayout.WEST, panel_9);
      panel_1.putConstraint(SpringLayout.WEST, panel_9, -351, SpringLayout.EAST, panel);
      panel.add(panel_9);

      JPanel panel_10 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_10, 25, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.WEST, panel_10, 604, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_10, -24, SpringLayout.EAST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_9, 0, SpringLayout.WEST, panel_10);
      panel_10.setBackground(new Color(255, 255, 255));
      panel_9.setLayout(new CardLayout(0, 0));

      tf_search_diary = new JTextField();
      panel_9.add(tf_search_diary, "name_1239705835097600");
      tf_search_diary.setColumns(10);
      panel.add(panel_10);
      panel_10.setLayout(new CardLayout(0, 0));

      JButton btnNewButton_1 = new JButton("");
      btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\searchicon1.png"));
      btnNewButton_1.setForeground(new Color(255, 255, 255));
      btnNewButton_1.setBackground(new Color(255, 255, 255));
      btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      panel_10.add(btnNewButton_1, "name_1239686026994800");
      // 기본 외곽선
      btnNewButton_1.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btnNewButton_1.setFocusPainted(false);

      JPanel panel_11 = new JPanel();
      panel_1.putConstraint(SpringLayout.EAST, panel_6, -29, SpringLayout.WEST, panel_11);
      panel_1.putConstraint(SpringLayout.EAST, panel_5, -409, SpringLayout.WEST, panel_11);
      panel_1.putConstraint(SpringLayout.EAST, panel_4, -29, SpringLayout.WEST, panel_11);
      panel_1.putConstraint(SpringLayout.NORTH, panel_11, 0, SpringLayout.NORTH, panel_4);
      panel_1.putConstraint(SpringLayout.WEST, panel_11, 573, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_11, -219, SpringLayout.SOUTH, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_11, 0, SpringLayout.EAST, panel_10);
      panel_11.setBackground(new Color(255, 255, 255));
      panel.add(panel_11);

      JButton bt_wishList = new JButton("");
      bt_wishList.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent arg0) {///마우스대면 변함
            bt_wishList.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\wishlist_W.PNG"));
         }
         @Override
         public void mouseExited(MouseEvent e) {//마우스빼면 원래대로
            bt_wishList.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\wishlist.PNG"));
         }
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		WishListGUI.main(id);
      	}
      });
      bt_wishList.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\wishlist.PNG"));
      bt_wishList.setForeground(new Color(47, 79, 79));
      bt_wishList.setBackground(new Color(255, 255, 255));
      bt_wishList.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      // 기본 외곽선
      bt_wishList.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      bt_wishList.setFocusPainted(false);
      bt_wishList.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      SpringLayout sl_panel_11 = new SpringLayout();
      sl_panel_11.putConstraint(SpringLayout.NORTH, bt_wishList, 0, SpringLayout.NORTH, panel_11);
      sl_panel_11.putConstraint(SpringLayout.WEST, bt_wishList, 0, SpringLayout.WEST, panel_11);
      sl_panel_11.putConstraint(SpringLayout.SOUTH, bt_wishList, -214, SpringLayout.SOUTH, panel_11);
      sl_panel_11.putConstraint(SpringLayout.EAST, bt_wishList, 0, SpringLayout.EAST, panel_11);
      panel_11.setLayout(sl_panel_11);
      panel_11.add(bt_wishList);

      JButton bt_friend_list = new JButton("");
      sl_panel_11.putConstraint(SpringLayout.NORTH, bt_friend_list, 46, SpringLayout.SOUTH, bt_wishList);
      sl_panel_11.putConstraint(SpringLayout.WEST, bt_friend_list, 0, SpringLayout.WEST, bt_wishList);
      sl_panel_11.putConstraint(SpringLayout.EAST, bt_friend_list, 0, SpringLayout.EAST, bt_wishList);
      bt_friend_list.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\friendlist2.PNG"));
      bt_friend_list.setForeground(new Color(47, 79, 79));
      bt_friend_list.setBackground(new Color(255, 255, 255));
      bt_friend_list.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      // 기본 외곽선
      bt_friend_list.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      bt_friend_list.setFocusPainted(false);
      bt_friend_list.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            friend_search.main(id);
         }
         @Override
         public void mouseEntered(MouseEvent e) {//마우스대면 변함
            bt_friend_list.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\friendlist2_W.PNG"));
         }
         @Override
         public void mouseExited(MouseEvent e) {//마우스빼면 원래대로
            bt_friend_list.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\friendlist2.PNG"));
         }
      });
      panel_11.add(bt_friend_list);

      JButton bt_new_book = new JButton("");
      sl_panel_11.putConstraint(SpringLayout.NORTH, bt_new_book, 209, SpringLayout.NORTH, panel_11);
      sl_panel_11.putConstraint(SpringLayout.SOUTH, bt_new_book, 0, SpringLayout.SOUTH, panel_11);
      sl_panel_11.putConstraint(SpringLayout.SOUTH, bt_friend_list, -41, SpringLayout.NORTH, bt_new_book);
      sl_panel_11.putConstraint(SpringLayout.EAST, bt_new_book, 0, SpringLayout.EAST, bt_wishList);
      sl_panel_11.putConstraint(SpringLayout.WEST, bt_new_book, 0, SpringLayout.WEST, bt_wishList);
      bt_new_book.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\readingnewbook4.png"));
      bt_new_book.setForeground(new Color(47, 79, 79));
      bt_new_book.setBackground(new Color(255, 255, 255));
      bt_new_book.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      // 기본 외곽선
      bt_new_book.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      bt_new_book.setFocusPainted(false);
      bt_new_book.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            NewdiaryGUI.main(id);
            frame.dispose();
         }
         @Override
         public void mouseEntered(MouseEvent e) {//마우스대면 변함
            bt_new_book.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\readingnewbook4_W.png"));
         }
         @Override
         public void mouseExited(MouseEvent e) {//마우스대면 원래대로
            bt_new_book.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\readingnewbook4.png"));
         }
      });
      panel_11.add(bt_new_book);
      
      JLabel label_1 = new JLabel("");
      panel_1.putConstraint(SpringLayout.NORTH, label_1, 422, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_6, -6, SpringLayout.NORTH, label_1);
      panel_1.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, panel_2);
      label_1.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\footboradSMAL.PNG"));
      panel.add(label_1);
      
      JLabel lblNewLabel_2 = new JLabel("");
      panel_1.putConstraint(SpringLayout.WEST, panel_5, 5, SpringLayout.EAST, lblNewLabel_2);
      panel_1.putConstraint(SpringLayout.NORTH, panel_6, 4, SpringLayout.SOUTH, lblNewLabel_2);
      panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 236, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, lblNewLabel_2);
      panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, panel_2);
      lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\readingbookSMAL.PNG"));
      panel.add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("");
      panel_1.putConstraint(SpringLayout.WEST, panel_3, 6, SpringLayout.EAST, lblNewLabel_3);
      panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_3, -586, SpringLayout.EAST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, panel_3);
      lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\reading completeSMAL.PNG"));
      
      JLabel lblNewLabel_4 = new JLabel("\uB2D8\uC758 \uB2E4\uC774\uC5B4\uB9AC");
      lblNewLabel_4.setForeground(new Color(47, 79, 79));
      sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, panel_2);
      sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, panel_2);
      sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, panel_2);
      lblNewLabel_4.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 24));
      panel_2.add(lblNewLabel_4);
      
      JPanel panel_12 = new JPanel();
      panel_12.setBackground(new Color(255, 255, 255));
      sl_panel_2.putConstraint(SpringLayout.NORTH, panel_12, 0, SpringLayout.NORTH, lblNewLabel_4);
      sl_panel_2.putConstraint(SpringLayout.WEST, panel_12, 0, SpringLayout.WEST, panel_2);
      sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_12, 0, SpringLayout.SOUTH, lblNewLabel_4);
      sl_panel_2.putConstraint(SpringLayout.EAST, panel_12, -10, SpringLayout.WEST, lblNewLabel_4);
      panel_2.add(panel_12);
      SpringLayout sl_panel_12 = new SpringLayout();
      panel_12.setLayout(sl_panel_12);
      
      
      
      JLabel lblNewLabel_5 = new JLabel(login.now_id);
      lblNewLabel_5.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 20));
      lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
      sl_panel_12.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, panel_12);
      sl_panel_12.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, panel_12);
      sl_panel_12.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 33, SpringLayout.NORTH, panel_12);
      sl_panel_12.putConstraint(SpringLayout.EAST, lblNewLabel_5, 99, SpringLayout.WEST, panel_12);
      panel_12.add(lblNewLabel_5);
      panel.add(lblNewLabel_3);
      
      JLabel lblMenu = new JLabel("MENU");
      panel_1.putConstraint(SpringLayout.SOUTH, panel_10, -12, SpringLayout.NORTH, lblMenu);
      panel_1.putConstraint(SpringLayout.EAST, panel_3, -386, SpringLayout.WEST, lblMenu);
      panel_1.putConstraint(SpringLayout.NORTH, lblMenu, 0, SpringLayout.NORTH, lblNewLabel_3);
      panel_1.putConstraint(SpringLayout.EAST, lblMenu, -26, SpringLayout.EAST, panel);
      lblMenu.setForeground(new Color(47, 79, 79));
      lblMenu.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
      panel.add(lblMenu);
      // 리스트 스크롤 기능 추가
      // JScrollPane scroll3 = new JScrollPane(list_8);
      // panel_6.add(scroll3, "Center"); // JScrooPane에 담은 JList를 나타내기 위해 배치한다.

   }
}