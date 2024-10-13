package test;

//import function.Method;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Send_File_New extends javax.swing.JPanel {
 public static byte content[];
    public int getFileID() {
        return fileID;
    }
public static void set_content(byte[]data){
content=data;
}

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Send_File_New() {
        initComponents();
    }
    private int fileID;
    private String fileName;
    private String fileSize;

    public static void set_content(){
    
    
    }
    public void set(String fileName) {
        //this.fileID = Integer.valueOf(fileName.split("!")[0]);
       // this.fileName = fileName.split(".")[1];
      //  this.fileSize = fileName.split(".")[2];
       // lbFileName.setIcon(icon);
       this.fileName=fileName;
        lbFileName.setText(this.fileName);
//        if (Method.getFriends().get(ID).getImage() != null) {
//            profile.setIcon(Method.getFriends().get(ID).getImage());
//        }
        lbFileName.setToolTipText(fileSize);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        border = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbFileName = new javax.swing.JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new java.awt.Color(72, 173, 243));
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
            }
        };

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 72));

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        border.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/border_small.png"))); // NOI18N
        jLayeredPane1.add(border);

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile_small.png"))); // NOI18N
        jLayeredPane1.add(profile);

        lbName.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(29, 118, 206));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbName.setText("You");

        lbFileName.setFont(new java.awt.Font("Khmer SBBIC Serif", 0, 13)); // NOI18N
        lbFileName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file_1.png"))); // NOI18N
        lbFileName.setText("File name.rar");
        lbFileName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        lbFileName.setContentAreaFilled(false);
        lbFileName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFileName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbFileNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbFileName)))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbFileNameActionPerformed
       if(!fileName.equals("")){
        downloadFile( fileName);
       }
       else{
       downloadFile();
       }
    }//GEN-LAST:event_lbFileNameActionPerformed

   public static void downloadFile( String name) {
       try {
            String ex[] = name.split("\\.");
            String x = ex[ex.length - 1];
            JFileChooser ch = new JFileChooser();
            ch.setSelectedFile(new File(name));
            int c = ch.showSaveDialog(null);
            if (c == JFileChooser.APPROVE_OPTION) {
                File f = ch.getSelectedFile();
                if (f.exists()) {
                    int click = JOptionPane.showConfirmDialog(null, "This file name has already do you want to replace", "Save File", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (click != JOptionPane.YES_OPTION) {
                        return;
                    }
                }
                String parth = f.getAbsolutePath();
                if (!parth.endsWith("." + x)) {
                    parth += "." + x;
                
                }
                FileOutputStream fos=new FileOutputStream(parth); 
                JOptionPane.showMessageDialog(null, "downloaded successfully");
            }
       }
                catch(Exception e){
                        
                        }
            
        
   }
   public static void downloadFile() {
       JFileChooser ch = new JFileChooser();
   int c = ch.showSaveDialog(null);
   if (c == JFileChooser.APPROVE_OPTION) {
       try{
                File f = ch.getSelectedFile();
                if (f.exists()) {
                    int click = JOptionPane.showConfirmDialog(null, "This file name has already do you want to replace", "Save File", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (click != JOptionPane.YES_OPTION) {
                        return;
                    }
                }
                String parth = f.getAbsolutePath();
//                if (!parth.endsWith("." + x)) {
//                    parth += "." + x;
//                
//                }
                FileOutputStream fos=new FileOutputStream(parth); 
                JOptionPane.showMessageDialog(null, "fdctrgre");
            }catch(IOException e){
            System.out.println(e);
            }
   }
   }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel border;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton lbFileName;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel profile;
    // End of variables declaration//GEN-END:variables
}
