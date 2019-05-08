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
import java.text.SimpleDateFormat;
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

public class Timecx extends JInternalFrame {
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//u=794619075,3505052030&fm=27&gp=0.gif");
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
	private JLabel tishiJLabel = new JLabel("下面是具体时长表");
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

	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	public Timecx() {
		setTitle("时效查询");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);

		wherecom.setBounds(30, 30, 100, 80);
		depBoxcom.setBounds(150, 40, 100, 40);
		wherego.setBounds(30, 130, 100, 80);
		depBoxgo.setBounds(150, 140, 100, 40);
		cxButton.setBounds(400, 60, 80, 80);
		tishiJLabel.setBounds(30, 430, 150 , 80);
		panel1.setBounds(0,0,900,930);
		add(tishiJLabel);
		add(depBoxcom);
		add(wherecom);
		add(cxButton);
		add(depBoxgo);
		add(jScrollPane);
		add(jTable);
		add(wherego);
		add(jTable1);
		add(jScrollPane1);
		wherecom.setFont(new Font("楷体", 1, 12));
		wherego.setFont(new Font("楷体", 1, 12));
		depBoxcom.setFont(new Font("楷体", 1, 12));
		depBoxgo.setFont(new Font("楷体", 1, 12));
		cxButton.setFont(new Font("楷体", 1, 12));
		tishiJLabel.setFont(new Font("楷体", 1, 12));
		cxButton.setIcon(new ImageIcon("images//搜索2.gif"));
		setIcon("images//搜索2.gif", cxButton);
		cxButton.setToolTipText("取快递");

		Vector<String> thvector1 = new Vector<String>();

		thvector1.add("路线");
		thvector1.add("所需时间  /小时 ");

		Vector<Vector<String>> dataVector1 = new Vector<Vector<String>>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select luxian,time from luxian";
			PreparedStatement ps = connection.prepareStatement(sql);
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
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DefaultTableModel defaultTableModel1 = new DefaultTableModel(
				dataVector1, thvector1);
		jTable1.setModel(defaultTableModel1);// 设置表格的模型
		// 设置表头的宽度
		jTable1.getTableHeader().getColumnModel().getColumn(0)
				.setPreferredWidth(450);
		jTable1.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(450);
		jScrollPane1.setBounds(20, 500, 800, 300);
		jTable1.getTableHeader().setResizingAllowed(false);
		jTable1.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane1.getViewport().add(jTable1);
		add(jScrollPane1);

		// 查询监听事件
		cxButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Vector<String> thvector = new Vector<String>();

				thvector.add("路线");
				thvector.add("所需时间  /小时 ");

				Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql = "select luxian,time from luxian where qishiaddressid=? and mudiaddressid=?";
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, ((Address) depBoxcom.getSelectedItem())
							.getAddressid());
					ps.setObject(2, ((Address) depBoxgo.getSelectedItem())
							.getAddressid());
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
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				DefaultTableModel defaultTableModel = new DefaultTableModel(
						dataVector, thvector);
				jTable.setModel(defaultTableModel);// 设置表格的模型
				// 设置表头的宽度
				jTable.getTableHeader().getColumnModel().getColumn(0)
						.setPreferredWidth(20);
				jTable.getTableHeader().getColumnModel().getColumn(1)
						.setPreferredWidth(20);
				jScrollPane.setBounds(20, 300, 800, 100);
				jTable.getTableHeader().setResizingAllowed(false);
				jTable.getTableHeader().setReorderingAllowed(false);
				// 把表格加入滚动面板
				jScrollPane.getViewport().add(jTable);
				add(jScrollPane);

			}

		});

		// 初始化寄出去的地址下拉列表
		{
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
		add(panel1);
		setVisible(true);
	}

}
