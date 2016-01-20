/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author slintas
 */
public abstract class ModelMVC {
    
    //public abstract String getURL();
    public abstract void proccess(HttpServletRequest request, HttpServletResponse response);
    public abstract void dispatch(HttpServletRequest request, HttpServletResponse response);
    
}
