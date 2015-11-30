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
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kazimieras
 */
public class Darbuotoju_veiksmai extends Abstraktus {
public List<Integer> darbuotoju_identifikatorius = new ArrayList<Integer>();
    @Override
    public void prideti_irasa(String vardas, String pavarde, String pareigos, DefaultTableModel table, Statement st, Connection connection, ResultSet rs) {
         try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO darbuotojai(vardas, pavarde, pareigos,isidarbinimo_data) VALUES ('"+vardas+"','"+pavarde+"','"+pareigos+"',NOW())");
        } catch (SQLException ex) {
            Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
          //darbuotoju_lango_uzpildis(table, st, rs, connection);
    
    }

    @Override
    public Boolean redaguoti_irasa(int ID, String rusis, String vardas, String narvas, String data, DefaultTableModel table, Statement st, Connection connection) {
          try {
            st = connection.createStatement();
            st.executeUpdate("UPDATE darbuotojai SET vardas ='"+rusis+"', pavarde ='"+vardas+"', pareigos ='"+narvas+"', isidarbinimo_data='"+data+"' WHERE ID ="+darbuotoju_identifikatorius.get(ID));
        } catch (SQLException ex) {
            Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void trinti_irasa(int ID, DefaultTableModel table, Statement st, ResultSet rs, Connection connection) {
        try {
             Darbuotoju_veiksmai ne=new Darbuotoju_veiksmai();
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM darbuotojai WHERE ID='"+ne.darbuotoju_identifikatorius.get(ID)+"'");
            darbuotoju_lango_uzpildis(table, st, rs, connection);
         } catch (SQLException ex) {
             Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
         }
          
     
    }
    public DefaultTableModel darbuotoju_lango_uzpildis(DefaultTableModel table,Statement st,ResultSet rs,Connection connection){
        try {
           
            table.setRowCount(0);
            darbuotoju_identifikatorius.clear();
           st = connection.createStatement();
         
            
            
           rs = st.executeQuery("SELECT * FROM darbuotojai ORDER BY ID");
            
            while(rs.next()) {
                table.insertRow(table.getRowCount(), new String[]{rs.getString("vardas"),rs.getString("pavarde"),rs.getString("pareigos"),rs.getString("isidarbinimo_data")});
                darbuotoju_identifikatorius.add(rs.getInt("ID"));
                
                //list.add(rs.getString("vardas"));
            }
        
        } catch (SQLException ex) {
           // Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return list;
        return table;
    }
    public void perkelti_pretend_darb(ArrayList<String> pretend,JTextField text,Integer i){
            perkelimas(pretend,text,i);
    }
    private JTextField perkelimas(ArrayList<String> pretend,JTextField text,Integer i){
        //      irankiai.table_eilutes_gavimas(textbox_vardas, table_model_darb, darb_table,0);
     //   irankiai.table_eilutes_gavimas(textbox_pavard, table_model_darb, darb_table,1);
       // irankiai.table_eilutes_gavimas(pareigos, table_model_darb, darb_table,2);
     //   irankiai.table_eilutes_gavimas(textbox_data,  table_model_darb, darb_table,3);
      text.setText(pretend.get(i));
      
      return text;
    }
    
    public void trinti_pretendenta(DefaultTableModel dtable,JTable table,Statement st,ResultSet rs,Connection connection,Integer row){
         try {
             Pretendentu_veiksmai pretend_veiks= new Pretendentu_veiksmai();
            st = connection.createStatement();
            
            st.executeUpdate("DELETE FROM pretendentai WHERE ID='"+row+"'");
           
            pretend_veiks.pretendentu_lango_uzpildis(dtable, st, rs, connection);
         } catch (SQLException ex) {
             Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
