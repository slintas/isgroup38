/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.sign.handlers;

import docs.ModelMVC;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.UserBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;
import tuc.transferobjects.UserTO;

/**
 *
 * @author slintas
 */
public class Sign_in extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        UserTO user = new UserTO();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        UserBean userBean = DAOFactory.getMySQLDAOFactory().getUserDAO().sign_in(user);
        
        if (userBean.getEmail() != "") {
            request.setAttribute("data", "true");
            request.getSession().setAttribute("user_email", userBean.getEmail());
            request.getSession().setAttribute("user_name", userBean.getName());
            request.getSession().setAttribute("user_last_name", userBean.getLast_name());
            request.getSession().setAttribute("guide", userBean.getGuide());
            request.getSession().setAttribute("user_upvotes",userBean.getTotal_upvotes());
            request.getSession().setAttribute("user_downvotes", userBean.getTotal_downvotes());
        } else {
            request.setAttribute("data", "false");
        }
        
        this.dispatch(request, response);
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
