/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.persistencylayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teras
 */
public class MySqlDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://195.251.249.131:3306/ismgroup38";//
    
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
    
    public GuideDAO getGuideDAO() {
        return new GuideDAOImpl();
    }
    
    public CommentsDAO getCommentsDAO() {
        return new CommentsDAOImpl();
    }
    
    public TagDAO getTagDAO() {
        return new TagDAOImpl();
    }
    
    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try {
            conn = DriverManager.getConnection(DBURL, "ismgroup38", "ya9m49"); // "ismgroup38","ya9m49"
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return conn;
    }

    public static DatabaseMetaData GetDatabaseInfo() {
        Connection connection = MySqlDAOFactory.createConnection();
        DatabaseMetaData dmd = null;
        try {
            dmd = connection.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dmd;
    }

}
