package xiaojiemian;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Tijiaokdsm extends JDialog{
	


		private JLabel timeJLabel = new JLabel("两地运输所需的时间大约为：");
		private JButton timeButton = new JButton("");

		private JLabel luxianJLabel = new JLabel("两地的路线为：");
		private JButton lxButton = new JButton("");
		private JButton successButton=new JButton("提交成功！");

		public Tijiaokdsm( String b, String c) {
			setTitle("查询快递");
			setSize(400, 300);
			setLayout(null);
			setResizable(false);
			setLocationRelativeTo(null);
			setModal(true);

			lxButton.setText(b);
			timeButton.setText(c);

			timeJLabel.setBounds(0, 100, 140, 30);
			timeButton.setBounds(155, 95, 140, 30);
			luxianJLabel.setBounds(0, 180, 140, 30);
			lxButton.setBounds(0, 175, 140, 30);

			successButton.setBounds(180,250,100,40);
			add(luxianJLabel);
			add(lxButton);
			add(timeButton);
			add(timeJLabel);
           add(successButton);
			
			setVisible(true);
		}

	}

