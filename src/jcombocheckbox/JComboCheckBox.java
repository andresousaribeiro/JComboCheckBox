/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcombocheckbox;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author AndreRibeiro
 */
public class JComboCheckBox extends JComboBox {
    Vector v = new Vector();  
    
    public JComboCheckBox() {
        init();
    }

     public JComboCheckBox(Vector items) {
      super(items);
      v = items;
      init();
   }

    private void init() {
        setRenderer(new ComboBoxRenderer());
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                itemSelected();
            }
        });
    }

    private void itemSelected() {
        if (getSelectedItem() instanceof JCheckBox) {
            JCheckBox jcb = (JCheckBox) getSelectedItem();
            jcb.setSelected(!jcb.isSelected());
            SwingUtilities.invokeLater(new Runnable(){

                public void run()
                {

                   showPopup();
                }
            });
        }
    }

    class ComboBoxRenderer implements ListCellRenderer {

        private JLabel label;

        public ComboBoxRenderer() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Component) {
                Component c = (Component) value;
                if (isSelected) {
                    c.setBackground(list.getSelectionBackground());
                    c.setForeground(list.getSelectionForeground());
                } else {
                    c.setBackground(list.getBackground());
                    c.setForeground(list.getForeground());
                }

                return c;
            } else {
                if (label == null) {
                    label = new JLabel(value.toString());
                } else {
                    label.setText(value.toString());
                }

                return label;
            }
        }
    }
    
}
