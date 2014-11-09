
package prototype;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DBConnect {
    private Connection connections;
    private Statement statements;
    private ResultSet resultsets;
    
   DBConnect(){
       
   }
    public Statement connection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connections = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cis","root","");
            statements = (Statement) connections.createStatement();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        return statements;
    }
}
