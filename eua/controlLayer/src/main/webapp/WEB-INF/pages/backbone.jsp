<%-- 
    Document   : home
    Created on : Nov 7, 2015, 4:07:13 PM
    Author     : slintas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../base/head.jsp" %>
    <body onload="content_controller_ajax.load('home')">
        
        <%@include file="../base/header.jsp" %>
        
        <div id="blanket" onclick="render.clear();">

        </div>
        <div id="blanket_info">
            <div id="blanket_info_header">

            </div>
            <div id="blanket_info_body">

            </div>
            <div id="blanket_info_footer">

            </div>
        </div>
        
        <div id="content">
            
        </div>
        <%@include file="../base/footer.jsp" %>
    </body>

</html>
