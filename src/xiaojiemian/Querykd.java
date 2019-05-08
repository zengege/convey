package xiaojiemian;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.table.DefaultTableModel;

public class Querykd extends JInternalFrame {
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//u=794619075,3505052030&fm=27&gp=0.gif");
			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};
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
private JLabel jijianJLabel=new JLabel("你寄出的快递到站，请及时提醒你的朋友去取哦");

private JLabel quJLabel=new JLabel("");

	public Querykd(String query) {
		setTitle("查快递");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		panel1.setBounds(0, 0, 900,930);
	
		
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Vector<String> thvector1 = new Vector<String>();
		thvector1.add("快递的编号");
		thvector1.add("路线");
		thvector1.add("时间更新");
		thvector1.add("状态");

		Vector<Vector<String>> dataVector1 = new Vector<Vector<String>>();
		Connection connection = null;
		Connection connection4 = null;
		Connection connection5 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select yzjjid,luxian,newtime,staus from yzjj y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and   y.statusid=s.statusid and yzjjid=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Vector<String> vector1 = new Vector<String>();
				vector1.add(rs.getString(1));
				vector1.add(rs.getString(2));

				vector1.add(rs.getString(4));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs.getString(3)));
				vector1.add(str);

				dataVector1.add(vector1);

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
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection4 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
			String sql1 = "select y.kdysmid,luxian,newtime,staus from kdysm y,luxian l,staus s ,tbzfb t where y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and  y.statusid=s.statusid and kdysmid=?";
			PreparedStatement ps1 = connection4.prepareStatement(sql1);
			ps1.setObject(1, query);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {

				Vector<String> vector1 = new Vector<String>();
				vector1.add(rs1.getString(1));
				vector1.add(rs1.getString(2));
			
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs1.getString(3)));
				vector1.add(str);
				vector1.add(rs1.getString(4));

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
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection5 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
			String sql2 = "select dnlid,luxian,newtime,staus from dnl o,tbdingdan y,luxian l,staus s ,tbzfb t where o.dingdanid=y.ddid and o.statusid=s.statusid and y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and dnlid=?";

			PreparedStatement ps2 = connection5.prepareStatement(sql2);
			ps2.setObject(1, query);

			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {

				Vector<String> vector1 = new Vector<String>();
				vector1.add(rs2.getString(1));
				vector1.add(rs2.getString(2));

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs2.getString(3)));
				vector1.add(str);
				vector1.add(rs2.getString(4));

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

		DefaultTableModel defaultTableModel1 = new DefaultTableModel(
				dataVector1, thvector1);
		jTable1.setModel(defaultTableModel1);// 设置表格的模型
		// 设置表头的宽度
		jTable1.getTableHeader().getColumnModel().getColumn(0)
		.setPreferredWidth(150);
		jTable1.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(250);
		jTable1.getTableHeader().getColumnModel().getColumn(2)
				.setPreferredWidth(250);
		jTable1.getTableHeader().getColumnModel().getColumn(3)
		.setPreferredWidth(150);
		jScrollPane1.setBounds(20, 100, 800, 300);
		jTable1.getTableHeader().setResizingAllowed(false);
		jTable1.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane1.getViewport().add(jTable1);
		add(jScrollPane1);
		add(panel1);
		setVisible(true);
	}

}
