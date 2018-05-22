package connectionMySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/arduino?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "newrootpassword";
    
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if (con != null)
        {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
       if(stmt != null){
           try {
               stmt.close();
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
       closeConnection(con);
    }
    
      public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
      
         if (rs != null){
             try {
                 rs.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
         } 
         
          closeConnection(con, stmt);
    }
    
    
    
    
}

