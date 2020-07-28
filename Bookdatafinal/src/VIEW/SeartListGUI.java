package VIEW;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import DAO.BookDAO;
import VO.BookVO;
public class SeartListGUI extends JDialog {
   private final JPanel contentPanel = new JPanel();
   private JPanel panel_1;
   private JTextField textField;
       static DefaultListModel<String> model = new DefaultListModel<String>();
     String search;
     String type;
     BookDAO dao = new BookDAO();
     ArrayList<BookVO> searchResult = new ArrayList<BookVO>();
   /**
    * Launch the application.
    */
   public static void main(String search, String type) {
           try {
                SeartListGUI dialog = new SeartListGUI(search, type);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
           } catch (Exception e) {
                e.printStackTrace();
           }
     }
   /**
    * Create the dialog.
    */
   public SeartListGUI(String search, String type) {
           this.search = search;
           this.type = type;
      setTitle("\uB3C4\uC11C\uAC80\uC0C9\uB9AC\uC2A4\uD2B8");
      setBounds(100, 100, 665, 418);
     
      getContentPane().setLayout(new BorderLayout());
      SpringLayout springLayout = new SpringLayout();
      SpringLayout sl_contentPanel = new SpringLayout();
      contentPanel.setBackground(Color.WHITE);
      contentPanel.setLayout(sl_contentPanel);
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      {
         panel_1 = new JPanel();
         sl_contentPanel.putConstraint(SpringLayout.NORTH, panel_1, 14, SpringLayout.NORTH, contentPanel);
         sl_contentPanel.putConstraint(SpringLayout.WEST, panel_1, 216, SpringLayout.WEST, contentPanel);
         sl_contentPanel.putConstraint(SpringLayout.EAST, panel_1, -175, SpringLayout.EAST, contentPanel);
         panel_1.setBackground(Color.WHITE);
         contentPanel.add(panel_1);
      }
     
      JPanel panel = new JPanel();
      panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(105, 105, 105), null, new Color(211, 211, 211), null));
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel_1, -19, SpringLayout.NORTH, panel);
      sl_contentPanel.putConstraint(SpringLayout.WEST, panel, 105, SpringLayout.WEST, contentPanel);
      contentPanel.add(panel);
     
      JPanel panel_2 = new JPanel();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, panel_2, 75, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_2);
      sl_contentPanel.putConstraint(SpringLayout.EAST, panel, -6, SpringLayout.WEST, panel_2);
      sl_contentPanel.putConstraint(SpringLayout.WEST, panel_2, 514, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, panel_2, -90, SpringLayout.EAST, contentPanel);
      panel_2.setBackground(Color.WHITE);
      panel_1.setLayout(new CardLayout(0, 0));
     
      JLabel lblNewLabel = new JLabel("Search List");
      lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
      lblNewLabel.setForeground(new Color(0, 102, 153));
      lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 38));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      panel_1.add(lblNewLabel, "name_14009893698600");
      contentPanel.add(panel_2);
      panel_2.setLayout(new CardLayout(0, 0));
     
      JButton btnNewButton = new JButton("");
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent arg0) {
            btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\searchicon4.png"));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\searchicon3.png"));
         }
      });
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\searchicon3.png"));
      btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
      btnNewButton.setFont(new Font("궁서체", Font.PLAIN, 18));
      // 기본 외곽선
      btnNewButton.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btnNewButton.setFocusPainted(false);
      panel_2.add(btnNewButton, "name_14137806385400");
      panel.setLayout(new CardLayout(0, 0));
     
      textField = new JTextField();
      textField.setForeground(new Color(102, 102, 102));
      textField.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      panel.add(textField, "name_14088489211800");
      textField.setColumns(10);
     
      JPanel panel_3 = new JPanel();
      panel_3.setBorder(null);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel_2, -16, SpringLayout.NORTH, panel_3);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel, -16, SpringLayout.NORTH, panel_3);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, panel_3, 126, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.WEST, panel_3, 39, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel_3, -15, SpringLayout.SOUTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, panel_3, -34, SpringLayout.EAST, contentPanel);
      contentPanel.add(panel_3);
      panel_3.setLayout(new CardLayout(0, 0));
     
      JList list = new JList();
      list.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(112, 128, 144), null, new Color(248, 248, 255), null));
      list.setForeground(new Color(102, 102, 102));
      list.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 14));
      panel_3.add(list, "name_14919787741600");

//           // 타입에 따라서 리스트에 추가해주기
           // 책이름 ,작가이름 ,출판사 , 키워드,
           if (type.equals("전체")) {
                // 롱 타입으로 변환 하기
                try {
                     // 타입변환이 실패하면 스트링이므로 제목과 작가로 검색한다.
                     long isbn = Long.parseLong(search);
                     searchResult = dao.book_info_isbn(isbn);
                } catch (Exception e) {
                     searchResult = dao.book_info_all(search);
                     getSearchList(searchResult);
                } finally {
                     list.setModel(model);
                }
           } else if (type.equals("제목")) {
                searchResult = dao.book_info_name(search);
                getSearchList(searchResult);
                list.setModel(model);
           } else if (type.equals("작가")) {
                searchResult = dao.book_info_WRITER(search);
                getSearchList(searchResult);
                list.setModel(model);
           } else if (type.equals("isbn")) {
                // 롱 타입으로 변환 하기
                long isbn = Long.parseLong(search);
                searchResult = dao.book_info_isbn(isbn);
                getSearchList(searchResult);
                list.setModel(model);
           }


     
      JScrollPane scroll = new JScrollPane(list);
        
       panel_3.add(scroll ,"Center"); //JScrooPane에 담은 JList를 나타내기 위해 배치한다.
      

           btnNewButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                     String search1 = textField.getText();
                     searchInPage(search1);
                }
                public void searchInPage(String search1) {
                     // 텍스트필드값 받아와서 search에 저장
                     try {
                           long isbn = Long.parseLong(search1);
                           searchResult = dao.book_info_isbn(isbn);
                     } catch (Exception e) {
                           searchResult = dao.book_info_all(search1);
                           getSearchList(searchResult);
                     } finally {
                           list.setModel(model);
                     }
                }
           });
           
           list.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                     JList list = (JList) evt.getSource();
                     if (evt.getClickCount() == 2) {
                           // Double-click detected
                           int index = list.locationToIndex(evt.getPoint());
                           //System.out.println("index 확인이나 해보자 " + index);
                          BOOK_info.main(searchResult.get(index).getIsbn());
                     } else if (evt.getClickCount() == 3) {
                           // Triple-click detected
                           int index = list.locationToIndex(evt.getPoint());
                     
                     }
                }
           });


       JLabel lblNewLabel_1 = new JLabel("");
       sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -9, SpringLayout.NORTH, panel);
       sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, panel_1);
       lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\booksearch.PNG"));
       contentPanel.add(lblNewLabel_1);
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setBackground(new Color(255, 255, 255));
         springLayout.putConstraint(SpringLayout.SOUTH, buttonPane, 0, SpringLayout.SOUTH, getContentPane());
         springLayout.putConstraint(SpringLayout.EAST, buttonPane, -10, SpringLayout.EAST, getContentPane());
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("");
            okButton.setBackground(new Color(255, 255, 255));
            okButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\check.PNG"));
            okButton.setHorizontalTextPosition(SwingConstants.CENTER);
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            // 기본 외곽선
            okButton.setBorderPainted(false);
            //클릭 했을때 테두리 사용 안함
            okButton.setFocusPainted(false);
            getRootPane().setDefaultButton(okButton);
         }
         {
            JButton cancelButton = new JButton("");
            cancelButton.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		dispose();
            	}
            });
            cancelButton.setBackground(new Color(255, 255, 255));
            cancelButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdatafinal\\image\\cancle2.PNG"));
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
            // 기본 외곽선
            cancelButton.setBorderPainted(false);
            //클릭 했을때 테두리 사용 안함
            cancelButton.setFocusPainted(false);
         }
      }
   }

     private void getSearchList(ArrayList<BookVO> searchResult2) {
           model.clear();
           for (int i = 0; i < searchResult2.size(); i++) {
                BookVO vo = searchResult2.get(i);
                String contents = vo.getBook_name() + "|     |" + vo.getWriter() + "|     |" + vo.getPublisher() + "|     |"
                           + vo.getKeyword();
                model.addElement(contents);
           }
     }
}