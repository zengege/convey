package constoms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

public class Qjinform extends JInternalFrame {
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
	private JScrollPane jScrollPane = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 不可编辑表内容
	private JTable jTable = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};

	public Qjinform(String username, String password) throws SQLException {
		Scottcha dao = new Scottcha();

		Scott scott = dao.ahaha(username, password);
		int addressid = scott.getZfbaddressid();
		String dateString = scott.getZfbdate();
		String mima = scott.getZfbdlmima();
		int gendar = scott.getZfbgendar();

		String identity = scott.getZfbid();
		String nameString = scott.getZfbname();
		int num = scott.getZfbnum();
		String telString = scott.getZfbtel();

		setTitle("取件通知");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		panel1.setBounds(0, 0, 900, 930);

		Vector<String> thvector = new Vector<String>();
		thvector.add("快递的编号");
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

			String sql = "select dnlid,zfbname,luxian,staus,newtime from dnl o,tbdingdan y,luxian l,staus s ,tbzfb t where o.dingdanid=y.ddid and o.statusid=s.statusid and y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and zfbnum=? and o.statusid=6";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setObject(1, num);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				JLabel inform1 = new JLabel(
						"<html><body><div style='color:#36648B;font-size:30px;font-family:黑体;'>快递已到驿站哦！<span style='color:#87cefa'>请凭借快递编号于今天18：00之前快速取件！</span></div></body></html>");

				JLabel inform2 = new JLabel("若不能取件请设置代收，或者联系驿站和客服！");
				Font f = new Font("宋体", Font.PLAIN, 35);

				inform2.setFont(f);

				inform2.setForeground(Color.green);

				inform1.setBounds(100, 20, 700, 100);
				inform2.setBounds(120, 150, 680, 100);
				add(inform1);
				add(inform2);
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH-MM-ss");
				String str = sdf.format(DateFormat.getDateInstance().parse(
						rs.getString(5)));
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
				.setPreferredWidth(50);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(50);
		jTable.getTableHeader().getColumnModel().getColumn(2)
				.setPreferredWidth(150);
		jTable.getTableHeader().getColumnModel().getColumn(4)
				.setPreferredWidth(100);
		jScrollPane.setBounds(20, 500, 800, 300);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		add(panel1);
		setVisible(true);
	}
}
