
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Owais
 */
public class Database {
    
       public static void saveData(String name, int score){
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat();
        String date = sf.format(d);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Trivia","root","admin");
            PreparedStatement ps = conn.prepareStatement("insert into Details values(?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.setString(3, date);
            ps.executeUpdate();
            System.out.println("Data Stored to Database");
        }
         catch(SQLException | ClassNotFoundException e){
             System.out.println(e);
         }
    }
}
