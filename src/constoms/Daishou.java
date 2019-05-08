package constoms;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pojo.Address;
import xiaojiemian.Scott;
import xiaojiemian.Scottcha;

public class Daishou extends JInternalFrame {
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
	private JButton daishouButton = new JButton("确定代收");
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

	public Daishou(String username, String password) throws SQLException {
		setTitle("驿站代收");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		panel1.setBounds(0, 0, 900, 930);
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

		daishouButton.setBounds(300,550,80,40);
		add(daishouButton);
		daishouButton.setFont(new Font("楷体", 1, 13));
		Vector<String> thvector = new Vector<String>();
		thvector.add("快递的编号");
		thvector.add("用户名");
		thvector.add("路线");
		thvector.add("状态");
		thvector.add("时间更新");
		
	
		final Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

			String sql = "select dnlid,zfbname,luxian,staus,newtime from dnl o,tbdingdan y,luxian l,staus s ,tbzfb t where o.dingdanid=y.ddid and o.statusid=s.statusid and y.qishiaddressid=l.qishiaddressid and y.mudiaddressid=l.mudiaddressid and zfbnum=? and o.statusid=6";

			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println(ps);
			ps.setObject(1, num);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
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
				.setPreferredWidth(100);
		jTable.getTableHeader().getColumnModel().getColumn(1)
				.setPreferredWidth(100);
		jTable.getTableHeader().getColumnModel().getColumn(2)
		.setPreferredWidth(250);
		jTable.getTableHeader().getColumnModel().getColumn(3)
		.setPreferredWidth(100);
		jTable.getTableHeader().getColumnModel().getColumn(4)
		.setPreferredWidth(250);
		jScrollPane.setBounds(20, 200, 800, 300);
		jTable.getTableHeader().setResizingAllowed(false);
		jTable.getTableHeader().setReorderingAllowed(false);
		// 把表格加入滚动面板
		jScrollPane.getViewport().add(jTable);
		add(jScrollPane);
		// 代收按钮监听事件
		daishouButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int row = jTable.getSelectedRow();

				if (row == -1) {
					JOptionPane.showMessageDialog(null, "请选中先！");
					return;
				}

				int n = 0;
				Connection connection = null;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
					String mysql = "update dnl set statusid=7 where dnlid=?";
					PreparedStatement ps = connection.prepareStatement(mysql);
                    ps.setObject(1, jTable.getValueAt(row, 0));
					n = ps.executeUpdate();
					if (n > 0) {
						
						jTable.setValueAt("已代收", row, 3);
						JOptionPane.showMessageDialog(null, "提交成功！");

					} else {
						JOptionPane.showMessageDialog(null,
								"还未提交给驿站，请拨打联系客服电话：84802112 询问");

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

				// 加到数据库中

			}
		});
add(panel1);
		setVisible(true);
	}
}
