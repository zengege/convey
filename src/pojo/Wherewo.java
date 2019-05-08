package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import xiaojiemian.Scott;
import constoms.Mainview;
import constoms.Syview;

public class Wherewo extends JInternalFrame{
public Wherewo(String username,String password) {
	setTitle("我的地址簿");
	setSize(900, 930);
	setLayout(null);
	setResizable(false);
	setClosable(true);
	setIconifiable(true);
	
	
	Connection connection = null;
	try {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
		String mysql = "select zfbdlmima,zfbtel from tbzfb where zfbtel=? and zfbdlmima= ?";

		PreparedStatement ps = connection.prepareStatement(mysql);

		ps.setObject(1, username);
		ps.setObject(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			
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

	
	
	
	
	
	
	setVisible(true);
	
}
}
