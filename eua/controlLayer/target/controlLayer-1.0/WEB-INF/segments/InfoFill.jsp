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
%>
<div id="guide_owner" class="<%= gb.getID() %>">
    <%= gb.getName()%> <%= gb.getLname()%>
</div>
<div class="user_menu_option" style="height:40px;margin-left:12px;">
    <div class="votes" style="margin:10px;">
        <i class="fa fa-thumbs-up" style="cursor:pointer" title="Like" onclick="create_man.like_guide(<%= gb.getID()%>)"></i>
        :<span id="guide_likes"><%= gb.getUpvotes()%></span>
    </div>
    <div class="votes" style="margin:10px;">
        <i class="fa fa-thumbs-down" style="cursor:pointer" title="Like" onclick="create_man.dislike_guide(<%= gb.getID()%>)"></i>
        :<span  id="guide_dislikes"><%= gb.getDownvotes()%></span>
    </div>
</div>
<div id="guide_video">
    <iframe class="video" src="<%= gb.getUrl()%>">
    </iframe>
</div>
<div id="guide_description">
    <%= gb.getDescription()%>">
</div>