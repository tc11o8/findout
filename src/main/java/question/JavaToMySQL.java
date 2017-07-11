package question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 * @author Javin Paul
 */
public class JavaToMySQL {
  // JDBC URL, username and password of MySQL server
  private static final String url = "jdbc:mysql://120.27.161.144:3306/trbs";
  private static final String user = "root";
  private static final String password = "root@admin";
  // JDBC variables for opening and managing connection
  private static Connection con;
  private static Statement stmt;
  private static ResultSet rs;
  public static void main(String args[]) {
	  
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(new Date());
		
	  StringBuilder sb = new StringBuilder("TRUNCATE user_recommed_paiming; SET @ranking=0; ");
		sb.append("INSERT INTO user_recommed_paiming(uid, uname, real_name, mobile, one_month_invest, register_con, invest_con, invest_money, om_invest_con, om_invest_money, invest_con_pm) ");
		sb.append("select b1.*,@ranking:=@ranking+1 AS invest_con_pm from (SELECT recomed.from_uid AS uid, u.uname,u.`real_name`,u.`mobile`,");
		sb.append("IFNULL((SELECT SUM(od.money) FROM fi_prj_order AS od WHERE od.uid=u.uid AND od.`time_limit_day`>=28 and FROM_UNIXTIME(od.ctime)<'");
		sb.append(currentDate).append("'");
		sb.append("),0) AS one_month_invest, recomed.推荐注册数 AS register_con, recomed.推荐的投资人数 AS invest_con,");
		sb.append("recomed.推荐的总投资金额 AS invest_money, recomed.推荐一个月以上投资人数 AS om_invest_con,");
		sb.append("recomed.推荐一个月以上总投资金额 AS om_invest_money FROM(SELECT from_uid,COUNT(1) AS 推荐注册数,");
		sb.append("IFNULL((SELECT COUNT(DISTINCT uid) FROM fi_prj_order WHERE uid>99 AND uid IN(");
		sb.append("SELECT uid FROM fi_user_recommed b WHERE uid>99 AND b.from_uid=a.`from_uid` AND b.is_invest>0) ");
		sb.append("and FROM_UNIXTIME(fi_prj_order.ctime)<'").append(currentDate).append("'),0) AS 推荐的投资人数,");
		sb.append("IFNULL((SELECT SUM(money) FROM fi_prj_order WHERE uid>99 AND uid IN(");
		sb.append("SELECT uid FROM fi_user_recommed b WHERE uid>99 AND b.from_uid=a.`from_uid` AND b.is_invest>0) ");
		sb.append("and FROM_UNIXTIME(fi_prj_order.ctime)<'").append(currentDate).append("'),0) AS 推荐的总投资金额,");
		sb.append("IFNULL((SELECT COUNT(DISTINCT uid) FROM fi_prj_order WHERE uid>99 AND uid IN(");
		sb.append("SELECT uid FROM fi_user_recommed b WHERE uid>99 AND b.from_uid=a.`from_uid` AND b.is_invest>0) AND fi_prj_order.`time_limit_day`>=28 ");
		sb.append("and FROM_UNIXTIME(fi_prj_order.ctime)<'").append(currentDate).append("'),0) AS 推荐一个月以上投资人数,");
		sb.append("IFNULL((SELECT SUM(money) FROM fi_prj_order WHERE uid>99 AND uid IN( ");
		sb.append("SELECT uid FROM fi_user_recommed b WHERE uid>99 AND b.from_uid=a.`from_uid` AND b.is_invest>0) AND fi_prj_order.`time_limit_day`>=28 ");
		sb.append("and FROM_UNIXTIME(fi_prj_order.ctime)<'").append(currentDate).append("'),0) AS 推荐一个月以上总投资金额  ");
		sb.append("FROM fi_user_recommed a WHERE a.from_uid>99 and FROM_UNIXTIME(a.ctime)<'").append(currentDate);
		sb.append("' GROUP BY from_uid ORDER BY 推荐的投资人数 DESC, 推荐的总投资金额 DESC, 推荐注册数 DESC");
		sb.append(") AS recomed, fi_user u WHERE recomed.from_uid = u.uid and exists(select 1 from fi_org_member where fi_org_member.uid=u.uid or fi_org_member.mobile=u.mobile) ");
		sb.append("order by invest_con desc) as b1"); 
	  
		String query = sb.toString();
    //String query = "select count(*) from books";
    try {
      // opening database connection to MySQL server
      con = DriverManager.getConnection(url, user, password);
      // getting Statement object to execute query
      stmt = con.createStatement();
      // executing SELECT query
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        int count = rs.getInt(1);
        System.out.println("Total number of books in the table : " + count);
      }
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    } finally {
      //close connection ,stmt and resultset here
      try { con.close(); } catch(SQLException se) { /*can't do anything */ }
      try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
      try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
    }
  }
	
}
