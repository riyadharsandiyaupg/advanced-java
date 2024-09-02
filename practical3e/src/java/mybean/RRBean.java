package mybean;

import static java.lang.System.out;
import javax.ejb.Stateful;
import java.sql.*;

@Stateful
public class RRBean {

    public RRBean() {
    }
    
     String msg="";
     public String roombooking(String customer_name,String customer_mobile,String roomType)
        {
            //database connectivity
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                String query="SELECT * FROM roombook_19 WHERE roomtype=? and statusroom='Not Booked'";
                PreparedStatement pst=conn.prepareStatement(query);
                pst.setString(1,roomType);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    String roomno=rs.getString(1);
                    PreparedStatement pst1=conn.prepareStatement("UPDATE roombook_19 SET cust=? , mob=? , statusroom='Booked' WHERE roomid=?");
                    pst1.setString(1,customer_name);
                    pst1.setString(2,customer_mobile);
                    pst1.setString(3,roomno);
                    pst1.executeUpdate();
                    msg="Room "+roomType+" booked "+" charges "+rs.getString(3);
                }
                else
                {
                    msg="Room "+roomType+" not available";
                }
            }
            catch(Exception e){
                out.println("Excpetion"+e);
            }
      return msg;
        }
    
}
