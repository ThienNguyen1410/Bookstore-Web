package models;
import java.sql.*;

public class ConnectionSqlite {
	 
    public static Connection CreateMySqlConnection() throws Exception{
    	Class.forName("org.sqlite.JDBC"); 
    	Connection c=DriverManager.getConnection("jdbc:sqlite:E:\\eclipe_workspace\\bookstore_project\\WebContent\\CustomerDatabase.db");
        return c;
    }
    
    public void excuteSql(String sql) throws Exception {
    	Connection c = CreateMySqlConnection();
    	Statement st = c.createStatement();
    	st.executeUpdate(sql);
    }
    
    public ResultSet choseData(String sql) throws Exception {
    	Connection c = CreateMySqlConnection();
    	Statement st = c.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	return rs;
    }
    
    public PreparedStatement update(String sql) throws SQLException, Exception{
    	Connection c = CreateMySqlConnection();
    	PreparedStatement ps = c.prepareStatement(sql);
    	ps.executeUpdate();
    	return ps;
    }
    
}
