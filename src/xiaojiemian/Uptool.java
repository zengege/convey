package xiaojiemian;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import pojo.Address;

public class Uptool extends JFrame {
	public final void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	static JComboBox<City> citybox = new JComboBox<City>();
	static JComboBox<Province> provincebox = new JComboBox<Province>();
	private JButton ahahaButton = new JButton("驿站");

	public Uptool() {
		setTitle("快递员上门");
		setSize(900, 930);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		provincebox.setBounds(0, 200, 80, 40);
		citybox.setBounds(100, 200, 80, 40);
		add(provincebox);
		add(citybox);
		ahahaButton.setBounds(100, 300, 100, 80);
		add(ahahaButton);
		ahahaButton.setIcon(new ImageIcon("images//yizhan.jpg"));
		setIcon("images//yizhan.jpg", ahahaButton);
		{

			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

				String sql = "select provinceid , province from province";

				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Province address = new Province();
					address.setProvinceid(rs.getInt(1));
					address.setProvince(rs.getString(2));

					provincebox.addItem(address);
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

		}int i;
		for(i=0;i<1;i++){
		provincebox.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent e) {
	
			
				if (((Province) provincebox.getSelectedItem()).getProvinceid()!=0) {
					Connection connection1 = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");

						connection1 = DriverManager.getConnection(
								"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");

						String sql1 = "select cityid , city from city c where c.provinceid=?";

						PreparedStatement ps1 = connection1
								.prepareStatement(sql1);
						ps1.setObject(1, ((Province) provincebox
								.getSelectedItem()).getProvinceid());
						ResultSet rs1 = ps1.executeQuery();

						while (rs1.next()) {

							City address = new City();
							address.setCityid(rs1.getInt(1));
							address.setCity(rs1.getString(2));

							citybox.addItem(address);
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection1.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			
			}
		});
		i++;}
		setVisible(true);
	}

	public static void main(String[] args) {
		Uptool Kset = new Uptool();
	}

}
