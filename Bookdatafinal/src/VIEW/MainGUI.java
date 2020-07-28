package VIEW;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import DAO.BookDAO;
import DAO.DiaryDAO;
import DAO.FinalBook_diaryno_DAO;
import DAO.FinalDiaryDAO;
import VO.BestReviewVO;
import VO.BookVO;
import VO.MembersVO;

public class MainGUI extends JFrame {

   private JFrame frame;
   private JTextField tf_search;
   static BookDAO dao = new BookDAO();
   FinalDiaryDAO finalDao = new FinalDiaryDAO();
   FinalBook_diaryno_DAO diaryno_Dao = new FinalBook_diaryno_DAO();
   DiaryDAO diaryDao = new DiaryDAO();

   String id;

   /**
    * Launch the application.
    */
   public static void main(String id) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MainGUI window = new MainGUI(id);
               System.out.println(id);
               window.frame.setVisible(true);
               window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public MainGUI(String id) {
       this.id = id;
       initialize();
     
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);

      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel, 507, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel, 749, SpringLayout.WEST, frame.getContentPane());
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      frame.getContentPane().add(panel);

      JPanel combo = new JPanel();
      sl_panel.putConstraint(SpringLayout.WEST, combo, 118, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, combo, -360, SpringLayout.SOUTH, panel);
      panel.add(combo);

      JComboBox comboBox = new JComboBox();
      comboBox.setForeground(new Color(128, 128, 128));
      comboBox.setBackground(new Color(245, 245, 245));
      comboBox.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 15));
      comboBox.setModel(new DefaultComboBoxModel(new String[] { "전체" }));
      combo.add(comboBox);
      comboBox.addItem(new String("제목"));
      comboBox.addItem(new String("작가"));
      comboBox.addItem(new String("ISBN"));

      SpringLayout sl_combo = new SpringLayout();
      sl_combo.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, combo);
      sl_combo.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, combo);
      sl_combo.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, combo);
      sl_combo.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, combo);
      combo.setLayout(sl_combo);

      JPanel recommendTitle1 = new JPanel();
      sl_panel.putConstraint(SpringLayout.WEST, recommendTitle1, 31, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendTitle1, -21, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, recommendTitle1, -558, SpringLayout.EAST, panel);
      recommendTitle1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      recommendTitle1.setBackground(new Color(255, 255, 255));
      panel.add(recommendTitle1);

      JPanel recommendImage1 = new JPanel();
      sl_panel.putConstraint(SpringLayout.NORTH, recommendTitle1, 6, SpringLayout.SOUTH, recommendImage1);
      sl_panel.putConstraint(SpringLayout.WEST, recommendImage1, 31, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendImage1, -50, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, recommendImage1, -558, SpringLayout.EAST, panel);
      recommendImage1.setBackground(new Color(255, 255, 255));
      recommendImage1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      panel.add(recommendImage1);

      JPanel recommendImage2 = new JPanel();
      sl_panel.putConstraint(SpringLayout.WEST, recommendImage2, 16, SpringLayout.EAST, recommendImage1);
      recommendImage2.setBackground(new Color(255, 255, 255));
      recommendImage2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      panel.add(recommendImage2);

      JPanel recommendImage3 = new JPanel();
      sl_panel.putConstraint(SpringLayout.WEST, recommendImage3, 383, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, recommendImage2, -16, SpringLayout.WEST, recommendImage3);
      recommendImage3.setBackground(new Color(255, 255, 255));
      recommendImage3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      panel.add(recommendImage3);

      JPanel recommendImage4 = new JPanel();
      sl_panel.putConstraint(SpringLayout.EAST, recommendImage3, -18, SpringLayout.WEST, recommendImage4);
      sl_panel.putConstraint(SpringLayout.WEST, recommendImage4, 561, SpringLayout.WEST, panel);
      recommendImage4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      recommendImage4.setBackground(new Color(255, 255, 255));
      panel.add(recommendImage4);

      JButton mypageButton = new JButton("\uB9C8\uC774\uD398\uC774\uC9C0");
      sl_panel.putConstraint(SpringLayout.SOUTH, mypageButton, -464, SpringLayout.SOUTH, panel);
      mypageButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            // 마이페이지버튼을 클릭
            MypageGUI.main(id);

         }
      });
      mypageButton.setForeground(new Color(119, 136, 153));
      sl_panel.putConstraint(SpringLayout.NORTH, mypageButton, 10, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, mypageButton, -10, SpringLayout.EAST, panel);
      mypageButton.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 17));
      mypageButton.setBackground(Color.WHITE);
      panel.add(mypageButton);

      JTextField tf_search = new JTextField(10);
      sl_panel.putConstraint(SpringLayout.WEST, tf_search, 179, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, tf_search, -360, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, tf_search, -121, SpringLayout.EAST, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, combo, 0, SpringLayout.NORTH, tf_search);
      sl_panel.putConstraint(SpringLayout.EAST, combo, -6, SpringLayout.WEST, tf_search);

      tf_search.setForeground(new Color(105, 105, 105));
      panel.add(tf_search);
      tf_search.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 17));
      tf_search.setHorizontalAlignment(SwingConstants.LEFT);
      tf_search.setText("\uCC45 \uAC80\uC0C9");
      tf_search.setColumns(10);

      JLabel lblMyBookDiary = new JLabel("My Book Diary");
      sl_panel.putConstraint(SpringLayout.SOUTH, lblMyBookDiary, -414, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, tf_search, 21, SpringLayout.SOUTH, lblMyBookDiary);
      sl_panel.putConstraint(SpringLayout.NORTH, lblMyBookDiary, 39, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, lblMyBookDiary, 0, SpringLayout.WEST, recommendImage2);
      lblMyBookDiary.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent arg0) {
            lblMyBookDiary.setForeground(new Color(105, 105, 105));
         }

         @Override
         public void mouseExited(MouseEvent e) {
            lblMyBookDiary.setForeground(new Color(119, 136, 153));
         }
      });
      lblMyBookDiary.setForeground(new Color(119, 136, 153));
      lblMyBookDiary.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 50));
      panel.add(lblMyBookDiary);

      JPanel bestreview = new JPanel();
      sl_panel.putConstraint(SpringLayout.NORTH, bestreview, 171, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, bestreview, -265, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, recommendImage3, 15, SpringLayout.SOUTH, bestreview);
      sl_panel.putConstraint(SpringLayout.NORTH, recommendImage2, 15, SpringLayout.SOUTH, bestreview);
      sl_panel.putConstraint(SpringLayout.NORTH, recommendImage4, 15, SpringLayout.SOUTH, bestreview);
      sl_panel.putConstraint(SpringLayout.NORTH, recommendImage1, 15, SpringLayout.SOUTH, bestreview);
      recommendImage1.setLayout(new CardLayout(0, 0));

      MembersVO memberVO = dao.recommendMember(login.now_id);
      System.out.println(memberVO.getKeyword_1());
      String MemberkeyWord1 = memberVO.getKeyword_1();// 로그인 당사자의 키워드1불러옴
      String MemberkeyWord2 = memberVO.getKeyword_2();// 로그인 당사자의 키워드2불러옴
      String MemberkeyWord3 = memberVO.getKeyword_3();// 로그인 당사자의 키워드3불러옴

      ArrayList<BookVO> recommend1 = dao.recommendKeywordBOOK(MemberkeyWord1);// 로그인 당사자의 키워드1에 해당하는 책의 0번째의 ISBN을
      long recoISBN1 = recommend1.get(0).getIsbn();
      ArrayList<BookVO> recommend2 = dao.recommendKeywordBOOK(MemberkeyWord2);// 로그인 당사자의 키워드2에 해당하는 책의 0번째의 ISBN을 //
                                                            // 불러옴.
      long recoISBN2 = recommend2.get(0).getIsbn();
      ArrayList<BookVO> recommend3 = dao.recommendKeywordBOOK(MemberkeyWord3);// 로그인 당사자의 키워드3에 해당하는 책의 0번째의 ISBN을
      long recoISBN3 = recommend3.get(0).getIsbn();
      ArrayList<BookVO> recommend4 = dao.recommendKeywordBOOK(MemberkeyWord1);// 로그인 당사자의 키워드1에 해당하는책의 1번째의 ISBN을
      long recoISBN4 = recommend4.get(1).getIsbn();

      ImageIcon resizeicon1 = new ImageIcon(
            "C:\\Users\\SAMSUNG\\Desktop\\Bookdatafinal\\image\\" + recoISBN1 + ".jpg");// 이미지주소
      Image resizeimage1 = resizeicon1.getImage(); // ImageIcon을 Image로 변환.
      Image resizeimageok1 = resizeimage1.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);

      ImageIcon resizeicon2 = new ImageIcon(
            "C:\\Users\\SAMSUNG\\Desktop\\Bookdatafinal\\image\\" + recoISBN2 + ".jpg");
      Image resizeimage2 = resizeicon2.getImage(); // ImageIcon을 Image로 변환.
      Image resizeimageok2 = resizeimage2.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);

      ImageIcon resizeicon3 = new ImageIcon(
            "C:\\Users\\SAMSUNG\\Desktop\\Bookdatafinal\\image\\" + recoISBN3 + ".jpg");
      Image resizeimage3 = resizeicon3.getImage(); // ImageIcon을 Image로 변환.
      Image resizeimageok3 = resizeimage3.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);

      ImageIcon resizeicon4 = new ImageIcon(
            "C:\\Users\\SAMSUNG\\Desktop\\Bookdatafinal\\image\\" + recoISBN4 + ".jpg");
      Image resizeimage4 = resizeicon4.getImage(); // ImageIcon을 Image로 변환.
      Image resizeimageok4 = resizeimage4.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);

      JLabel lblNewLabel_4 = new JLabel("New label");
      lblNewLabel_4.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
      lblNewLabel_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            BOOK_info.main(recoISBN1);
         }
      });
      lblNewLabel_4.setIcon(new ImageIcon(resizeimageok1));
      recommendImage1.add(lblNewLabel_4, "name_14875234766900");
      sl_panel.putConstraint(SpringLayout.EAST, recommendImage4, 0, SpringLayout.EAST, bestreview);
      bestreview.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Today Best Preview",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(119, 136, 153)));

      bestreview.setBackground(new Color(255, 255, 255));
      sl_panel.putConstraint(SpringLayout.WEST, bestreview, 28, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, bestreview, -28, SpringLayout.EAST, panel);
      panel.add(bestreview);
      SpringLayout sl_bestreview = new SpringLayout();
      bestreview.setLayout(sl_bestreview);

      JPanel bestreviewMemberName = new JPanel();
      bestreviewMemberName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      bestreviewMemberName.setBackground(new Color(255, 255, 255));
      sl_bestreview.putConstraint(SpringLayout.NORTH, bestreviewMemberName, 0, SpringLayout.NORTH, bestreview);
      sl_bestreview.putConstraint(SpringLayout.WEST, bestreviewMemberName, 10, SpringLayout.WEST, bestreview);
      sl_bestreview.putConstraint(SpringLayout.SOUTH, bestreviewMemberName, 37, SpringLayout.NORTH, bestreview);
      sl_bestreview.putConstraint(SpringLayout.EAST, bestreviewMemberName, 83, SpringLayout.WEST, bestreview);
      bestreview.add(bestreviewMemberName);

      JPanel bestreviewTitle = new JPanel();
      bestreviewTitle.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      bestreviewTitle.setBackground(new Color(255, 255, 255));
      sl_bestreview.putConstraint(SpringLayout.NORTH, bestreviewTitle, 0, SpringLayout.NORTH, bestreview);
      sl_bestreview.putConstraint(SpringLayout.WEST, bestreviewTitle, 6, SpringLayout.EAST, bestreviewMemberName);
      sl_bestreview.putConstraint(SpringLayout.SOUTH, bestreviewTitle, 37, SpringLayout.NORTH, bestreview);
      bestreviewMemberName.setLayout(new CardLayout(0, 0));

      JLabel lb_bestID = new JLabel("\uC544\uC774\uB514");
      lb_bestID.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 16));
      lb_bestID.setHorizontalAlignment(SwingConstants.CENTER);

      // 베스트 총 서평의 아이디
      int max = finalDao.selectMax().getDiary_like();
      BestReviewVO max_result = finalDao.searchMax(max);
      System.out.println("아이디 확인 : " + max_result.getMember_id());
      lb_bestID.setText(max_result.getMember_id());

      bestreviewMemberName.add(lb_bestID, "name_1656090070228200");
      bestreview.add(bestreviewTitle);
      bestreviewTitle.setLayout(new CardLayout(0, 0));

      JLabel lb_bestBook = new JLabel("\uCC45 \uC81C\uBAA9");
      lb_bestBook.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 16));
      lb_bestBook.setHorizontalAlignment(SwingConstants.CENTER);
      bestreviewTitle.add(lb_bestBook, "name_1656001017472300");

      // 베스트 총 서평의 책 제목
      System.out.println("확인1 : " + max_result.getDiary_no()); // 4
      diaryDao.searchBookname(max_result.getDiary_no());
      lb_bestBook.setText(diaryDao.searchBookname(max_result.getDiary_no()));

      JPanel panel_1 = new JPanel();
      sl_bestreview.putConstraint(SpringLayout.WEST, panel_1, 228, SpringLayout.WEST, bestreview);
      sl_bestreview.putConstraint(SpringLayout.EAST, bestreviewTitle, -6, SpringLayout.WEST, panel_1);
      panel_1.setBackground(Color.WHITE);
      sl_bestreview.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, bestreview);
      sl_bestreview.putConstraint(SpringLayout.SOUTH, panel_1, 37, SpringLayout.NORTH, bestreview);
      bestreview.add(panel_1);
      panel_1.setLayout(new CardLayout(0, 0));

      JLabel lb_bestReview = new JLabel("\uCD1D \uC11C\uD3C9");
      lb_bestReview.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 16));
      panel_1.add(lb_bestReview, "name_1655996720226700");

      // 베스트 서평
      lb_bestReview.setText(max_result.getReview());

      JPanel panel_2 = new JPanel();
      sl_bestreview.putConstraint(SpringLayout.WEST, panel_2, 568, SpringLayout.WEST, bestreview);
      sl_bestreview.putConstraint(SpringLayout.EAST, panel_1, -4, SpringLayout.WEST, panel_2);
      sl_bestreview.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, bestreview);
      sl_bestreview.putConstraint(SpringLayout.SOUTH, panel_2, 37, SpringLayout.NORTH, bestreview);
      sl_bestreview.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, bestreview);
      bestreview.add(panel_2);
      panel_2.setLayout(new CardLayout(0, 0));

      JButton btnNewButton = new JButton("\uB4E4\uC5B4\uAC00\uAE30");
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 15));
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            // 베스트로 가기
        	Finished_Diary.main(max_result.getDiary_no());

         }
      });
      panel_2.add(btnNewButton, "name_121809465420900");

      JPanel recommendTitle2 = new JPanel();
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendImage2, -6, SpringLayout.NORTH, recommendTitle2);
      sl_panel.putConstraint(SpringLayout.NORTH, recommendTitle2, 0, SpringLayout.NORTH, recommendTitle1);
      sl_panel.putConstraint(SpringLayout.WEST, recommendTitle2, 16, SpringLayout.EAST, recommendTitle1);
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendTitle2, -21, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, recommendTitle2, 0, SpringLayout.EAST, recommendImage2);
      recommendImage2.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_5 = new JLabel("New label");
      lblNewLabel_5.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
      lblNewLabel_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            BOOK_info.main(recoISBN2);
         }
      });
      lblNewLabel_5.setIcon(new ImageIcon(resizeimageok2));
      recommendImage2.add(lblNewLabel_5, "name_14881491947500");
      recommendTitle2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      recommendTitle2.setBackground(new Color(255, 255, 255));
      panel.add(recommendTitle2);

      JPanel recommendTitle3 = new JPanel();
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendImage3, -6, SpringLayout.NORTH, recommendTitle3);
      recommendImage3.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_6 = new JLabel("New label");
      lblNewLabel_6.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
      lblNewLabel_6.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            BOOK_info.main(recoISBN3);
         }
      });
      lblNewLabel_6.setIcon(new ImageIcon(resizeimageok3));
      recommendImage3.add(lblNewLabel_6, "name_14887546818800");
      sl_panel.putConstraint(SpringLayout.NORTH, recommendTitle3, 0, SpringLayout.NORTH, recommendTitle1);
      sl_panel.putConstraint(SpringLayout.WEST, recommendTitle3, 16, SpringLayout.EAST, recommendTitle2);
      recommendTitle2.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_1 = new JLabel(recommend2.get(0).getBook_name());
      lblNewLabel_1.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      recommendTitle2.add(lblNewLabel_1, "name_14715792856900");
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendTitle3, -21, SpringLayout.SOUTH, panel);
      recommendTitle3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      recommendTitle3.setBackground(new Color(255, 255, 255));
      panel.add(recommendTitle3);

      JPanel recommendTitle4 = new JPanel();
      sl_panel.putConstraint(SpringLayout.EAST, recommendTitle3, -18, SpringLayout.WEST, recommendTitle4);
      recommendTitle3.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_2 = new JLabel(recommend3.get(0).getBook_name());
      lblNewLabel_2.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      recommendTitle3.add(lblNewLabel_2, "name_14723601534600");
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendImage4, -6, SpringLayout.NORTH, recommendTitle4);
      sl_panel.putConstraint(SpringLayout.NORTH, recommendTitle4, 0, SpringLayout.NORTH, recommendTitle1);
      recommendTitle1.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel = new JLabel(recommend1.get(0).getBook_name());
      lblNewLabel.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      recommendTitle1.add(lblNewLabel, "name_14708712564900");
      sl_panel.putConstraint(SpringLayout.WEST, recommendTitle4, 0, SpringLayout.WEST, recommendImage4);
      recommendImage4.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_7 = new JLabel("New label");
      lblNewLabel_7.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
      lblNewLabel_7.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            BOOK_info.main(recoISBN4);
         }
      });
      lblNewLabel_7.setIcon(new ImageIcon(resizeimageok4));
      recommendImage4.add(lblNewLabel_7, "name_14893459513400");
      sl_panel.putConstraint(SpringLayout.SOUTH, recommendTitle4, -21, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, recommendTitle4, -28, SpringLayout.EAST, panel);
      recommendTitle4.setBackground(new Color(255, 255, 255));
      recommendTitle4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(245, 245, 245), null));
      panel.add(recommendTitle4);
      recommendTitle4.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_3 = new JLabel(recommend4.get(1).getBook_name());
      lblNewLabel_3.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      recommendTitle4.add(lblNewLabel_3, "name_14730277146500");

      JLabel search_click = new JLabel("");
      sl_panel.putConstraint(SpringLayout.WEST, mypageButton, 0, SpringLayout.WEST, search_click);
      sl_panel.putConstraint(SpringLayout.NORTH, search_click, 114, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, search_click, 614, SpringLayout.WEST, panel);
      search_click.setBackground(new Color(255, 255, 255));
      search_click.setIcon(new ImageIcon("C:\\Users\\smhrd\\Desktop\\book\uB370\uC774\uD130\\eeeeee.png"));
      panel.add(search_click);
      frame.setBounds(100, 100, 765, 546);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Action action = new AbstractAction() { //// 엔터치면 검색시작//
         @Override
         public void actionPerformed(ActionEvent e) {

            String cB = (String) comboBox.getSelectedItem();
            System.out.println("some action");

            if (cB.equals("제목")) {
               String searchBook_name = "";
               searchBook_name = tf_search.getText();
               SeartListGUI.main(searchBook_name, "제목");

            } else if (cB.equals("작가")) {
               String searchWriter = "";
               searchWriter = tf_search.getText();
               SeartListGUI.main(searchWriter, "작가");

            } else if (cB.equals("ISBN")) {
               String searchISBN = tf_search.getText();
               SeartListGUI.main(searchISBN, "isbn");
            } else if (cB.equals("전체")) {
               String allsearch = tf_search.getText();
               SeartListGUI.main(allsearch, "전체");
            }

         }
      };
      tf_search.addActionListener(action);
      //// 엔터치면 검색시작//

   }

}