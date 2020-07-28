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

import DAO.BookDAO;
import DAO.DiaryDAO;
import VO.BookVO;
import VO.Book_diaryVO;
import VO.Daily_book_diaryVO;
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
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class DiaryNow extends JDialog {
   String id = "test"; // 임의로 줌 나중에 연결하기
   private JFrame frame;
   private JTextField contentsInsert;
   private JTextField tf_nowPage;
   static DefaultListModel<String> model = new DefaultListModel<String>();
   int diary_no;
   int progress = 0;

   /**
    * Launch the application.
    */
   public static void main(int diary_no) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               // System.out.println("다이어리 번호 :" + diary_no);
               DiaryNow window = new DiaryNow(diary_no);
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
    */
   public DiaryNow(int diary_no) {
      this.diary_no = diary_no;

      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      DiaryDAO dao = new DiaryDAO();
      Book_diaryVO diaryVO = dao.selectDiary(diary_no);

      BookDAO b_dao = new BookDAO();
      BookVO bookVO = b_dao.book_info(diaryVO.getIsbn());
      frame = new JFrame();
      frame.setBounds(100, 100, 765, 546);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      System.out.println("진행률 : " + diaryVO.getProgress());
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      SpringLayout panel_1 = new SpringLayout();
      panel.setLayout(panel_1);
      frame.getContentPane().add(panel, BorderLayout.CENTER);
      
            JPanel panel_2 = new JPanel();
            panel_1.putConstraint(SpringLayout.NORTH, panel_2, 21, SpringLayout.NORTH, panel);
            panel_1.putConstraint(SpringLayout.WEST, panel_2, 234, SpringLayout.WEST, panel);
            panel_1.putConstraint(SpringLayout.EAST, panel_2, -240, SpringLayout.EAST, panel);
            panel_2.setBackground(new Color(255, 255, 255));
            panel.add(panel_2);
            panel_2.setLayout(new CardLayout(0, 0));
            
                  JLabel label = new JLabel(bookVO.getBook_name());
                  label.setForeground(new Color(105, 105, 105));
                  label.setHorizontalAlignment(SwingConstants.CENTER);
                  label.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 28));
                  panel_2.add(label, "name_2230088150661566");

      JPanel panel_3 = new JPanel();
      panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -17, SpringLayout.NORTH, panel_3);
      panel_1.putConstraint(SpringLayout.NORTH, panel_3, 75, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.WEST, panel_3, 56, SpringLayout.WEST, panel);
      panel_3.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(211, 211, 211)));
      panel_3.setBackground(new Color(255, 255, 255));
      panel.add(panel_3);

      JPanel panel_4 = new JPanel();
      panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -13, SpringLayout.NORTH, panel_4);
      panel_1.putConstraint(SpringLayout.EAST, panel_4, -382, SpringLayout.EAST, panel);
      panel_1.putConstraint(SpringLayout.WEST, panel_4, 56, SpringLayout.WEST, panel);
      panel_4.setBackground(new Color(255, 255, 255));
      panel_4.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(211, 211, 211)));
      panel_1.putConstraint(SpringLayout.NORTH, panel_4, 114, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -367, SpringLayout.SOUTH, panel);
      panel.add(panel_4);

      JPanel panel_5 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_5, 28, SpringLayout.SOUTH, panel_2);
      panel_1.putConstraint(SpringLayout.WEST, panel_5, 391, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -367, SpringLayout.SOUTH, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_5, -58, SpringLayout.EAST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_3, -24, SpringLayout.WEST, panel_5);
      panel_5.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
      panel_5.setBackground(new Color(255, 255, 255));
      panel.add(panel_5);
      panel_5.setLayout(new GridLayout(0, 3, 0, 0));
      
      JLabel label_3 = new JLabel("\uD604\uC7AC");
      label_3.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
      label_3.setForeground(new Color(47, 79, 79));
      label_3.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\progressicon.PNG"));
      panel_5.add(label_3);

      JLabel label_1 = new JLabel("\uC9C4\uD589\uB960");
      label_1.setForeground(new Color(47, 79, 79));
      label_1.setBackground(new Color(255, 255, 255));
      label_1.setHorizontalAlignment(SwingConstants.LEFT);
      label_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
      panel_5.add(label_1);

      JLabel lb_progress = new JLabel(diaryVO.getProgress() + " %");
      lb_progress.setForeground(new Color(47, 79, 79));
      lb_progress.setHorizontalAlignment(SwingConstants.CENTER);
      lb_progress.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 30));
      panel_5.add(lb_progress);

      JPanel panel_6 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_6, 17, SpringLayout.SOUTH, panel_4);
      panel_1.putConstraint(SpringLayout.WEST, panel_6, 56, SpringLayout.WEST, panel);
      panel_6.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(211, 211, 211)));
      panel_6.setBackground(new Color(255, 255, 255));
      panel_3.setLayout(new GridLayout(0, 2, 0, 0));

      JLabel lblNewLabel_1 = new JLabel("\uC77D\uAE30 \uC2DC\uC791\uD55C \uB0A0\uC9DC");
      lblNewLabel_1.setForeground(new Color(112, 128, 144));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
      lblNewLabel_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
      panel_3.add(lblNewLabel_1);

      JLabel lb_startdate = new JLabel(diaryVO.getStart_date() + "");
      lb_startdate.setForeground(new Color(105, 105, 105));
      lb_startdate.setHorizontalAlignment(SwingConstants.CENTER);
      lb_startdate.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
      panel_3.add(lb_startdate);
      panel.add(panel_6);
      panel_4.setLayout(new GridLayout(1, 0, 0, 0));

      JLabel label_2 = new JLabel("\uBAA9\uD45C \uB0A0\uC9DC");
      label_2.setForeground(new Color(112, 128, 144));
      label_2.setHorizontalAlignment(SwingConstants.RIGHT);
      label_2.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
      panel_4.add(label_2);

      JLabel lb_finaldate = new JLabel(diaryVO.getFinish_date() + "");
      lb_finaldate.setForeground(new Color(105, 105, 105));
      lb_finaldate.setHorizontalAlignment(SwingConstants.CENTER);
      lb_finaldate.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
      panel_4.add(lb_finaldate);

      JPanel panel_9 = new JPanel();
      panel_1.putConstraint(SpringLayout.SOUTH, panel_6, -17, SpringLayout.NORTH, panel_9);
      panel_1.putConstraint(SpringLayout.NORTH, panel_9, 200, SpringLayout.NORTH, panel);
      panel_9.setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
      panel_1.putConstraint(SpringLayout.WEST, panel_9, 280, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_9, 461, SpringLayout.WEST, panel);
      panel_9.setBackground(new Color(255, 255, 255));
      panel_6.setLayout(new GridLayout(0, 2, 0, 0));

      JLabel label_4 = new JLabel("\uCD5C\uADFC \uC77D\uC740 \uB0A0\uC9DC");
      label_4.setForeground(new Color(112, 128, 144));
      label_4.setHorizontalAlignment(SwingConstants.RIGHT);
      label_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      panel_6.add(label_4);

      JLabel lb_recent = new JLabel(diaryVO.getRecent_date() + "");
      lb_recent.setForeground(new Color(105, 105, 105));
      lb_recent.setHorizontalAlignment(SwingConstants.CENTER);
      lb_recent.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 18));
      panel_6.add(lb_recent);
      panel.add(panel_9);

      JPanel panel_10 = new JPanel();
      panel_1.putConstraint(SpringLayout.WEST, panel_10, 56, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_9, -6, SpringLayout.NORTH, panel_10);
      panel_1.putConstraint(SpringLayout.NORTH, panel_10, 243, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_10, -210, SpringLayout.SOUTH, panel);
      panel_10.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(112, 128, 144), null));
      SpringLayout sl_panel_9 = new SpringLayout();
      panel_9.setLayout(sl_panel_9);

      JLabel lblDaily = new JLabel("Daily record");
      sl_panel_9.putConstraint(SpringLayout.NORTH, lblDaily, 0, SpringLayout.NORTH, panel_9);
      sl_panel_9.putConstraint(SpringLayout.WEST, lblDaily, 0, SpringLayout.WEST, panel_9);
      sl_panel_9.putConstraint(SpringLayout.SOUTH, lblDaily, 37, SpringLayout.NORTH, panel_9);
      sl_panel_9.putConstraint(SpringLayout.EAST, lblDaily, 178, SpringLayout.WEST, panel_9);
      lblDaily.setForeground(new Color(105, 105, 105));
      lblDaily.setHorizontalAlignment(SwingConstants.CENTER);
      lblDaily.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 22));
      panel_9.add(lblDaily);
      panel.add(panel_10);

      JPanel panel_11 = new JPanel();
      panel_1.putConstraint(SpringLayout.WEST, panel_11, 637, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_11, -58, SpringLayout.EAST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_10, -21, SpringLayout.WEST, panel_11);
      panel_11.setBackground(Color.WHITE);
      panel.add(panel_11);

      JPanel panel_12 = new JPanel();
      panel_1.putConstraint(SpringLayout.SOUTH, panel_11, -18, SpringLayout.NORTH, panel_12);
      panel_1.putConstraint(SpringLayout.NORTH, panel_12, 18, SpringLayout.SOUTH, panel_10);
      panel_1.putConstraint(SpringLayout.WEST, panel_12, 56, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_12, -58, SpringLayout.EAST, panel);

      JButton btnNewButton = new JButton("");
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\write1.png"));
      btnNewButton.setForeground(Color.WHITE);
      btnNewButton.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btnNewButton.setFocusPainted(false);
      // 저장 버튼 누를때 이벤트(데일리 다이어리 추가)
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date = format1.format(System.currentTimeMillis());
            String contents = contentsInsert.getText();
            // model.addElement(date+" "+contents );
            model.add(0, date + "         " + contents);
            // daily 다이어리에 넣어줌~
            dao.updateDailyDiary(diary_no, contents);
            contentsInsert.setText(" ");
         }
      });
      SpringLayout sl_panel_11 = new SpringLayout();
      sl_panel_11.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, panel_11);
      sl_panel_11.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, panel_11);
      sl_panel_11.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, panel_11);
      sl_panel_11.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, panel_11);
      panel_11.setLayout(sl_panel_11);
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      panel_11.add(btnNewButton);
      SpringLayout sl_panel_10 = new SpringLayout();
      panel_10.setLayout(sl_panel_10);

      contentsInsert = new JTextField();
      contentsInsert.setForeground(new Color(102, 102, 102));
      sl_panel_10.putConstraint(SpringLayout.NORTH, contentsInsert, 0, SpringLayout.NORTH, panel_10);
      sl_panel_10.putConstraint(SpringLayout.WEST, contentsInsert, 0, SpringLayout.WEST, panel_10);
      sl_panel_10.putConstraint(SpringLayout.SOUTH, contentsInsert, 48, SpringLayout.NORTH, panel_10);
      sl_panel_10.putConstraint(SpringLayout.EAST, contentsInsert, 555, SpringLayout.WEST, panel_10);
      contentsInsert.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      contentsInsert.setHorizontalAlignment(SwingConstants.LEFT);
      panel_10.add(contentsInsert);
      contentsInsert.setColumns(10);
      panel.add(panel_12);

      JPanel panel_13 = new JPanel();
      panel_1.putConstraint(SpringLayout.SOUTH, panel_12, -6, SpringLayout.NORTH, panel_13);
      panel_1.putConstraint(SpringLayout.NORTH, panel_13, 452, SpringLayout.NORTH, panel);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_13, -7, SpringLayout.SOUTH, panel);
      panel_13.setBackground(new Color(255, 255, 255));
      panel_1.putConstraint(SpringLayout.WEST, panel_13, 224, SpringLayout.WEST, panel);
      panel_1.putConstraint(SpringLayout.EAST, panel_13, 498, SpringLayout.WEST, panel);

      JList list_dailyDiary = new JList();
      list_dailyDiary.setForeground(new Color(102, 102, 102));
      list_dailyDiary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, new Color(169, 169, 169), null));
      list_dailyDiary.setModel(new AbstractListModel() {
         String[] values = new String[] { "2019-11-31 \uC815\uB9D0\uB8E8 \uC7AC\uBBF8\uC788\uC5C8\uB2F9",
               "2019-11-25 \uC815\uB9D0 \uC7AC\uBC0C\uB2F9~~~~~~" };

         public int getSize() {
            return values.length;
         }

         public Object getElementAt(int index) {
            return values[index];
         }
      });
      list_dailyDiary.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      panel_12.add(list_dailyDiary, "name_2232392654534644");

      // 오늘의 기록
      // 데일리 다이어리 리스트 불러오기-->수정

      DiaryDAO d_dao = new DiaryDAO();
      ArrayList<Daily_book_diaryVO> result = d_dao.selectAlldaily(diary_no);

      model = new DefaultListModel<String>();

      for (int i = 0; i < result.size(); i++) {
         model.addElement(result.get(i).getReporting_date() + "         " + result.get(i).getContent());
      }
      SpringLayout sl_panel_12 = new SpringLayout();
      panel_12.setLayout(sl_panel_12);

      list_dailyDiary.setModel(model);
      // 리스트 스크롤 기능 추가
      JScrollPane scroll = new JScrollPane(list_dailyDiary);
      sl_panel_12.putConstraint(SpringLayout.NORTH, scroll, 0, SpringLayout.NORTH, panel_12);
      sl_panel_12.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, panel_12);
      sl_panel_12.putConstraint(SpringLayout.SOUTH, scroll, 131, SpringLayout.NORTH, panel_12);
      sl_panel_12.putConstraint(SpringLayout.EAST, scroll, 635, SpringLayout.WEST, panel_12);

      panel_12.add(scroll); // JScrooPane에 담은 JList를 나타내기 위해 배치한다.

      //

      panel.add(panel_13);

      JButton btnNewButton_1 = new JButton("");
      btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\check.PNG"));
      btnNewButton_1.setBackground(Color.WHITE);
      btnNewButton_1.setForeground(new Color(105, 105, 105));
      // 기본 외곽선
      btnNewButton_1.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btnNewButton_1.setFocusPainted(false);
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            // 진행율이 100일때와 100이하 일 때
            int page = Integer.parseInt(tf_nowPage.getText());
            if (page < bookVO.getTotal_page()) {
               progress = (int) (((float) page / bookVO.getTotal_page()) * 100.0);
            } else {
               progress = 100;
            }
            
            dao.updateDiary(diary_no, progress);
            
            
            //System.out.println("dairy now " + diary_no + " " + progress);
            
            if (progress >= 100) {
               // 서평과 별점 남기는 창으로 이동
               DiaryFinishGUI.main(diary_no);
               frame.dispose();
            } else {
               // 창 꺼주기
               frame.dispose();
            }

         }
      });
      SpringLayout sl_panel_13 = new SpringLayout();
      sl_panel_13.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, panel_13);
      sl_panel_13.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, panel_13);
      sl_panel_13.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, panel_13);
      sl_panel_13.putConstraint(SpringLayout.EAST, btnNewButton_1, 51, SpringLayout.WEST, panel_13);
      panel_13.setLayout(sl_panel_13);
      btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      panel_13.add(btnNewButton_1);

      JButton btnNewButton_2 = new JButton("");
      sl_panel_13.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, panel_13);
      sl_panel_13.putConstraint(SpringLayout.WEST, btnNewButton_2, 172, SpringLayout.EAST, btnNewButton_1);
      sl_panel_13.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, btnNewButton_1);
      sl_panel_13.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, panel_13);
      btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\cancle.PNG"));
      btnNewButton_2.setForeground(new Color(105, 105, 105));
      // 기본 외곽선
      btnNewButton_2.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btnNewButton_2.setFocusPainted(false);
      btnNewButton_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            frame.dispose();
            // dispose();
         }
      });
      btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      panel_13.add(btnNewButton_2);

      JPanel panel_7 = new JPanel();
      panel_1.putConstraint(SpringLayout.EAST, panel_6, -34, SpringLayout.WEST, panel_7);
      panel_1.putConstraint(SpringLayout.NORTH, panel_7, 6, SpringLayout.SOUTH, panel_5);
      panel_1.putConstraint(SpringLayout.WEST, panel_7, 10, SpringLayout.WEST, panel_5);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_7, 0, SpringLayout.SOUTH, panel_6);
      panel_1.putConstraint(SpringLayout.EAST, panel_7, -241, SpringLayout.EAST, panel);
      panel_7.setBackground(new Color(255, 255, 255));
      panel.add(panel_7);
      panel_7.setLayout(new CardLayout(0, 0));

      JLabel label_6 = new JLabel("\uD604\uC7AC \uD398\uC774\uC9C0");
      label_6.setForeground(new Color(112, 128, 144));
      panel_7.add(label_6, "name_2232883411482082");
      panel_1.putConstraint(SpringLayout.WEST, label_6, 117, SpringLayout.EAST, panel_9);
      panel_1.putConstraint(SpringLayout.SOUTH, label_6, 0, SpringLayout.SOUTH, panel_9);
      label_6.setHorizontalAlignment(SwingConstants.CENTER);
      label_6.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));

      JPanel panel_8 = new JPanel();
      panel_1.putConstraint(SpringLayout.NORTH, panel_11, 57, SpringLayout.SOUTH, panel_8);
      panel_1.putConstraint(SpringLayout.WEST, panel_8, 6, SpringLayout.EAST, panel_7);
      panel_1.putConstraint(SpringLayout.EAST, panel_8, -58, SpringLayout.EAST, panel);
      panel_1.putConstraint(SpringLayout.NORTH, panel_8, 6, SpringLayout.SOUTH, panel_5);
      panel_1.putConstraint(SpringLayout.SOUTH, panel_8, 0, SpringLayout.SOUTH, panel_6);
      panel_8.setBackground(new Color(255, 255, 255));
      panel.add(panel_8);

      tf_nowPage = new JTextField();
      int nowPage = (int) (bookVO.getTotal_page() * ((float) diaryVO.getProgress() / 100)) + 1;
      panel_8.setLayout(new GridLayout(0, 3, 0, 0));
      tf_nowPage.setText(nowPage + "");
      tf_nowPage.setHorizontalAlignment(SwingConstants.CENTER);
      tf_nowPage.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
      panel_8.add(tf_nowPage);
      tf_nowPage.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("/ "+bookVO.getTotal_page());
      lblNewLabel.setForeground(Color.GRAY);
      lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
      panel_8.add(lblNewLabel);
      
            JLabel lblPage = new JLabel(" page");
            lblPage.setForeground(Color.GRAY);
            lblPage.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 18));
            panel_8.add(lblPage);

      ArrayList<Daily_book_diaryVO> arr = dao.selectAlldaily(diary_no);
      for (int i = 0; i < arr.size(); i++) {
         System.out.println(arr.get(i).getContent());
      }
   }
}