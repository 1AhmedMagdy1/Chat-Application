package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class databaseQuery {
 dbconn conection=new dbconn();
    Statement stmt;
    Connection con;
     ResultSet rs;
      byte[] imag;
      String filename="";
     public static String path = "jdbc:sqlserver://localhost;databaseName=chatingapp";
public static String user ="sa";
public static String pass ="321";

//conection.connecttosql();
     databaseQuery(){
         
        // conection.connecttosql();
        try {
            con = DriverManager.getConnection(path, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public void onlogin(String username,String password){
        
        try{    
   //c1.con=DriverManager.getConnection(c1.path, c1.user, c1.pass);
   stmt=conection.con.createStatement();
    rs=stmt.executeQuery("select image from userinfo where username ="+username+" and "+"password ="+password                                                                                                                                                                                   );
    
}catch(SQLException e){
            System.out.println("on login exciption");
}
    }
    public void onsignup(String username,String password,JLabel imgholder) throws SQLException{
       //String id=username+password;
      byte[] profile = null;
      JFileChooser fe1=new JFileChooser();
      int j=fe1.showOpenDialog(null);
       
              File chosenFile;
             chosenFile=fe1.getSelectedFile();
                     
      File image = chosenFile;
            filename=image.getAbsolutePath();
            filename=image.getAbsolutePath();
            ImageIcon profileImg=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(imgholder.getWidth(),imgholder.getHeight(),Image.SCALE_SMOOTH));
            imgholder.setIcon(profileImg);
            try{
                File f1=new File(filename);
                FileInputStream fis=new FileInputStream(image);
                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                byte[] buff=new byte[1024];
                for (int i ;(i=fis.read(buff))!=-1;) {
                    bos.write(buff,0,i);
                }
                profile=bos.toByteArray();
            }catch(Exception e){
                System.out.println("shit");
            }
            String userid=username+password;

String query = "INSERT INTO userinfo (userid, username, passworde, imge) VALUES (?, ?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, userid);
pstmt.setString(2, username);
pstmt.setString(3, password);
pstmt.setBytes(4, profile);
pstmt.executeUpdate();          
      System.out.println("INSERTED");
       
    }
     void setclientinfo(JLabel imgholder,JLabel infoholder,String usid){
         PreparedStatement pstmt;
         BufferedImage image = null;
          String usname=null;
       try {
           pstmt = con.prepareStatement("SELECT image, username FROM mytable WHERE user_id = ?");
           pstmt.setString(1, usid);
            usname=rs.getString("username");
            byte profile[]=rs.getBytes("image");
             image = ImageIO.read(new ByteArrayInputStream(profile));
       } catch (SQLException ex) {
           Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
            imgholder.setIcon((Icon) image);
             infoholder.setText(path);
        
            // Convert the byte array to a BufferedImage object
            
            
            // Do something with the BufferedImage object, such as displaying it in a JLabel
            // ...
       
     }
     
     public  String[] historyotxt(String username,String wanted){
        String []msgdata = null;
     try {
          String query = "SELECT * FROM chat_history WHERE "+wanted+" IS NOT NULL AND userid = ?"; 
         PreparedStatement pstmt = con.prepareStatement(query);
          pstmt.setString(1, username);
          ResultSet rs = pstmt.executeQuery();
          int i=0;
          while (rs.next()) {
                String masag = rs.getString(username);
               msgdata[i]=masag;
            }
     } catch (SQLException ex) {
         Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
         return msgdata;
     }
     
     public boolean signedup(String username){
     try {
         String query = "select * from chat_history where userid = "+username;
         PreparedStatement pstmt = con.prepareStatement(query);
          ResultSet rs = pstmt.executeQuery();
          return rs.next();
     } catch (SQLException ex) {
         Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     }
     }
     
     
  void insert_txt(String massage,String userid){
     try {
         System.out.println(massage);
          String query = "INSERT INTO chat_history (userid,msg) VALUES (?,?)";
           PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userid);
            pstmt.setString(2, massage);
             pstmt.executeUpdate();
               System.out.println("inserted");

     } catch (SQLException ex) {
         Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
  }  
  void insert_img(String imagename,byte[]imagecontent,String userid){
     try {
         System.out.println(imagename);
          String query = "INSERT INTO chat_history (images,imagesdata,userid) VALUES (?,?,?)";
           PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, imagename);
            pstmt.setBytes(2, imagecontent);
             pstmt.setString(3, userid);
             pstmt.executeUpdate();
               System.out.println("inserted");

     } catch (SQLException ex) {
         Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
  }
   void insert_file(String filename,byte[]filecontent,String  userid){
     try {
         System.out.println(filename);
          String query = "INSERT INTO chat_history (filenam,filedata, userid) VALUES (?,?,?)";
           PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, filename);
            pstmt.setBytes(2, filecontent);
             pstmt.setString(3, userid);
             pstmt.executeUpdate();
               System.out.println("inserted");

     } catch (SQLException ex) {
         Logger.getLogger(databaseQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
  }
}
