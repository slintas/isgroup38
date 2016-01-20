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
import javabeans.GuideBean;
import tuc.transferobjects.GuideTO;

/**
 *
 * @author slintas
 */
public class GuideDAOImpl implements GuideDAO {

    @Override
    public boolean save(GuideTO guideTO) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            boolean result = statement.execute("insert into guide (owner,url,description,title,upvotes,downvotes) values( "
                    + "'" + guideTO.getOwner() + "',"
                    + "'" + guideTO.getUrl() + "',"
                    + "'" + guideTO.getDescription() + "',"
                    + "'" + guideTO.getTitle() + "',"
                    + "0,"
                    + "0);");

            for (int i = 0; i < guideTO.getTags().size(); i++) {
                statement.addBatch("insert into tags values( (select max(id) from guide) ,'" + guideTO.getTags().get(i) + "');");
            }
            statement.executeBatch();

            conn.close();
            return true;

        } catch (SQLException ex) {
            return true;
        }
    }

    @Override
    public List<GuideBean> search(List<String> ls) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            String tags = "";
            for (int i = 0; i < ls.size(); i++) {
                tags += "tag = '" + ls.get(i) + "' and ";
            }
            tags = tags.substring(0, tags.length() - 5);
            ResultSet rs;
            String st = "select * from guide , user , "
                    + "(Select * , count(id) as weight from tags where " + tags + " group by(id) ) as tagged "
                    + "where guide.id = tagged.id and guide.owner = user.email group by(guide.id) order by (guide.upvotes - guide.downvotes) DESC; ";

            rs = statement.executeQuery(st);

            List<GuideBean> lgb = new ArrayList<>();
            while (rs.next()) {
                GuideBean gb = new GuideBean(
                        rs.getInt(1),
                        rs.getString(5),
                        rs.getString(2),
                        null,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(10),
                        rs.getString(11)
                );
                lgb.add(gb);
            }

            conn.close();
            return lgb;

        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public GuideBean get(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "select * from guide , user  where guide.id = " + ID + " and guide.owner = user.email ;";

            rs = statement.executeQuery(st);
            GuideBean gb = null;
            while (rs.next()) {
                gb = new GuideBean(
                        rs.getInt(1),
                        rs.getString(5),
                        rs.getString(2),
                        null,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(10),
                        rs.getString(11)
                );
            }

            conn.close();
            return gb;

        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<GuideBean> getGuides(String owner) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "select * from guide where guide.owner = '" + owner + "'; ";

            rs = statement.executeQuery(st);

            List<GuideBean> lgb = new ArrayList<>();
            while (rs.next()) {
                GuideBean gb = new GuideBean(
                        rs.getInt(1),
                        rs.getString(5),
                        rs.getString(2),
                        null,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(6),
                        rs.getInt(7),
                        null,
                        null
                );
                lgb.add(gb);
            }

            conn.close();
            return lgb;

        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean update(GuideTO guideTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs;
            String st = "delete from guide where id = " + ID + " ;";
            Boolean result = statement.execute(st);
            conn.close();
            
            return result;

        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean like(int ID) {
        Connection conn = MySqlDAOFactory.createConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("update guide set upvotes = upvotes + 1 where id = " + ID + ";");

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
            statement.executeUpdate("update guide set downvotes = downvotes + 1 where id = " + ID + ";");

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
            rs = statement.executeQuery("select max(id) from guide;");
            rs.next();
            int id = rs.getInt(1) + 1;

            conn.close();
            return id;
        } catch (SQLException ex) {
            return 0;
        }
    }
}
