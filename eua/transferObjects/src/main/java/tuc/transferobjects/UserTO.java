/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.transferobjects;

/**
 *
 * @author slintas
 */
public class UserTO {
    private String email;
    private String password;
    private String name;
    private String last_name;
    private String guide;
    
    public UserTO(String email, String password, String name, String last_name, String guide){
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.guide = guide;
    }

    public UserTO() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.last_name = "";
        this.guide = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
    
    
}
