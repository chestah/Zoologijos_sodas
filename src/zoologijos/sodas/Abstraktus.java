/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologijos.sodas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author k.miknys
 */
public abstract class Abstraktus {
 
   public abstract void trinti_irasa(int ID,DefaultTableModel table,Statement st,ResultSet rs,Connection connection);
   public abstract Boolean redaguoti_irasa(int ID,String rusis,String vardas,String narvas,String data,DefaultTableModel table,Statement st,Connection connection); 
   public abstract void prideti_irasa(String rusis,String vardas,String narvas,DefaultTableModel table,Statement st,Connection connection,ResultSet rs);
}
