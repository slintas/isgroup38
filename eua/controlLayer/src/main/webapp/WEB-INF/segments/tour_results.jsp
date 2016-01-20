<%-- 
    Document   : InfoFill
    Created on : Jan 16, 2016, 7:13:11 PM
    Author     : slintas
--%>

<%@page import="javabeans.TagBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javabeans.GuideBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    GuideBean gb = (GuideBean) request.getAttribute("data");
    List<TagBean> ltb = (ArrayList<TagBean>) request.getAttribute("tags");
%>
<div id="guide_id_for_comments" class="<%= gb.getID() %>"></div>
<div class="input_field">
    <div class="input_field_expl">
        Title:
    </div>
    <div class="input_field_text">
        <input id="create_title_text" type="text" value="<%= gb.getTitle()%>" placeholder="Title for your guide." />
    </div>
</div>
<div class="input_field">
    <div class="input_field_expl">
        Video URL:
    </div>
    <div class="input_field_text">
        <input id="create_url_text" type="text" value="<%= gb.getUrl()%>" placeholder="The video's url."/>
    </div>
</div>
<div class="input_field">
    <div class="input_field_expl">
        Tag:
    </div>
    <div class="seperate">
        <input id="tag_text" type="text" style="height:25px; font-size: 18px; margin-top:-3px;" value="" placeholder="Add tags to your guide."/>
        <input class="button" type="button" value="Add" onclick="tag_management.addTag();"/>
    </div>
</div>
<div class="input_field">
    <div class="input_field_expl">
        Added Tags:
    </div>
    <div id="current_tags">
        <%
            for (int i = 0; i < ltb.size(); i++) {
        %>
        <div class="tag" id="tag_id<%= ltb.get(i).getId()%>">
            <span class="tag_text"><%= ltb.get(i).getTag()%></span>
            <i class="fa fa-times" onclick="this.parentNode.remove()" style="cursor:pointer; margin:2px;"></i>
        </div>
        <%
            }
        %>
    </div>
</div>
<div class="description">
    <div class="title">
        Description:
    </div>
    <div> 
        <textarea id="create_description_text" rows="4" cols="50" placeholder="In depth description of the tour."><%= gb.getDescription()%>
        </textarea> 
    </div>
</div>
<div class="buttons">
    <input type="button" class="button_cancel" value="Preview" onclick="create_man.preview()"/>
    <input type="button" class="button" value="Delete" onclick='create_man.delete_tour()'/>
    <input type="button" class="button" value="Update" onclick='create_man.update_tour()'/>
</div>