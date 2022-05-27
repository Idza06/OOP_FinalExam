/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexam;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orenji
 */
public class MovieView extends JFrame{
    JLabel lTitle = new JLabel("Title");
    JLabel lPlot = new JLabel("Plot");
    JLabel lCharacter = new JLabel("Character");
    JLabel lActing = new JLabel("Acting");
    
    public JTextField tfTitle = new JTextField();
    public JTextField tfPlot = new JTextField();
    public JTextField tfCharacter = new JTextField();
    public JTextField tfActing = new JTextField();
    
    public JButton btnAdd = new JButton("Add");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] columnName = {"Title", "Plot", "Character", "Acting", "Score"};

    public MovieView() {
        dtm = new DefaultTableModel(columnName, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        
        setTitle("Movie Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lTitle);
        lTitle.setBounds(510, 20, 90, 20);
        add(tfTitle);
        tfTitle.setBounds(510, 40, 120, 20);
        
        add(lPlot);
        lPlot.setBounds(510, 60, 90, 20);
        add(tfPlot);
        tfPlot.setBounds(510, 80, 120, 20);
        
        add(lCharacter);
        lCharacter.setBounds(510, 100, 90, 20);
        add(tfCharacter);
        tfCharacter.setBounds(510, 120, 120, 20);
        
        add(lActing);
        lActing.setBounds(510, 140, 90, 20);
        add(tfActing);
        tfActing.setBounds(510, 160, 120, 20);
        
        add(btnAdd);
        btnAdd.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
    }
    
    @Override
    public String getTitle(){
        return tfTitle.getText();
    }
    
    public String getPlot(){
        return tfPlot.getText();
    }
    
    public String getCharacter(){
        return tfCharacter.getText();
    }
    
    public String getActing(){
        return tfActing.getText();
    }
}
