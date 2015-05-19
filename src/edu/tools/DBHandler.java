package edu.tools;
import java.sql.*;

import database.DBConnectionConfig;

public class DBHandler {
	Connection conn;
		
	public DBHandler(){
	
		String sqlURL = DBConnectionConfig.getPropertyByName("sqlURL");
		String userName = DBConnectionConfig.getPropertyByName("username");
		String password = DBConnectionConfig.getPropertyByName("password");
		try
		{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(sqlURL, userName, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	
	public PreparedStatement getPrSt(String sql) throws SQLException
	{
		  PreparedStatement prep = conn.prepareStatement(sql);
		  return prep;
	}
	
	public ResultSet execQuery(String sql)
	{
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void close()
	  {
		  
		  if(null == conn)
		  {
			  try
			  {
				  conn.close();
			  }
			  catch(SQLException e)
			  { 
			  }
			  finally
			  {
				  conn = null;
			  }
		  }
	  }
	  
	  
}
