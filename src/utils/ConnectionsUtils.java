package utils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionsUtils {
    Connection conn = null;
    public static Connection connectdb()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/football_info","root","root");
            return connection;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}