package pojo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banwp extends  JInternalFrame{
	final JPanel panel1 = new JPanel() {

		private ImageIcon images;

		public void paintComponent(Graphics g) {
			images = new ImageIcon("images//u=794619075,3505052030&fm=27&gp=0.gif");
			Dimension dimension = getSize();
			g.drawImage(images.getImage(), 0, 0, dimension.width,
					dimension.height, null);
		}
	};
	private JLabel label1=new JLabel("禁限物品及贵重物品寄递告知:一、贵重物品寄递说明二、禁止寄递物品目录三、限制寄递物品目录四、重货物品限制和拒收物品目录一、贵");
	private JLabel label2=new JLabel("重物品寄递说明为了更好的保障您的权益，寄递贵重物品时，建议您向快递员购买保价服务。以便在货丢货损时挽回一定的损失。由于快递员或快递公司原因导致的，未保价的货品赔付上限为1000元现金，有向快递公司");
	private JLabel label3=new JLabel("重物品寄递说明为了更好的保障您的权益，寄递贵重物品时，建议您向快递员购买保价服务。以便在货丢货损时挽回一定的损失。由于快递员或快递公司原因导致的，未保价的货品赔付上限为1000元现金，有向快递公司");
	private JLabel label4=new JLabel("应国家邮政局等三部门联合发布的《禁止寄递物品管理规定》要求，以下物品的寄递会因禁止寄递而被拒收。1.枪支（含仿制品、主要零部件）如手枪、步枪、冲锋枪、防暴枪、气枪、猎枪、运动枪、麻醉注射枪、钢珠");
	private JLabel label5=new JLabel("枪、催泪枪等。2.弹药（含仿制品）如子弹、炸弹、手榴弹、火箭弹、照明弹、燃烧弹、烟幕（雾）弹、信号弹、催泪弹、毒气弹、地雷、手雷、炮弹、火药等。3.管制器具如匕首、三棱刮刀、带有自锁装置的弹簧刀（跳");
	private JLabel label6=new JLabel("刀）、弩、催泪器等。4.爆炸物品如炸药、雷管、导火索、烟花、鞭炮、摔炮、拉炮、砸炮等。5.易燃液体如汽油、柴油、煤油、桐油、丙酮、乙醚、油漆、生漆、苯、酒精、松香油等。6.易燃固体、自燃物质、遇水易燃物");
	private JLabel label7=new JLabel("质如红磷、硫磺、固体酒精、火柴、活性炭等。7.氧化剂和过氧化物如高锰酸盐、高氯酸盐、氧化氢、双氧水等。8.毒性物质如砷、砒霜、汞化物、铊化物、氰化物、硒粉、苯酚、汞、剧毒农药等。9.生化制品、传染性、");
	private JLabel label8=new JLabel("感染性物质如病菌、炭疽、寄生虫、排泄物、医疗废弃物、尸骨、动物器官等。10.放射性物质如铀、钴、镭、钚等。11.腐蚀性物质如硫酸、硝酸、盐酸、蓄电池、氢氧化钠、氢氧化钾等。12.毒品及吸毒工具、非正当用途");
	private JLabel label9=new JLabel("麻醉药品和精神药品、非正当用途的易制毒化学品。13.非法出版物、印刷品、音像制品等宣传品。14.间谍专用器材如暗藏式窃听器材、窃照器材、用于获取情报的电子监听和截收器材等。15.非法伪造物品如伪造或者变造");
	private JLabel label10=new JLabel("的货币、证件、公章等。16.侵犯知识产权和假冒伪劣物品如侵犯专利权、商标权、著作权的图书、音像制品，假冒伪劣的食品、药品、儿童用品、电子产品、化妆品、纺织品等。17.濒危野生动物及其制品如象牙、虎骨、");
	private JLabel label11=new JLabel("犀牛角及其制品等。18.禁止进出境物品如有碍人畜健康的、来自疫区的以及其他能传播疾病的食品、药品或者其他物品；内容涉及国家秘密的文件、资料及其他物品。19.其他物品《危险化学品目录》《民用爆炸物品品名");
	private JLabel label12=new JLabel("表》《易制爆危险化学品名录》《易制毒化学品的分类和品种目录》《中华人民共和国禁止进出境物品表》载明的物品和《人间传染的病原微生物名录》载明的第一、二类病原微生物等，以及法律、行政法规、国务院和");
	private JLabel label13=new JLabel("国务院有关部门规定禁止寄递的其他物品。三、限制寄递物品目录应国家邮政局等三部门联合发布的《禁止寄递物品管理规定》要求，以下物品的寄递会有限制。");
	private JLabel label14=new JLabel("1.活物不能邮递。2.手机不能空运，只能陆运。3.白酒不能超过56度，酒精不能邮递。4.每人的单份邮递品，邮寄香烟不能超过两条。四、重货物品限制和拒收物品目录1.工艺品类铁艺物品、铜艺物品、花艺物品、骨雕物");
	private JLabel label15=new JLabel("品、木雕物品、石雕物品、竹雕物品、炭雕物品、树脂类工艺品（上述物品单票保价在5000元以上的拒收）。2.家具机器类如钢琴、摩托车整件等3.食品类新鲜的肉、新鲜的水产品、新鲜的蛋类、速冻食品。4.不确");
	private JLabel label16=new JLabel("定价值类有效证件、车牌、文件、技术资料、公章、合同、发票、游艇、玉雕物品、象牙雕刻物品、各种土壤样本。5.易碎物品类纯玻璃制品（灯具、生活器皿类、含玻璃仪器/仪表除外）、亚克力板（有机玻璃）、含玻");
	private JLabel label17=new JLabel("璃的家具（玻璃面积超过家具最大面面积30%）、大理石类物品。6.LED类所有非原厂包装的LED类电视、LED类显示器、LED类显示屏(如果没有原厂包装，则必须为蜂窝纸箱包装)。7.液晶类所有非原厂包装的液晶类电视");
	
	
	
	
	
public Banwp(){
	setTitle("禁寄物品");
	setSize(900,930);
	setLayout(null);
	setResizable(false);	
	setClosable(true);
	setIconifiable(true);
	label1.setBounds(0,0,900,40);
	label2.setBounds(0,45,900,40);
	label3.setBounds(0,90,900,40);
	label4.setBounds(0,135,900,40);
	label5.setBounds(0,180,900,40);
	label6.setBounds(0,225,900,40);
	label7.setBounds(0,270,900,40);
	label8.setBounds(0,315,900,40);
	label9.setBounds(0,360,900,40);
	label10.setBounds(0,405,900,40);
	label11.setBounds(0,450,900,40);
	label12.setBounds(0,495,900,40);
	label13.setBounds(0,540,900,40);
	label14.setBounds(0,585,900,40);
	label15.setBounds(0,630,900,40);
	label16.setBounds(0,675,900,40);
	label17.setBounds(0,720,900,40);
	panel1.setBounds(0,0,900,930);
	label1.setFont(new Font("楷体", 1, 12));
	label12.setFont(new Font("楷体", 1, 12));
	label2.setFont(new Font("楷体", 1, 12));
	label11.setFont(new Font("楷体", 1, 12));
	label13.setFont(new Font("楷体", 1, 12));
	label3.setFont(new Font("楷体", 1, 12));
	label14.setFont(new Font("楷体", 1, 12));
	label4.setFont(new Font("楷体", 1, 12));
	label15.setFont(new Font("楷体", 1, 12));
	label5.setFont(new Font("楷体", 1, 12));
	label16.setFont(new Font("楷体", 1, 12));
	label6.setFont(new Font("楷体", 1, 12));
	label17.setFont(new Font("楷体", 1, 12));
	label7.setFont(new Font("楷体", 1, 12));
	label8.setFont(new Font("楷体", 1, 12));
	label9.setFont(new Font("楷体", 1, 12));
	label10.setFont(new Font("楷体", 1, 12));
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
	add(label11);
	add(label12);
	add(label13);
	add(label14);
	add(label15);
	add(label16);
	add(label17);
	add(panel1);
	setVisible(true);
}
}
