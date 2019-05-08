package pojo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import constoms.Syview;
import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import constoms.Mainview;
import constoms.Syview;

public class WodeUpdate extends JInternalFrame {
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon(
					"images//u=794619075,3505052030&fm=27&gp=0.gif");
			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};
	private JLabel usernamejJLabel = new JLabel("姓名");
	private JTextField usernameField = new JTextField();

	private JLabel userdlmima = new JLabel("登录密码");
	private JTextField userdlmimaField = new JTextField();

	private JLabel usertel = new JLabel("手机号码");
	private JTextField usertelField = new JTextField();
	private JLabel checkJLabel1 = new JLabel("");

	private JLabel userid = new JLabel("身份证号码");
	private JTextField useridField = new JTextField();
	private JLabel checkJLabel3 = new JLabel("");

	private JLabel userdate = new JLabel("出生日期");
	private JTextField userdateField = new JTextField();

	private JLabel usergender = new JLabel("性别");
	private JRadioButton maleButton = new JRadioButton("男");
	private JRadioButton femaleButton = new JRadioButton("女");

	private JLabel useraddress = new JLabel("所在地");
	private JComboBox<Address> depBox = new JComboBox<Address>();

	private JButton updateButton = new JButton("确定修改");
	private JButton resetButton = new JButton("重置");

	public WodeUpdate(final String name, final String password, final JLabel namename) {

		setTitle("编辑我的信息");
		setSize(1000, 930);
		setLayout(null);// 设置空布局
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		Scottcha dao = new Scottcha();
		Scott scott=null;
		try {
			scott = dao.ahaha(name, password);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}

		String dateString = scott.getZfbdate();
		String mima = scott.getZfbdlmima();
		int agendar = scott.getZfbgendar();
		String identity = scott.getZfbid();
		int addressid = scott.getZfbaddressid();
		String nameString = scott.getZfbname();
		int num = scott.getZfbnum();
		String telString = scott.getZfbtel();
		usernameField.setText(nameString);
		userdlmimaField.setText(mima);
		usertelField.setText(telString);
		useridField.setText(identity);
		userdateField.setText(dateString);
		if (agendar == 1) {
			maleButton.setSelected(true);
		} else if (agendar == 0) {
			femaleButton.setSelected(true);
		}

		usertel.setBounds(150, 20, 80, 50);
		usertelField.setBounds(230, 20, 150, 50);
		checkJLabel1.setBounds(400, 20, 20, 50);

		userdlmima.setBounds(150, 100, 80, 50);
		userdlmimaField.setBounds(230, 100, 150, 50);

		usernamejJLabel.setBounds(150, 180, 50, 50);
		usernameField.setBounds(230, 180, 150, 50);

		userid.setBounds(150, 260, 80, 50);
		useridField.setBounds(230, 260, 150, 50);
		checkJLabel3.setBounds(390, 260, 20, 50);

		userdate.setBounds(150, 340, 80, 50);
		userdateField.setBounds(230, 340, 180, 50);

		useraddress.setBounds(150, 420, 80, 50);
		depBox.setBounds(230, 420, 150, 50);

		usergender.setBounds(150, 500, 50, 50);
		maleButton.setBounds(230, 500, 50, 50);
		femaleButton.setBounds(310, 500, 50, 50);

		resetButton.setBounds(150, 580, 80, 50);
		updateButton.setBounds(330, 580, 100, 50);
panel1.setBounds(0,0,900,930);
		Chooser chooser = Chooser.getInstance();
		// 哪个文本框需要使用日历控件
		chooser.register(userdateField);

		add(femaleButton);
		add(maleButton);
		add(resetButton);
		add(updateButton);
		add(useraddress);
		add(userdate);
		add(userdateField);
		add(userdlmima);
		add(userdlmimaField);
		add(usergender);
		add(userid);
		add(useridField);
		add(usernamejJLabel);
		add(usernameField);
		add(checkJLabel1);
		add(checkJLabel3);
		add(usertel);
		add(usertelField);
		add(depBox);
		
		femaleButton.setFont(new Font("楷体", 1, 13));
		maleButton.setFont(new Font("楷体", 1, 13));
		resetButton.setFont(new Font("楷体", 1, 13));
		updateButton.setFont(new Font("楷体", 1, 13));
		useraddress.setFont(new Font("楷体", 1, 13));
		userdate.setFont(new Font("楷体", 1, 13));
		userdateField.setFont(new Font("楷体", 1, 13));
		userdlmima.setFont(new Font("楷体", 1, 13));
		userdlmimaField.setFont(new Font("楷体", 1, 13));
		usergender.setFont(new Font("楷体", 1, 13));
		userid.setFont(new Font("楷体", 1, 13));
		useridField.setFont(new Font("楷体", 1, 13));
		usernameField.setFont(new Font("楷体", 1, 13));
		usernamejJLabel.setFont(new Font("楷体", 1, 13));
		usertel.setFont(new Font("楷体", 1, 13));
		usertelField.setFont(new Font("楷体", 1, 13));
		depBox.setFont(new Font("楷体", 1, 13));
		
		
		
		
		{

			Connection connection1 = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection1 = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select addressid,address from address";
				PreparedStatement ps = connection1.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Address address = new Address();

					address.setAddressid(rs.getInt(1));
					address.setAddress(rs.getString(2));
					depBox.addItem(address);

					if (address.getAddressid() == addressid) {

						depBox.setSelectedItem(address);
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					connection1.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}

		// 逻辑分组
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);

		// 重置按钮监听事件
		resetButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				userdlmimaField.setText("");
				usertelField.setText("");
				useridField.setText("");
				maleButton.setSelected(true);
				userdateField.setText("");

			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText();
				String usertel = usertelField.getText();
				String userid = useridField.getText();
				String userdlmima = userdlmimaField.getText();
				String userdate = userdateField.getText();
				int gender = 1;

				Scottcha dao = new Scottcha();
				try {
					Scott scott = dao.ahaha(username, password);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

		
				Connection connection = null;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
					String mysql = "update tbzfb set zfbname=?,zfbdlmima=?,zfbtel=?,"
							+ "zfbid=?,zfbdate=?,zfbaddressid=?,zfbgendar=? where zfbtel=? and zfbdlmima=?";
					PreparedStatement ps = connection.prepareStatement(mysql);
			
					ps.setObject(1, username);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date birthday = sdf.parse(userdate);
					ps.setObject(5, new java.sql.Date(birthday.getTime()));
					ps.setObject(2, userdlmima);
					ps.setObject(3, usertel);
					ps.setObject(4, userid);

					ps.setObject(6,
							((Address) depBox.getSelectedItem()).getAddressid());
					if (femaleButton.isSelected()) {
						gender = 0;
					}
					ps.setObject(7, gender);
					ps.setObject(8, name);
					ps.setObject(9, password);
					System.out.println(ps);
				    int n = ps.executeUpdate();

					if (n > 0) {
						JOptionPane.showMessageDialog(null, "已保存！");
						
					namename.setText(username);
					} else {
						JOptionPane.showMessageDialog(null, "保存失败，请重新保存");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
        add(panel1);
		setVisible(true);

	}
}
