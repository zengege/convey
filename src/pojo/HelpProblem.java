package pojo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpProblem extends JInternalFrame{
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
	private JLabel label1=new JLabel("亲爱的用户，您的宝贵意见和建议将帮助我们更好地提升服务质量。我们将在两个工作日内处理回复您的反馈，感谢您对快递之眼的关注与支持 ");
	private JLabel label2=new JLabel("查件问题：快递员的电话号码错误怎么办？如果您是使用我们的寄件业务，显示的电话号码错误的情况，你可以打客服电话 	400-900-5656，我们会即时为您服务，服务时间：9:00-21:00");
	private JLabel label3=new JLabel("寄件问题楼下就有自提柜，为什么搜索不到？寄件业务可以选择快递公司吗？寄大件业务说明在寄快递时，出现的“揽件码”有什么作用？快递之眼下单是否有保价无法在线支付快递员超时未揽收预测运费和快递收费不同从快递之眼");
	private JLabel label4=new JLabel("上提交驿站寄件订单，有哪些好处？带有“快递单免手写”标签的驿站代表什么？带有“支”字标签的驿站代表什么？线上提交驿站寄件订单后，从哪可以看寄件详情？在线支付运费时碰到系统繁忙怎么办？驿站寄件能");
	private JLabel label5=new JLabel("提供运费计算功能吗？闲鱼按距离收邮费跟快递之眼估计的价格不一样楼下就有自提柜，为什么搜索不到？寄件业务可以选择快递公司吗？寄大件业务说明在寄快递时，出现的“揽件码”有什么作用？快递之眼下单是否");
	private JLabel label6=new JLabel("有保价无法在线支付快递员超时未揽收预测运费和快递收费不同您好，寄件费用是参考寄收地址的城市由系统自动算出的，在下单页面的下方有“运费估算”，点击后就能看到收费参考标准。费用以您和快递员协商的价");
	private JLabel label7=new JLabel("格为准。如果您有异议，您可以右下角“我”-“寄件记录”-找到对应的订单-“客服”-点击“在线咨询”，我们会即时为您服务，服务时间：9:00-21:00。 有用 没用从快递之眼上提交驿站寄件订单，有哪些好处？带有“快递");
	private JLabel label8=new JLabel("单免手写”标签的驿站代表什么？带有“支”字标签的驿站代表什么？线上提交驿站寄件订单后，从哪可以看寄件详情？在线支付运费时碰到系统繁忙怎么办？驿站寄件能提供运费计算功能吗？闲鱼按距离收邮费跟快递之眼");
	private JLabel label9=new JLabel("估计的价格不一样楼下就有自提柜，为什么搜索不到？寄件业务可以选择快递公司吗？寄大件业务说明在寄快递时，出现的“揽件码”有什么作用？快递之眼下单是否有保价无法在线支付快递员超时未揽收预测运费");
	private JLabel label10=new JLabel("和快递收费不同从快递之眼上提交驿站寄件订单，有哪些好处？带有“快递单免手写”标签的驿站代表什么？带有“支”字标签的驿站代表什么？线上提交驿站寄件订单后，从哪可以看寄件详情？在线支付运费时碰到系统繁");

	
	public HelpProblem() {
		setTitle("快递员上门");
	setSize(900, 930);
	setLayout(null);
	setResizable(false);
	setClosable(true);
	setIconifiable(true);
		label1.setBounds(30,100,900,40);
		label2.setBounds(30,170,900,40);
		label3.setBounds(30,240,900,40);
		label4.setBounds(30,310,900,40);
		label5.setBounds(30,380,900,40);
		label6.setBounds(30,450,900,40);
		label7.setBounds(30,520,900,40);
		label8.setBounds(30,590,900,40);
		label9.setBounds(30,660,900,40);
		label10.setBounds(30,730,900,40);
		panel1.setBounds(0, 0, 900, 930);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		add(label8);
		add(label9);
		add(label10);
		add(panel1);
 	label1.setFont(new Font("楷体", 1, 13));
		label2.setFont(new Font("楷体", 1, 13));
		label3.setFont(new Font("楷体", 1, 13));
		label4.setFont(new Font("楷体", 1, 13));
		label5.setFont(new Font("楷体", 1, 13));
		label6.setFont(new Font("楷体", 1, 13));
		label7.setFont(new Font("楷体", 1, 13));
		label8.setFont(new Font("楷体", 1, 13));
		label9.setFont(new Font("楷体", 1, 13));
		label10.setFont(new Font("楷体", 1, 13));
	setVisible(true);
	}

}
