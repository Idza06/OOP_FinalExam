package finalexam;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    static final String DBurl = "jdbc:mysql://localhost/movie_db";
    static final String DBusername = "root";
    static final String DBpassword = "";
    
    Connection conn;
    Statement statement;
    
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }
    
    public String[][] readMovie(){
        try {
            int totalData = 0;
            String data[][] = new String[getDatas()][5]; //total data
            String query = "SELECT * FROM `movie`"; //select data from table movie
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //convert table to String
            while(resultSet.next()){ 
                data[totalData][0] = resultSet.getString("title"); 
                data[totalData][1] = String.valueOf(resultSet.getDouble("plot")); 
                data[totalData][2] = String.valueOf(resultSet.getDouble("character"));
                data[totalData][3] = String.valueOf(resultSet.getDouble("acting"));
                data[totalData][4] = String.valueOf(resultSet.getDouble("score"));
                totalData++; 
            }
            return data;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertData (String title, double plot, double character, double acting, double score){
        try {
            String query = "INSERT INTO `movie` (`title`,`plot`,`character`, `acting`,`Score`)" + "VALUES('" + title + "','" + plot + "','" + character + "','" + acting + "','" + score + "')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Input Success");
            JOptionPane.showMessageDialog(null, "Input Success");
        }catch(Exception ex){
            System.out.println("Input Failed");
            JOptionPane.showMessageDialog(null, "Data already exists");}
        }
    
    public void updateData (String title, double plot, double character, double acting, double score){
        try {
            String query = "UPDATE `movie` SET `plot` ='" + plot + "', `character` = '" + character + 
                    "', `acting` ='" + acting + "', `score` = '" + score + "' WHERE `title` = '" + title + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Update Success");
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }
    
    public int getDatas(){
        int totalData = 0;
        try{
            statement = conn.createStatement();
            String query = "SELECT * FROM `movie`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                totalData++;
            }
            return totalData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteMovie(String title){
        try {
            String query = "DELETE FROM `movie` WHERE title='" + title + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Successs");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
            System.out.println("SQL Error");
        }
    }
}