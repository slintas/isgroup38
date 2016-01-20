<%-- 
    Document   : tours
    Created on : Jan 16, 2016, 2:05:43 PM
    Author     : slintas
--%>

<%@page import="javabeans.GuideBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<GuideBean> lgb = (ArrayList<GuideBean>) request.getAttribute("data");

    for (int i = 0; i < lgb.size(); i++) {
%>
<div class='guide_result' onclick="create_man.get(<%= lgb.get(i).getID() %>)">
    <div class='guide_title'>
        <%= lgb.get(i).getTitle()%>
    </div>
    <div class='guide_owner'>
        <%= lgb.get(i).getName()%> <%= lgb.get(i).getLname()%>
    </div>
</div>
<%
    }
%>