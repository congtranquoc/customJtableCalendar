
package customcalendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author SEHC
 */
public class CustomPopUp extends JDialog{
    

    private static final int POPUP_WIDTH = 200;
    private static final int POP_HEIGHT = 100;
    
    public CustomPopUp(String text){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(POPUP_WIDTH, POP_HEIGHT));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx =1;
        gbc.weighty =1;
        gbc.fill = GridBagConstraints.BOTH;
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        panel.add(label, gbc);
        add(panel);
    }
   
}
