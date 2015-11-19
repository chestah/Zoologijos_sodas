/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologijos.sodas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author k.miknys
 */
public class mysql_veiksmai  {
    Connection connection=null;
    Statement st = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    List<String> list = new ArrayList<String>();
    List<Integer> gyvunu_identifikatorius = new ArrayList<Integer>();
    String url = "jdbc:mysql://localhost:3306/zoologijos";
    String username = "root";
    String password = "";
    
      
    public void prisijungimas_db() throws SQLException
    {
        connection= DriverManager.getConnection(url, username, password);
       
        
        System.out.println("Database connected!");
       
    }
    public void atsijungimas() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                st=null;
                rs=null;               
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public DefaultTableModel pridejimo_lango_uzpildis(DefaultTableModel table){
        try {
            String rusis_kint;
            rusis_kint="Šuo";
            
            st = connection.createStatement();

        
           rs = st.executeQuery("SELECT * FROM gyvunai ORDER BY ID");
            
            while(rs.next()) {
                gyvunu_identifikatorius.add(rs.getInt("ID")); //Eina table1 visvien pagal "order by id"
                table.insertRow(table.getRowCount(), new String[]{rs.getString("rusis"),rs.getString("vardas"),rs.getString("narvas")});
                //list.add(rs.getString("vardas"));
            }
           for(Integer s:gyvunu_identifikatorius)
           {
              
           }
        } catch (SQLException ex) {
            Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return list;
        return table;
    }
    public List rusies(String rusis_kint){
        
        try {
            rusis_kint="Šuo";
            st = connection.createStatement();
          
           rs = st.executeQuery("SELECT * FROM gyvunai where rusis = '"+rusis_kint+"' ORDER BY ID");
            
            while(rs.next()) {
                
                list.add(rs.getString("vardas"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
    }
   public void redaguoti_irasa(int ID,String rusis,String vardas,String narvas) throws SQLException {
           st = connection.createStatement();
          System.out.println(rusis+" "+ vardas+" "+ narvas);
          st.executeUpdate("UPDATE gyvunai SET rusis ='"+rusis+"', vardas ='"+vardas+"', narvas ='"+narvas+"' WHERE ID ="+ID);
    }
  
}
