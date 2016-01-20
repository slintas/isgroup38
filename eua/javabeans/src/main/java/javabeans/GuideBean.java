/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.List;

/**
 *
 * @author slintas
 */
public class GuideBean {
    
    private int ID;
    private String title;
    private String owner;
    private List<String> tags;
    private String url;
    private String description;
    private int upvotes;
    private int downvotes;
    private String name;
    private String lname;

    public GuideBean(int ID, String title, String owner, List<String> tags, String url, String description, int upvotes, int downvotes, String name, String lname) {
        this.ID = ID;
        this.title = title;
        this.owner = owner;
        this.tags = tags;
        this.url = url;
        this.description = description;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.name = name;
        this.lname = lname;
    }

    public GuideBean(int ID,String title, String owner, List<String> tags, String url, String description, int upvotes, int downvotes) {
        this.ID = ID;
        this.title = title;
        this.owner = owner;
        this.tags = tags;
        this.url = url;
        this.description = description;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
}
