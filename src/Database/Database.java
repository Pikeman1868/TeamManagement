/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import Logger.Logger;

/**
 * Abstract database class
 * @author PikeMobile
 */
public class Database {
    
    Logger l = null;
    private String dbPath = "jdbc:sqlite:/Users/PikeMobile/Programs/TeamManagement/db/management.db";
    
    /**
     * Database constructor
     * Get logger instance.
     */
    public Database()
    {
        l = Logger.getInstance();
    }
    
    /**
     * Connect to database and return connection.
     * @return 
     */
    public Connection connect() {
        Connection con = null;
        try{
            con = DriverManager.getConnection(dbPath);
            return con;
        }
        catch (SQLException e)
        {
            l.log(e.getMessage());
            return null;
        }

    }
    
    /**
     * Send Query to database.
     * @param: String str is the string statememnt wanted to be passed to DB.
     * @return ResultSet
     */
    public ResultSet sendQuery(String str) {
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try{
            con = this.connect();
            stmt = con.createStatement(); 
            rs = stmt.executeQuery(str);
            stmt.close();
            disconnect(con);
            
            return rs;
        }
        catch(SQLException e)
        {
            l.log(e.getMessage());
            return rs;
        }
        
    }
   
    /**
     * 
     * @param rs 
     */
    public void printResults(ResultSet rs)
    {
        try{
            while(rs.next())
            {
                l.log(rs.toString());
            }
        }
        catch(java.lang.NullPointerException e)
        {
            l.log(e.getMessage());
        }
        catch(SQLException e)
        {
            l.log(e.getMessage());
        }
    }
    
    /**
     * Disconnect from the database
     */
    void disconnect(Connection con){
        try {
            con.close();
        }
        catch(Exception e)
        {
            l.log(e.getMessage());
        }
    }
    
    /**
     * Insert into database
     * @param sql
     * @param o
     * @throws Exception 
     */
    public void insert(String sql, Object[] o) throws Exception{
        //String sql = "INSERT INTO USERS (Email, Password, First, Last, Phone) VALUES(?1,?2,?3,?4,?5)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for(int i = 0; i < o.length; i++)
            {
                switch(o[i].getClass().getSimpleName())
                {
                    case "String": 
                        pstmt.setString(i+1, (String) o[i]);
                        break;
                    case "Double": 
                        pstmt.setDouble(i+1, (Double) o[i]);
                        break;
                    case "Int": 
                        pstmt.setInt(i+1, (int) o[i]);
                        break;
                    case "Float": 
                        pstmt.setFloat(i+1, (Float) o[i]);
                        break;
                    case "Boolean": 
                        pstmt.setBoolean(i+1, (Boolean) o[i]);
                        break;
                    default:
                        throw new DatabaseInsertException();
                }
            }
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            l.log(e.getMessage());
            throw new DatabaseInsertException();
        }
    }
    /**
     * 
     * @param input
     * @return 
     */
    public String ListToString(String[] input)
    {
        String output = "";
        
        for(int i =0; i<=input.length; i++)
        {
            output += input[i];
            if(i < input.length)
            {
                output += ","; 
            }
        }
        return output;
    }
    
}

