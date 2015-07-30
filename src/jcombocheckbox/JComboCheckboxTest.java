/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcombocheckbox;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author AndreRibeiro
 */
public class JComboCheckboxTest extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JComboCheckboxTest window = new JComboCheckboxTest();
    }

    public JComboCheckboxTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        getContentPane().setLayout(new FlowLayout());
        Vector v = new Vector();
        v.add("Europe");
        v.add(new JCheckBox("Brussels", false));
        v.add(new JCheckBox("Paris", false));
        v.add(new JCheckBox("London", false));
        v.add("United States");
        v.add(new JCheckBox("New York", false));
        v.add(new JCheckBox("Detroit", false));
        v.add(new JCheckBox("San Francisco", false));
        JComboCheckBox combo = new JComboCheckBox(v);
        combo.setPreferredSize(new Dimension(100, 30));
        getContentPane().add(combo);
        setVisible(true);
    }
}
