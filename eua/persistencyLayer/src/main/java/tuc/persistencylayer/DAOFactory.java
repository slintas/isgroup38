/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tuc.persistencylayer;

/**
 *
 * @author teras
 */
public abstract class DAOFactory {
    
    public abstract UserDAO getUserDAO();
    public abstract GuideDAO getGuideDAO();
    public abstract CommentsDAO getCommentsDAO();
    public abstract TagDAO getTagDAO();
   
    public static DAOFactory getMySQLDAOFactory() {
        return new MySqlDAOFactory();
    }
    
}
