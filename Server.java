import java.sql.*;
import java.net.*;

public class Server extends Thread 
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public void run(){
        try{
        int a=0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://arcs12.com:3306/arcscom_Pipi","arcscom_amin","45vyzx6795klfg");
        st = con.createStatement();
        
        InetAddress IP = InetAddress.getLocalHost(); // checking if the ip address already added

        String sql = "SELECT * FROM User";
            rs = st.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("UserIP");
                if(name.equals(IP.getHostAddress().toString()) ) {a=1; break;}
            }
                                             // if not added then add the ip address
            if(a==0){
            String s = "INSERT INTO `User` (`UserIP`) VALUES (?)";
            PreparedStatement preparedStmt = con.prepareStatement(s);
            preparedStmt.setString (1, IP.getHostAddress());
            preparedStmt.execute();
        }
            
    }catch(Exception ex){}
    }
}
