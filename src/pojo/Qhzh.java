package pojo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;
import constoms.Mainview;
import constoms.Syview;
import constoms.Tkym;
import constoms.Wjmm;
import constoms.Zcym;


public class Qhzh  extends JInternalFrame {
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	final JPanel panel1 = new JPanel() {
		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//1.jpg");

			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};
	private JLabel timez1 = new JLabel();
	private JLabel usernamelabel = new JLabel("<html><body><div style='color:#36648B;font-size:13px;font-family:楷体;'>手机号<span style='color:#87cefa'>登录</span></div></body></html>");
	public static JTextField usernameField = new JTextField();
	private JLabel checkJLabel1 = new JLabel("");

	private JLabel passwordLabel = new JLabel(
			"<html><body><div style='color:#36648B;font-size:15px;font-family:楷体;'>密<span style='color:#87cefa'>码</span></div></body></html>");
	public static JTextField passwordField = new JPasswordField();

	private JButton yanjingButton = new JButton("");
	private JLabel tkJLabel = new JLabel("我已阅读并同意");
	private JButton tkjButton = new JButton("<html>快递之眼<br>使用条款</html>");
	private JButton resetButton = new JButton("重置");
	private JButton loginButton = new JButton("登录");
	private JButton zcbButton = new JButton("注册");
	private JButton wjmmButton = new JButton("忘记密码？");

	public String username1 = usernameField.getText();
	public String password = passwordField.getText();
	private int n = 1;

	public Qhzh(String username, String password){
		
		setTitle("欢迎使用快递之眼");
		setSize(800, 600);
		setLocation(null);
		setLayout(null);// 设置空布局
		setResizable(false);
		JFrame frame1 = new JFrame();
		frame1.setUndecorated(true);
		frame1.setBackground(new Color(0, 0, 0, 0));

		panel1.setBounds(0, 0, 800, 600);
		usernamelabel.setBounds(100, 100, 100, 40);
		usernameField.setBounds(250, 100, 150, 40);
		checkJLabel1.setBounds(410, 100, 50, 30);
		yanjingButton.setBounds(400, 250, 40, 40);
		passwordLabel.setBounds(120, 250, 100, 40);
		passwordField.setBounds(250, 250, 150, 40);
		wjmmButton.setBounds(470, 250, 120, 40);
		tkjButton.setBounds(350, 350, 100, 40);
		tkJLabel.setBounds(250, 360, 100, 20);
		resetButton.setBounds(200, 450, 80, 40);
		loginButton.setBounds(300, 450, 80, 40);
		zcbButton.setBounds(400, 450, 80, 40);
		timez1.setBounds(100, 530, 150, 40);
		add(timez1);
		add(usernamelabel);
		add(usernameField);
		add(yanjingButton);
		add(checkJLabel1);
		add(resetButton);
		add(loginButton);
		add(zcbButton);
		add(tkjButton);
		add(tkJLabel);
		add(wjmmButton);
		add(passwordLabel);
		add(passwordField);
		add(panel1);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		usernameField.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(51, 245, 41)));
		usernameField.setOpaque(false);
		passwordField.setOpaque(false);
		wjmmButton.setOpaque(false);
		passwordField.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(51, 245, 41)));
		usernamelabel.setFont(new Font("楷体", 1, 16));
		passwordLabel.setFont(new Font("楷体", 1, 16));
		resetButton.setFont(new Font("楷体", 1, 16));
		loginButton.setFont(new Font("楷体", 1, 16));
		zcbButton.setFont(new Font("楷体", 1, 16));
		usernameField.setFont(new Font("楷体", 1, 16));
		tkjButton.setFont(new Font("楷体", 1, 13));
		tkJLabel.setFont(new Font("楷体", 1, 13));
		wjmmButton.setFont(new Font("楷体", 1, 13));
		yanjingButton.setIcon(new ImageIcon("images//yizhan.jpg"));
		setIcon("images//yanjing.jpg", yanjingButton);
		// 眼睛监听事件

		yanjingButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (n % 2 != 0) {
					((JPasswordField) passwordField).setEchoChar('\0');
				} else {
					((JPasswordField) passwordField).setEchoChar('*');
				}
				n++;
				passwordField.requestFocusInWindow();
			}
		});



		// 给按钮添加监听事件
		// 重置按钮监听
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				passwordField.setText("");
				checkJLabel1.setText("");

			}
		});
		// 登录按钮监听
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String username1 = usernameField.getText();
				String password1 = passwordField.getText();
				if ((username1 != null) && (password1 != null)) {

					Scottcha dao = new Scottcha();
					Scott scott;
					try {
						scott = dao.ahaha(username1, password1);
						int addressid = scott.getZfbaddressid();
						String dateString = scott.getZfbdate();
						String mima = scott.getZfbdlmima();
						int gendar = scott.getZfbgendar();

						String identity = scott.getZfbid();
						String nameString = scott.getZfbname();
						int num = scott.getZfbnum();
						String telString = scott.getZfbtel();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				Qhzh.this.dispose();

					Syview syview = null;
					try {
						syview = new Syview(username1, password1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Thread thread = new Thread(syview);
					thread.start();
					// 要是登录成功了，进去首页

				}
			}
		});
		// 注册按钮
		zcbButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Zcym();
			Qhzh.this.dispose();
			}
		});
		// 电话号码检查
		usernameField.addKeyListener(new KeyAdapter() {

			// 释放键盘
			@Override
			public void keyReleased(KeyEvent e) {

				String id = usernameField.getText();//
				String regex = "^1[34578]\\d{9}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(id);

				if (matcher.find()) {
					checkJLabel1.setText("√");
				} else {
					checkJLabel1.setText("×");
				}

			}

		});
		// 条款按钮
		tkjButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Tkym();

			}
		});
		// 忘记密码监听事件
		wjmmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new Wjmm();

			}
		});

		setVisible(true);
		
		
		
	}


}
