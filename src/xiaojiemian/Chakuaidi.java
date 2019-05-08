package xiaojiemian;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constoms.Syview;
import pojo.Kdysm;

public class Chakuaidi extends JInternalFrame {
	JDesktopPane rightPane = Syview.rightPane;
	private JLabel querylJLabel = new JLabel("请输入快递运输号");
	public static JTextField queryField = new JTextField();
	private JButton queryButton = new JButton();
	private JLabel inform = new JLabel("可帮别人查哦");

	private JButton spkdButton = new JButton("我路上的快递");
	private JButton jckdButton = new JButton("我寄出的快递");

	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	public Chakuaidi(final String username, final String password) {
		setTitle("查询快递");
		setSize(100, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		querylJLabel.setBounds(0, 10, 100, 100);
		queryField.setBounds(0, 110, 100, 40);
		queryButton.setBounds(0, 210, 100, 100);
		inform.setBounds(0, 320, 80, 50);

		spkdButton.setBounds(0, 400, 100, 100);
		jckdButton.setBounds(0, 500, 100, 100);

		queryButton.setFont(new Font("楷体", 1, 16));
		queryField.setFont(new Font("楷体", 1, 13));
		querylJLabel.setFont(new Font("楷体", 1, 10));
		inform.setFont(new Font("楷体", 1, 10));
		spkdButton.setFont(new Font("楷体", 1, 13));
		jckdButton.setFont(new Font("楷体", 1, 13));
		queryButton.setIcon(new ImageIcon("images//yizhan.jpg"));
		setIcon("images//搜索2.gif", queryButton);
		queryButton.setToolTipText("点击查询");
		spkdButton.setFont(new Font("楷体", 1, 13));
		jckdButton.setFont(new Font("楷体", 1, 13));

		add(queryButton);
		add(inform);
		add(jckdButton);
		add(queryField);
		add(querylJLabel);
		add(spkdButton);

		spkdButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Spkdcx) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					try {
						rightPane.add(new Spkdcx(username, password));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		});
		jckdButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Jckdcx) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					try {
						rightPane.add(new Jckdcx(username, password));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		});
		queryButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String query = queryField.getText();

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql = "select * from yzjj where yzjjid=?";

					PreparedStatement ps = connection.prepareStatement(sql);

					ps.setObject(1, query);

					ResultSet rs = ps.executeQuery();
					if (rs.next()) {

						JInternalFrame[] internalFrames = rightPane
								.getAllFrames();
						// 定义一个标识
						boolean flag = true;
						for (JInternalFrame jInternalFrame : internalFrames) {
							if (jInternalFrame instanceof Querykd) {
								flag = false;
								jInternalFrame.setVisible(true);
							} else {
								jInternalFrame.setVisible(false);
							}
						}
						if (flag) {
							rightPane.add(new Querykd(query));
						}
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
				Connection connection1 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection1 = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql = "select * from kdysm where kdysmid=?";

					PreparedStatement ps = connection1.prepareStatement(sql);
					ps.setObject(1, query);

					ResultSet rs = ps.executeQuery();
					if (rs.next()) {

						JInternalFrame[] internalFrames = rightPane
								.getAllFrames();
						// 定义一个标识
						boolean flag = true;
						for (JInternalFrame jInternalFrame : internalFrames) {
							if (jInternalFrame instanceof Querykd) {
								flag = false;
								jInternalFrame.setVisible(true);
							} else {
								jInternalFrame.setVisible(false);
							}
						}
						if (flag) {
							rightPane.add(new Querykd(query));
						}
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
				Connection connection2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connection2 = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

					String sql = "select * from dnl where dnl.dnlid=?";

					PreparedStatement ps = connection2.prepareStatement(sql);
					ps.setObject(1, query);

					ResultSet rs = ps.executeQuery();
					if (rs.next()) {

						JInternalFrame[] internalFrames = rightPane
								.getAllFrames();
						// 定义一个标识
						boolean flag = true;
						for (JInternalFrame jInternalFrame : internalFrames) {
							if (jInternalFrame instanceof Querykd) {
								flag = false;
								jInternalFrame.setVisible(true);
							} else {
								jInternalFrame.setVisible(false);
							}
						}
						if (flag) {
							rightPane.add(new Querykd(query));
						}
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
			}

		});

		setVisible(true);
	}
}
