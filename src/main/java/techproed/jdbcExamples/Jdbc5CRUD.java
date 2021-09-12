package techproed.jdbcExamples;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jdbc5CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		Statement st = con.createStatement(); 
		
		
//		st.execute("Create table urunler "
//				+ "(id number(3), "
//				+ "isim varchar2(10), "
//				+ "fiyat number(7,2))");
		
		List<Urun> records = new ArrayList<>();
		
		records.add(new Urun(101, "laptop", 6500));
		records.add(new Urun(102, "PC", 7500));
		records.add(new Urun(103, "phone", 4500));
		records.add(new Urun(104, "board", 600));
		records.add(new Urun(105, "keyboard", 500));
		records.add(new Urun(106, "mouse", 600));
		
		PreparedStatement pst = con.prepareStatement("insert into urunler values(?, ?, ?)");
		
		for (Urun each: records) {
			pst.setInt(1, each.getId());
			pst.setString(2, each.getIsim());
			pst.setDouble(3, each.getFiyat());
			pst.addBatch();
		}
		
		int [] sonuc = pst.executeBatch();
		System.out.println(sonuc.length);
		
		
		

	}

}
