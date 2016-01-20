/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.post;

import docs.ModelMVC;
import java.io.IOException;
import java.util.List;
import javabeans.GuideBean;
import javabeans.TagBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;

/**
 *
 * @author slintas
 */
public class ShowTour extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        int ID = Integer.parseInt(request.getParameter("id"));

        GuideBean gb = DAOFactory.getMySQLDAOFactory().getGuideDAO().get(ID);
        request.setAttribute("data", gb);
        
        List<TagBean> ltb = DAOFactory.getMySQLDAOFactory().getTagDAO().getTags(ID);
        request.setAttribute("tags", ltb);

        dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/segments/InfoFill.jsp");
            rd.forward(request, response);
        } catch (ServletException ex) {
            return;
            //Logger.getLogger(GetFriendsHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            return;
            //Logger.getLogger(GetFriendsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
