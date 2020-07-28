package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DAO.MemberDao;
import VO.MembersVO;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;


public class login extends JDialog{
   static String now_id = "";
   MemberDao dao = new MemberDao();

   ResultSet rs;
   Connection con;
   PreparedStatement ps;

   private JFrame frame;
   private JTextField tf_ID;
   private JTextField tf_PW;
   private String InputID; // 입력받은
   private String InputPW;

   //private String id;
   //private String pw;
   //private String name;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               login window = new login();
               window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               window.frame.setVisible(true);
               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
      
      //System.out.println(id);
   }

   /**
    * Create the application.
    */
   public login() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 765, 546);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      frame.getContentPane().add(panel);

      JLabel lblBook = new JLabel("\uC9C0\uB2A5\uD615 BOOK\uB370\uC774\uD130");
      sl_panel.putConstraint(SpringLayout.NORTH, lblBook, 144, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, lblBook, 269, SpringLayout.WEST, panel);
      lblBook.setBackground(Color.WHITE);
      lblBook.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.BOLD, 23));
      lblBook.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(lblBook);

      JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
      btnNewButton.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         // 로그인버튼클릭시
         public void mouseClicked(MouseEvent arg0) {
            // 로그인창의 텍스트필드에 쓴값을 가져오기
            InputID = tf_ID.getText();
            InputPW = tf_PW.getText();
            
            String id = dao.selectMember(InputID, InputPW);
            System.out.println("아이디 넘어오는지 확인"+id);
            
            tf_ID.setText("");// 그러면 입력 후 추가하고, 이름쓰는 공간이 빈칸으로 되돌아감.
            tf_PW.setText("");

            /////////////////
            if (id!=null) {
            	now_id = id;
            	System.out.println("나우아이디확인"+now_id);
                JOptionPane.showMessageDialog(null, "환영합니다.");
                
               frame.dispose();
               MainGUI.main(id);
               
               
 
            }

         }
      });
      panel.add(btnNewButton);

      JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
      btnNewButton_1.setBackground(Color.WHITE);
      btnNewButton_1.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
      sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
      sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -20, SpringLayout.WEST, btnNewButton_1);
      sl_panel.putConstraint(SpringLayout.EAST, lblBook, 18, SpringLayout.EAST, btnNewButton_1);
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         // 회원가입 눌렀을 때, 회원가입 연결
         //////////////아직 덜 됨...
         @Override
         public void mouseClicked(MouseEvent e) {
        	 JoinGUI.main(null);
         }
      });
      panel.add(btnNewButton_1);

      tf_ID = new JTextField();
      tf_ID.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 17));
      sl_panel.putConstraint(SpringLayout.SOUTH, lblBook, -19, SpringLayout.NORTH, tf_ID);
      sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, tf_ID);
      sl_panel.putConstraint(SpringLayout.NORTH, tf_ID, 193, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, tf_ID, 313, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, tf_ID, -268, SpringLayout.EAST, panel);
      tf_ID.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(tf_ID);
      tf_ID.setColumns(10);

      tf_PW = new JPasswordField();
      tf_PW.setFont(new Font("돋움체", Font.PLAIN, 17));
      sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 17, SpringLayout.SOUTH, tf_PW);
      sl_panel.putConstraint(SpringLayout.NORTH, tf_PW, 229, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, tf_ID, -6, SpringLayout.NORTH, tf_PW);
      sl_panel.putConstraint(SpringLayout.WEST, tf_PW, 0, SpringLayout.WEST, tf_ID);
      sl_panel.putConstraint(SpringLayout.SOUTH, tf_PW, -248, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, tf_PW, 481, SpringLayout.WEST, panel);
      tf_PW.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(tf_PW);
      tf_PW.setColumns(10);

      JLabel lblId = new JLabel("ID");
      sl_panel.putConstraint(SpringLayout.EAST, lblId, -15, SpringLayout.WEST, tf_ID);
      lblId.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 17));
      sl_panel.putConstraint(SpringLayout.NORTH, lblId, 7, SpringLayout.NORTH, tf_ID);
      panel.add(lblId);

      JLabel lblPw = new JLabel("PW");
      sl_panel.putConstraint(SpringLayout.EAST, lblPw, -4, SpringLayout.WEST, tf_PW);
      lblPw.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 17));
      sl_panel.putConstraint(SpringLayout.NORTH, lblPw, 7, SpringLayout.NORTH, tf_PW);
      panel.add(lblPw);
      
      JPanel panel_1 = new JPanel();
      sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 193, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, panel_1, 177, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -232, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, panel_1, -23, SpringLayout.WEST, lblId);
      panel.add(panel_1);
      panel_1.setLayout(new GridLayout(0, 1, 0, 0));
      
      JLabel lblDdd = new JLabel("");
      panel_1.add(lblDdd);
      sl_panel.putConstraint(SpringLayout.SOUTH, lblDdd, -13, SpringLayout.NORTH, panel_1);
      sl_panel.putConstraint(SpringLayout.EAST, lblDdd, -84, SpringLayout.WEST, lblBook);
      lblDdd.setIcon(new ImageIcon("C:\\Users\\SAMSUNG\\Desktop\\Bookdatafinal\\image\\newbookreading.PNG"));
      lblDdd.setForeground(Color.WHITE);
      lblDdd.setHorizontalAlignment(SwingConstants.CENTER);
   }
}