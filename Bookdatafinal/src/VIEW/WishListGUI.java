package VIEW;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.BookDAO;
import DAO.WishListDAO;
import VO.BookVO;
import VO.WishListVO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class WishListGUI extends JDialog{

   // 나중에 아이디 받아오기 임시로 씀
   //String member_id = "test";
   private JFrame frame;
   private WishListDAO dao = new WishListDAO();
   DefaultListModel<String> model = new DefaultListModel<String>();
   String id;

   /**
    * Launch the application.
    */
   public static void main(String id) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               WishListGUI window = new WishListGUI(id);
               window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
   public WishListGUI(String id) {
      this.id = id;
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      frame.getContentPane().add(panel);

      JPanel panel_1 = new JPanel();
      sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -223, SpringLayout.SOUTH, panel);
      panel_1.setBackground(Color.WHITE);
      sl_panel.putConstraint(SpringLayout.WEST, panel_1, 165, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, panel_1, -154, SpringLayout.EAST, panel);
      panel.add(panel_1);

      JLabel lblNewLabel = new JLabel("\uC704\uC2DC\uB9AC\uC2A4\uD2B8");
      lblNewLabel.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 18));
      panel_1.add(lblNewLabel);

      JPanel panel_2 = new JPanel();
      sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_1);
      sl_panel.putConstraint(SpringLayout.WEST, panel_2, 24, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -55, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, panel_2, -21, SpringLayout.EAST, panel);
      panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
      panel.add(panel_2);

      panel_2.setLayout(new BorderLayout(0, 0));

      JList list = new JList();
      list.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 15));
      list.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             
            
             
         }
      });
      list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent e) {
             
         }
      });
      panel_2.add(list);

      //
      ArrayList<WishListVO> arr = dao.getwishlist(id);
      BookDAO bookDAO = new BookDAO();
      BookVO vo;
      add_model_update(arr, bookDAO);
      
         
         /*for(int i=0;i<brr.size();i++) {
            model.addElement(brr.get(i)+"         "+arr.get(i).getIsbn()+"         "+arr.get(i).getAdd_date());
         }*/
         
      
      list.setModel(model);
      
      JButton btn_cancel = new JButton("");
      sl_panel.putConstraint(SpringLayout.NORTH, btn_cancel, 19, SpringLayout.SOUTH, panel_2);
      sl_panel.putConstraint(SpringLayout.WEST, btn_cancel, 188, SpringLayout.WEST, panel);
      btn_cancel.setBackground(Color.WHITE);
      btn_cancel.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      	
      });
      panel.add(btn_cancel);
      btn_cancel.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\small_ok.png"));
     
      // 기본 외곽선
      btn_cancel.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btn_cancel.setFocusPainted(false);
      
      JButton btn_delete = new JButton("");
      sl_panel.putConstraint(SpringLayout.NORTH, btn_delete, 16, SpringLayout.SOUTH, panel_2);
      sl_panel.putConstraint(SpringLayout.SOUTH, btn_delete, -8, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, btn_cancel, 0, SpringLayout.SOUTH, btn_delete);
      sl_panel.putConstraint(SpringLayout.EAST, btn_cancel, -125, SpringLayout.WEST, btn_delete);
      sl_panel.putConstraint(SpringLayout.WEST, btn_delete, 384, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, btn_delete, 0, SpringLayout.EAST, panel_2);
      btn_delete.setIcon(new ImageIcon("C:\\Users\\smhrd04\\Desktop\\javaStudy\\Bookdata_ay55\\image\\small_delete.png"));
      // 기본 외곽선
      btn_delete.setBorderPainted(false);
      //클릭 했을때 테두리 사용 안함
      btn_delete.setFocusPainted(false);
      btn_delete.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent evt) {
            
            ArrayList<WishListVO> arr = dao.getwishlist(id);
            BookDAO bookDAO = new BookDAO();
            BookVO vo;
             int index = list.locationToIndex(evt.getPoint());
             System.out.println("여기봐라 " +index);
             
             //System.out.println("wish list no, 확인"+arr.get(index).getWishlist_no());
             
             System.out.println(index+"확인");
             model.removeElement(list.getSelectedValue());
             JOptionPane.showMessageDialog(null, "삭제되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
             list.setModel(model);
             dao.deleteWishlist(arr.get(index).getWishlist_no());
             
             
             
              
         }
      });
      btn_delete.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            
         }
      });
      panel.add(btn_delete);
      btn_cancel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
         }
      });

   }

   private void add_model_update(ArrayList<WishListVO> arr, BookDAO bookDAO) {
      BookVO vo;
      for (int i = 0; i < arr.size(); i++) {
         vo = bookDAO.book_info(arr.get(i).getIsbn());
         model.addElement(arr.get(i).getWishlist_no()+".  "+vo.getBook_name()+"       "+arr.get(i).getAdd_date());
         //System.out.println(arr.get(i).getWishlist_no()+" "+arr.get(i).getIsbn()+" "+arr.get(i).getAdd_date());
         
      }
   }
}