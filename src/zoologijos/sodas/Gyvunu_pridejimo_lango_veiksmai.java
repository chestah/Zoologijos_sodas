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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author k.miknys
 */
public class Gyvunu_pridejimo_lango_veiksmai extends Abstraktus {
    public List<Integer> gyvunu_identifikatorius = new ArrayList<Integer>();
     
    @Override
    public void trinti_irasa(int ID,DefaultTableModel table,Statement st,ResultSet rs,Connection connection) {
         try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM gyvunai WHERE ID='"+gyvunu_identifikatorius.get(ID)+"'");
            pridejimo_lango_uzpildis(table, st, rs, connection);
         } catch (SQLException ex) {
             Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
         }
          
     
    }
    @Override
     public void prideti_irasa(String rusis,String vardas,String narvas,DefaultTableModel table,Statement st,Connection connection,ResultSet rs){
          
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO gyvunai(rusis, vardas, narvas) VALUES ('"+rusis+"','"+vardas+"','"+narvas+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
          pridejimo_lango_uzpildis(table, st, rs, connection);
    }
    @Override
    public Boolean redaguoti_irasa(int ID,String rusis,String vardas,String narvas,String data,DefaultTableModel table,Statement st,Connection connection) {
         
        try {
            st = connection.createStatement();
            st.executeUpdate("UPDATE gyvunai SET rusis ='"+rusis+"', vardas ='"+vardas+"', narvas ='"+narvas+"', Gimimo_data ='"+data+"' WHERE ID ="+gyvunu_identifikatorius.get(ID));
        } catch (SQLException ex) {
            Logger.getLogger(Gyvunu_pridejimo_lango_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public DefaultTableModel pridejimo_lango_uzpildis(DefaultTableModel table,Statement st,ResultSet rs,Connection connection){
        try {
            System.out.println(table.getRowCount());
            table.setRowCount(0);
            gyvunu_identifikatorius.clear();
            st = connection.createStatement();
         
            
            
           rs = st.executeQuery("SELECT * FROM gyvunai ORDER BY ID");
            
            while(rs.next()) {
                table.insertRow(table.getRowCount(), new String[]{rs.getString("rusis"),rs.getString("vardas"),rs.getString("narvas"),rs.getString("Gimimo_data")});
                gyvunu_identifikatorius.add(rs.getInt("ID"));
                //list.add(rs.getString("vardas"));
            }
        
        } catch (SQLException ex) {
           // Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return list;
        return table;
    }
    
    
}
