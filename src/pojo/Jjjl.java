package pojo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

public class Jjjl extends JInternalFrame {
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

	public Jjjl(String username, String password) throws SQLException {
		setTitle("寄出快递查询");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		panel1.setBounds(0,0,900,930);
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
				.setPreferredWidth(100);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(100);
		jTable.getTableHeader().getColumnModel().getColumn(2)
		.setPreferredWidth(250);
		jTable.getTableHeader().getColumnModel().getColumn(3)
		.setPreferredWidth(250);
		jTable.getTableHeader().getColumnModel().getColumn(4)
		.setPreferredWidth(100);
		jScrollPane.setBounds(20, 50, 800, 200);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		//

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

			String sql2 = " select yzjjid,zfbname,luxian,newtime,staus from yzjj y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and   y.statusid=s.statusid and t.zfbnum=?";
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

				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd ");
				String str2 = sdf2.format(DateFormat.getDateInstance().parse(
						rs2.getString(4)));
				vector2.add(str2);
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
				.setPreferredWidth(100);
		jTable2.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(100);
		jTable2.getTableHeader().getColumnModel().getColumn(2)
		.setPreferredWidth(250);
		jTable2.getTableHeader().getColumnModel().getColumn(3)
		.setPreferredWidth(250);
		jTable2.getTableHeader().getColumnModel().getColumn(4)
		.setPreferredWidth(100);
		jScrollPane2.setBounds(20, 300, 800, 200);
		jTable2.getTableHeader().setResizingAllowed(false);
		jTable2.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane2.getViewport().add(jTable2);
		add(jScrollPane2);
		add(panel1);
setVisible(true);
	}
}
