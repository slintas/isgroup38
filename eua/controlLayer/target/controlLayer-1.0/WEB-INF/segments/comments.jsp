<%-- 
    Document   : comments
    Created on : Jan 16, 2016, 3:22:35 PM
    Author     : slintas
--%>

<%@page import="javabeans.CommentBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<CommentBean> lcb = (ArrayList<CommentBean>) request.getAttribute("data");
%>
<%
    for (int i = 0; i < lcb.size(); i++) {
%>
<div class='comment' id="<%= lcb.get(i).getID()%>">
    <div class='comment_owner'>
        <div class='comment_name' style="margin:5px">
            <%= lcb.get(i).getName()%> <%= lcb.get(i).getLname()%>
            <div>
                <div class="votes" style="margin:2px 5px 2px 5px;">
                    <%= lcb.get(i).getDate()%>
                </div>
                <div class="votes" style="margin:2px 5px 2px 5px;">
                    <i class="fa fa-thumbs-up" id="likes" title="Like" onclick="create_man.like(<%= lcb.get(i).getID()%>)" style="cursor: pointer;"></i>
                    : <span class="num"><%= lcb.get(i).getUpvotes()%></span>
                </div>
                <div class="votes" style="margin:2px 5px 2px 5px;">
                    <i class="fa fa-thumbs-down" id="likes" title="Like" onclick="create_man.dislike(<%= lcb.get(i).getID()%>)" style="cursor: pointer;"></i>
                    : <span class="num"><%= lcb.get(i).getDownvotes()%></span>
                </div>
                <div class="votes" style="margin:2px 5px 2px 5px;">
                    <i class="fa fa-reply" style="cursor: pointer; margin:0px 5px 0px 5px;" onclick="create_man.setreplyto(<%= lcb.get(i).getID()%>,'<%= lcb.get(i).getName()%>' + ' ' + '<%= lcb.get(i).getLname()%>')"></i>
                </div>
            </div>
        </div>
    </div>
    <div class='comment_text'>
        <%= lcb.get(i).getComment()%>
    </div>
    <%
        if (lcb.get(i).getLcb().size() > 0) {
    %>
    <jsp:include page="sub_comments.jsp" flush="true" >
        <jsp:param name="parentID" value="<%= lcb.get(i).getID()%>"/>
    </jsp:include>
    <%
        }
    %>
</div>
<%
    }
%>