/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slintas
 */
public class CommentBean {

    private int ID;
    private int guide_id;
    private String comment;
    private String owner;
    private String date;
    private int upvotes;
    private int downvotes;
    private String name;
    private String lname;
    private int To;
    private List<CommentBean> lcb;

    public CommentBean(int ID, int guide_id, String comment, String owner, String date, int upvotes, int downvotes, String name, String lname, int To) {
        this.ID = ID;
        this.guide_id = guide_id;
        this.comment = comment;
        this.owner = owner;
        this.date = date;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.name = name;
        this.lname = lname;
        this.To = To;
        this.lcb = new ArrayList<CommentBean>();
    }

    public CommentBean(int ID, int guide_id, String comment, String owner, String date, int upvotes, int downvotes, String name, String lname) {
        this.ID = ID;
        this.guide_id = guide_id;
        this.comment = comment;
        this.owner = owner;
        this.date = date;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.name = name;
        this.lname = lname;
        this.lcb = new ArrayList<CommentBean>();
    }

    public CommentBean(int ID, int guide_id, String comment, String owner, String date, int upvotes, int downvotes) {
        this.ID = ID;
        this.guide_id = guide_id;
        this.comment = comment;
        this.owner = owner;
        this.date = date;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.lcb = new ArrayList<CommentBean>();
    }

    public CommentBean() {

    }

    public List<CommentBean> subFromParent(List<CommentBean> lcb, int parentID) {
        for (int i = 0; i < lcb.size(); i++) {
            if (lcb.get(i).getID() == parentID) {
                return lcb.get(i).getLcb();
            } else {
                List<CommentBean> res = subFromParent(lcb.get(i).getLcb(), parentID);
                if (res.size() > 0) {
                    return res;
                }
            }
        }
        List<CommentBean> rest = new ArrayList<CommentBean>();
        return rest;
    }

    public void addSubComment(CommentBean cb) {
        if (this.ID == cb.getTo()) {
            lcb.add(cb);
        } else {
            for (int i = 0; i < getLcb().size(); i++) {
                lcb.get(i).addSubComment(cb);
            }
        }
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(int guide_id) {
        this.guide_id = guide_id;
    }

    public List<CommentBean> getLcb() {
        return lcb;
    }

    public void setLcb(List<CommentBean> lcb) {
        this.lcb = lcb;
    }

    public int getTo() {
        return To;
    }

    public void setTo(int To) {
        this.To = To;
    }

}
