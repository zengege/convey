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
import javax.swing.JLabel;

import pojo.Banwp;
import pojo.Kdry;
import pojo.Kdtel;
import pojo.Kdysm;
import pojo.Pricecx;
import pojo.Timecx;
import pojo.Yzjj;
import constoms.Syview;


public class Gikuaidi extends JInternalFrame{
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	JDesktopPane rightPane=Syview.rightPane;
	private JButton kdyButton=new JButton("快递员上门");
	private JButton yzButton=new JButton("驿站寄件");
	private JLabel toolJLabel=new JLabel("小工具帮助");
	 private JButton priceButton=new JButton("<html>价格<br>查询</html>");
	 private JButton timebButton=new JButton("<html>时效<br>查询</html>");
	 private JButton banButton=new JButton("<html>禁寄<br>物品</html>");
	 private JButton telbButton=new JButton("<html>快递<br>电话</html>");
	 private JButton kdryButton=new JButton("<html>附近<br>快递员</html>");
	 
	public Gikuaidi(final String username,final String password) {
		setTitle("寄快递");
		setSize(100,930);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		kdyButton.setBounds(0,10,100,100);
        yzButton.setBounds(0,110,100,100);
 toolJLabel.setFont(new Font("楷体", 1, 12));
 priceButton.setFont(new Font("楷体", 1, 12));
 telbButton.setFont(new Font("楷体", 1, 12));
 timebButton.setFont(new Font("楷体", 1, 12));
 banButton.setFont(new Font("楷体", 1, 12));
 kdryButton.setFont(new Font("楷体", 1, 12));
 kdyButton.setFont(new Font("楷体", 1, 12));
 yzButton.setFont(new Font("楷体", 1, 12));
		toolJLabel.setBounds(0,330,80,50);
		priceButton.setBounds(0,380,80,50);
		timebButton.setBounds(0,430,80,50);
		banButton.setBounds(0,480,80,50);
		telbButton.setBounds(0,530,80,50);
		kdryButton.setBounds(0,580,80,50);


		add(toolJLabel);
		add(kdryButton);
		add(banButton);
		add(kdyButton);
		add(priceButton);
		add(telbButton);
		add(timebButton);
		add(yzButton);
		
	//监听事件
   //快递员上门
		kdyButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
		
					JInternalFrame[] internalFrames = rightPane.getAllFrames();
					// 定义一个标识
					boolean flag = true;
					for (JInternalFrame jInternalFrame : internalFrames) {
						if (jInternalFrame instanceof Kdysm) {
							flag = false;
							jInternalFrame.setVisible(true);
						} else {
							jInternalFrame.setVisible(false);
						}
					}
					if (flag) {
						 try {
							rightPane.add(new Kdysm(username,password));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
					
		
		});
		
	//驿站寄件
	yzButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
	
				JInternalFrame[] internalFrames =rightPane.getAllFrames();
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
	
	//价格查询
	priceButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
				JInternalFrame[] internalFrames = rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Pricecx) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					rightPane.add(new Pricecx());
				}
			}
				
	
	});
	//时效查询
	timebButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		
				JInternalFrame[] internalFrames =rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Timecx) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					rightPane.add(new Timecx());
				}
			}
				
	
	});
	//banButton
banButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
	
				JInternalFrame[] internalFrames =rightPane.getAllFrames();
				// 定义一个标识
				boolean flag = true;
				for (JInternalFrame jInternalFrame : internalFrames) {
					if (jInternalFrame instanceof Banwp) {
						flag = false;
						jInternalFrame.setVisible(true);
					} else {
						jInternalFrame.setVisible(false);
					}
				}
				if (flag) {
					rightPane.add(new Banwp());
				}
			}
				
	
	});
	//快递电话
telbButton.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
			JInternalFrame[] internalFrames =rightPane.getAllFrames();
			// 定义一个标识
			boolean flag = true;
			for (JInternalFrame jInternalFrame : internalFrames) {
				if (jInternalFrame instanceof Kdtel) {
					flag = false;
					jInternalFrame.setVisible(true);
				} else {
					jInternalFrame.setVisible(false);
				}
			}
			if (flag) {
				rightPane.add(new Kdtel());
			}
		}
			

});
//附近快递员
kdryButton.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
			JInternalFrame[] internalFrames = rightPane.getAllFrames();
			// 定义一个标识
			boolean flag = true;
			for (JInternalFrame jInternalFrame : internalFrames) {
				if (jInternalFrame instanceof Kdry) {
					flag = false;
					jInternalFrame.setVisible(true);
				} else {
					jInternalFrame.setVisible(false);
				}
			}
			if (flag) {
				try {
					rightPane.add(new Kdry(username,password));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
			

});	
		
		setVisible(true);
	}		
		
	}


