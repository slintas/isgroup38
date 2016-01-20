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
public class CommentsTO {
    
    private String comment;
    private String owner;
    private String date;
    private int upvotes;
    private int downvotes;
    private String name;
    private String lname;
    private int guideID;
    private int toID;

    public CommentsTO(String comment, String owner, int guideID, int toID) {
        this.comment = comment;
        this.owner = owner;
        this.guideID = guideID;
        this.toID = toID;
    }

    public CommentsTO(String comment, String owner, int guideID) {
        this.comment = comment;
        this.owner = owner;
        this.guideID = guideID;
    }

    public CommentsTO(String comment, String owner, String date, String name, String lname, int guideID) {
        this.comment = comment;
        this.owner = owner;
        this.date = date;
        this.name = name;
        this.lname = lname;
        this.guideID = guideID;
    }

    public CommentsTO(String comment, String owner, String date, int upvotes, int downvotes) {
        this.comment = comment;
        this.owner = owner;
        this.date = date;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getGuideID() {
        return guideID;
    }

    public void setGuideID(int guideID) {
        this.guideID = guideID;
    }

    public int getToID() {
        return toID;
    }

    public void setToID(int toID) {
        this.toID = toID;
    }
    
}
