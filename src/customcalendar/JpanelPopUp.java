/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customcalendar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author SEHC
 */
public class JpanelPopUp extends JPanel{

    public JpanelPopUp() {
        setBackground(Color.red);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(252,217,196));
        g2.fillRect(8, 0, getSize().width - 8, getSize().height);
        int x[] = {0,10,10};
        int y[] = {20,13,27};
        g2.fillPolygon(x, y, x.length);
        super.paintComponent(g);
    }
    
    
    
}
