package xiaojiemian;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import pojo.HelpProblem;
import pojo.Jjjl;
import pojo.Shezhi;
import pojo.WodeUpdate;
import constoms.Daishou;
import constoms.Mainview;
import pojo.Qhzh;
import constoms.Syview;
import constoms.Zcym;

public class Wode extends JInternalFrame {
	JDesktopPane rightPane = Syview.rightPane;
	private JButton jjjlButton = new JButton("寄件记录");
	private JButton zcButton = new JButton("注册新账号");
	private JButton wodeButton = new JButton("我的信息");
	private JButton helpButton = new JButton("帮助和问题");
	private static JButton shezhi = new JButton("设置");
	private static JButton tcdl = new JButton("退出登录");
	private static JButton qhzh = new JButton("切换账号");
	private static JButton yzdsButton = new JButton("驿站代收设置");
	private static int n = 1;

	public Wode(final String username, final String password,final JLabel namename) {
		setTitle("我的");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		jjjlButton.setBounds(0, 10, 100, 100);
		wodeButton.setBounds(0, 110, 100, 100);
		zcButton.setBounds(0, 210, 100, 100);
		helpButton.setBounds(0, 360, 100, 100);
		shezhi.setBounds(0, 460, 100, 100);
		tcdl.setBounds(0, 560, 100, 40);
		qhzh.setBounds(0, 600, 100, 40);
		yzdsButton.setBounds(0, 640, 100, 40);
		jjjlButton.setFont(new Font("楷体", 1, 16));
		wodeButton.setFont(new Font("楷体", 1, 16));
		zcButton.setFont(new Font("楷体", 1, 16));
		helpButton.setFont(new Font("楷体", 1, 16));
		shezhi.setFont(new Font("楷体", 1, 16));
		tcdl.setFont(new Font("楷体", 1, 16));
		qhzh.setFont(new Font("楷体", 1, 16));
		yzdsButton.setFont(new Font("楷体", 1, 16));
		add(helpButton);
		add(jjjlButton);
		add(wodeButton);
		add(zcButton);
		add(shezhi);
		// 监听事件
		jjjlButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Jjjl) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					try {
						rightPane.add(new Jjjl(username, password));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		});
		zcButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new Zcym();

			}
		});

		wodeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof WodeUpdate) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					rightPane.add(new WodeUpdate(username, password,namename));
				}

			}

		});
		shezhi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (n % 2 != 0) {

					add(tcdl);
					add(qhzh);
					add(yzdsButton);
					tcdl.setVisible(true);
					qhzh.setVisible(true);
					yzdsButton.setVisible(true);
				} else {
					tcdl.setVisible(false);
					qhzh.setVisible(false);
					yzdsButton.setVisible(false);
				}
				n++;

			}

		});

		helpButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof HelpProblem) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					rightPane.add(new HelpProblem());
				}
			}

		});
		// 退出登录监听
		tcdl.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "程序即将退出...");
				System.exit(0);
				new Mainview();

			}
		});
		// 驿站代收监听
		yzdsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {


				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Daishou) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					try {
						rightPane.add(new Daishou(username, password));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		//切换账号
				qhzh.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						

						JInternalFrame[] internalFrames = rightPane.getAllFrames();
						// 定义一个标识
						boolean flag = true;
						for (JInternalFrame jInternalFrame : internalFrames) {
							if (jInternalFrame instanceof Qhzh) {
								flag = false;
								jInternalFrame.setVisible(true);
							} else {
								jInternalFrame.setVisible(false);
							}
						}
						if (flag) {
							rightPane.add(new pojo.Qhzh(username, password));
						}
					}
				});

		setVisible(true);
	}



}
