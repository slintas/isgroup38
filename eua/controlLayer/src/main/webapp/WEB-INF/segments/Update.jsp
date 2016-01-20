<%-- 
    Document   : Update
    Created on : Jan 16, 2016, 6:38:22 PM
    Author     : slintas
--%>

<%@page import="javabeans.GuideBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id='benches' stlye='clear:both'>
    <!-- LEFT  BENCH -->
    <div id="left_bench" class="empty" style="margin-top:10px;">
        <div class="create_title">
            Update Form
        </div>
        <div class="input_field">
            <div class="input_field_expl" style="width:200px">
                Your current guides:
            </div>
            <div class="input_field_text">
                <select id="guide_selector" style="height:22px; font-size:16px; width:120px;">
                    <%
                        List<GuideBean> ls = (ArrayList<GuideBean>) request.getAttribute("data");
                        for (int i = 0; i < ls.size(); i++) {
                    %>
                    <option id="<%= ls.get(i).getID() %>" > <%= ls.get(i).getTitle()%> </option>
                    <%
                        }
                    %>
                </select>
                <input type="button" class="button" value="Load" style="width:120px; height: 30px; font-size:16px;" onclick="create_man.load_to_view()"/>
            </div>
        </div>
        <div id="updateCreate">
            
        </div>
    </div>

    <!-- RIGHT BENCH -->
    <div id="right_bench" class="empty" style="display:none; margin-top:10px;">
        <div id="guide_title">

        </div>
        <div id="guide_owner">
            
        </div>
        <div class="input_field">
            <div class="input_field_expl">
                Tags:
            </div>
            <div id="guide_tags">
                
            </div>
        </div>
        <div id="guide_video">
            <iframe id="guide_video_frame" class="video" src="https://www.youtube.com/embed/VQH8ZTgna3Q?autoplay=0">
            </iframe>
        </div>
        <div id="guide_description">
            
        </div>
    </div>
</div>
