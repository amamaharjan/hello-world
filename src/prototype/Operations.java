
package prototype;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class Operations {

    DBConnect dbConnect = new DBConnect();
    Statement st;
    ResultSet rs;
    
    
    public DefaultComboBoxModel getList(String value){
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
            
        try {
            String sql = "Select id, name, address from customer where name like '"+value+"%';";
            
            st = dbConnect.connection();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                model.addElement(rs.getString("name"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
        
    }
    
    public String[] setData(String value){
        String data[] = new String[4];
        try {
            String sql = "Select * from customer where name = '"+value+"'";
            st = dbConnect.connection();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                for(int i=0; i<data.length; i++){
                    data[i]=rs.getString(i+1);
                }
                
            }
            
            
        } catch (SQLException ex) {
            return null;
        }
        return data;
        
    }
    
    
}
