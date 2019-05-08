package constoms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.util.Timer;

import sun.tools.jar.resources.jar;
import xiaojiemian.Chakuaidi;
import xiaojiemian.Gikuaidi;
import xiaojiemian.Qukuaidi;
import xiaojiemian.Scott;
import xiaojiemian.Scottcha;
import xiaojiemian.Wode;
import xiaojiemian.Yizhan;

public class Syview extends JFrame implements Runnable {

	

	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	private JLabel timez = new JLabel();
	private JButton jiButton = new JButton("寄快递");
	private JButton chaButton = new JButton("查快递");
	private JButton wodeButton = new JButton("我的信息");
	private JButton quButton1 = new JButton("取快递");
	private JButton yizhanButton1 = new JButton("驿站");
	private JMenuBar bar = new JMenuBar();
	private JLabel nameJLabel = new JLabel("你好！");
	private JLabel timez1 = new JLabel();
	// 子容器
	private JDesktopPane leftPane = new JDesktopPane();
	public static JDesktopPane rightPane = new JDesktopPane();

	private JDesktopPane daPane = new JDesktopPane();

	public Syview(final String username, final String password) throws SQLException {
		setTitle("之眼在手，递送无忧");
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		Scottcha dao = new Scottcha();
		Scott scott = dao.ahaha(username, password);
		int addressid = scott.getZfbaddressid();
		String dateString = scott.getZfbdate();
		String mima = scott.getZfbdlmima();
		int gendar = scott.getZfbgendar();
		setDefaultLookAndFeelDecorated(true);
		String identity = scott.getZfbid();
		String nameString = scott.getZfbname();
		int num = scott.getZfbnum();
		String telString = scott.getZfbtel();

		final JLabel namename = new JLabel(nameString);
		setLayout(null);// 设置空布局
		setResizable(false);
		daPane.setBounds(0, 70, 1000, 930);
		bar.setBounds(0, 0, 1000, 70);
		jiButton.setBounds(50, 0, 80, 60);
		chaButton.setBounds(200, 0, 80, 60);
		wodeButton.setBounds(350, 0, 80, 60);
		quButton1.setBounds(500, 0, 80, 60);
		yizhanButton1.setBounds(610, 0, 80, 60);
		namename.setBounds(945, 0, 55, 60);
		nameJLabel.setBounds(900, 10, 40, 50);
		timez1.setBounds(800, 900, 200, 70);
		namename.setFont(new Font("楷体", 1, 16));
		nameJLabel.setFont(new Font("楷体", 0, 13));
		jiButton.setFont(new Font("楷体", 1, 16));
		chaButton.setFont(new Font("楷体", 1, 16));
		wodeButton.setFont(new Font("楷体", 1, 16));
		quButton1.setFont(new Font("楷体", 1, 16));
		yizhanButton1.setFont(new Font("楷体", 1, 16));
		leftPane.setBounds(0, 0, 100, 930);
		rightPane.setBounds(100, 0, 900, 850);
		add(timez1);
		timez1.setFont(new Font("楷体", 1, 16));
		add(namename);
		yizhanButton1.setIcon(new ImageIcon("images//yizhan.jpg"));
		setIcon("images//yizhan.jpg", yizhanButton1);
		yizhanButton1.setToolTipText("驿站");

		quButton1.setIcon(new ImageIcon("images//qu.jpg"));
		setIcon("images//qu.jpg", quButton1);
		jiButton.setToolTipText("取快递");

		wodeButton.setIcon(new ImageIcon("images//anniu2.jpg"));
		setIcon("images//anniu2.jpg", wodeButton);
		wodeButton.setToolTipText("我的信息");

		chaButton.setIcon(new ImageIcon("images//anniu5.jpg"));
		setIcon("images//anniu1.jpg", chaButton);
		chaButton.setToolTipText("查询快递");

		jiButton.setIcon(new ImageIcon("images//anniu5.jpg"));
		setIcon("images//anniu5.jpg", jiButton);
		jiButton.setToolTipText("寄快递");
		add(daPane);
		add(nameJLabel);
		daPane.add(leftPane);
		add(chaButton);
		add(jiButton);
		add(quButton1);
		add(wodeButton);
		add(yizhanButton1);
		add(bar);
		bar.add(chaButton);
		bar.add(jiButton);
		bar.add(quButton1);
		bar.add(wodeButton);
		bar.add(yizhanButton1);
		daPane.add(rightPane);

		jiButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = leftPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Gikuaidi) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					leftPane.add(new Gikuaidi(username, password));
				}
			}

		});

		chaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JInternalFrame[] internalFrames = leftPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Chakuaidi) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					leftPane.add(new Chakuaidi(username, password));
				}

			}
		});
		wodeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JInternalFrame[] internalFrames = leftPane.getAllFrames();

				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Wode) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					leftPane.add(new Wode(username, password,namename));
				}

			}
		});
		quButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JInternalFrame[] internalFrames = leftPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Qukuaidi) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					leftPane.add(new Qukuaidi(username, password));
				}

			}
		});
		yizhanButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JInternalFrame[] internalFrames = leftPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Yizhan) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					try {
						leftPane.add(new Yizhan(username, password));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		setVisible(true);

	}

	public void run() {
	
		while (true) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			timez1.setText(sdf.format(date));
		}
		
	}
}
