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
import javabeans.TagBean;

/**
 *
 * @author slintas
 */
public class TagDAOImpl implements TagDAO {

    @Override
    public List<TagBean> getTags(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "select * from tags where id = " + ID + " ;";

            rs = statement.executeQuery(st);
            List<TagBean> lcb = new ArrayList<TagBean>();

            while (rs.next()) {
                TagBean tb = new TagBean(
                        rs.getInt(1),
                        rs.getString(2)
                );
                lcb.add(tb);
            }

            conn.close();
            return lcb;

        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean deleteTags(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "delete from tags where id = " + ID + " ;";
            Boolean result = statement.execute(st);
            conn.close();
            
            return result;

        } catch (SQLException ex) {
            return false;
        }
    }

}
