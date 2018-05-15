/*
 * 一个并不标准的JavaBean
 *  1、没有给每一个属性都设置get、set
 *  2、并不存在名为connection的属性
 */
package beans;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static Properties pr = new Properties();
	public JdbcUtil(){}
	static{
		try {
			pr.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = pr.getProperty("driver");
			url=pr.getProperty("url");
			user=pr.getProperty("username");
			password=pr.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	public static void free(ResultSet rs, Statement st, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(st!=null){
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}



