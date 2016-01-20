/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function content_controller_ajax() {
    this.load = function (command) {

        var xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange = function () {
            //alert(xmlhttp.readyState + " " + xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                //alert(xmlhttp.responseText);
                document.getElementById('content').innerHTML = xmlhttp.responseText;

                if (command === "workbench") {
                    elements_placement.place_bench_loaders();
                    elements_placement.benches_height();
                    elements_placement.wrap_children();
                } else if (command === "home") {
                    elements_placement.content_set_height();
					slide_starter.initialize();
                }
                elements_placement.content_set_height();
            } else {
                return false;
            }
        };
        xmlhttp.open("GET", command.toString(), true);
        xmlhttp.send();
    };
}
var content_controller_ajax = new content_controller_ajax();

function ajax() {
    this.load = function (command, data, format, wait) {

        var xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange = function () {
            //alert(xmlhttp.readyState + " " + xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var info = xmlhttp.responseText;
                //alert(info);
                if (command === "sign_up") {
                    if (info === "true") {
                        window.location.href = 'backbone';
                    } else {
                        alert("fail");
                    }
                } else if (command === "logout") {
                    window.location.href = 'backbone';
                } else if (command === "sign_in") {
                    if (info === "true") {
                        window.location.href = 'backbone';
                    } else {
                        alert("fail");
                    }
                } else if (command === "save_guide") {
                    if (info === "true") {
                        alert("Success");
                    } else {
                        alert("fail");
                    }//tour_guide_results
                } else if (command === "search") {
                    document.getElementsByClassName('tour_guide_results')[0].innerHTML = info;
                } else if (command === "gettour") {
                    document.getElementById('right_bench').style.display = "block";
                    document.getElementById('right_bench').innerHTML = info;
                    document.getElementById('benches').style.height = document.getElementById('right_bench').offsetHeight + "px";

                    ajax.load('comments', data, '', true);
                } else if (command === "comments") {
                    document.getElementById('comment_section').style.display = "block";
                    document.getElementById('comment_section_container').innerHTML = info;
                } else if ((command === "like") || (command === "dislike") || (command === "likeguide") || (command === "dislikeguide")) {
                    return;
                } else if (command === "viewguide") {
                    document.getElementById('updateCreate').innerHTML = info;
                } else if (command === "deleteguide") {
                    ajax.load('update', '', '', true);
                } else if (command === "updatetour") {
                    if (info === "true") {
                        alert("Success");
                        create_man.preview();
                    } else {
                        alert("fail");
                    }//tour_guide_results
                } else if (command === "newcomment") {
                    if (info === "true") {
                        ajax.load('comments', format, '', true);
                    } else {
                        alert("fail");
                    }//tour_guide_results
                } else if (command === "newcommentto") {
                    if (info === "true") {
                        ajax.load('comments', format, '', true);
                    } else {
                        alert("fail");
                    }//tour_guide_results
                } else {
                    document.getElementById('content').innerHTML = info;
                    elements_placement.content_set_height();
                }
            }
        };
        if (data === '') {
            xmlhttp.open("GET", command.toString(), !wait);
            xmlhttp.send();
        } else {
            if (format === 'json') {
                xmlhttp.open("POST", command.toString(), !wait);
                xmlhttp.setRequestHeader("Content-type", "application/json");
                xmlhttp.setRequestHeader("Content-length", data.length);
                xmlhttp.setRequestHeader("Connection", "close");
                xmlhttp.send(data);
            } else {
                xmlhttp.open("POST", command.toString(), !wait);
                xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlhttp.setRequestHeader("Content-length", data.length);
                xmlhttp.setRequestHeader("Connection", "close");
                xmlhttp.send(data);
            }
        }
    };
}
var ajax = new ajax();

function signUp() {
    var data = "&name=" + document.getElementById('name').value + "&last_name=" + document.getElementById('last_name').value;
    var data2 = "&email=" + document.getElementById('email').value + "&password=" + document.getElementById('password').value;
    if (document.getElementById('guide_check').checked) {
        data2 += "&guide=1";
    } else {
        data2 += "&guide=0";
    }

    ajax.load('sign_up', data + data2, '', true);

}

function signIn() {
    var data = "&email=" + document.getElementById('s_email').value + "&password=" + document.getElementById('s_password').value;

    ajax.load('sign_in', data, '', true);

}

function elements_placement() {
    this.place_bench_loaders = function () {
        var total_width_of_bench = document.getElementById('left_bench').offsetWidth;
        var total_height_of_bench = document.getElementById('right_bench').offsetHeight;

        if (document.getElementsByClassName('bench_click')[0]) {
            document.getElementsByClassName('bench_click')[0].style.marginLeft = (total_width_of_bench / 2 - 100) + "px";
            document.getElementsByClassName('bench_click')[0].style.marginTop = (total_height_of_bench / 2 - 26.5) + "px";
        }

        if (document.getElementsByClassName('bench_click')[1]) {
            document.getElementsByClassName('bench_click')[1].style.marginLeft = (total_width_of_bench / 2 - 100) + "px";
            document.getElementsByClassName('bench_click')[1].style.marginTop = (total_height_of_bench / 2 - 26.5) + "px";
        }
    };
    this.content_set_height = function () {
        document.getElementById('content').style.height = (window.innerHeight - 80) + "px";
    };
    this.wrap_children = function () {
        document.getElementById('content').style.height = "auto";
    };
    this.benches_height = function () {
        if (document.getElementById('left_bench').offsetHeight > document.getElementById('right_bench').offsetHeight) {
            document.getElementById('benches').style.height = document.getElementById('left_bench').offsetHeight + "px";
        } else {
            document.getElementById('benches').style.height = document.getElementById('right_bench').offsetHeight + "px";
        }
    };
}
var elements_placement = new elements_placement();


function tag_management() {
    this.addTag = function () {

        if (document.getElementById('tag_text').value.length === 0) {
            document.getElementById('tag_text').style.border = "1px solid red";
            return;
        } else if (this.check_if_exists()) {
            document.getElementById('tag_text').style.border = "1px solid red";
            return;
        }

        document.getElementById('tag_text').style.border = "1px solid black";
        var tag = document.createElement('div');
        tag.className = "tag";
        var span = document.createElement('span');
        span.className = 'tag_text';
        span.innerHTML = document.getElementById('tag_text').value;
        tag.appendChild(span);

        var cross = document.createElement('i');
        cross.className = "fa fa-times";
        cross.style.cursor = "pointer";
        cross.style.margin = "2px";
        cross.onclick = function () {
            this.parentNode.remove();
        };

        tag.appendChild(cross);
        document.getElementById('current_tags').appendChild(tag);

        document.getElementById('tag_text').value = '';

    };
    this.check_if_exists = function () {
        for (var i = 0; i < document.getElementById('left_bench').getElementsByClassName('tag_text').length; i++) {
            if (document.getElementById('left_bench').getElementsByClassName('tag_text')[i].innerHTML === document.getElementById('tag_text').value) {
                return true;
            }
        }
        return false;
    };
}
var tag_management = new tag_management();

function create_man() {
    this.preview = function () {
        if (this.check()) {
            alert("Please fill all fields");
            return;
        }

        document.getElementById('guide_title').innerHTML = document.getElementById('create_title_text').value;
        document.getElementById('guide_owner').innerHTML = document.getElementById('user_info').innerHTML;
        document.getElementById('guide_tags').innerHTML = document.getElementById('current_tags').innerHTML;
        document.getElementById('guide_video_frame').src = "https://www.youtube.com/embed/" +
                document.getElementById('create_url_text').value.substring(document.getElementById('create_url_text').value.indexOf('?v=') + 3);
        +"?autoplay=0";

        document.getElementById('guide_description').innerHTML = document.getElementById('create_description_text').value;
        document.getElementById('right_bench').style.display = "block";

    };
    this.save = function () {
        var data = "";
        data += "&guide_title=" + document.getElementById('create_title_text').value;
        data += "&guide_owner=" + document.getElementById('user_info').className;
        data += "&tags_num=" + document.getElementById('left_bench').getElementsByClassName('tag_text').length;
        for (var i = 0; i < document.getElementById('left_bench').getElementsByClassName('tag_text').length; i++) {
            data += "&guide_tag" + i + "=" + document.getElementById('left_bench').getElementsByClassName('tag_text')[i].innerHTML;
        }
        data += "&guide_video_frame=" + "https://www.youtube.com/embed/" +
                document.getElementById('create_url_text').value.substring(document.getElementById('create_url_text').value.indexOf('?v=') + 3);
        +"?autoplay=0";
        data += "&guide_description=" + document.getElementById('create_description_text').value;

        ajax.load('save_guide', data, '', true);
    };
    this.search = function () {
        var data = "";
        data += "&tags_num=" + document.getElementsByClassName('tag_text').length;
        for (var i = 0; i < document.getElementsByClassName('tag_text').length; i++) {
            data += "&guide_tag" + i + "=" + document.getElementsByClassName('tag_text')[i].innerHTML;
        }

        ajax.load('search', data, '', true);
    };
    this.get = function (id) {
        var data = '';
        data += '&id=' + id;

        ajax.load('gettour', data, '', true);
    };
    this.check = function () {
        if ((document.getElementById('create_title_text').value === '') || (document.getElementById('create_url_text').value === '') ||
                (document.getElementById('create_description_text').value === '') || (document.getElementsByClassName('tag_text').length === 0)) {
            return true;
        }
        return false;
    };
    this.like = function (id) {
        document.getElementById(id).getElementsByClassName('num')[0].innerHTML++;
        ajax.load('like', '&id=' + id, '', true);
    };
    this.dislike = function (id) {
        document.getElementById(id).getElementsByClassName('num')[1].innerHTML++;
        ajax.load('dislike', '&id=' + id, '', true);
    };
    this.load_to_view = function () {
        var data = "&id=" + document.getElementById('guide_selector').children[document.getElementById('guide_selector').selectedIndex].id;

        ajax.load('viewguide', data, '', true);
    };
    this.delete_tour = function () {
        var data = "&id=" + document.getElementById('guide_selector').children[document.getElementById('guide_selector').selectedIndex].id;

        ajax.load('deleteguide', data, '', true);
    };
    this.update_tour = function () {
        var data = "";
        data += "&guide_title=" + document.getElementById('create_title_text').value;
        data += "&guide_owner=" + document.getElementById('user_info').className;
        data += "&tags_num=" + document.getElementById('left_bench').getElementsByClassName('tag_text').length;
        for (var i = 0; i < document.getElementById('left_bench').getElementsByClassName('tag_text').length; i++) {
            data += "&guide_tag" + i + "=" + document.getElementById('left_bench').getElementsByClassName('tag_text')[i].innerHTML;
        }
        data += "&guide_video_frame=" + "https://www.youtube.com/embed/" +
                document.getElementById('create_url_text').value.substring(document.getElementById('create_url_text').value.indexOf('?v=') + 3);
        +"?autoplay=0";
        data += "&guide_description=" + document.getElementById('create_description_text').value;
        data += "&id=" + document.getElementById('guide_selector').children[document.getElementById('guide_selector').selectedIndex].id;

        ajax.load('updatetour', data, '', true);
    };
    this.newcomment = function () {
        var data = "";
        data += "&comment=" + document.getElementById('comment_section_new_reply_text').value;
        var data2 = "&id=" + document.getElementById('guide_owner').className;
        data += data2;

        ajax.load('newcomment', data, data2, true);
    };
    this.setreplyto = function (id, name) {
        document.getElementById('comment_section_new_reply_button_at').innerHTML = "@ " + name;
        document.getElementById('comment_section_container').className = id;
        document.getElementById('comment_section_new_reply_button').disabled = false;
    };
    this.sendreply = function () {
        var data = "";
        data += "&comment=" + document.getElementById('comment_section_new_reply_text').value;
        var data2 = "&id=" + document.getElementById('guide_owner').className;
        data += data2;
        data += "&to_id=" + document.getElementById('comment_section_container').className;

        ajax.load('newcommentto', data, data2, true);
    };
    this.like_guide = function (id){
        document.getElementById('guide_likes').innerHTML++;
        ajax.load('likeguide', '&id=' + id, '', true);
    };
    this.dislike_guide = function (id){
        document.getElementById('guide_dislikes').innerHTML++;
        ajax.load('dislikeguide', '&id=' + id, '', true);
    };
}
var create_man = new create_man();

/*
 *  Slideshow JS
 */

//put the path of the 3 images you want to interchange
var image1 = 'yoda1.jpg';
var image2 = 'yoda2.jpg';
var image3 = 'yoda3.jpg';
var path = '../resources/images/';

function changeImage() {
    if (document.getElementById('slideshow').src.toString().indexOf(image1) !== -1) {
        document.getElementById('slideshow').src = path+image2;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    } else if (document.getElementById('slideshow').src.toString().indexOf(image2) !== -1) {
        document.getElementById('slideshow').src = path+image3;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 1;
    } else {
        document.getElementById('slideshow').src = path+image1;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    }
}

function changeNextImage() {
    slide_starter.stop();
    if (document.getElementById('slideshow').src.toString().indexOf(image1) !== -1) {
        document.getElementById('slideshow').src = path+image2;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    } else if (document.getElementById('slideshow').src.toString().indexOf(image2) !== -1) {
        document.getElementById('slideshow').src = path+image3;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 1;
    } else {
        document.getElementById('slideshow').src = path+image1;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    }
    slide_starter.init();
}

function changePrevImage() {
    slide_starter.stop();
    if (document.getElementById('slideshow').src.toString().indexOf(image1) !== -1) {
        document.getElementById('slideshow').src = path+image3;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 1;
    } else if (document.getElementById('slideshow').src.toString().indexOf(image2) !== -1) {
        document.getElementById('slideshow').src = path+image1;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    } else {
        document.getElementById('slideshow').src = path+image2;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    }
    slide_starter.init();
}

function getImage(choice){
    slide_starter.stop();
    if (choice === 1) {
        document.getElementById('slideshow').src = path+image1;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    } else if (choice === 2) {
        document.getElementById('slideshow').src = path+image2;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
    } else {
        document.getElementById('slideshow').src = path+image3;
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 1;
    }
    slide_starter.init();
}


function slideshow_start() {
    var timer = false;
    this.initialize = function () {
        document.getElementById('loaded_bar').style.width = '0px';
        document.getElementById('slideshow').style.opacity = '1';
        document.getElementsByClassName('slideshow_item')[0].style.opacity = 1;
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
        slide_bar.start();
    };
    this.init = function(){
        document.getElementById('loaded_bar').style.width = '0px';
        document.getElementById('slideshow').style.opacity = '1';
        document.getElementsByClassName('slideshow_item')[1].style.opacity = 0.5;
        document.getElementsByClassName('slideshow_item')[2].style.opacity = 0.5;
        
        slide_bar.start();
    };
    this.start = function () {//
        if (!this.isUp()) {
            timer = setInterval(function () {
                document.getElementById('loaded_bar').style.width = '0px';
                document.getElementById('slideshow').style.opacity = '1';
                slide_bar.start();
            }, 10000);
        }
    };
    this.stop = function () {
        clearInterval(timer);
        document.getElementById('loaded_bar').style.width = '0px';
        document.getElementById('slideshow').style.opacity = '1';
        document.getElementById('slideshow').style.marginLeft = '0px';
        slide_bar.stop();
        slide_slider.stop();
        timer = false;
    };
    this.isUp = function () {
        return timer !== false;
    };
}
var slide_starter = new slideshow_start();

function slideshow_loadBar() {
    var timer = false;
    this.start = function () {//
        if (!this.isUp()) {
            timer = setInterval(function () {
                if ((parseInt(onlyNum(document.getElementById('loaded_bar').style.width))) < 80 * 4) {
                    document.getElementById('loaded_bar').style.width = (parseInt(onlyNum(document.getElementById('loaded_bar').style.width)) + 4) + 'px';
                } else if ((parseInt(onlyNum(document.getElementById('loaded_bar').style.width))) < 100 * 4) {
                    document.getElementById('loaded_bar').style.width = (parseInt(onlyNum(document.getElementById('loaded_bar').style.width)) + 4) + 'px';
                    document.getElementById('slideshow').style.opacity = document.getElementById('slideshow').style.opacity - 0.05;
                }
                else {
                    document.getElementById('loaded_bar').style.width = '0px';
                    changeImage();
                    document.getElementById('slideshow').style.marginLeft = '400px';
                    document.getElementById('slideshow').style.opacity = 1;
                    slide_slider.start();
                }

            }, 100);
        }
    };
    this.stop = function () {
        document.getElementById('loaded_bar').style.width = '0px';
        clearInterval(timer);
        timer = false;
    };
    this.isUp = function () {
        return timer !== false;
    };
}
var slide_bar = new slideshow_loadBar();

function slideshow_slider() {
    var timer = false;
    this.start = function () {//
        if (!this.isUp()) {
            timer = setInterval(function () {
                if ((parseInt(onlyNum(document.getElementById('slideshow').style.marginLeft))) > 40) {
                    document.getElementById('slideshow').style.marginLeft = (parseInt(onlyNum(document.getElementById('slideshow').style.marginLeft)) - 8) + 'px';
                } else if ((parseInt(onlyNum(document.getElementById('slideshow').style.marginLeft))) > 0) {
                    document.getElementById('slideshow').style.marginLeft = (parseInt(onlyNum(document.getElementById('slideshow').style.marginLeft)) - 1) + 'px';
                } else {
                    slide_slider.stop;
                    timer = true;
                }
            }, 10);
        }
    };
    this.stop = function () {
        clearInterval(timer);
        timer = false;
    };
    this.isUp = function () {
        return timer !== false;
    };
}
var slide_slider = new slideshow_slider();

function slideshow_kill() {
    if (document.getElementById('slideshow_stop').src.toString().indexOf('x.png') !== -1) {
        slide_starter.stop();
        document.getElementById('slideshow_stop').src = path+'play.png';
    } else {
        slide_starter.initialize();
        document.getElementById('slideshow_stop').src = path+'x.png';
    }

}

function onlyNum(str) {
    return str.toString().replace(/\D/g, '');
}

function menu(mouseover) {
    if (mouseover === 1) {
        
    } else if (mouseover === 2) {
        
    } else {
        
    }
}
