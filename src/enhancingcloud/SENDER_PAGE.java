/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhancingcloud;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;


public class SENDER_PAGE extends javax.swing.JFrame {

    /**
     * Creates new form SENDER_PAGE
     */
    Vector msgsend = new Vector();
    JFileChooser c1 = new JFileChooser();
    File fpath;
    public static String filename, filepath, filesize, filecontent, msg,ipadd,dep,year,sub;
    int portno;
     String[] columnNames = {"FILE NAME", "FILE PATH","FILE KEY"};
     char convert[];
     Socket s1 = null;
     String fn,fs,fp,fk,key,name,password;
    FileInputStream fin;
    byte[] b;
    Vector message = new Vector();
    Connection conn = null;

    public SENDER_PAGE(String n,String p) {
        initComponents();
        name=n;
        password=p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN PAGE");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel3.setText("SELECT FILE");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 10, 90, 15);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 10, 290, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(480, 20, 80, 30);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel4.setText("FILE SIZE");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 60, 80, 15);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(150, 50, 290, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 260, 570, 140);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ENC & UPLOAD FILE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 410, 570, 30);

        jLabel5.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel5.setText("FILE KEY");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 100, 80, 15);

        jTextField3.setEditable(false);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(150, 90, 290, 30);

        jButton4.setText("View Enc key");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(450, 90, 110, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Department");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 210, 80, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MSC,BSC", "MCA,BCA", "BCA,BSC" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(150, 210, 290, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Year");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 170, 26, 15);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "I", "II", "III" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(150, 170, 290, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("SUBJECT");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 135, 60, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JAVA", "PYTHON", "C++", "" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(150, 130, 290, 22);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 584, 390);

        jTabbedPane1.addTab("FILE UPLOAD", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(null);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FILE NAME", "FILE PATH", "FILE KEY"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 20, 560, 190);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton3.setText("GET INFO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(10, 260, 560, 50);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 0, 590, 386);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FILE DETAIL", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("UPLOAD FILE");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        c1.showOpenDialog(null);
        fpath = c1.getSelectedFile();
        filename = fpath.getName();
        filepath = fpath.getAbsolutePath();
        String filepath1 = filepath;
        long fileSize1 = fpath.length();
        long filesize2 = fileSize1 / 1024;
        filesize =""+fileSize1;
      
        try {
            filecontent = new String(Files.readAllBytes(Paths.get(filepath)));
            fin = new FileInputStream(fpath);
            b = new byte[fin.available()];
            fin.read(b);
            msg = new String(b);
            message.add(msg);
            jTextField1.setText(filename);
            jTextField2.setText("" + fileSize1);
            jTextArea1.setText(message.toString());
            fin.close();
        } catch (Exception e1) {

            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
            e1.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

     public Socket ClientSocket() {
        try {
//        	
            ipadd = "localhost";
            portno = 1234;
            s1 = new Socket(ipadd, portno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() ,"Error", 1);
            ex.printStackTrace();
        }
        return s1;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int flg=0,flg2=0;
        try {
//            
            File folder = new File("D://SERVER");
            String[] fileNames = folder.list();
            
            for (int i = 0; i < fileNames.length; i++) {
                try{
            String contents = FileUtils.readFileToString(new File("D://SERVER//"+fileNames[i]), "UTF-8");
            if(contents.contains(filecontent))
                {
                    flg++;
                }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            
            String na;
                for(int i = 0; i < fileNames.length; i++)
                {
                    na=fileNames[i];
                    if(na.equals(filename))
                    {
                        flg2=1;
                    }    
                  
                }
            
            
            
            if(flg>0)
            {
                JOptionPane.showMessageDialog(null, "FILE CONTENT IS SAME PLEASE UPLOAD SOME OTHER FILE");
            }
            else if(flg2>0)
            {
                JOptionPane.showMessageDialog(null, "PLEASE RE-NAME THE FILE");
            }
            else if(flg2==0 && flg==0)
                {
                    try {
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/encloud", "root", "root");
                        Statement stmt = (Statement) con.createStatement();
                        String Sql = "Select * from keypath";
                         ResultSet rs = stmt.executeQuery(Sql);
                         while (rs.next()) {
                            String kwd = rs.getString("keyword");
                            if (filecontent.contains(kwd)) {
                                File theDir = new File("D:/DataSet/" + kwd);

                                if (theDir.exists()) {
                                    //   String fpath="D:/"+folder1+"/" +keyword+"/"+ fileNames[i];
                                    String fpath = "D:/DataSet/" + kwd + "/" + filename;
                                    try {

                                        PrintWriter out = new PrintWriter("D:/DataSet/" + kwd + "/" + filename);
                                        out.println(filecontent);
                                        out.close();
                                        //  updatedb();
                                    } catch (Exception e) {
                                        System.out.println("Exception in file upload1");
                                    }

                                }

                            }
                        }
                        
                        PrintWriter out = new PrintWriter("D:/SERVER/" + filename);

                        out.println(filecontent);
                        out.close();
                        updatedb();
                        JOptionPane.showMessageDialog(null, "FILE LOADED IN SERVER");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            
        String a=jTextField1.getText();
        String b=jComboBox3.getSelectedItem().toString();
        String c=jComboBox2.getSelectedItem().toString();
        String d=jComboBox1.getSelectedItem().toString();
        String e=jTextArea1.getText();
         try {
              msgsend.clear();
               msgsend.add("upload");  
               msgsend.add(a);  
               msgsend.add(b);
               msgsend.add(c);
               msgsend.add(d);
               msgsend.add(e);
               msgsend.add(name);
               
            
                s1 = ClientSocket();
                ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
                oos.writeObject(msgsend);
                s1.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
                System.out.println(e1);
            } finally {
                //  s1.close();
            }
//               msgsend.clear();
//               msgsend.add("upload");  
//               msgsend.add(filename);  
//               msgsend.add(key);
//               msgsend.add(filecontent);  
//              try {
//                s1 = ClientSocket();
//                ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
//                oos.writeObject(msgsend);
//                s1.close();
//            } catch (Exception e1) {
//                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
//                System.out.println(e1);
//            } finally {
//                //  s1.close();
//            }
           
            
        } catch (Exception e) {
            System.out.println("Exception in file upload");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try{
        
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/encloud", "root", "root");
             
            model.setColumnIdentifiers(columnNames);
            String sql = "select * from fileinfo WHERE name='"+name+"'";
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fn = rs.getString("FileName");
                fp = rs.getString("FilePath");
                fk = rs.getString("FileKey");
                System.out.println("key :"+fk);
                model.addRow(new Object[]{fn,fp,fk});
                

            }
            rs.close();
            ps.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       
         try {
             
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/encloud", "root", "root");
            Statement stmt = (Statement) conn.createStatement();
            
             String insert = "select filekey from fileinfo where filename='"+jTextField1.getText()+"' and name='"+name+"'";
             ResultSet rs=stmt.executeQuery(insert);
             if(rs.next())
             {
                jTextField3.setText(rs.getString("FileKey"));
             }
        } catch (Exception e) {
            System.out.println("view owner 1" + e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);

        }
        
            
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    public void encriptionfunction() throws IOException {

        int temp = 0;
        String ptext;
        String kkey;
        int s[] = new int[256];
        int k[] = new int[256];

        filecontent = new String(Files.readAllBytes(Paths.get(filepath)));
        ptext = filecontent;
        //
        char ptextc[] = ptext.toCharArray();
        char keyc[] = key.toCharArray();
        int cipher[] = new int[ptext.length()];
        int decrypt[] = new int[ptext.length()];

        int ptexti[] = new int[ptext.length()];
        int keyi[] = new int[key.length()];

        for (int i = 0; i < ptext.length(); i++) {
            ptexti[i] = (int) ptextc[i];
        }
        for (int i = 0; i < key.length(); i++) {
            keyi[i] = (int) keyc[i];
        }
        for (int i = 0; i < 255; i++) {
            s[i] = i;
            k[i] = keyi[i % key.length()];
        }
        int j = 0;
        for (int i = 0; i < 255; i++) {
            j = (j + s[i] + k[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        int i = 0;
        j = 0;
        int z = 0;
        for (int l = 0; l < ptext.length(); l++) {
            i = (l + 1) % 256;
            j = (j + s[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = s[(s[i] + s[j]) % 256];
            cipher[l] = z ^ ptexti[l];
            decrypt[l] = z ^ cipher[l];
        }

        display(cipher);

    }

    void display(int disp[]) {
        convert = new char[disp.length];
        for (int l = 0; l < disp.length; l++) {
            convert[l] = (char) disp[l];
            System.out.print(convert[l]);

        }
    }
    
    
    public void updatedb()
    {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SENDER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SENDER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SENDER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SENDER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ADMIN_PAGE().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SENDER_PAGE().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
