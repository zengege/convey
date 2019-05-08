package constoms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Tkym extends JFrame {

	private JLabel text1 = new JLabel(
			"本协议自发布之日起即刻生效。审慎阅读】如果您完成全部注册程序取得快递之眼账户或开始");
	private JLabel text2 = new JLabel(
			"使用服务，即表示您接受或同意本协议。特别是免除或限制责任条款、法律适用条款和管辖条款。免除");
	private JLabel text3 = new JLabel(
			"或限制责任条款、法律适用条款和管辖条款将以下划线粗体标识，请您重点阅读。如果您对本协议条款有");

	private JLabel text4 = new JLabel(
			"疑问，请通过快递之眼客服进行询问（快递之眼将向您解释条款内容.因此，请您在完成全部注册程序取得快递");
	private JLabel text5 = new JLabel(
			"之眼账户之前或开始使用服务之前，务必审慎阅读本协议各条款.如果您不接受本协议或本协议任一条款，请立即停止使用服务.");
	private JScrollPane j1 = new JScrollPane();

	public Tkym() {
		setTitle("之眼条款");
		setSize(760, 300);
		setLocationRelativeTo(null);

		setLayout(null);// 设置空布局
		setResizable(false);
		text1.setBounds(40, 20, 720, 40);
		text2.setBounds(30, 65, 730, 40);
		text3.setBounds(30, 115, 730, 40);
		text4.setBounds(30,175, 730, 40);
		text5.setBounds(30, 235, 730, 30);// 怎么在界面中加滚动条呢？
		j1.setBounds(740,20,20,260);
		text1.setFont(new Font("楷体", 0, 13));
		text2.setFont(new Font("楷体", 0, 13));
		text2.setFont(new Font("楷体", 0, 13));
		text3.setFont(new Font("楷体", 0, 13));
		text4.setFont(new Font("楷体", 0, 13));
		text5.setFont(new Font("楷体", 0, 13));
		add(j1);
		add(text1);
		add(text2);
		add(text3);
		add(text4);
	    add(text5);
		setVisible(true);

	}

}
