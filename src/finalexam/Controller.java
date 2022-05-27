package finalexam;

import javax.swing.*;
import java.awt.event.*;

public class Controller {
    Connector editMovie;
    MovieView viewMovie;
    
    public String data;
    public Controller(Connector editMovie, MovieView viewMovie){
        this.editMovie = editMovie;
        this.viewMovie = viewMovie;
        
        if(editMovie.getDatas() != 0){ //if movie is not empty, then we can view movie
            String dataMovie[][] = editMovie.readMovie();
            viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Data is empty");          
        }
        
        //for add button
        viewMovie.btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String title = viewMovie.getTitle();
                double plot = Double.parseDouble(viewMovie.getPlot());
                double character = Double.parseDouble(viewMovie.getCharacter());
                double acting = Double.parseDouble(viewMovie.getActing());
                double score = (plot + character + acting)/3;
                editMovie.insertData(title, plot, character, acting, score);        
                 
                String dataMovie[][] = editMovie.readMovie();
                viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
            }
        });
        
        //for update button
        viewMovie.btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String title = viewMovie.getTitle();
                double plot = Double.parseDouble(viewMovie.getPlot());
                double character = Double.parseDouble(viewMovie.getCharacter());
                double acting = Double.parseDouble(viewMovie.getActing());
                double score = (plot + character + acting)/3;
                editMovie.updateData(title, plot, character, acting, score);        
                 
                String dataMovie[][] = editMovie.readMovie();
                viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
            }
        });
        
        //for reset button
        viewMovie.btnReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                viewMovie.tfTitle.setText("");
                viewMovie.tfPlot.setText("");
                viewMovie.tfCharacter.setText("");
                viewMovie.tfActing.setText("");
            }
        });
        
        //for table
        viewMovie.table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);
                int row = viewMovie.table.getSelectedRow();
                data = viewMovie.table.getValueAt(row, 0).toString();
                String updateData[] = new String[4];
                updateData[0] = viewMovie.table.getValueAt(row, 0).toString();
                updateData[1] = viewMovie.table.getValueAt(row, 1).toString();
                
                System.out.println(data);
            }
        });
        
        //for delete button
        viewMovie.btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                int input = JOptionPane.showConfirmDialog(null, "Do you want to delete " + data + "?",
                        "Option ... ", JOptionPane.YES_NO_OPTION);
                if (input == 0){
                    editMovie.deleteMovie(data);
                    String dataMovie[][] = editMovie.readMovie();
                    viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to delete data");
                }
            }
        });    
    }
}