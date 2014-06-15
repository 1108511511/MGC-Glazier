//testing netbeans git integration
package mgcproject;

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;
import javax.sql.rowset.CachedRowSet;

/**
 * @author Peter C
 */

public class Query {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/my_test"; //*** Change to actual DB name ***
    private static final String USER = "root";
    private static final String PASS = "";  
    
    public static void printFromTable(String sqlString) throws SQLException {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNum = rsmd.getColumnCount();
            System.out.println("Reading from database");
            while(rs.next()) {
                for(int i = 1; i <= columnsNum; i++) {
                    String columnValue = rs.getString(i);
                    System.out.println(rsmd.getColumnName(i) + ": " + columnValue);
                }
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {
            System.err.println("Read SQLException: " + e.getMessage());
        }
    }
    
    public static CachedRowSet readFromTable(String sqlString) throws SQLException {
        CachedRowSet crs = new CachedRowSetImpl();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);            
            System.out.println("Reading from database"); 
            crs.populate(rs);
            rs.close();
            stmt.close();
        } catch(SQLException e) {
            System.err.println("Read SQLException: " + e.getMessage());
        }
        return crs;
    }
    
    public static void writeToTable(String sqlString) throws SQLException {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlString);
            System.out.println("Statement written to database");
        } catch(SQLException e) {
            System.err.println("Write SQLException: " + e.getMessage());
        } 
    }
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            try {   //register JDBC
                Class.forName(JDBC_DRIVER);     
            } catch(ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e.getMessage());
            }   
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database");
        } catch(SQLException e) {
            System.err.println("Write SQLException: " + e.getMessage());
        }
        return conn;
    }
    
}
