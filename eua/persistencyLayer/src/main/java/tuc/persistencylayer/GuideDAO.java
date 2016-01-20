/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.persistencylayer;

import java.util.List;
import javabeans.GuideBean;
import tuc.transferobjects.GuideTO;

/**
 *
 * @author slintas
 */
public interface GuideDAO {

    public boolean save(GuideTO guideTO);
    public List<GuideBean> search(List<String> ls);
    public GuideBean get(int ID);
    public List<GuideBean> getGuides(String owner);
    public boolean update(GuideTO guideTO);
    public boolean delete(int ID);
    public boolean like(int ID);
    public boolean dislike(int ID);

}
