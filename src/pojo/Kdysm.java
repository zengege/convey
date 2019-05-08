package pojo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import xiaojiemian.Dizhiqueding;
import xiaojiemian.Scott;
import xiaojiemian.Scottcha;
import xiaojiemian.Tijiaokdsm;

public class Kdysm extends JInternalFrame {
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
	public static String luxianString;
	public static String time1;
	public static String pricesumString;
	private JLabel wherecom = new JLabel("包裹从哪里来");
	private JComboBox<Address> depBoxcom = new JComboBox<Address>();
	private JLabel jjrname = new JLabel("寄件人姓名");
	private JTextField jjrnameField = new JTextField();
	private JLabel jjrtelJLabel = new JLabel("寄件人电话");
	private JTextField jjrtelField = new JTextField();
	private JLabel chickjlabel1 = new JLabel("");

	private JLabel wherego = new JLabel("你想寄到哪里去");
	private JComboBox<Address> depBoxgo = new JComboBox<Address>();

	private JLabel sjrname = new JLabel("收件人姓名");
	private JTextField sjrnameField = new JTextField();
	private JLabel sjrtelJLabel = new JLabel("收件人电话");
	private JTextField sjrtelField = new JTextField();
	static JLabel priceJLabel1 = new JLabel("");
	private JLabel chickjlabel2 = new JLabel("");

	private JLabel time = new JLabel("期望上门时间");
	private JComboBox<Timesm> timeBox = new JComboBox<Timesm>();
	private JLabel priceJLabel2 = new JLabel("");

	private JLabel weight = new JLabel("类型和重量");
	private JComboBox<Sortweight> sortBox = new JComboBox<Sortweight>();
	private JComboBox<Weight> weightBox = new JComboBox<Weight>();
	private JLabel priceJLabel3 = new JLabel("");

	private JLabel protect = new JLabel("保价");
	private JComboBox<Baojia> bJComboBox = new JComboBox<Baojia>();
	private JLabel priceJLabel4 = new JLabel("");

	private JLabel bJLabel1 = new JLabel(
			"(温馨提示：1.请按照物品实际情况来填写物品实际价值，快递员上门将会核实。");
	private JLabel bJLabel2 = new JLabel("2.运送过程中出现丢失或者破损，会按照物品的实际价值的90%进行赔偿)");

	private JLabel inform = new JLabel("留言给快递员");
	// private JComboBox<Liuyan> liuyanBox = new JComboBox<Liuyan>();
	// private JCheckBox j1=new JCheckBox("缺包装袋");
	private JTextField j2 = new JTextField();
	private JButton jibaButton = new JButton("确定");
	private JButton restButton = new JButton("重置");
	StringBuffer ssBuffer = new StringBuffer("");

	public Kdysm(final String username, final String password) throws SQLException {
		Scottcha dao = new Scottcha();
		Scott scott = dao.ahaha(username, password);

		String dateString = scott.getZfbdate();
		String mima = scott.getZfbdlmima();
		int agendar = scott.getZfbgendar();
		String identity = scott.getZfbid();
		int addressid = scott.getZfbaddressid();
		String nameString = scott.getZfbname();
		final int num = scott.getZfbnum();
		String telString = scott.getZfbtel();
		setTitle("快递员上门");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		wherecom.setBounds(0, 0, 100, 70);
		jjrname.setBounds(150, 0, 80, 70);
		jjrnameField.setBounds(250, 20, 100, 50);
		jjrtelJLabel.setBounds(400, 0, 80, 70);
		jjrtelField.setBounds(500, 20, 100, 50);
		chickjlabel1.setBounds(630, 20, 50, 50);
		depBoxcom.setBounds(700, 30, 80, 30);

		wherego.setBounds(0, 100, 100, 70);
		sjrname.setBounds(150, 100, 80, 70);
		sjrnameField.setBounds(250, 120, 100, 50);
		sjrtelJLabel.setBounds(400, 100, 80, 70);
		sjrtelField.setBounds(500, 120, 80, 50);
		chickjlabel2.setBounds(630, 120, 50, 50);
		depBoxgo.setBounds(700, 130, 80, 30);
		priceJLabel1.setBounds(800, 100, 30, 70);//

		time.setBounds(0, 200, 100, 70);
		timeBox.setBounds(150, 220, 150, 30);
		priceJLabel1.setBounds(270, 200, 50, 70);//

		weight.setBounds(0, 300, 100, 70);
		sortBox.setBounds(150, 320, 100, 30);
		weightBox.setBounds(300, 320, 100, 30);
		priceJLabel1.setBounds(420, 300, 50, 70);//

		protect.setBounds(0, 400, 100, 70);
		bJComboBox.setBounds(150, 420, 100, 30);
		bJLabel1.setBounds(100, 500, 500, 30);
		bJLabel2.setBounds(130, 530, 500, 30);
		priceJLabel1.setBounds(370, 400, 50, 70);//

		inform.setBounds(200, 550, 100, 80);
		// liuyanBox.setBounds(100,700,200,50);
		j2.setBounds(200, 640, 200, 50);
		jibaButton.setBounds(100, 750, 100, 50);
		restButton.setBounds(300, 750, 100, 50);
		panel1.setBounds(0, 0, 900, 930);
		wherecom.setFont(new Font("楷体", 1, 13));
		depBoxcom.setFont(new Font("楷体", 1, 13));
		jjrname.setFont(new Font("楷体", 1, 13));
		jjrnameField.setFont(new Font("楷体", 1, 13));
		jjrtelField.setFont(new Font("楷体", 1, 13));
		jjrtelJLabel.setFont(new Font("楷体", 1, 13));
		wherego.setFont(new Font("楷体", 1, 13));
		sjrname.setFont(new Font("楷体", 1, 13));
		sjrnameField.setFont(new Font("楷体", 1, 13));
		sjrtelField.setFont(new Font("楷体", 1, 13));
		sjrtelJLabel.setFont(new Font("楷体", 1, 13));
		time.setFont(new Font("楷体", 1, 13));
		timeBox.setFont(new Font("楷体", 1, 13));
		weight.setFont(new Font("楷体", 1, 13));
		weightBox.setFont(new Font("楷体", 1, 13));
		sortBox.setFont(new Font("楷体", 1, 13));
		protect.setFont(new Font("楷体", 1, 13));
		bJComboBox.setFont(new Font("楷体", 1, 13));
		bJLabel1.setFont(new Font("楷体", 1, 13));
		bJLabel2.setFont(new Font("楷体", 1, 13));
		inform.setFont(new Font("楷体", 1, 13));
		j2.setFont(new Font("楷体", 1, 13));
		jibaButton.setFont(new Font("楷体", 1, 13));
		restButton.setFont(new Font("楷体", 1, 13));
		depBoxgo.setFont(new Font("楷体", 1, 13));
		add(priceJLabel1);
		add(priceJLabel2);
		add(priceJLabel3);
		add(priceJLabel4);

		add(jjrname);
		add(jjrnameField);
		add(jjrtelField);
		add(jjrtelJLabel);
		add(sjrname);
		add(sjrnameField);
		add(sjrtelField);
		add(sjrtelJLabel);

		add(depBoxcom);
		add(wherecom);
		add(depBoxgo);
		add(inform);
		add(jibaButton);
		add(restButton);
		add(bJComboBox);
		add(bJLabel1);
		add(bJLabel2);
		add(protect);
		add(sortBox);
		add(time);
		add(timeBox);
		add(weight);
		add(weightBox);
		add(wherego);
		// add(liuyanBox);

		add(j2);

		// 初始化寄出去的地址下拉列表
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select addressid , address from Address";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Address address = new Address();
					address.setAddressid(rs.getInt(1));
					address.setAddress(rs.getString(2));

					depBoxcom.addItem(address);
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
		// 初始化目的地地址下拉列表
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select addressid , address from Address";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Address address = new Address();
					address.setAddressid(rs.getInt(1));
					address.setAddress(rs.getString(2));

					depBoxgo.addItem(address);
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
		// 初始化期望时间预定下拉列表
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select tmid , howlong from timesm";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Timesm timesm = new Timesm();
					timesm.setTmid(rs.getInt(1));
					timesm.setHowlong(rs.getString(2));

					timeBox.addItem(timesm);
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
		// 初始化寄件类型
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select sortid , sort from Sortweight";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Sortweight sortweight = new Sortweight();
					sortweight.setSortid(rs.getInt(1));
					sortweight.setSort(rs.getString(2));

					sortBox.addItem(sortweight);
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
		// 初始化重量下拉列表
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select wtid , wtnum from Weight";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Weight weight = new Weight();
					weight.setWtid(rs.getInt(1));
					weight.setWtnum(rs.getString(2));

					weightBox.addItem(weight);
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
		// 初始化保价下拉列表
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select bjid , jiazhi from baojia";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Baojia baojia = new Baojia();
					baojia.setBjid(rs.getInt(1));
					baojia.setJiazhi(rs.getString(2));

					bJComboBox.addItem(baojia);
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

		// 确定按钮的监听事件
		jibaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String jjrnameString = jjrnameField.getText();
				String jjrtelString = jjrtelField.getText();
				String sjrnameString = sjrnameField.getText();
				String sjrtelString = sjrtelField.getText();
				String ssString = j2.getText();
				Connection connection = null;
				Connection connection1 = null;
				Connection connection2 = null;
				String price2 = null;
				String price3 = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
					String mysql = "insert into kdysm(jjrname,jjrtel,sortid,wtid,tmid,bjid,liuyan,sjrname,sjrtel,zfbnum,qishiaddressid,mudiaddressid,newtime,statusid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement ps = connection.prepareStatement(mysql);
					ps.setObject(1, jjrnameString);
					ps.setObject(5,
							((Timesm) timeBox.getSelectedItem()).getTmid());
					ps.setObject(2, jjrtelString);
					ps.setObject(3, ((Sortweight) sortBox.getSelectedItem())
							.getSortid());
					ps.setObject(4,
							((Weight) weightBox.getSelectedItem()).getWtid());
					ps.setObject(6,
							((Baojia) bJComboBox.getSelectedItem()).getBjid());
					ps.setObject(7, ssString);
					ps.setObject(8, sjrnameString);
					ps.setObject(9, sjrtelString);
					ps.setObject(10, num);
					ps.setObject(11, ((Address) depBoxcom.getSelectedItem())
							.getAddressid());
					ps.setObject(12, ((Address) depBoxgo.getSelectedItem())
							.getAddressid());

					Date date = new Date();// 得到系统的当前时间
					System.out.println(date);

					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss");// 参数指的是按照什么样的格式进行格式化

					// 格式化
					String dateString = sdf.format(date);
					ps.setObject(13, dateString);
					ps.setObject(14, 0);
					System.out.println(ps);
					int rs = ps.executeUpdate();
					if (rs > 0) {
						JOptionPane.showMessageDialog(null, "提交成功！快递员即将上门....");
					} else {
						JOptionPane.showMessageDialog(null, "提交失败，请重新提交");

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

		restButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				jjrnameField.setText("");
				jjrtelField.setText("");
				chickjlabel1.setText("");
				sjrnameField.setText("");
				sjrtelField.setText("");
				chickjlabel2.setText("");
				priceJLabel1.setText("");
				priceJLabel2.setText("");
				priceJLabel3.setText("");
				priceJLabel4.setText("");
			}
		});
		// 电话号码的检查
		jjrtelField.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				String id = jjrtelField.getText();// 得到用户输入的身份证号码
				String regex = "^1[34578]\\d{9}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(id);

				if (matcher.find()) {
					chickjlabel1.setText("√");
				} else {
					chickjlabel1.setText("×");
				}

			}

		});
		sjrtelField.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				String id = sjrtelField.getText();// 得到用户输入的身份证号码
				String regex = "^1[34578]\\d{9}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(id);

				if (matcher.find()) {
					chickjlabel2.setText("√");
				} else {
					chickjlabel2.setText("×");
				}

			}

		});
		add(panel1);
		setVisible(true);
	}

}
