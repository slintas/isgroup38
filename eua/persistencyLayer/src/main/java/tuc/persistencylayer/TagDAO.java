/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuc.persistencylayer;

import java.util.List;
import javabeans.TagBean;

/**
 *
 * @author slintas
 */
public interface TagDAO {
    
    public List<TagBean> getTags(int ID);
    public boolean deleteTags(int ID);
    
}
