package tuc;

import docs.ModelMVC;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/Controller/*"})
public class Controller extends HttpServlet {

    protected HashMap events = new HashMap();

    @Override
    public void init() throws ServletException {

        ResourceBundle bundle = ResourceBundle.getBundle("Actions");
        Enumeration e = bundle.getKeys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = bundle.getString(key);
            events.put(key, value);
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1).toLowerCase();
        String classhandler = (String) events.get(action);
        String ajaxheader = request.getHeader("X-Requested-With");
        
        if (true) {
            ModelMVC model = null;

            try {
                model = (ModelMVC) Class.forName(classhandler).newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            model.proccess(request, response);
        } else if ("redirect".equals("")) {
            try {
                String domain = request.getServletContext().getInitParameter("domain");
                response.sendRedirect(domain + "Error404.jsp");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
