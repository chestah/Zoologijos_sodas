/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologijos.sodas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kazimieras
 */
public class Pretendentu_veiksmai extends Mysql_veiksmai{
 public  List<Integer> pretendentu_identifikatorius = new ArrayList<Integer>();

    Mysql_veiksmai DB=new Mysql_veiksmai();
    
    
     public DefaultTableModel pretendentu_lango_uzpildis(DefaultTableModel table,Statement st,ResultSet rs,Connection connection){
        try {
            System.out.println(table.getRowCount());
            table.setRowCount(0);
            pretendentu_identifikatorius .clear();
           st = connection.createStatement();
         
            
           
           rs = st.executeQuery("SELECT * FROM pretendentai ORDER BY ID");
            
            while(rs.next()) {
                table.insertRow(table.getRowCount(), new String[]{rs.getString("vardas"),rs.getString("pavarde"),rs.getString("gimimo_data"),rs.getString("darbo_vieta")});
                pretendentu_identifikatorius.add(rs.getInt("ID"));
                //list.add(rs.getString("vardas"));
                 
            }
        
        } catch (SQLException ex) {
           // Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return list;
        return table;
    }
    
      public DefaultTableModel pretendentu_lango_uzpildis(DefaultTableModel table,Statement st,ResultSet rs,Connection connection,Integer statusas){
        try {
            System.out.println(table.getRowCount());
            table.setRowCount(0);
            pretendentu_identifikatorius .clear();
           st = connection.createStatement();
         
            
            
               rs = st.executeQuery("SELECT * FROM pretendentai WHERE statusas_priimtas="+statusas+" ORDER BY ID");
            
            while(rs.next()) {
                table.insertRow(table.getRowCount(), new String[]{rs.getString("vardas"),rs.getString("pavarde"),rs.getString("gimimo_data"),rs.getString("darbo_vieta")});
                pretendentu_identifikatorius.add(rs.getInt("ID"));
              
               
                //list.add(rs.getString("vardas"));
            }
        
        } catch (SQLException ex) {
           // Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return list;
        return table;
    }
     
    public JTextArea pretendentu_area(JTextArea area,JTable table,Statement st,ResultSet rs,Connection connection){
      try{
        st = connection.createStatement();           
           rs = st.executeQuery("SELECT motyvacinis FROM pretendentai where ID="+pretendentu_identifikatorius.get(table.getSelectedRow()));
            while(rs.next()) {
                area.setText(rs.getString("motyvacinis"));
            }
      }
      catch(SQLException ex){}
            
        return area;
    }
    public JTextArea pretendentu_area(JTextArea area,JTable table,Statement st,ResultSet rs,Connection connection,Integer intas){
      try{
        st = connection.createStatement();           
           rs = st.executeQuery("SELECT issilavinimas FROM pretendentai where ID="+pretendentu_identifikatorius.get(table.getSelectedRow()));
            while(rs.next()) {
                area.setText(rs.getString("issilavinimas"));
            }
      }
      catch(SQLException ex){}
            
        return area;
    }
    public void statusas(JTable table,Statement st,Connection connection,Integer statusas){
             try{
        st = connection.createStatement();  
       
        st.executeUpdate("UPDATE pretendentai SET statusas_priimtas="+statusas+" WHERE ID ="+pretendentu_identifikatorius.get(table.getSelectedRow()));
        
             }
             catch(SQLException ex){}     
    }
    public void atmesti(DefaultTableModel table,JTable stalas,Statement st,ResultSet rs,Connection connection){
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM pretendentai WHERE ID='"+pretendentu_identifikatorius.get(stalas.getSelectedRow())+"'");
            pretendentu_lango_uzpildis(table, st, rs, connection);
         } catch (SQLException ex) {
            
         }
    }
      public String toString() {
        return "Pretendentu_veiksmai{" + "Pretendentu identfikatorius=" + pretendentu_identifikatorius.size()+  '}';
    }
}
