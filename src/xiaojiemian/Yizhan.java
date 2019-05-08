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
import constoms.Syview;
import pojo.Kdysm;
import pojo.Yzjj;

public class Yizhan extends JInternalFrame{
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	private JButton dsButton=new JButton("驿站代收");
	private JButton yzButton=new JButton("驿站寄件");
	JDesktopPane rightPane=Syview.rightPane;
	public Yizhan(final String username,final String password) throws SQLException {
		
		
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
		setTitle("驿站");
		setSize(100,930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		dsButton.setBounds(0,10,100,100);
        yzButton.setBounds(0,300,100,100);
        add(dsButton);
        add(yzButton);
       dsButton .setFont(new Font("楷体", 1, 16));
        yzButton.setFont(new Font("楷体", 1, 16));
        //代收监听
		dsButton.addActionListener(new ActionListener() {
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
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		
		
		//
		yzButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Yzjj) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					 rightPane.add(new Yzjj(username,password));
				}
				
				
			}
		});
		
	}
	
	

}
