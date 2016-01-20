/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs.post;

import docs.ModelMVC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javabeans.CommentBean;
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
public class GetComments extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        int ID = Integer.parseInt(request.getParameter("id"));

        List<CommentBean> lcb = DAOFactory.getMySQLDAOFactory().getCommentsDAO().get(ID);
        List<CommentBean> list = new ArrayList<>();
        
        for(int i = 0 ; i < lcb.size() ; i++){
            if(lcb.get(i).getTo() == lcb.get(i).getID()){
                list.add(lcb.get(i));
            } else {
                for(int j = 0 ; j < list.size() ; j ++){
                    list.get(j).addSubComment(lcb.get(i));
                }
            }
        }
        
        request.setAttribute("data", list);

        dispatch(request, response);
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/segments/comments.jsp");
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
