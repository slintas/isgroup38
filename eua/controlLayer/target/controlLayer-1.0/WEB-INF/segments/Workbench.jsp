<%-- 
    Document   : Workbench
    Created on : Nov 7, 2015, 6:31:37 PM
    Author     : slintas
--%>

<div id="workbench">
    <div id="tools" style="height:50px;">
        <div class="input_field" style="float:left; width:33%;  margin:9px;" >
            <div class="input_field_expl" style="width:50px; margin-top:6px;">
                Tag:
            </div>
            <div class="seperate" style="width:calc(100% - 100px); height:40px;">
                <input id="tag_text" type="text" style="height:25px; font-size: 18px; margin-top:-1px;" value="" placeholder="Add tags to your guide."/>
                <input class="button" type="button" value="Add" onclick="tag_management.addTag();"/>
            </div>
        </div>
        <div class='guide_tags' style="float:left; width:33%; margin-top:12px;">
            <div class="input_field_expl" style="width:50px;">
                Tag:
            </div>
            <div id="current_tags">
                <div class="tag">
                    <span class="tag_text">Athens</span>
                    <i class="fa fa-times" onclick="this.parentNode.remove()" style="cursor:pointer; margin:2px;"></i>
                </div>
            </div>
        </div>
        <div class="search_button_workbench" style="float:left; width:32%; margin-top:12px;">
            <input class="button" type="button" value="Search" onclick="create_man.search();" style="float:right; margin:0px;"/>
        </div>
    </div>

    <div id='benches' stlye='clear:both'>
        <!-- LEFT  BENCH -->
        <div id="left_bench" class="empty">
            <div style='font-size:22px; font-weight: bold; margin:10px;'>
                Results:
            </div>
            <div class='tour_guide_results'>

            </div>
        </div>

        <!-- RIGHT BENCH -->
        <div id="right_bench" class="empty" style="display:none;">
            <div id="guide_owner">

            </div>
            <div id="guide_video">
                <iframe class="video" src="">
                </iframe>
            </div>
            <div id="guide_description">

            </div>
        </div>
    </div>

    <div id='comment_section' style="display:none;">
        <div id="comment_section_container">

        </div>
        <%
            if (session.getAttribute("user_name") != null) {
        %>
        <div id="comment_section_new" style="margin:10px; height:50px; padding:1px">
            <div style="float:left; margin-top:10px;">
                <input id="comment_section_new_reply_text" type="text" placeholder="Write your comment" style="height:25px; font-size:16px; width:350px;"/>
                <input type="button" class="button" value="Comment" onclick="create_man.newcomment()" />
            </div>
            <div id="comment_section_new_reply" style="margin:12px 0px 0px 10px;">
                <input id="comment_section_new_reply_button" type="button" class="button" value="Reply" disabled onclick="create_man.sendreply()" />
                <span id="comment_section_new_reply_button_at" style="color:green;"></span>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
