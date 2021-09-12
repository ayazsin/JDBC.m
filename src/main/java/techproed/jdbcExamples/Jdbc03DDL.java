package techproed.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class Jdbc03DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		Statement st = con.createStatement(); 
		
		st.execute("drop table isciler purge");
		
		boolean rs = st.execute("create table isciler"
				+ " (id number(3), birim varchar2(10), "
				+ " maas number(5))");
		
		System.out.println(!rs);
		
		st.execute("alter table isciler add isim varchar2(20)");
		
		st.execute("alter table isciler add (soyisim varchar2(20), sehir varchar2(20))");
		
		st.execute("alter table isciler drop column soyisim");
		
		st.execute("alter table isciler rename to calisanlar");
		 
		

	}

}
