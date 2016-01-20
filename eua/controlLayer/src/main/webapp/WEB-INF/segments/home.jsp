<%-- 
    Document   : home.jsp
    Created on : Nov 30, 2015, 5:51:40 PM
    Author     : slintas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="information_side">
    <div id="slideshow_div">
        <img id="slideshow" src="../resources/images/yoda1.jpg" />
        <div id="slideshow_stoper">
            <img id="slideshow_stop" src="../resources/images/x.png" onclick="slideshow_kill();"/>   
        </div>
        <div id="left_div">
            <img id="left_arrow" src="../resources/images/larrow.png" onclick="changePrevImage();"/>
        </div>
        <div id="right_div">
            <img id="right_arrow" src="../resources/images/rarrow.png" onclick="changeNextImage();"/>
        </div>
    </div>
    <div id="loading_bar">
        <div id="loaded_bar">

        </div>
        <div class="fade_bar">
            <div id="fade_bar1" title="The picture will start bluring here">

            </div>
        </div>
        <div class="fade_bar">
            <div id="fade_bar2" title="The new picture will start sliding in">

            </div>
        </div>
    </div>
    <div id="slideshow_previews">
        <div class="slideshow_item" style="margin-right:5px;">
            <img src="../resources/images/yoda1.jpg" onclick="getImage(1);
                    slideshow_kill();"/>
        </div>
        <div class="slideshow_item" style="margin-right:5px;">
            <img src="../resources/images/yoda2.jpg" onclick="getImage(2);
                    slideshow_kill();"/>
        </div>
        <div class="slideshow_item">
            <img src="../resources/images/yoda3.jpg" onclick="getImage(3);
                    slideshow_kill();"/>
        </div>
    </div>
    <div id="info">
		Travel Guide is a web application that allows users to create guides for 
		other users with helpful videos and descriptions.
    </div>
</div>
<div id="sign_in_up">
    <div id="render_area">
        <div id="to_sign_in" onmouseover="check.logIn();">
            <div class="model_title">
                <div class="title_info">
                    Sign In
                </div>
                <div class="title_close">
                    <img src="../resources/images/x.png" 
                         onclick="
                                 document.getElementById('render_area').style.display = 'none';
                                 document.getElementById('buttons').style.display = 'block';"/>
                </div>
            </div>
            <div class="input">
                <input id="s_email" type="email" placeholder="Email" onblur="check.logIn();" onkeypress="
                        if (event.keyCode === 13) {
                            signIn();
                        }" />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input">
                <input id="s_password" type="password" placeholder="Password"  onblur="check.logIn();" onkeyup="
                        if (event.keyCode === 13) {
                            signIn();
                        } else if (this.value.length >= 4) {
                            check.logIn();
                        }" />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input_button">
                <input id="sign_in_button" type="button" class="button" value="Sign in" onclick='signIn()' disabled/>
            </div>
            <div class='JS_error_button'>

            </div>
        </div>
        <div id="to_sign_up" onmouseover="check.signUp();">
            <div class="model_title">
                <div class="title_info">
                    Sign Up
                </div>
                <div class="title_close">
                    <img src="../resources/images/x.png" 
                         onclick="
                                 document.getElementById('render_area').style.display = 'none';
                                 document.getElementById('buttons').style.display = 'block';"/>
                </div>
            </div>
            <div class="input">
                <input id="name" type="text" placeholder="Name" onblur="check.signUp();" onkeypress="
                        if (event.keyCode === 13) {
                            signUp();
                        }" />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input">
                <input id="last_name" type="text" placeholder="Last Name" onblur="check.signUp();" onkeypress="
                        if (event.keyCode === 13) {
                            signUp();
                        }" />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input">
                <input id="email" type="email" placeholder="Email" onblur="check.signUp();" onkeypress="
                        if (event.keyCode === 13) {
                            signUp();
                        }
                        timer.start();
                       " />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input">
                <input id="password" type="password" placeholder="Password" onblur="check.signUp();" onkeypress="
                        if (event.keyCode === 13) {
                            signUp();
                        }" />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input">
                <input id="password_re" type="password" placeholder="Retype password" onblur="check.signUp();" onkeyup="
                        if (event.keyCode === 13) {
                            signUp();
                        }" />
            </div>
            <div class='JS_error'>

            </div>
            <div class="input_button">
                <div class="checkbox">
                    Guide: <input id="guide_check" type="checkbox" />
                </div>
                <input id="sign_up_button" type="button" class="button" value="Sign up" onclick="signUp()" disabled/>
            </div>
            <div class='JS_error_button'>

            </div>
        </div>
    </div>
    <div id="buttons">
        <div class="buttons_text">
            If you want to be able to save data maps<br> join our community<br> or just help us please
        </div>
        <div class="sign_button">
            <input type="button" class="button" value="Sign In" onclick="document.getElementById('to_sign_in').style.display = 'block';
                    document.getElementById('to_sign_up').style.display = 'none';
                    document.getElementById('render_area').style.display = 'block';
                    document.getElementById('buttons').style.display = 'none';"/>
        </div>
        <div class="buttons_tex_middle">
            or 
        </div>
        <div class="sign_button">
            <input type="button" class="button" value="Sign Up" onclick="document.getElementById('to_sign_in').style.display = 'none';
                    document.getElementById('to_sign_up').style.display = 'block';
                    document.getElementById('render_area').style.display = 'block';
                    document.getElementById('buttons').style.display = 'none';"/>
        </div>
        <div class="buttons_text">
            <!--to better your experience with our services-->
        </div>
    </div>
</div>