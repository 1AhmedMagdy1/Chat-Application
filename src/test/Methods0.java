package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import test.client;

/**
 *
 * @author Mohamed
 */
public class Methods0 extends client{
    static byte []tmp;
//  public static void recievefile(){
//    try {
//                    int size = din.readInt();
//                    System.out.println("size");
//                    byte arr[] = new byte[size];
//                    tmp=arr;
//                    System.out.println("arr");
//                    
//                    din.readFully(arr, 0, size);
//                    System.out.println("reay");
//                    String filname=din.readUTF();
//                    System.out.println("fma");
//                    System.out.println(filname);
//                                   int x=filname.lastIndexOf(".");
//    String extention=filname.substring(x, filname.length());
//    if(extention.equals("png")||extention.equals("jpg")||extention.equals("bmp"))
//    {
//        ////server recive img
//        sendimg image=new sendimg(filname);
//        chat.add(image);
//            image.revalidate();
//                   
//    }
//                    //ff.addAncestorListener(listener);
//     
//                    else{ 
//                     fileshower ff=new fileshower(filname,"reci",filname);
//                     chat.add(ff);
//                     ff.revalidate();
//                     //ff.putfile=true;
//                     ff.putfile=true;
//                   }
//                         
//                        System.out.println("siga");
//                     fos = new FileOutputStream("C:\\Users\\user\\OneDrive\\سطح المكتب\\"+filname);
//                    fos.write(arr);
//                    
//                    System.out.println("dddd");
//                  //  fos = new FileOutputStream("C:\\Users\\user\\OneDrive\\سطح المكتب\\modern Academy\\img.pdf");
//                  
//                } catch (IOException ex) {
//                    Logger.getLogger(Methods0.class.getName()).log(Level.SEVERE, null, ex);
//                }
//    }
//  public static void ricievetxt(){
//     try {
//              String msgin = "";
//                    msgin = din.readUTF();
//                    //put in msgview
//                    
//chat.setLayout(new javax.swing.BoxLayout(chat, javax.swing.BoxLayout.Y_AXIS));
//        chat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
//
//                    sendmsg ms=new sendmsg();
//       
//       ms.getinfo(msgin, UserName);
//                chat.add(ms);
//                
//                //y+=10;
//                ms.revalidate();
//                    String temp = msgArea.getText().trim();
//                    msgArea.setText(" ");
//                    msgArea.append(temp + "\n" + msgin);
//                    System.out.println(msgin);
//                    //      din.notify();
//                } catch (IOException ex) {
//                    Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
//                }
//    }
//  public static void send_message(){
//  String msgout = "";
//  
//        if (msgtxt.getText().isEmpty()) {
//            System.out.println("empty");
//        } else {
//            try {
//                msgout = msgtxt.getText().trim();
//                dout.writeUTF( msgout);//UserName + ": " +
//                chat.setLayout(new javax.swing.BoxLayout(chat, javax.swing.BoxLayout.Y_AXIS));
//        chat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
//
//                    sendmsg ms=new sendmsg();
//       
//       ms.getinfo(msgout, UserName);
//                chat.add(ms);
//                
//                //y+=10;
//                ms.revalidate();
//                msgArea.append("\n" + UserName + ": " + msgout);
//            } catch (IOException ex) {
//                System.out.println("send error ");
//            }
//            msgtxt.setText(" ");
//        }     
//  }
//  
   
   
//private  boolean chk(String file,String ext){
//   //String d=file.getName();
//        int x=file.lastIndexOf(".");
//        String ext1=file.substring(x, file.length());
//   if(ext.equals(ext1))
//       return true;
//   else
//        return false;
//   
//}
//private static void check(String filename){
    
//}
}
