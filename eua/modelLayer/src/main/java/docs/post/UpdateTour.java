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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuc.persistencylayer.DAOFactory;
import tuc.transferobjects.GuideTO;

/**
 *
 * @author slintas
 */
public class UpdateTour extends ModelMVC {

    @Override
    public void proccess(HttpServletRequest request, HttpServletResponse response) {

        List<String> ls = new ArrayList<String>();

        for (int i = 0; i < Integer.parseInt(request.getParameter("tags_num")); i++) {
            ls.add(request.getParameter("guide_tag" + String.valueOf(i)));
        }

        //(String title, String owner, List<String> tags, String url, String description
        GuideTO guideTO = new GuideTO(request.getParameter("guide_title"), request.getParameter("guide_owner"), ls, request.getParameter("guide_video_frame"), request.getParameter("guide_description"));
        boolean insert = false;
        if (DAOFactory.getMySQLDAOFactory().getGuideDAO().save(guideTO)) {
            insert = true;
        } else {
            insert = false;
        }
        
        if (insert) {
            int ID = Integer.parseInt(request.getParameter("id"));
            
            boolean com = DAOFactory.getMySQLDAOFactory().getCommentsDAO().delete(ID);
            boolean ltb = DAOFactory.getMySQLDAOFactory().getTagDAO().deleteTags(ID);
            boolean result = DAOFactory.getMySQLDAOFactory().getGuideDAO().delete(ID);
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
