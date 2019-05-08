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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

public class Kdry extends  JInternalFrame{

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
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//u=794619075,3505052030&fm=27&gp=0.gif");
			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};
private JLabel inform=new JLabel("下面是你收货地址附近的快递员");	
	public Kdry(final String username, final String password) throws SQLException{
		setTitle("附近快递员");
		setSize(900,930);
		setLayout(null);
		setResizable(false);
		Scottcha dao = new Scottcha();
		Scott scott = dao.ahaha(username, password);
		panel1.setBounds(0,0,900,930);

		String dateString = scott.getZfbdate();
		String mima = scott.getZfbdlmima();
		int agendar = scott.getZfbgendar();
		String identity = scott.getZfbid();
		int addressid = scott.getZfbaddressid();
		String nameString = scott.getZfbname();
		final int num = scott.getZfbnum();
		String telString = scott.getZfbtel();
		
		
		
		
		panel1.setBounds(0,0,900,930);
		
		

		Vector<String> thvector = new Vector<String>();
		thvector.add("快递哥编号");
		thvector.add("快递哥姓名");
		thvector.add("所在地");
		thvector.add("电话");
		thvector.add("性别");
		
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Connection connection1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection1 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select kdyid,kdyname,address,kdytel,kdygender from kdy,address where kdyaddressid=? and kdyaddressid=addressid";
			PreparedStatement ps = connection1.prepareStatement(sql);
		
			ps.setObject(1, addressid);

			ResultSet rs = ps.executeQuery();
			System.out.println(ps);
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));

				vector.add(rs.getString(4));
				vector.add(rs.getString(5).equals("0") ? "女" : "男");
			
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
				.setPreferredWidth(220);
		jTable.getTableHeader().getColumnModel().getColumn(2)
				.setPreferredWidth(150);
		jTable.getTableHeader().getColumnModel().getColumn(3)
				.setPreferredWidth(250);
		jTable.getTableHeader().getColumnModel().getColumn(4)
				.setPreferredWidth(80);
		jScrollPane.setBounds(20, 100, 800, 200);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		jTable.setOpaque(false);
		jScrollPane.setOpaque(false);
		add(panel1);
		
		setVisible(true);
	}

}
