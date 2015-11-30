
package zoologijos.sodas;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author k.miknys
 */
public class irankiu_veiksmai{
    public JTextField table_eilutes_gavimas(JTextField laukas, DefaultTableModel model, JTable table, Integer stulp)
    {
        laukas.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), stulp)));
        return laukas;
    }
  
    public DefaultTableModel table_eilutes_redagavimas(JTextField laukas, DefaultTableModel model, JTable table, Integer stulp)
    {
        model.setValueAt(laukas.getText(), table.getSelectedRow(), stulp);
        return model;
    }
}
