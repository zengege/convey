package xiaojiemian;
import xiaojiemian.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Scottcha {
	private Scott scott;

	public Scott ahaha(String username, String password) throws SQLException {

		Connection connection = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/kuaidi", "root", "admin");
			String mysql = "select zfbname,zfbdate,zfbgendar,zfbid,zfbnum,zfbdlmima,zfbtel,zfbaddressid from tbzfb where zfbtel=? and zfbdlmima= ?";

			PreparedStatement ps = connection.prepareStatement(mysql);

			ps.setObject(1, username);
			ps.setObject(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
			    Scott scott = new Scott();
            this.scott=scott;
		        scott.setZfbname(rs.getString(1));

				scott.setZfbdate(rs.getString(2));

				scott.setZfbgendar(rs.getInt(3));

				scott.setZfbid(rs.getString(4));

				scott.setZfbnum(rs.getInt(5));

				scott.setZfbdlmima(rs.getString(6));
				scott.setZfbtel(rs.getString(7));

				scott.setZfbaddressid(rs.getInt(8));
		
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
	
				connection.close();
		
		}
		return scott;
	}
}