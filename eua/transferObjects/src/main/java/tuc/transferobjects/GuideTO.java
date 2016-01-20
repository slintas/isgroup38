/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.transferobjects;

import java.util.List;

/**
 *
 * @author slintas
 */
public class GuideTO {
    
    private String title;
    private String owner;
    private List<String> tags;
    private String url;
    private String description;

    public GuideTO(String title, String owner, List<String> tags, String url, String description) {
        this.title = title;
        this.owner = owner;
        this.tags = tags;
        this.url = url;
        this.description = description;
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
    
}
