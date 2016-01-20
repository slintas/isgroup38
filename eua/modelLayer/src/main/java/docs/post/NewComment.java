/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.post;

import docs.ModelMVC;
import docs.sign.handlers.Sign_up;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;
import tuc.transferobjects.CommentsTO;

/**
 *
 * @author slintas
 */
public class NewComment extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {
        CommentsTO commentsTO = new CommentsTO(request.getParameter("comment"), 
                (String) request.getSession().getAttribute("user_email"),
                Integer.parseInt(request.getParameter("id")));
        
        boolean flag = DAOFactory.getMySQLDAOFactory().getCommentsDAO().comment(commentsTO);
        
        if (flag) {
            request.setAttribute("data", "true");
        } else {
            request.setAttribute("data", "false");
        }
        
        dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getAttribute("data").equals("true")) {
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } catch (IOException ex) {
            Logger.getLogger(Sign_up.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
