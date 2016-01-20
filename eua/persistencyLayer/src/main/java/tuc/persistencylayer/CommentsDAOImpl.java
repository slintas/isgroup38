/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.persistencylayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javabeans.CommentBean;
import javabeans.GuideBean;
import tuc.transferobjects.CommentsTO;

/**
 *
 * @author slintas
 */
public class CommentsDAOImpl implements CommentsDAO {

    @Override
    public List<CommentBean> get(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "select * from comment , user where comment.guide_id = " + ID + " and user.email = owner ;";

            rs = statement.executeQuery(st);
            List<CommentBean> lcb = new ArrayList<CommentBean>();

            while (rs.next()) {
                CommentBean cb = new CommentBean(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(8)
                );
                lcb.add(cb);
            }

            conn.close();
            return lcb;

        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean like(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("update comment set upvotes = upvotes + 1 where id = " + ID + ";");

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean dislike(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("update comment set downvotes = downvotes + 1 where id = " + ID + ";");

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean delete(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "delete from comment where guide_id = " + ID + " ;";
            Boolean result = statement.execute(st);
            conn.close();

            return result;

        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean comment(CommentsTO commentsTO) {
        int id = maxID();

        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            boolean res = statement.execute("insert into comment values ( " + id + ""
                    + ",  " + commentsTO.getGuideID() + " "
                    + ", '" + commentsTO.getComment() + "' "
                    + ", '" + commentsTO.getOwner() + "' "
                    + ", CURDATE() , 0 , 0 "
                    + ", " + id + ")"
                    + ";");

            conn.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean commentTo(CommentsTO commentsTO) {
        int id = maxID();

        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            boolean res = statement.execute("insert into comment values ( " + id + ""
                    + ",  " + commentsTO.getGuideID() + " "
                    + ", '" + commentsTO.getComment() + "' "
                    + ", '" + commentsTO.getOwner() + "' "
                    + ", CURDATE() , 0 , 0 "
                    + ", " + commentsTO.getToID() + ")"
                    + ";");

            conn.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    private int maxID() {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select max(id) from comment;");
            rs.next();
            int id = rs.getInt(1) + 1;

            conn.close();
            return id;
        } catch (SQLException ex) {
            return 0;
        }
    }
    //select @max := max(id)  from comment ;
    //insert into comment values ( @max + 1 , 1 , 'comment' , 'egiannatou@isc.tuc.gr' , CURDATE() , 0 , 0 , @max + 1);
    //insert into comment values ( LAST_INSERT_ID() , 1 , 'comment' , 'egiannatou@isc.tuc.gr' , '2015-01-09' , 0 , 0 , LAST_INSERT_ID() );

}
