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
import javabeans.GuideBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;

/**
 *
 * @author slintas
 */
public class Dislike extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        int ID = Integer.parseInt(request.getParameter("id"));

        boolean flag = DAOFactory.getMySQLDAOFactory().getCommentsDAO().dislike(ID);

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
