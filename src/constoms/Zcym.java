package constoms;

import java.awt.Color;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



import javax.swing.JFrame;





import pojo.Address;
import pojo.Chooser;

public class Zcym extends JFrame{
	final JPanel panel1 = new JPanel() {
		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//8.png");

			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};
	private JLabel username=new JLabel("姓名");
	private JTextField usernameField=new JTextField("");
	
	private JLabel userdlmima=new JLabel("登录密码");
	private JTextField userdlmimaField=new JTextField("");
	
	private JLabel usertel=new JLabel("手机号码");
	private JTextField usertelField=new JTextField("");
	private JLabel checkJLabel1=new JLabel("");
	
	private JLabel userid=new JLabel("身份证号码");
	private JTextField useridField=new JTextField("");
	private JLabel checkJLabel3=new JLabel("");
	
	private JLabel userdate=new JLabel("出生日期");
	private JTextField userdateField=new JTextField("");
	
	private JLabel usergender= new JLabel("性别");
	private JRadioButton maleButton = new JRadioButton("男");
	private JRadioButton femaleButton = new JRadioButton("女");
	
	private JLabel useraddress=new JLabel("所在地");
	private JComboBox<Address> depBox = new JComboBox<Address>();
	
	private JLabel tkJLabel = new JLabel("我已阅读并同意");
	private JButton tkjButton = new JButton("<html>快递之眼<br>使用条款</html>");
	
	private JButton zcbButton=new JButton("点击注册");
	private JButton resetButton = new JButton("重置");
	private JButton dlbButton=new JButton("立即登录");
	
	public Zcym() {
		setTitle("之眼注册");
		setSize(700,800);
		setLocationRelativeTo(null);
JFrame frame=new JFrame();
frame.setBackground(Color.yellow);
		setLayout(null);// 设置空布局
		setResizable(false);
		
		 usertel.setBounds(150,20,80,50);
		 usertelField.setBounds(230,20,150,50);
			checkJLabel1.setBounds(400,20,20,50);
		 panel1.setBounds(0,0,700,800);
		 userdlmima.setBounds(150,100,80,50);
		 userdlmimaField.setBounds(230,100,150,50);
			
		username.setBounds(150,180,50,50);
		usernameField.setBounds(230,180,150,50);
	
		 userid.setBounds(150,260,80,50);
		 useridField.setBounds(230,260,150,50);
			checkJLabel3.setBounds(390,260,20,50);
		 
		 userdate.setBounds(150,340,80,50);
		 userdateField.setBounds(230,340,180,50);
		 
		 useraddress.setBounds(150,420,80,50);	
		 depBox.setBounds(230,420,150,50);	
		
		usergender.setBounds(150,500,50,50);
		maleButton.setBounds(230,500,50,50);
		femaleButton.setBounds(310,500,50,50);
		tkJLabel.setBounds(150,570,100,20);
		tkjButton.setBounds(270,560,100,40);
		
		zcbButton.setBounds(280,650,100,50);
		resetButton.setBounds(150,650,80,50);
		dlbButton.setBounds(430,650,100,50);
		username.setFont(new Font("楷体", 1, 16));
		userdlmima.setFont(new Font("楷体", 1, 16));
		usertel.setFont(new Font("楷体", 1, 16));
		userid.setFont(new Font("楷体", 1, 16));
		userdate.setFont(new Font("楷体", 1, 16));
		usergender.setFont(new Font("楷体", 1, 16));
		useraddress.setFont(new Font("楷体", 1, 16));
		tkjButton.setFont(new Font("楷体", 1, 16));
		tkJLabel.setFont(new Font("楷体", 1, 13));
		dlbButton.setFont(new Font("楷体", 1, 16));
		depBox.setFont(new Font("楷体", 1, 16));
		zcbButton.setFont(new Font("楷体", 1, 16));
		resetButton.setFont(new Font("楷体", 1, 16));
		femaleButton.setFont(new Font("楷体", 1, 13));
		maleButton.setFont(new Font("楷体", 1, 13));
		Chooser chooser = Chooser.getInstance();
		// 哪个文本框需要使用日历控件
		chooser.register(userdateField);
		add(panel1);
		add(femaleButton);
		add(maleButton);
		add(resetButton);
		add(useraddress);
		add(userdate);
	    add(userdateField);
	    add(userdlmima);
	    add(userdlmimaField);
		add(usergender);
		add(userid);
		add(useridField);
		add(username);
		add(usernameField);
		add(checkJLabel1);
		add(checkJLabel3);
		add(usertel);
		add(usertelField);
		add(zcbButton);
		add(dlbButton);
		add(depBox);
		add(tkJLabel);
		add(tkjButton);
		add(panel1);
		//逻辑分组
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);

		maleButton.setSelected(true);
	
		
		
		
		
		
		//关闭窗口
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "不注册了吗?", "提示",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					Zcym.this.dispose();
				}
			}

		});
		
	//重置按钮监听事件	
		resetButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				userdlmimaField.setText("");
				usertelField.setText("");
				useridField.setText("");
		
			}
		});
		//初始化下拉列表
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/kuaidi","root","admin");

				String sql = "select addressid , address from Address";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Address address = new Address();
					address.setAddressid(rs.getInt(1));
					address.setAddress(rs.getString(2));

					depBox.addItem(address);
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

		}

		//注册按钮监听
		zcbButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String usertel = usertelField.getText();
				String userid = useridField.getText();
				String userdlmima = userdlmimaField.getText();
				String userdate = userdateField.getText();
				int gender=1;
				
				
			int n=0;
			Connection  connection=null;
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager
								.getConnection("jdbc:mysql://127.0.0.1/kuaidi","root","admin");
						String mysql = "insert into tbzfb(zfbname,zfbdlmima,zfbtel,zfbid,zfbdate,zfbaddressid,zfbgendar) values(?,?,?,?,?,?,?)";
						PreparedStatement ps = connection.prepareStatement(mysql);
		
						ps.setObject(1, username);

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date birthday = sdf.parse(userdate);
						ps.setObject(5, new java.sql.Date(birthday.getTime()));
						ps.setObject(2,userdlmima);
						ps.setObject(3, usertel);
						ps.setObject(4, userid);
						if (femaleButton.isSelected()) {
							gender = 0;
						}
						ps.setObject(7, gender);
						
						ps.setObject(6, ((Address)depBox.getSelectedItem()).getAddressid());
						n = ps.executeUpdate();
					if (n>0) {
						JOptionPane.showMessageDialog(null, "注册成功！");
						
					} else {
						JOptionPane.showMessageDialog(null, "注册失败，请重新注册");
						
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}finally {
						try {
							connection.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				
			}
		});
	//登录按钮监听
		dlbButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Mainview();
					Zcym.this.dispose();
					}
				});
		

		//电话号码的检查
		usertelField.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				String id = usertelField.getText();// 得到用户输入的身份证号码
				String regex = "^1[34578]\\d{9}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(id);

				if (matcher.find()) {
					checkJLabel1.setText("√");
				} else {
					checkJLabel1.setText("×");
				}

			}

		});
		
		//身份证号的检查
		useridField.addKeyListener(new KeyAdapter() {

			// 释放键盘
			public void keyReleased(KeyEvent e) {
				String id = useridField.getText();// 得到用户输入的身份证号码
				String regex = "^\\d{17}[xX\\d]$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(id);

				if (matcher.find()) {
					checkJLabel3.setText("√");
				} else {
					checkJLabel3.setText("×");
				}

			}

		});
		//条款按钮
		tkjButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
               new Tkym();
				
			}
		});
		
		setVisible(true);
	}

}
