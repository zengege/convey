package pojo;

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
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xpath.internal.operations.And;

public class Pricecx extends JInternalFrame {
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
	private JLabel wherecom = new JLabel("你在哪里寄");
	private JComboBox<Address> depBoxcom = new JComboBox<Address>();
	private JLabel wherego = new JLabel("你想寄到哪里去");
	private JComboBox<Address> depBoxgo = new JComboBox<Address>();
	private JButton cxButton = new JButton();
	private JLabel weight = new JLabel("重量");
	private JComboBox<Weight> weightBox = new JComboBox<Weight>();
	private JLabel lxJLabel = new JLabel("下面的表是路线价格表");
	private JLabel zLabel = new JLabel("下面的表是重量价格表");
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	// 表结构
	private JScrollPane jScrollPane = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	private JScrollPane jScrollPane1 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable1 = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	private JScrollPane jScrollPane3 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable3 = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};

	public Pricecx() {
		setTitle("价格估算");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		panel1.setBounds(0, 0, 900, 930);
		wherecom.setBounds(30, 30, 100, 80);
		depBoxcom.setBounds(150, 40, 100, 40);
		wherego.setBounds(30, 120, 100, 80);
		depBoxgo.setBounds(150, 130, 100, 40);
		cxButton.setBounds(400, 60, 80, 80);
		weight.setBounds(30, 200, 100, 80);
		weightBox.setBounds(150, 210, 100, 40);
		zLabel.setBounds(0, 630, 200, 20);
		lxJLabel.setBounds(0, 400, 200, 20);
		wherecom.setFont(new Font("楷体", 1, 13));
		wherego.setFont(new Font("楷体", 1, 13));
		depBoxcom.setFont(new Font("楷体", 1, 12));
		depBoxgo.setFont(new Font("楷体", 1, 12));
		zLabel.setFont(new Font("楷体", 1, 16));
		lxJLabel.setFont(new Font("楷体", 1, 16));
		weightBox.setFont(new Font("楷体", 1, 12));
		weight.setFont(new Font("楷体", 1, 16));

		add(depBoxcom);
		add(wherecom);
		add(cxButton);
		add(depBoxgo);
		add(jScrollPane);
		add(jTable);
		add(wherego);
		add(weight);
		add(weightBox);
		add(lxJLabel);
		add(zLabel);
	cxButton.setIcon(new ImageIcon("images//搜索2.gif"));
		setIcon("images//搜索2.gif", cxButton);
		cxButton.setToolTipText("点击查询");

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

			Connection connection7 = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection7 = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select addressid , address from Address";

				PreparedStatement ps = connection7.prepareStatement(sql);
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
					connection7.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}
		// 初始化重量下拉列表
		{

			Connection connection8 = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection8 = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select wtid , wtnum from Weight";

				PreparedStatement ps = connection8.prepareStatement(sql);
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
					connection8.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

		Vector<String> thvector1 = new Vector<String>();

		thvector1.add("路线");
		thvector1.add("路线费用表");

		Vector<Vector<String>> dataVector1 = new Vector<Vector<String>>();
		Connection connection1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection1 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select luxian,price from luxian";
			PreparedStatement ps = connection1.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));

				dataVector1.add(vector);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DefaultTableModel defaultTableModel1 = new DefaultTableModel(
				dataVector1, thvector1);
		jTable1.setModel(defaultTableModel1);// 设置表格的模型
		// 设置表头的宽度
		jTable1.getTableHeader().getColumnModel().getColumn(0)
				.setPreferredWidth(50);
		jTable1.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(50);
		jScrollPane1.setBounds(20, 430, 800, 150);
		jTable1.getTableHeader().setResizingAllowed(false);
		jTable1.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane1.getViewport().add(jTable1);
		add(jScrollPane1);

		// 重量价格

		Vector<String> thvector = new Vector<String>();

		thvector.add("重量");
		thvector.add("重量费用表");

		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Connection connection2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection2 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select wtnum,wtprice from weight";
			PreparedStatement ps = connection2.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));

				dataVector.add(vector);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection2.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(
				dataVector1, thvector1);
		jTable.setModel(defaultTableModel);// 设置表格的模型
		// 设置表头的宽度
		jTable.getTableHeader().getColumnModel().getColumn(0)
				.setPreferredWidth(50);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(50);
		jScrollPane.setBounds(20, 660, 800, 150);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		// 查询监听事件
		cxButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Vector<String> thvector3 = new Vector<String>();
				Vector<String> vector3 = new Vector<String>();
				thvector3.add("路线");
				thvector3.add("路线费用 ");
				thvector3.add("重量");
				thvector3.add("重量费用");
				Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();
				Connection connection4 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection4 = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
					String sql1 = "select wtnum,wtprice from weight where wtid=?";
					PreparedStatement ps1 = connection4.prepareStatement(sql1);
					ps1.setObject(1,
							((Weight) weightBox.getSelectedItem()).getWtid());
					ResultSet rs1 = ps1.executeQuery();
					String sql = "select luxian,price from luxian where qishiaddressid=? and mudiaddressid=?";

					PreparedStatement ps = connection4.prepareStatement(sql);

					ps.setObject(1, ((Address) depBoxcom.getSelectedItem())
							.getAddressid());
					ps.setObject(2, ((Address) depBoxgo.getSelectedItem())
							.getAddressid());

					System.out.println(ps);
					ResultSet rs = ps.executeQuery();

					while (rs.next() && rs1.next()) {

						vector3.add(rs.getString(1));
						vector3.add(rs.getString(2));
						vector3.add(rs1.getString(1));
						vector3.add(rs1.getString(2));

						dataVector3.add(vector3);

						DefaultTableModel defaultTableModel = new DefaultTableModel(
								dataVector3, thvector3);
						jTable3.setModel(defaultTableModel);// 设置表格的模型
						// 设置表头的宽度
						jTable3.getTableHeader().getColumnModel().getColumn(0)
								.setPreferredWidth(20);
						jTable3.getTableHeader().getColumnModel().getColumn(1)
								.setPreferredWidth(20);
						jScrollPane3.setBounds(20, 270, 800, 100);
						jTable3.getTableHeader().setResizingAllowed(false);
						jTable3.getTableHeader().setReorderingAllowed(false);
						// 把表格加入滚动面板
						jScrollPane3.getViewport().add(jTable3);
						add(jScrollPane3);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection4.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		add(panel1);
		setVisible(true);
	}

}
