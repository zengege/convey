package pojo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

public class Yzjj extends JInternalFrame {
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
	private JLabel wherecom = new JLabel("包裹从哪里来");
	private JComboBox<Address> depBoxcom = new JComboBox<Address>();
	private JLabel jjrname = new JLabel("寄件人姓名");
	private JTextField jjrnameField = new JTextField();

	private JLabel jjrtelJLabel = new JLabel("寄件人电话");
	private JTextField jjrtelField = new JTextField();
	private JLabel chickjlabel1 = new JLabel("");
	private JLabel jjradd = new JLabel("寄件人地址");

	private JLabel wherego = new JLabel("你想寄到哪里去");
	private JComboBox<Address> depBoxgo = new JComboBox<Address>();
	private JLabel sjradd = new JLabel("收件人地址");
	private JLabel sjrname = new JLabel("收件人姓名");
	private JTextField sjrnameField = new JTextField();
	private JLabel sjrtelJLabel = new JLabel("收件人电话");
	private JTextField sjrtelField = new JTextField();
	private JLabel chickjlabel2 = new JLabel("");
	private JLabel sortLabel = new JLabel("类型");
	private JComboBox<Sortweight> sortBox = new JComboBox<Sortweight>();

	private JButton dizhiButton = new JButton("地址信息确认键");
	private JLabel dizhiJLabel = new JLabel("请再确认一下地址哦，若无误请按一下地址信息确认键哦");
	private JButton jiba = new JButton("确定");
	private JButton restButton = new JButton("重置");

	public Yzjj(final String username, final String password) {
		Scottcha dao = new Scottcha();
		Scott scott=null;
		try {
			scott = dao.ahaha(username, password);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String dateString = scott.getZfbdate();
		String mima = scott.getZfbdlmima();
		int agendar = scott.getZfbgendar();
		String identity = scott.getZfbid();
		int addressid = scott.getZfbaddressid();
		String nameString = scott.getZfbname();
		final int num = scott.getZfbnum();
		String telString = scott.getZfbtel();
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		wherecom.setBounds(0, 20, 200, 70);
		jjrname.setBounds(150, 150, 80, 70);
		jjrnameField.setBounds(250, 170, 100, 40);
		jjrtelJLabel.setBounds(150, 250, 80, 70);
		jjrtelField.setBounds(250, 270, 100, 40);
		chickjlabel1.setBounds(370, 270, 50, 70);
		jjradd.setBounds(450,260,90,70);
		depBoxcom.setBounds(550, 270, 80, 30);
		panel1.setBounds(0, 0, 900, 930);
		wherego.setBounds(0, 400, 200, 70);
		sjrname.setBounds(150, 500, 80, 70);
		sjrnameField.setBounds(250, 520, 100, 40);
		sjrtelJLabel.setBounds(150, 600, 80, 70);
		sjrtelField.setBounds(250, 620, 80, 40);
		chickjlabel2.setBounds(370, 620, 50, 70);
		sjradd.setBounds(450,610,90,70);
		depBoxgo.setBounds(550, 620, 80, 30);
		sortLabel.setBounds(150, 700, 80, 70);
		sortBox.setBounds(250, 720, 80, 30);
		jiba.setBounds(250, 790, 80, 40);
		restButton.setBounds(400, 790, 80, 40);
add(jjradd);
add(sjradd);
		add(depBoxcom);
		add(wherecom);
		add(chickjlabel1);
		add(chickjlabel2);
		add(depBoxgo);
		add(jjrname);
		add(jjrnameField);
		add(jjrtelField);
		add(jjrtelJLabel);
		add(sjrname);
		add(sjrnameField);
		add(sjrtelField);
		add(sjrtelJLabel);
		add(wherego);
		add(sortBox);
		add(sortLabel);
		add(jiba);
		add(restButton);
		add(panel1);
		depBoxcom.setFont(new Font("楷体", 1, 13));
		wherecom.setFont(new Font("楷体", 1, 16));
		depBoxgo.setFont(new Font("楷体", 1, 13));
		sortBox.setFont(new Font("楷体", 1, 13));
		sortLabel.setFont(new Font("楷体", 1, 13));
		wherego.setFont(new Font("楷体", 1, 16));
		jjrname.setFont(new Font("楷体", 1, 13));
		jjrnameField.setFont(new Font("楷体", 1, 13));
		jjrtelField.setFont(new Font("楷体", 1, 13));
		jjrtelJLabel.setFont(new Font("楷体", 1, 13));
		sjrname.setFont(new Font("楷体", 1, 13));
		sjrnameField.setFont(new Font("楷体", 1, 13));
		sjrtelField.setFont(new Font("楷体", 1, 13));
		sjrtelJLabel.setFont(new Font("楷体", 1, 13));
		restButton.setFont(new Font("楷体", 1, 16));
		jiba.setFont(new Font("楷体", 1, 16));
		sjradd.setFont(new Font("楷体", 1, 13));
		jjradd.setFont(new Font("楷体", 1, 13));

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
		// 确实按钮监听事件
		jiba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jjrnameString = jjrnameField.getText();
				String jjrtelString = jjrtelField.getText();
				String sjrnameString = sjrnameField.getText();
				String sjrtelString = sjrtelField.getText();

				Connection connection = null;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String mysql = "insert into yzjj(jjrname,jjrtel,sortid,sjrname,sjrtel,zfbnum,qishiaddressid,mudiaddressid,newtime,statusid) values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(mysql);

					ps.setObject(1, jjrnameString);
					ps.setObject(2, jjrtelString);
					ps.setObject(3, ((Sortweight) sortBox.getSelectedItem())
							.getSortid());
					ps.setObject(4, sjrnameString);
					ps.setObject(5, sjrtelString);
					ps.setObject(7, ((Address) depBoxcom.getSelectedItem())
							.getAddressid());
					ps.setObject(8, ((Address) depBoxgo.getSelectedItem())
							.getAddressid());

					Date date = new Date();// 得到系统的当前时间
					System.out.println(date);

					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss");// 参数指的是按照什么样的格式进行格式化

					// 格式化
					String dateString = sdf.format(date);

					ps.setObject(9, dateString);
					ps.setObject(10, 0);
					ps.setObject(6, num);
					int rs = ps.executeUpdate();
					if (rs > 0) {
						JOptionPane.showMessageDialog(null, "提交成功！");

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
		// 重置按钮监听
		restButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				jjrnameField.setText("");
				jjrtelField.setText("");
				chickjlabel1.setText("");
				sjrnameField.setText("");
				sjrtelField.setText("");
				chickjlabel2.setText("");
			}
		});
		setVisible(true);

	}

}
