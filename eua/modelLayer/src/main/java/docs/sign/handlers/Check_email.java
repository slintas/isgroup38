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
public class Check_email extends ModelMVC{

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {
        
        UserTO user = new UserTO();
        user.setEmail(request.getParameter("email"));
        
        boolean exists = DAOFactory.getMySQLDAOFactory().getUserDAO().checkIfEmailExists(user);
        if(exists){
            request.setAttribute("data", "exists");
        }else{
            request.setAttribute("data", "new");
        }
        this.dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().print((String) request.getAttribute("data"));
        } catch (IOException ex) {
            Logger.getLogger(Check_email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
