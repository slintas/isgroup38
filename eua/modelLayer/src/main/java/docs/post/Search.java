/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.post;

import docs.ModelMVC;
import docs.sign.handlers.Sign_up;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.GuideBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;
import tuc.transferobjects.GuideTO;

/**
 *
 * @author slintas
 */
public class Search extends ModelMVC{
    
    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        List<String> ls = new ArrayList<String>();
        for(int i = 0 ; i < Integer.parseInt(request.getParameter("tags_num")) ; i++ ){
            ls.add(request.getParameter("guide_tag"+String.valueOf(i)));
        }
        
        List<GuideBean> lgb = DAOFactory.getMySQLDAOFactory().getGuideDAO().search(ls);
        request.setAttribute("data", lgb);
        this.dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/segments/search.jsp");
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
