package pojo;

import java.awt.Dimension;
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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Kdtel extends JInternalFrame {
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
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	private JLabel querylJLabel = new JLabel("请输入快递公司名称");
	private JTextField queryField = new JTextField();
	private JButton queryButton = new JButton("点击查询");

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

	public Kdtel() {
		setTitle("快递电话");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);

		querylJLabel.setBounds(100, 20, 120, 40);
		queryField.setBounds(270, 20, 150, 40);
		queryButton.setBounds(470, 20, 100, 40);
		panel1.setBounds(0, 0, 900, 930);
		add(queryButton);
		add(queryField);
		add(querylJLabel);
	queryButton.setIcon(new ImageIcon("images//搜索2.gif"));
		setIcon("images//搜索2.gif", queryButton);
		queryButton.setToolTipText("点击查询");
		Vector<String> thvector = new Vector<String>();
		thvector.add("快递名称");
		thvector.add("电话");
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select kdm, tel from kdgstel";

			PreparedStatement ps = connection.prepareStatement(sql);
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
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector,
				thvector);
		jTable.setModel(defaultTableModel);// 设置表格的模型
		// 设置表头的宽度
		jTable.getTableHeader().getColumnModel().getColumn(0)
				.setPreferredWidth(450);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(450);
		jScrollPane.setBounds(20, 400, 800, 500);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);

		// 查询按钮监听事件
		queryButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String kdmString = queryField.getText();
				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql = "select kdm, tel from kdgstel where kdm=?";

					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, kdmString);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						// 表结构
						JScrollPane jScrollPane1 = new JScrollPane(
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						// 不可编辑表内容
						JTable jTable1 = new JTable() {
							public boolean isCellEditable(int row, int column) {
								return false;
							};
						};
						Vector<String> thvector1 = new Vector<String>();
						thvector1.add("快递名称");
						thvector1.add("电话");
						Vector<Vector<String>> dataVector1 = new Vector<Vector<String>>();
						Vector<String> vector1 = new Vector<String>();
						vector1.add(rs.getString(1));
						vector1.add(rs.getString(2));

						dataVector1.add(vector1);
						DefaultTableModel defaultTableModel1 = new DefaultTableModel(
								dataVector1, thvector1);
						jTable1.setModel(defaultTableModel1);// 设置表格的模型
						// 设置表头的宽度
						jTable1.getTableHeader().getColumnModel().getColumn(0)
								.setPreferredWidth(450);
						jTable1.getTableHeader().getColumnModel().getColumn(1)
								.setPreferredWidth(450);
						jScrollPane1.setBounds(20, 100, 800, 200);
						jTable1.getTableHeader().setResizingAllowed(false);
						jTable1.getTableHeader().setReorderingAllowed(false);
						// 把表格加入滚动面板
						jScrollPane1.getViewport().add(jTable1);
						add(jScrollPane1);
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
		});
		add(panel1);
		setVisible(true);

	}

}
