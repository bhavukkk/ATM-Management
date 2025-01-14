package atm;
import java.sql.*;
public class conn {
    Connection c;
    public Statement s;
    public conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///atm_management","root", "bhavuk@123");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
