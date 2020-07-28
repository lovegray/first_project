package VIEW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import DAO.DiaryDAO;

import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DiaryFinishGUI extends JDialog {
   // 책이름하고 별점, 총서평, 마지막 날짜 insert
   // 다이어리 넘버 받아오기.
   int diary_no;
   private final JPanel contentPanel = new JPanel();
   private JTextField textField;
   DiaryDAO dao = new DiaryDAO();
   private JButton okButton;

   /**
    * Launch the application.
    */
   public static void main(int diary_no) {
      try {
         DiaryFinishGUI dialog = new DiaryFinishGUI(diary_no);
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public DiaryFinishGUI(int diary_no) {
      this.diary_no = diary_no;
      setTitle("\uCE5C\uAD6C\uCC3E\uAE30");
      setBounds(100, 100, 639, 354);
      getContentPane().setLayout(new BorderLayout());
      SpringLayout sl_total = new SpringLayout();
      contentPanel.setBackground(Color.WHITE);
      contentPanel.setPreferredSize(new Dimension(630, 380));
      contentPanel.setLayout(sl_total);

      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);

      JPanel panel = new JPanel();
      sl_total.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPanel);
      sl_total.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, contentPanel);
      panel.setBackground(Color.WHITE);
      sl_total.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPanel);
      sl_total.putConstraint(SpringLayout.SOUTH, panel, 47, SpringLayout.NORTH, contentPanel);
      contentPanel.add(panel);
      panel.setLayout(new CardLayout(0, 0));

      String bookName = dao.searchBookname(diary_no);
      JLabel lblNewLabel = new JLabel("[ " + bookName + " ] 어떠셨나요?");
      lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 20));
      lblNewLabel.setBackground(Color.WHITE);
      panel.add(lblNewLabel, "name_27534579505700");

      JPanel panel_1 = new JPanel();
      sl_total.putConstraint(SpringLayout.NORTH, panel_1, 11, SpringLayout.SOUTH, panel);
      sl_total.putConstraint(SpringLayout.SOUTH, panel_1, -203, SpringLayout.SOUTH, contentPanel);
      panel_1.setBackground(Color.WHITE);
      sl_total.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, contentPanel);
      sl_total.putConstraint(SpringLayout.EAST, panel_1, 136, SpringLayout.WEST, contentPanel);
      contentPanel.add(panel_1);
      panel_1.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_1 = new JLabel("\uD3C9\uC810");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
      panel_1.add(lblNewLabel_1, "name_27569467138700");

      JPanel panel_2 = new JPanel();
      sl_total.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_1);
      sl_total.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel);
      sl_total.putConstraint(SpringLayout.SOUTH, panel_2, -127, SpringLayout.SOUTH, contentPanel);
      sl_total.putConstraint(SpringLayout.EAST, panel_2, -264, SpringLayout.EAST, contentPanel);
      panel_2.setBackground(Color.WHITE);
      contentPanel.add(panel_2);
      panel_2.setLayout(new CardLayout(0, 0));

      JSlider slider = new JSlider(1, 5);
      slider.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 16));
      slider.setBackground(Color.WHITE);
      panel_2.add(slider, "rate");
      slider.setMajorTickSpacing(1);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);

      JPanel panel_3 = new JPanel();
      sl_total.putConstraint(SpringLayout.NORTH, panel_3, 5, SpringLayout.SOUTH, panel_2);
      sl_total.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, contentPanel);
      sl_total.putConstraint(SpringLayout.SOUTH, panel_3, -85, SpringLayout.SOUTH, contentPanel);
      sl_total.putConstraint(SpringLayout.EAST, panel_3, -477, SpringLayout.EAST, contentPanel);
      panel_3.setBackground(Color.WHITE);
      contentPanel.add(panel_3);
      panel_3.setLayout(new CardLayout(0, 0));

      JLabel lblNewLabel_2 = new JLabel("\uCD1D \uC11C\uD3C9");
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
      panel_3.add(lblNewLabel_2, "name_27852684353800");

      JPanel panel_4 = new JPanel();
      sl_total.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_3);
      sl_total.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel);
      sl_total.putConstraint(SpringLayout.EAST, panel_4, 603, SpringLayout.WEST, contentPanel);
      contentPanel.add(panel_4);
      panel_4.setLayout(new CardLayout(0, 0));

      textField = new JTextField();

      panel_4.add(textField, "name_28001912907500");
      textField.setColumns(10);
      {
         okButton = new JButton("");
         sl_total.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, okButton);
         sl_total.putConstraint(SpringLayout.WEST, okButton, 523, SpringLayout.WEST, contentPanel);
         sl_total.putConstraint(SpringLayout.NORTH, okButton, 279, SpringLayout.NORTH, contentPanel);
         okButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\small_check.png"));
         okButton.setBackground(Color.WHITE);
         contentPanel.add(okButton);
         okButton.addMouseListener(new MouseAdapter() {
            @Override // 확인버튼 눌렀을 때요.
            public void mouseClicked(MouseEvent e) {
               // 별점 값
               int rate = slider.getValue();
               // 리뷰
               String contents = textField.getText();
               dao.lastUpdateDiary(contents, rate, diary_no);
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
         sl_total.putConstraint(SpringLayout.EAST, okButton, -6, SpringLayout.WEST, cancelButton);
         sl_total.putConstraint(SpringLayout.NORTH, cancelButton, 6, SpringLayout.SOUTH, panel_4);
         sl_total.putConstraint(SpringLayout.WEST, cancelButton, 567, SpringLayout.WEST, contentPanel);
         sl_total.putConstraint(SpringLayout.EAST, cancelButton, -10, SpringLayout.EAST, contentPanel);
         cancelButton.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\small_s_cancle.png"));
         cancelButton.setBackground(Color.WHITE);
         contentPanel.add(cancelButton);
         cancelButton.addMouseListener(new MouseAdapter() {
         	@Override
         	public void mouseClicked(MouseEvent arg0) {
         		dispose();
         	}
         });
         // 기본 외곽선
         cancelButton.setBorderPainted(false);
      	//클릭 했을때 테두리 사용 안함
         cancelButton.setFocusPainted(false);
         cancelButton.setActionCommand("Cancel");
      }
   }
}