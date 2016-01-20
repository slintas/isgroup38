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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;
import tuc.transferobjects.UserTO;

/**
 *
 * @author slintas
 */
public class Sign_up extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        UserTO user = new UserTO(request.getParameter("email"), request.getParameter("password"), request.getParameter("name"), request.getParameter("last_name"), request.getParameter("guide"));

        if (DAOFactory.getMySQLDAOFactory().getUserDAO().sign_up(user)) {
            request.setAttribute("data", "true");
            request.getSession().setAttribute("user_email", user.getEmail());
            request.getSession().setAttribute("user_name", user.getName());
            request.getSession().setAttribute("user_last_name", user.getLast_name());
            request.getSession().setAttribute("guide", user.getGuide());
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
