/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.segments.get;

import docs.ModelMVC;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author slintas
 */
public class Create extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {
        dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/segments/Create.jsp");
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
