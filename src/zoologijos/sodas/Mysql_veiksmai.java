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
public class Mysql_veiksmai  {
   public Connection connection=null;
   public Statement st = null;
    PreparedStatement pstmt=null;
   public ResultSet rs = null;
    List<String> list = new ArrayList<String>();
    List<Integer> gyvunu_identifikatorius = new ArrayList<Integer>();
    String url ;
    String username;
    String password="";
    
      public Mysql_veiksmai(){
           url = "jdbc:mysql://localhost:3306/zoologijos";
           username = "root";
      }
      public Mysql_veiksmai(String pass){
                    password = pass;
      }
      
      
    public void prisijungimas_db() throws SQLException
    {
        connection= DriverManager.getConnection(url, username, password);       
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
            gyvunu_identifikatorius.clear();
            table.setRowCount(0);
            
            st = connection.createStatement();

        
           rs = st.executeQuery("SELECT * FROM gyvunai ORDER BY ID");
            
            while(rs.next()) {
                gyvunu_identifikatorius.add(rs.getInt("ID")); //Eina table1 visvien pagal "order by id"
                
                table.insertRow(table.getRowCount(), new String[]{rs.getString("rusis"),rs.getString("vardas"),rs.getString("narvas"),rs.getString("Gimimo_data")});
                //list.add(rs.getString("vardas"));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_veiksmai.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return list;
        return table;
    }
   @Override
   public String toString() {
        return "Mysql_veiksmai{" + "Connection=" +connection+", Statement=" + st +", ResultSet=" + rs +", Statement=" + st +", URL=" + url +", Login=" + username +", PASS=" + password + '}';
    }
  
}
   /* public void trinti_irasa(int ID,DefaultTableModel table) throws SQLException {
         System.out.println("\n");
        System.out.println("Gaunamas ID= "+ID);
        System.out.println("Saraso elementas pagal ta ID= "+gyvunu_identifikatorius.get(ID));
           st = connection.createStatement();
          
          st.executeUpdate("DELETE FROM gyvunai WHERE ID='"+gyvunu_identifikatorius.get(ID)+"'");
          pridejimo_lango_uzpildis(table);
    }
      public void pridėti_irasa(String rusis,String vardas,String narvas,DefaultTableModel table) throws SQLException {
           st = connection.createStatement();
          st.executeUpdate("INSERT INTO gyvunai(rusis, vardas, narvas) VALUES ('"+rusis+"','"+vardas+"','"+narvas+"')");
          pridejimo_lango_uzpildis(table);
    }
     public void redaguoti_irasa(int ID,String rusis,String vardas,String narvas,String data) throws SQLException {
           st = connection.createStatement();
          st.executeUpdate("UPDATE gyvunai SET rusis ='"+rusis+"', vardas ='"+vardas+"', narvas ='"+narvas+"', Gimimo_data ='"+data+"' WHERE ID ="+gyvunu_identifikatorius.get(ID));
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
    }*/