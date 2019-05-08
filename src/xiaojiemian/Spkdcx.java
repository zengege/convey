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

public class Spkdcx extends JInternalFrame {
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//u=794619075,3505052030&fm=27&gp=0.gif");
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
	
	private JScrollPane jScrollPane = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	private JLabel querylJLabel = new JLabel("请输入要查询的寄出快递编号");
	private JTextField queryField1 = new JTextField();
	private JButton queryButton1 = new JButton();
	private JLabel spJLabel = new JLabel("下面是您的快递记录");
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

	public Spkdcx(final String username, String password) throws SQLException {
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
		setTitle("我的快递");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);

		querylJLabel.setBounds(100, 20, 200, 40);
		queryField1.setBounds(320, 20, 150, 40);
		queryButton1.setBounds(470, 20, 50, 40);
		spJLabel.setBounds(0, 350, 200, 40);
		panel1.setBounds(0,0,900,930);
		add(queryButton1);
		add(queryField1);
		add(querylJLabel);
		add(spJLabel);
		
		queryField1.setFont(new Font("楷体", 1, 13));
		querylJLabel.setFont(new Font("楷体", 1, 13));
		spJLabel.setFont(new Font("楷体", 1, 13));
		
		
		queryButton1.setIcon(new ImageIcon("images//yizhan.jpg"));
		setIcon("images//搜索2.gif", queryButton1);
		queryButton1.setToolTipText("点击查询");
		Vector<String> thvector = new Vector<String>();
		thvector.add("快递的编号");
		thvector.add("订单编号");
		thvector.add("用户名");
		thvector.add("路线");
		thvector.add("状态");
		thvector.add("时间更新");
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select dnlid,ddid,zfbname,luxian,staus,newtime from dnl o,tbdingdan y,luxian l,staus s ,tbzfb t where o.dingdanid=y.ddid and o.statusid=s.statusid and y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and zfbnum=?";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setObject(1, num);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs.getString(6)));
				vector.add(str);
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
				.setPreferredWidth(90);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(90);
		jTable.getTableHeader().getColumnModel().getColumn(2)
				.setPreferredWidth(150);
		jTable.getTableHeader().getColumnModel().getColumn(3)
		.setPreferredWidth(250);
		jScrollPane.setBounds(20, 400, 800, 300);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		// 查询按钮监听事件
		queryButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String query = queryField1.getText();
				Vector<String> thvector1 = new Vector<String>();
				thvector1.add("快递的编号");
				thvector1.add("订单编号");
				thvector1.add("用户名");
				thvector1.add("路线");
				thvector1.add("状态");
				thvector1.add("时间更新");
				Vector<Vector<String>> dataVector1 = new Vector<Vector<String>>();
				Connection connection1 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection1 = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql = "select dnlid,ddid,zfbname,luxian,staus,newtime from dnl o,tbdingdan y,luxian l,staus s ,tbzfb t where o.dingdanid=y.ddid and o.statusid=s.statusid and y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and zfbnum=? and dnlid=?";

					PreparedStatement ps = connection1.prepareStatement(sql);

					ps.setObject(1, num);
					ps.setObject(2, query);

					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector1 = new Vector<String>();
						vector1.add(rs.getString(1));
						vector1.add(rs.getString(2));
						vector1.add(rs.getString(3));
						vector1.add(rs.getString(4));
						vector1.add(rs.getString(5));
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd ");
						String str = sdf.format(DateFormat.getDateInstance()
								.parse(rs.getString(6)));
						vector1.add(str);
						dataVector1.add(vector1);

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
				jTable1.getTableHeader().getColumnModel().getColumn(2)
						.setPreferredWidth(150);
				jScrollPane1.setBounds(20, 100, 800, 200);
				jTable1.getTableHeader().setResizingAllowed(false);
				jTable1.getTableHeader().setReorderingAllowed(false);
				// 把表格加入滚动面板
				jScrollPane1.getViewport().add(jTable1);
				add(jScrollPane1);
			}
		});
		add(panel1);
		setVisible(true);
	}

}
