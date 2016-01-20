/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author slintas
 */
public class UserBean {
    
    private String email;
    private String password;
    private String name;
    private String last_name;
    private String guide;
    private int total_upvotes;
    private int total_downvotes;

    public UserBean(String email, String password, String name, String last_name, int total_upvotes, int total_downvotes, String guide) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.guide = guide;
        this.total_upvotes = total_upvotes;
        this.total_downvotes = total_downvotes;
    }
    
    public UserBean() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.last_name = "";
        this.guide = "";
        this.total_upvotes = 0;
        this.total_downvotes = 0;
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

    public int getTotal_upvotes() {
        return total_upvotes;
    }

    public void setTotal_upvotes(int total_upvotes) {
        this.total_upvotes = total_upvotes;
    }

    public int getTotal_downvotes() {
        return total_downvotes;
    }

    public void setTotal_downvotes(int total_downvotes) {
        this.total_downvotes = total_downvotes;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
    
    
    
}
