package techproed.jdbcExamples;

import java.sql.*;

public class JdbcQuery02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		Statement st = con.createStatement(); 
		
		ResultSet rs = st.executeQuery("select * from bolumler");
		
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" " + rs.getString(2) + " " + rs.getString(3));
		}
		
		System.out.println("============================");
		ResultSet rs2 = st.executeQuery("SELECT personel_isim, maas FROM personel WHERE bolum_id IN(10, 30) ORDER BY maas DESC");
		
		while (rs2.next()) {
			System.out.println("Name :" + rs2.getString(1)+ "\t" + "SALARY :" + rs2.getString(2));
		}
		
		System.out.println("============================");
		
		ResultSet rs3 = st.executeQuery("select bolum_isim, p.personel_isim, p.maas "
				+ "from personel p full join bolumler b "
				+ "on b.bolum_id = p.bolum_id "
				+ "order by bolum_isim, p.maas");
		
		while (rs3.next()) {
			System.out.println(rs3.getString(1)+  "\t"  + rs3.getString(2) + "\t"  + rs3.getInt(3));
		}
		
		System.out.println("============================");
		
		ResultSet rs4 = st.executeQuery("select b.bolum_isim, p.personel_isim, p.maas \n"
				+ "    from personel p \n"
				+ "    join bolumler b \n"
				+ "    ON b.bolum_id = p.bolum_id\n"
				+ "    order by p.maas desc\n"
				+ "    fetch next 10 rows only");
		
		while (rs4.next()) {
			System.out.println(rs4.getString(1)+  "\t"  + rs4.getString(2) + "\t"  + rs4.getInt(3));
		}
		
		System.out.println("============================");
		
		con.close();
		st.close();
		rs.close();
		rs2.close();

	}

}
