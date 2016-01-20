/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.persistencylayer;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.math.BigInteger;
import javabeans.UserBean;
import tuc.transferobjects.UserTO;

/**
 *
 * @author slintas
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean sign_up(UserTO user) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            boolean result = statement.execute("insert into user values('" + user.getEmail() + "','" + user.getPassword()
                    + "','" + user.getName() + "','" + user.getLast_name() + "'," + user.getGuide() + ");");

            conn.close();
            return true;

        } catch (SQLException ex) {
            return true;
        }
    }

    @Override
    public UserBean sign_in(UserTO user) {

        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            
            rs = statement.executeQuery("select * from user , "
                    + "(select (guideVotes.up+commentVotes.up) as upvotes ,  (guideVotes.down+commentVotes.down) as downvotes from "
                    + "(select sum(guide.upvotes) as up , sum(guide.downvotes) as down from guide where owner = '" + user.getEmail() + "') guideVotes , "
                    + "(select sum(comment.upvotes) as up , sum(comment.downvotes) as down from comment where owner = '" + user.getEmail() + "') commentVotes ) votes "
                    + "where user.email = '" + user.getEmail() + "' and user.password = '" + user.getPassword() + "';");
            
            UserBean userBean = new UserBean();
            
            while (rs.next()) {
                userBean.setEmail(rs.getString(1));
                userBean.setPassword(rs.getString(2));
                userBean.setName(rs.getString(3));
                userBean.setLast_name(rs.getString(4));
                userBean.setGuide(rs.getString(5));
                
                userBean.setTotal_upvotes(rs.getInt(6));
                userBean.setTotal_downvotes(rs.getInt(7));
            }

            conn.close();

            return userBean;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean checkIfEmailExists(UserTO user) {

        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("SELECT email from user where user.email = '" + user.getEmail() + "'");

            if (rs.next()) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }

        } catch (SQLException ex) {
            return true;
        }
    }

}
