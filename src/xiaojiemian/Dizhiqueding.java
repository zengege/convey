package xiaojiemian;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dizhiqueding extends JDialog {


	private JLabel timeJLabel = new JLabel("两地运输所需的时间大约为：");
	private JButton timeButton = new JButton("");

	private JLabel luxianJLabel = new JLabel("两地的路线为：");
	private JButton lxButton = new JButton("");

	public Dizhiqueding(String a, String c) {
		setTitle("查询快递");
		setSize(300, 200);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);

		lxButton.setText(a);
		timeButton.setText(c);

		timeJLabel.setBounds(0, 100, 140, 30);
		timeButton.setBounds(155, 95, 140, 30);
		luxianJLabel.setBounds(0, 180, 140, 30);
		lxButton.setBounds(0, 175, 140, 30);

		add(luxianJLabel);
		add(lxButton);
		add(timeButton);
		add(timeJLabel);

		setVisible(true);
	}

}
