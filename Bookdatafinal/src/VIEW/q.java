package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.DbConnection;

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

public class q {
	// private DbConnection dao = new VisitDAO();
	
	private JFrame frame;
	private JTextField tf_visit_contents;
	static DefaultListModel<String> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					q window = new q();
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
	public q() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		SpringLayout panel_1 = new SpringLayout();
		panel.setLayout(panel_1);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_2, -475, SpringLayout.EAST, panel);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("\uAE40\uC544\uC601");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_2.add(lblNewLabel);

		JLabel label = new JLabel("\uB2D8\uC758 \uB2E4\uC774\uC5B4\uB9AC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 20));
		panel_2.add(label);

		JPanel panel_3 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_3, 63, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_3);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel_3);
		panel_1.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_3, -14, SpringLayout.EAST, panel);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, panel_4);
		panel_1.putConstraint(SpringLayout.NORTH, panel_4, 98, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -197, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_4, -14, SpringLayout.EAST, panel);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel label_1 = new JLabel("\uB0A0\uC9DC");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 18));
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("\uCC45 \uC81C\uBAA9");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 18));
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("\uC791\uAC00");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 18));
		panel_3.add(label_3);

		JLabel label_4 = new JLabel("\uBCC4\uC810");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 18));
		panel_3.add(label_4);
		panel.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		JList list_2 = new JList();
		list_2.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.PLAIN, 15));
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {
					"2019-11-31       \uC88B\uC544\uD558\uAC70\uB098 \uC9C0\uCCE4\uAC70\uB098       \uAE00\uBC30\uC6B0      4.5",
					"2019-09-12      \uC5D0\uC774\uD2B8                          \uC774\uC9C0\uC131      3.3     ",
					"2019-05-05      \uC9C0\uAE08 \uC774\uB300\uB85C \uC88B\uB2E4            \uBC95\uB95C        4.5",
					"2019-03-02      90\uB144\uC0DD\uC774 \uC628\uB2E4              \uC784\uD64D\uD0DD       4.4" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_4.add(list_2, "name_2235577353400558");

		JPanel panel_5 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, panel_4);
		panel_1.putConstraint(SpringLayout.WEST, panel_5, 187, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_5, 494, SpringLayout.WEST, panel);
		panel.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));

		JLabel label_5 = new JLabel("\uBC29\uBA85\uB85D");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 18));
		panel_5.add(label_5, "name_2236251674000703");

		JPanel panel_6 = new JPanel();
		panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -6, SpringLayout.NORTH, panel_6);
		panel_1.putConstraint(SpringLayout.NORTH, panel_6, 359, SpringLayout.NORTH, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_6, -64, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.WEST, panel_6, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_6, 739, SpringLayout.WEST, panel);
		panel.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_7, 14, SpringLayout.SOUTH, panel_6);
		panel_1.putConstraint(SpringLayout.WEST, panel_7, 10, SpringLayout.WEST, panel);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_7, -13, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_7, 669, SpringLayout.WEST, panel);

		JList list = new JList();
		list.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.PLAIN, 13));
		panel_6.add(list, "name_2236485240588348");
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "   \uC544\uC601\uB2D8 : \uD37C\uAC00\uC5EC ~ \u2661",
					"\uC870\uBBF8\uB2C8\uB2D8 : \uD37C\uAC00\uC5EC !  ~ \u2661" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		panel.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));

		tf_visit_contents = new JTextField();
		panel_7.add(tf_visit_contents, "name_2250873616066635");
		tf_visit_contents.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_1.putConstraint(SpringLayout.NORTH, panel_8, 14, SpringLayout.SOUTH, panel_6);
		panel_1.putConstraint(SpringLayout.WEST, panel_8, 6, SpringLayout.EAST, panel_7);
		panel_1.putConstraint(SpringLayout.SOUTH, panel_8, -13, SpringLayout.SOUTH, panel);
		panel_1.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel_3);
		panel.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));

		JButton btn_visit_save = new JButton("\uC800\uC7A5");

		btn_visit_save.setFont(new Font("¾Æ¸®µû-µ¸¿ò(TTF)-Light", Font.BOLD, 13));
		panel_8.add(btn_visit_save, "name_2251027820413935");
	}

}