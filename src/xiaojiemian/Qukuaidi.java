package xiaojiemian;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import constoms.Daishou;
import constoms.Qjinform;
import constoms.Syview;
import pojo.Kdysm;

public class Qukuaidi extends JInternalFrame {
	JDesktopPane rightPane = Syview.rightPane;
	private JButton informButton = new JButton("取件通知");
	private JButton daishouButton = new JButton("驿站代收");
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	public Qukuaidi(final String username, final String password) {
		setTitle("取快递");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		informButton.setBounds(0, 10, 100, 100);
		daishouButton.setBounds(0, 300, 100, 100);
		informButton.setFont(new Font("楷体", 1, 16));
		daishouButton.setFont(new Font("楷体", 1, 16));
		add(informButton);
		add(daishouButton);

		// 通知监听事件
		informButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Qjinform) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					try {
						rightPane.add(new Qjinform(username,password));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		});

		// 代收监听事件
		daishouButton.addActionListener(new ActionListener() {

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
						rightPane.add(new Daishou(username,password));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		});

	}

}
