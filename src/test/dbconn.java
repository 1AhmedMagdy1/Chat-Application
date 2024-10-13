
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconn {
       public static String path = "jdbc:sqlserver://localhost;databaseName=chatingapp";
public static String user ="sa";
public static String pass ="321";
/////////////
public static Connection con;
////////////////
//String query="insert into userinfo(userid,username,password,image)";
        
    public static void connecttosql(){
  
 try{
     con=DriverManager.getConnection(path, user, pass);
 System.out.println("CONNECTED");
 }catch(SQLException e){
     Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, e);
 System.out.println("Error CONNECTION");
 }
    }
    
       public static void closeconnection(){
        try{
        con.close();
    }catch (SQLException ex) {
  System.out.println("ERROR Connection");
   }
}
    public void insertDatta(String query,byte[] profile,String username,String pass) throws SQLException {
       
    }
    
       public static boolean executequery(String sqlquery){//to insert,update,delete
        try{
            Statement stmt=con.createStatement();
            stmt.executeQuery(sqlquery);
            return true;
        }catch(SQLException ex){
         System.out.println(ex);
         return false;
        }
    }
}
