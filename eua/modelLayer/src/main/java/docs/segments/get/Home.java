/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.segments.get;

import docs.ModelMVC;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author slintas
 */
public class Home extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {
        dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/segments/home.jsp");
        try {
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
