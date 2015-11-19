

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import zoologijos.sodas.gyvunu_pridejimo_lango_veiksmai;
import zoologijos.sodas.irankiu_veiksmai;
import zoologijos.sodas.mysql_veiksmai;

/**
 * @author Kazimieras
 */

public class NewJFrame extends javax.swing.JFrame {
    
    mysql_veiksmai DB = new mysql_veiksmai();
    irankiu_veiksmai irankiai = new irankiu_veiksmai();
    gyvunu_pridejimo_lango_veiksmai gyv_add=new gyvunu_pridejimo_lango_veiksmai();
    List<String> gyv_vardai=new ArrayList<String>();
    DefaultTableModel table_model; 
    public NewJFrame() throws SQLException {
        initComponents();
        DB.prisijungimas_db();
        
        table_model=(DefaultTableModel)table1.getModel(); // 
        DB.pridejimo_lango_uzpildis(table_model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mygtukas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jSplitPane1 = new javax.swing.JSplitPane();
        pridėti = new javax.swing.JButton();
        redaguoti = new javax.swing.JButton();
        trinti = new javax.swing.JButton();
        textbox_rus = new javax.swing.JTextField();
        textbox_vard = new javax.swing.JTextField();
        textbox_narv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(213, 213, 213));

        mygtukas.setText("jButton1");
        mygtukas.setActionCommand("mygtukas");
        mygtukas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mygtukasActionPerformed(evt);
            }
        });

        table1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rūšis", "Vardas", "Narvas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        pridėti.setText("Pridėti");
        pridėti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridėtiActionPerformed(evt);
            }
        });

        redaguoti.setText("Redaguoti");
        redaguoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redaguotiActionPerformed(evt);
            }
        });

        trinti.setText("Trinti");

        textbox_rus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textbox_rusActionPerformed(evt);
            }
        });

        jLabel1.setText("Rūšis:");

        jLabel2.setText("Vardas");

        jLabel3.setText("Narvas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mygtukas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(redaguoti)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textbox_narv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                        .addComponent(textbox_rus, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textbox_vard, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trinti)
                        .addGap(182, 182, 182))))
            .addGroup(layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(pridėti)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textbox_rus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textbox_vard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textbox_narv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridėti)
                    .addComponent(redaguoti)
                    .addComponent(trinti))
                .addGap(29, 29, 29)
                .addComponent(mygtukas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );

        mygtukas.getAccessibleContext().setAccessibleName("mygtukas");

        getAccessibleContext().setAccessibleName("mygtukas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mygtukasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mygtukasActionPerformed
        try {
            DB.prisijungimas_db();
            gyv_vardai=DB.rusies("Katė");
             for(String gyv: gyv_vardai){
                System.out.println(gyv);
            }
            DB.atsijungimas();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_mygtukasActionPerformed

    private void textbox_rusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textbox_rusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textbox_rusActionPerformed

    private void pridėtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridėtiActionPerformed
        try {
            DB.prisijungimas_db();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        table_model.insertRow(table_model.getRowCount(), new Object[]{textbox_rus.getText(), textbox_vard.getText(),textbox_narv.getText()});
    }//GEN-LAST:event_pridėtiActionPerformed

    private void redaguotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redaguotiActionPerformed
       
       System.out.print(table1.getSelectedRow()+1);
        try {
            irankiai.table_eilutes_redagavimas(textbox_rus, table_model, table1, 0);
       irankiai.table_eilutes_redagavimas(textbox_vard, table_model, table1, 1);
       irankiai.table_eilutes_redagavimas(textbox_narv, table_model, table1, 2);
            DB.redaguoti_irasa(table1.getSelectedRow()+1, textbox_rus.getText(), textbox_vard.getText(), textbox_narv.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_redaguotiActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       irankiai.table_eilutes_gavimas(textbox_rus, table_model, table1,0);
       irankiai.table_eilutes_gavimas(textbox_vard, table_model, table1,1);
       irankiai.table_eilutes_gavimas(textbox_narv, table_model, table1,2);
    }//GEN-LAST:event_table1MouseClicked
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton mygtukas;
    private javax.swing.JButton pridėti;
    private javax.swing.JButton redaguoti;
    private javax.swing.JTable table1;
    private javax.swing.JTextField textbox_narv;
    private javax.swing.JTextField textbox_rus;
    private javax.swing.JTextField textbox_vard;
    private javax.swing.JButton trinti;
    // End of variables declaration//GEN-END:variables
}
