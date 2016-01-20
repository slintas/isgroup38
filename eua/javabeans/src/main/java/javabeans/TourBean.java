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
public class TourBean {
    
    private GuideBean gb;
    private List<CommentBean> lcb;

    public TourBean(GuideBean gb, List<CommentBean> lcb) {
        this.gb = gb;
        this.lcb = lcb;
    }

    public GuideBean getGb() {
        return gb;
    }

    public void setGb(GuideBean gb) {
        this.gb = gb;
    }

    public List<CommentBean> getLcb() {
        return lcb;
    }

    public void setLcb(List<CommentBean> lcb) {
        this.lcb = lcb;
    }
    
}
