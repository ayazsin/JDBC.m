package techproed.jdbcExamples;

import java.sql.*;

public class JdbcQuery01 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		Statement st = con.createStatement(); 
		
		ResultSet rs = st.executeQuery("select personel_isim from personel where personel_id = 7369");
		
		while(rs.next()) {
			System.out.println("Personel Adi: " + rs.getString(1));
		}
		
		con.close();
		st.close();
		rs.close();

	}

}
