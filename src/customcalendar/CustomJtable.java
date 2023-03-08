/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customcalendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DayOfWeek;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEHC
 */
public class CustomJtable extends JFrame implements ActionListener {

    private DefaultTableModel model;
    private JTable table;
    private String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private JButton prevButton, nextButton, todayButton;
    private JLabel monthLable;
    private int currentMoth = Calendar.getInstance().get(Calendar.MONTH);
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    
    public CustomJtable(){
        setTitle("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        
        model = new DefaultTableModel(new String[]{"Sun","Mon","Tue","Web","Thu","Fri","Sat"},6);
        table = new JTable(model);
        table.setRowHeight(100);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setDefaultEditor(Object.class, null);
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                
                if(row > 0 && col > 0){
                    String date = table.getValueAt(row, col).toString();
                    if(!date.isEmpty()) {
                        System.out.println(".mouseClicked()" + date);
                        Point location = table.getCellRect(row, col, true).getLocation();
                        SwingUtilities.convertPointToScreen(location, table);
                        CustomDialog popup = new CustomDialog(date, location);
                        popup.setSize(100,50);
                        popup.toFront();
                        popup.setVisible(true);
                    }
                }
            }
        });
        
        prevButton = new JButton("<<");
        prevButton.addActionListener(this);
        
        nextButton = new JButton(">>");
        nextButton.addActionListener(this);
        
        todayButton = new JButton("TODAY");
        todayButton.addActionListener(this);
        
        monthLable = new JLabel(monthNames[currentMoth] + " " + currentYear, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(prevButton, BorderLayout.WEST);
        panel.add(monthLable, BorderLayout.CENTER);
        panel.add(nextButton, BorderLayout.EAST);
        panel.add(todayButton, BorderLayout.SOUTH);
        
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        populateTable(currentMoth, currentYear);
        setVisible(true);
        System.out.println("customcalendar.CustomJtable.<init>()" + currentMoth);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == prevButton){
            currentMoth--;
            if(currentMoth < 0){
                currentMoth =11;
                currentYear--;
            }
            System.out.println("customcalendar.CustomJtable.actionPerformed()" + currentMoth);
            populateTable(currentMoth, currentYear);
        } else if(e.getSource() == nextButton){
            currentMoth++;
            if (currentMoth > 11) {
                currentMoth = 0;
                currentYear++;
            }
            populateTable(currentMoth, currentYear);
        } else if (e.getSource() == todayButton){
            currentMoth = Calendar.getInstance().get(Calendar.MONDAY);
            currentYear = Calendar.getInstance().get(Calendar.YEAR);
            populateTable(currentMoth, currentYear);
        }
    }

    private void populateTable(int month, int year) {
        model.setRowCount(0);
        model.addRow(new Object[]{null,null,null,null,null,null,null});
        
        Calendar cal = Calendar.getInstance();
        System.out.println("customcalendar.CustomJtable.populateTable()" + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        cal.set(year, month,1);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("customcalendar.CustomJtable.populateTable()" + firstDayOfWeek);
        
        for (int i = 0; i < firstDayOfWeek; i++){
            model.setValueAt("", 0, i);
        }
        
        int row = 0;
        int col = firstDayOfWeek;
        for(int day = 1; day <= daysInMonth; day++){
            model.setValueAt(day, row, col);
            col++;
            if(col == 7){
                row++;
                col = 0;
                if(day < daysInMonth){
                    model.addRow(new Object[]{null,null,null,null,null,null,null});
                }
            }
        }
        
        monthLable.setText(monthNames[month] + " " + year);
    }
    
    public static void main(String[] args) {
        new CustomJtable();
    }

}
