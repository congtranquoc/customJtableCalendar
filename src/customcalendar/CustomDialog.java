
package customcalendar;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class CustomDialog extends javax.swing.JDialog {

    public CustomDialog(String text, Point location) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setModal(false);
//        setOpacity(0f);
//        setBackground(new Color(0,0,0,0));
        setSize(100,50);
        txtDate.setText(text);
        
        setLocation(location.x, location.y -getHeight());
        System.out.println("customcalendar.CustomDialog.<init>()" + location.x);
        addWindowFocusListener(new WindowAdapter(){
            @Override
            public void windowLostFocus(WindowEvent e) {
                setVisible(false);
                dispose();
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel = new customcalendar.JpanelPopUp();
        txtDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(100, 50));
        setUndecorated(true);
        setSize(new java.awt.Dimension(100, 50));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel.setForeground(new java.awt.Color(255, 102, 102));

        txtDate.setBackground(new java.awt.Color(0, 204, 102));
        txtDate.setText("jLabel1");

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Jpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customcalendar.JpanelPopUp Jpanel;
    private javax.swing.JLabel txtDate;
    // End of variables declaration//GEN-END:variables
}
