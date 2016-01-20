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

/**
 *
 * @author slintas
 */
public class Logout extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user_email", null);
        request.getSession().setAttribute("user_name", null);
        request.getSession().setAttribute("user_last_name", null);
        this.dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().print("logout");
        } catch (IOException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
