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

/**
 *
 * @author k.miknys
 */
public class mysql_veiksmai extends Abstraktus {
    Connection connection=null;
    Statement st = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    List<String> list = new ArrayList<String>();
    
    String url = "jdbc:mysql://localhost:3306/zoologijos";
    String username = "root";
    String password = "";
    
    @Override void piesti()
    {
        
    }        
    public void prisijungimas_db()
    {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         connection= DriverManager.getConnection(url, username, password);
       
                } catch (SQLException ex) {
                    Logger.getLogger(ZoologijosSodas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public List rusies(String rusis_kint){
        
        try {
            rusis_kint="ŠUO";
            st = connection.createStatement();
          
           rs = st.executeQuery("SELECT * FROM gyvunai where rusis = '"+rusis_kint+"' ORDER BY ID");
            
            while(rs.next()) {//get first result
                
                list.add(rs.getString("vardas"));//coloumn 1
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
    }
}
