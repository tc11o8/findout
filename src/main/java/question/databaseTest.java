package question;

import java.sql.Connection;
import java.sql.*;

public class databaseTest {

	public static void main(String[] args) {
		String usr = "trjquery";
		String pwd = "trjetl#2016";
		String url = "jdbc:postgresql://10.139.55.122:5432/trjdb";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Success loading Driver!");
		} catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}
		
		try {
			Connection db = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");
			Statement st = db.createStatement();
			
			String sql = "select * from trj_query.dm_platform_disclosure pl "+
			"join (select max(bsln_key)bsln_key from trj_query.dm_platform_disclosure "+
			" ) pl_max on pl_max.bsln_key = pl.bsln_key ";
			
	           ResultSet rs = st.executeQuery(sql);
	           while (rs.next()) {
	               System.out.println(rs.getString(1));
	               System.out.println(rs.getLong(2));
	               System.out.println(rs.getLong(3));
	               System.out.println(rs.getLong(4));
	               System.out.println(rs.getLong(5));
	               System.out.println(rs.getLong(6));
	           }

	           rs.close();

	           st.close();
		} catch (Exception e) {
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

}
