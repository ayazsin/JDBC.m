package techproed.jdbcExamples;

import java.sql.*;
import java.util.Arrays;

public class Jdc04DMLInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		Statement st = con.createStatement(); 
		
//		st.execute("insert into bolumler values(80, 'ARGE', 'ISTANBUL')");
		
		String [] query = {"insert into bolumler values(98, 'YEMEKHANE', 'ISTANBUL')",
				"insert into bolumler values(88, 'OFIS', 'ANKARA')",
				"insert into bolumler values(78, 'OFIS2', 'VAN')"};
//		
//		for(String each: query) {
//			st.executeUpdate(each);
//		
//		}
		
//		for(String each: query) {
//			st.addBatch(each);
//		}
//		
//		int[] s = st.executeBatch();
//		System.out.println(Arrays.toString(s));
		
		
		
	
		ResultSet rs = st.executeQuery("Select * from bolumler");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" " + rs.getString(2) + " " + rs.getString(3));
		}
		
		
	}

}
