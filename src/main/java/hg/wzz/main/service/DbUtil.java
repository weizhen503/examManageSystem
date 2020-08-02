package hg.wzz.main.service;


import java.sql.*;

public class DbUtil {
                                    //jdbc:数据库类型://IP地址:端口号/数据库名
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/exam_manage_system";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private static Connection conn = null;

    static{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接，conn的类型是Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
}