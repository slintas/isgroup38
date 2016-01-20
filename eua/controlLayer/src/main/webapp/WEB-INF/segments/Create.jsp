<%-- 
    Document   : create_guide
    Created on : Jan 16, 2016, 2:47:33 AM
    Author     : slintas
--%>

<div id='benches' stlye='clear:both'>
    <!-- LEFT  BENCH -->
    <div id="left_bench" class="empty" style="margin-top:10px;">
        <div class="create_title">
            Creation Form
        </div>
        <div class="input_field">
            <div class="input_field_expl">
                Title:
            </div>
            <div class="input_field_text">
                <input id="create_title_text" type="text" value="" placeholder="Title for your guide." />
            </div>
        </div>
        <div class="input_field">
            <div class="input_field_expl">
                Video URL:
            </div>
            <div class="input_field_text">
                <input id="create_url_text" type="text" value="" placeholder="The video's url."/>
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
                <div class="tag">
                    <span class="tag_text">Athens</span>
                    <i class="fa fa-times" onclick="this.parentNode.remove()" style="cursor:pointer; margin:2px;"></i>
                </div>
            </div>
        </div>
        <div class="description">
            <div class="title">
                Description:
            </div>
            <div> 
                <textarea id="create_description_text" rows="4" cols="50" placeholder="In depth description of the tour.">At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies.
                </textarea> 
            </div>
        </div>
        <div class="buttons">
            <input type="button" class="button_cancel" value="Preview" onclick="create_man.preview()"/>
            <input type="button" class="button" value="Save" onclick='create_man.save()'/>
        </div>
    </div>

    <!-- RIGHT BENCH -->
    <div id="right_bench" class="empty" style="display:none; margin-top:10px;">
        <div id="guide_title">
            
        </div>
        <div id="guide_owner">
            Eua Giannatou
        </div>
        <div class="input_field">
            <div class="input_field_expl">
                Tags:
            </div>
            <div id="guide_tags">
                <div class="tag">
                    <span class="tag_text">Athens</span>
                    <i class="fa fa-times" onclick="this.parentNode.remove()" style="cursor:pointer; margin:2px;"></i>
                </div>
            </div>
        </div>
        <div id="guide_video">
            <iframe id="guide_video_frame" class="video" src="https://www.youtube.com/embed/VQH8ZTgna3Q?autoplay=0">
            </iframe>
        </div>
        <div id="guide_description">
            This place in Athens is awesome because I'm Awesome and so on so on. This is supposed to be a description in length but because i am lazy
            it will be a stream of Blah blah. Ready? Wanna see me do it? OK!<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Wanna see me do it again?<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.<br>
            See? that's cool ain't it?
        </div>
    </div>
</div>
