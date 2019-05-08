package pojo;

import java.awt.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;
import constoms.Daishou;
import constoms.Mainview;
import constoms.Syview;
import constoms.Zcym;

public class Shezhi extends JInternalFrame {
	private JButton tuichuButton = new JButton("退出登录");
	private JButton qhzhButton = new JButton("切换账号");
	private JButton yzdsButton = new JButton("驿站代收设置");


	public Shezhi(final String username, final String password) {
		setTitle("设置");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		
	
		yzdsButton.setBounds(0, 0, 100, 50);
		qhzhButton.setBounds(100, 0, 100, 50);
		tuichuButton.setBounds(200, 0, 100, 50);
		
		add(tuichuButton);
		add(qhzhButton);
		add(yzdsButton);
		// 监听事件
		// 退出登录监听
		tuichuButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "程序即将退出...");
				System.exit(0);
				new Mainview();

			}
		});

		//驿站代收监听
		yzdsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					new Daishou(username, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		//切换账号
		qhzhButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			new Qhzh(username, password);
				
			}
		});
		setVisible(true);
	}

	

}
