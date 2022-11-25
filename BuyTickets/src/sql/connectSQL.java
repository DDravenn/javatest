package sql;


import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.*;
import java.beans.PropertyVetoException;

public class connectSQL {
    private ComboPooledDataSource dataSource;
    public static Connection con;
    public connectSQL() throws PropertyVetoException, SQLException {
        getConnection(); //初始化配置
        con=dataSource.getConnection();
    }
    public void getConnection() throws PropertyVetoException {
        dataSource = new ComboPooledDataSource();
        //对池进行四大参数的配置
        dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setJdbcUrl("jdbc:sqlserver://localhost:1433;DatabaseName=byts;trustServerCertificate=true");
        dataSource.setUser("sa");
        dataSource.setPassword("czy6220303");
        //池配置
        dataSource.setAcquireIncrement(5);
        dataSource.setInitialPoolSize(10);
        dataSource.setMinPoolSize(2);
        dataSource.setMaxPoolSize(30);
    }

    public static Connection getCon() {
        return con;
    }
    public void closeConnection() throws SQLException {
        con.close();
    }
    
//版权声明：本文为CSDN博主「潇洒不放纵的博客」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/lq1759336950/article/details/87527914
}
