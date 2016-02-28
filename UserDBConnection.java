package chatprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBConnection {

    // define MySQL database driver
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";

    // define MySQL database connection URL
    public static final String DBURL = "jdbc:mysql://localhost:3306/user";

    // username of MySQL database
    public static final String DBUSER = "root";

    // password of MySQL database
    public static final String DBPASS = "mysqladmin";

    public void insert(String name, String password, String sex, int age, String birthday, String email) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        Class.forName(DBDRIVER);
        String sqlInsert = "INSERT INTO userinfo(name,password,sex,age,birthday,email) VALUES ('" + name + "','" + password + "','" + sex + "'," + age + ",'" + birthday + "','" + email + "');";
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        stmt = conn.createStatement();
        stmt.executeUpdate(sqlInsert);
        stmt.close();
        conn.close();
    }

    public boolean search(String name, String password) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Class.forName(DBDRIVER);
        String sqlSelect = "SELECT id FROM userinfo WHERE name='" + name + "' AND password = '" + password + "'";
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sqlSelect);
        boolean result = rs.next();
        rs.close();
        stmt.close();
        conn.close();
        return result;
    }
}
