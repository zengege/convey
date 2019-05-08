package xiaojiemian;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class Jckdcx extends JInternalFrame {
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//u=794619075,3505052030&fm=27&gp=0.gif");
			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};

	private JLabel querylJLabel = new JLabel("请输入要查询的寄出快递编号");
	private JTextField queryField1 = new JTextField();
	private JButton queryButton1 = new JButton();
	private JLabel kdysmJLabel = new JLabel("下面是您曾经快递员上门寄件记录");
	private JLabel yzjjJLabel = new JLabel("下面是您曾经驿站寄件记录");
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	// 表结构
	private JScrollPane jScrollPane1 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable1 = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	// 表结构
	private JScrollPane jScrollPane2 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable2 = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
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

	public Jckdcx(final String username, String password) throws SQLException {
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
		setTitle("寄出快递查询");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		querylJLabel.setBounds(100, 20, 200, 40);
		queryField1.setBounds(320, 20, 150, 40);
		queryButton1.setBounds(470, 20, 50, 40);
		kdysmJLabel.setBounds(0, 570, 250, 40);
		yzjjJLabel.setBounds(0, 320, 200, 40);
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel1.setBounds(0,0,900,930);
		add(queryButton1);
		add(queryField1);
		add(querylJLabel);
		add(kdysmJLabel);
		add(yzjjJLabel);

		queryButton1.setFont(new Font("楷体", 1, 13));
		queryField1.setFont(new Font("楷体", 1, 13));
		querylJLabel.setFont(new Font("楷体", 1, 13));
		kdysmJLabel.setFont(new Font("楷体", 1, 13));
		yzjjJLabel.setFont(new Font("楷体", 1, 13));
	

		
		queryButton1.setIcon(new ImageIcon("images//yizhan.jpg"));
		setIcon("images//搜索2.gif", queryButton1);
		queryButton1.setToolTipText("点击查询");
		
		
		
		Vector<String> thvector = new Vector<String>();
		thvector.add("快递员上门寄出快递的编号");
		thvector.add("用户名");
		thvector.add("路线");
		thvector.add("状态");
		thvector.add("时间更新");
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Connection connection1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection1 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select y.kdysmid,zfbname,luxian,newtime,staus from kdysm y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and  y.statusid=s.statusid and t.zfbnum=?";
			PreparedStatement ps = connection1.prepareStatement(sql);
		
			ps.setObject(1, num);

			ResultSet rs = ps.executeQuery();
			System.out.println(ps);
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));

				vector.add(rs.getString(5));

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs.getString(4)));
				vector.add(str);
				dataVector.add(vector);
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
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector,
				thvector);
		jTable.setModel(defaultTableModel);// 设置表格的模型
		// 设置表头的宽度
		jTable.getTableHeader().getColumnModel().getColumn(0)
				.setPreferredWidth(200);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(75);
		jTable.getTableHeader().getColumnModel().getColumn(2)
				.setPreferredWidth(250);
		jTable.getTableHeader().getColumnModel().getColumn(3)
				.setPreferredWidth(200);
		jTable.getTableHeader().getColumnModel().getColumn(4)
				.setPreferredWidth(75);
		jScrollPane.setBounds(20, 600, 800, 200);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		jTable.setOpaque(false);
		jScrollPane.setOpaque(false);

		Vector<String> thvector2 = new Vector<String>();
		thvector2.add("驿站寄出快递的编号");
		thvector2.add("用户名");
		thvector2.add("路线");
		thvector2.add("状态");
		thvector2.add("时间更新");
		Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
		Connection connection2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection2 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql2= " select yzjjid,zfbname,luxian,newtime,staus from yzjj y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and   y.statusid=s.statusid and t.zfbnum=?";
			PreparedStatement ps2 = connection2.prepareStatement(sql2);
		
			ps2.setObject(1, num);
		
			ResultSet rs2 = ps2.executeQuery();
			System.out.println(ps2);
			while (rs2.next()) {
				Vector<String> vector2 = new Vector<String>();
				vector2.add(rs2.getString(1));
				vector2.add(rs2.getString(2));
				vector2.add(rs2.getString(3));

				vector2.add(rs2.getString(5));

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs2.getString(4)));
				vector2.add(str);
				dataVector2.add(vector2);
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
		DefaultTableModel defaultTableModel2 = new DefaultTableModel(
				dataVector2, thvector2);
		jTable2.setModel(defaultTableModel2);// 设置表格的模型
		// 设置表头的宽度
		jTable2.getTableHeader().getColumnModel().getColumn(0)
				.setPreferredWidth(150);
		jTable2.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(75);
		jTable2.getTableHeader().getColumnModel().getColumn(2)
				.setPreferredWidth(250);
		jTable2.getTableHeader().getColumnModel().getColumn(3)
				.setPreferredWidth(250);
		jTable2.getTableHeader().getColumnModel().getColumn(4)
	.setPreferredWidth(75);
		jScrollPane2.setBounds(20, 350, 800, 200);
		jTable2.getTableHeader().setResizingAllowed(false);
		jTable2.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane2.getViewport().add(jTable2);
		add(jScrollPane2);
		jTable2.setOpaque(false);
		jScrollPane2.setOpaque(false);

		// 查询按钮监听事件
		queryButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String outdnlid = queryField1.getText();
				Vector<String> thvector1 = new Vector<String>();
				thvector1.add("寄出快递的编号");
				thvector1.add("用户名");
				thvector1.add("路线");
				thvector1.add("状态");
				thvector1.add("时间更新");
				Vector<Vector<String>> dataVector1 = new Vector<Vector<String>>();
				Connection connection5 = null;
				Connection connection4 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection5= DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql5 = "select yzjjid,zfbname,luxian,newtime,staus from yzjj y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and   y.statusid=s.statusid and t.zfbnum=? and yzjjid=?";

					PreparedStatement ps5 = connection5.prepareStatement(sql5);
				
					ps5.setObject(2,outdnlid);
					ps5.setObject(1, num);
		
					ResultSet rs5 = ps5.executeQuery();
					System.out.println(ps5);
					while (rs5.next()) {

						Vector<String> vector1 = new Vector<String>();
						vector1.add(rs5.getString(1));
						vector1.add(rs5.getString(2));
						vector1.add(rs5.getString(3));

						vector1.add(rs5.getString(5));
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd ");
						String str = sdf.format(DateFormat.getDateInstance()
								.parse(rs5.getString(4)));
						vector1.add(str);

						dataVector1.add(vector1);

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection5.close();

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection4 = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
					String sql1 = "select y.kdysmid,zfbname,luxian,newtime,staus from kdysm y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and  y.statusid=s.statusid and t.zfbnum=? and kdysmid=?";
					PreparedStatement ps1 = connection4.prepareStatement(sql1);
					ps1.setObject(2, outdnlid);
					ps1.setObject(1, num);
				
					ResultSet rs1 = ps1.executeQuery();
					System.out.println(ps1);
					while (rs1.next()) {

						Vector<String> vector1 = new Vector<String>();
						vector1.add(rs1.getString(1));
						vector1.add(rs1.getString(2));
						vector1.add(rs1.getString(3));
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd ");
						String str = sdf.format(DateFormat.getDateInstance()
								.parse(rs1.getString(4)));
						vector1.add(str);
						vector1.add(rs1.getString(5));

						dataVector1.add(vector1);
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

				DefaultTableModel defaultTableModel1 = new DefaultTableModel(
						dataVector1, thvector1);
				jTable1.setModel(defaultTableModel1);// 设置表格的模型
				// 设置表头的宽度
				jTable1.getTableHeader().getColumnModel().getColumn(0)
						.setPreferredWidth(150);
				jTable1.getTableHeader().getColumnModel().getColumn(1)
						.setPreferredWidth(75);
				jTable1.getTableHeader().getColumnModel().getColumn(2)
						.setPreferredWidth(250);
				jTable1.getTableHeader().getColumnModel().getColumn(3)
						.setPreferredWidth(250);
				jTable1.getTableHeader().getColumnModel().getColumn(4)
						.setPreferredWidth(75);
				jScrollPane1.setBounds(20, 100, 800, 200);
				jTable1.getTableHeader().setResizingAllowed(false);
				jTable1.getTableHeader().setReorderingAllowed(false);
				// 把表格加入滚动面板
				jScrollPane1.getViewport().add(jTable1);
				add(jScrollPane1);
				jTable1.setOpaque(false);
				jScrollPane1.setOpaque(false);

			}
		});
		add(panel1);
		setVisible(true);
	}
}
