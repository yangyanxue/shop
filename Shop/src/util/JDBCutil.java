package util;
import java.io.IOException;
import java.sql.*;
import java.util.*;
public class JDBCutil {
	
	//˽�о�̬���������Զ�ȡ�����ļ�  
    private static Properties config=new Properties();  
    static{  
        try {  
            //������Դ�ļ�  
            config.load(JDBCutil.class.getClassLoader().getResourceAsStream("db.properties")); 
            
            //������  
            //Class.forName("com.mysql.jdbc.Driver"); 
           Class.forName(config.getProperty("driver")); 
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static  Connection getConnection(){  
        Connection connection=null;  
        try {  
            connection=DriverManager.getConnection(config.getProperty("url").trim(),config.getProperty("username").trim(),config.getProperty("password").trim());
        	//connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shop",config.getProperty("username"),config.getProperty("password"));
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
          
        return connection;  
    }  
    //���Թر����ӣ��ͷ���Դ  
    public static void releaseConn(Connection connection, Statement statement,  
            ResultSet resultSet) {  
        if(resultSet!=null){  
            try {  
                resultSet.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
            resultSet=null;  
        }  
          
        if(statement!=null){  
            try {  
                statement.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
            statement=null;  
        }  
          
        if(connection!=null){  
            try {  
                connection.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
            connection=null;  
        }  
    }  
    
	
}
