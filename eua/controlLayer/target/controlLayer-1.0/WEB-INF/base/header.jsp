<%-- 
    Document   : header
    Created on : Nov 7, 2015, 4:06:03 PM
    Author     : slintas
--%>

<div id="header">
    <div id="logo">
        <div id="logo_title">
            <span class="logo_stroke">Travel</span>GUIDE
        </div>
        <div id="logo_image">
            <img class="logo_image_icon" src="../resources/images/logo.png" />
        </div>
    </div>
    <div id="menu">
        <%
            if (session.getAttribute("user_name") != null) {
                if (session.getAttribute("guide").equals("1")) {
        %>
        <div class="menu_element" onclick="content_controller_ajax.load('home')" style="width:33%">
            <span class="clickable_text">Home</span>
        </div>
        <div class="menu_element" onclick="content_controller_ajax.load('workbench')" style="width:33%">
            <span class="clickable_text">Guides</span>
        </div>
        <div class="menu_element" onclick="content_controller_ajax.load('create')" style="width:33%">
            <span class="clickable_text">Create</span>
        </div>
        <%
        } else {
        %>
        <div class="menu_element" onclick="content_controller_ajax.load('home')">
            <span class="clickable_text">Home</span>
        </div>
        <div class="menu_element" onclick="content_controller_ajax.load('workbench')">
            <span class="clickable_text">Guides</span>
        </div>
        <%
            }
        } else {
        %>
        <div class="menu_element" onclick="content_controller_ajax.load('home')">
            <span class="clickable_text">Home</span>
        </div>
        <div class="menu_element" onclick="content_controller_ajax.load('workbench')">
            <span class="clickable_text">Guides</span>
        </div>
        <%
            }
        %>
    </div>
    <div id="user_controlls">
        <%
            if (session.getAttribute("user_name") != null) {
        %>
        <div id="user_controller_image" onclick="
                if (document.getElementById('user_menu').style.display === 'none') {
                    document.getElementById('user_menu').style.display = 'block';
                } else {
                    document.getElementById('user_menu').style.display = 'none';
                }
             ">
            <img class="logo_image_icon" src="../resources/images/triangle.png" />
            <div id="user_menu">
                <%
                    if (session.getAttribute("guide").equals("1")) {
                %>
                <div class="user_menu_option">
                    <div class="votes" style="margin:10px;">
                        <i class="fa fa-thumbs-up" id="likes" title="Like"></i>
                        : <%= session.getAttribute("user_upvotes")%>
                    </div>
                    <div class="votes" style="margin:10px;">
                        <i class="fa fa-thumbs-down" id="likes" title="Like"></i>
                        : <%= session.getAttribute("user_downvotes")%>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="user_menu_option" onclick="ajax.load('update', '', '', true)">
                    <div class="user_menu_option_text">
                        Update
                    </div>
                    <div class="user_menu_option_icon">
                        <img class="small_icon" src="../resources/images/gear.png" />
                    </div>
                </div>
                <div class="user_menu_option" onclick="ajax.load('logout', '', '', false)">
                    <div class="user_menu_option_text">
                        Logout
                    </div>
                    <div class="user_menu_option_icon">
                        <img class="small_icon" src="../resources/images/logout.png" />
                    </div>
                </div>
            </div>
        </div>
        <div id="user_info" class="<%= session.getAttribute("user_email")%>">
            <%= session.getAttribute("user_name")%> <%= session.getAttribute("user_last_name")%>
        </div>
        <%
            }
        %>
    </div>
</div>
