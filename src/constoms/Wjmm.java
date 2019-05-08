package constoms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

public class Wjmm extends JDialog {
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//cha.jpg");
			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};

	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	private JLabel username = new JLabel("姓名");
	private JTextField usernameField = new JTextField("");
	private JLabel usertel = new JLabel("手机号码");
	private JTextField usertelField = new JTextField("");
	private JLabel userid = new JLabel("身份证号码");
	private JButton qdButton = new JButton();
	private JTextField useridField = new JTextField("");
	private JLabel mimaJLabel = new JLabel("你的密码");
	private JTextField mimaField = new JTextField();
	private JButton fanhuiButton = new JButton();

	public Wjmm() {
		setTitle("找回密码");
		setSize(550, 460);
		setLocationRelativeTo(null);
		setLayout(null);// 设置空布局
		setResizable(false);
		panel1.setBounds(0,0,550,460);
		username.setBounds(100, 20, 80, 50);
		usernameField.setBounds(200, 20, 150,40);

		usertel.setBounds(100, 100, 80, 50);
		usertelField.setBounds(200, 100, 150, 40);
		userid.setBounds(100, 180,95, 50);
		useridField.setBounds(200, 180, 150, 40);
		qdButton.setBounds(370, 180, 80, 40);
		mimaJLabel.setBounds(100, 300, 70, 50);
		mimaField.setBounds(200, 300, 150, 40);
		fanhuiButton.setBounds(0, 380, 80, 50);
		
		usertel.setFont(new Font("楷体", 1, 16));
		userid.setFont(new Font("楷体", 1, 16));
		useridField.setFont(new Font("楷体", 1, 16));
		username.setFont(new Font("楷体", 1, 16));
		usernameField.setFont(new Font("楷体", 1, 16));
		usertelField.setFont(new Font("楷体", 1, 16));
		mimaField.setFont(new Font("楷体", 1, 16));
		mimaJLabel.setFont(new Font("楷体", 1, 16));
		qdButton.setFont(new Font("楷体", 1, 16));
		fanhuiButton.setFont(new Font("楷体", 1, 16));
		
		fanhuiButton.setIcon(new ImageIcon("images//返回.jpg"));
		setIcon("images//返回.jpg", fanhuiButton);
		fanhuiButton.setToolTipText("返回登录");
		qdButton.setIcon(new ImageIcon("images//密码.jpg"));
		setIcon("images//密码.jpg", qdButton);
		qdButton.setToolTipText("找回密码");
		
		
		

		add(fanhuiButton);
		add(mimaField);
		add(mimaJLabel);
		add(qdButton);
		add(userid);
		add(useridField);
		add(username);
		add(usernameField);
		add(usertel);
		add(usertelField);
		add(panel1);
		// 确定按钮的监听事件
		qdButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String username1 = usernameField.getText();
				String usertel = usertelField.getText();
				String userid = useridField.getText();

				if ((username1 != null) && (usertel != null)
						&& (userid != null)) {
					Connection connection = null;
					try {

						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection(
								"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
						String mysql = "select zfbdlmima from tbzfb where zfbtel=? and zfbname=? and zfbid=?";

						PreparedStatement ps = connection
								.prepareStatement(mysql);

						ps.setObject(1, usertel);
						ps.setObject(2, username1);
						ps.setObject(3, userid);

						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							mimaField.setText(rs.getString(1));

						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				}

			}
		});

		// 返回按钮的监听事件
		fanhuiButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Wjmm.this.dispose();

			}
		});

		setVisible(true);
	}

}
