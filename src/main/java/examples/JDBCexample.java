package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCexample {
	private JDBCexample(){}
	private static JDBCexample jdbcExample;
	public static JDBCexample getJDBCexample() {  
        if (jdbcExample == null) {    
        	jdbcExample = new JDBCexample();  
        }
        try {
			Class.forName(driver);
			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()){
				System.out.println( "Succeeded connecting to the Database!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
       return jdbcExample;  
   }  
	//驱动程序名
	private static String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名scutcs
	private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	// MySQL配置时的用户名
	private static String user = "root";
	// Java连接MySQL配置时的密码
	private static String password = "123456";
	
	private static Connection conn=null;
	
	public Connection grtConn(){
		/*
		Connection conn=null;
		try {
			Class.forName(driver);
			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()){
				System.out.println( "Succeeded connecting to the Database!");
			}
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		*/
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		String s="中国";
		String sql = "select * from area where area_name='"+s+"' and grade=1 limit 0,1";
    	ResultSet rs=JDBCexample.getJDBCexample().select(sql);
    	while(rs.next()) {  
    		//选择sname这列数据
    		System.out.println(rs.getString("area_name"));  
    	}
    	System.out.println(2);
//    	if(null==rs){
//    		System.out.println(1);
//    	}else{
//    		
//    	}
//		save();
	}
	
	public void save(String sql){
		try {
			// statement用来执行SQL语句
			Statement statement = grtConn().createStatement();
			// 要执行的SQL语句
//			String sql = "insert into area (area_name) value('中国')";
			int rs = statement.executeUpdate(sql);
			System.out.println(rs);
		}catch(Exception e){
			
		}
	}
	
	
	public ResultSet select(String sql){
		try {
			// statement用来执行SQL语句
			Statement statement = grtConn().createStatement();
			// 要执行的SQL语句
//			String sql = "select * from scmc_button";
			
			ResultSet rs = statement.executeQuery(sql);  
			return rs;
			/*
			String name = null;  
			while(rs.next()) {  
				//选择sname这列数据
				name = rs.getString("button_name");
				System.out.println(name);
				System.out.println("-----------------");  
				// 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
				// 然后使用GB2312字符集解码指定的字节数组
//				name = new String(name.getBytes("ISO-8859-1"),"GB2312");
			}
			*/
		}catch(Exception e){
			
		}
		return null;
	}

}
