/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function render() {
    this.load_data_base_view = function (event) {
        basic_render.activate_blanket();
        basic_render.set_header('Load data base View');
        basic_render.add_text("Find the address with the representation of the database you wish to view.");
        basic_render.add_input_text_title_field("Insert adress here: ", "http:\\.....", 400);
        basic_render.add_button_to_footer("Load", "alert();", "button");
        basic_render.position_blanket_info();
    };
    this.clear = function () {
        basic_render.clear();

    };

}
var render = new render();

function basic_render() {
    this.activate_blanket = function () {
        document.getElementById('blanket').style.display = "block";
        document.getElementById('blanket_info').style.display = "block";
    };
    this.clear = function () {
        document.getElementById('blanket').style.display = "none";
        document.getElementById('blanket_info').style.display = "none";
        document.getElementById('blanket_info_body').innerHTML = "";
        document.getElementById('blanket_info_footer').innerHTML = "";
    };
    this.set_header = function (text) {
        document.getElementById('blanket_info_header').innerHTML = text;
    };
    this.set_footer = function () {
        document.getElementById('blanket_info_footer');
    };
    this.add_text = function (text) {
        document.getElementById('blanket_info_body').appendChild(factory.text_display(text));
    };
    this.add_input_text_field = function (placeholder, width) {
        document.getElementById('blanket_info_body').appendChild(factory.input_element_text(placeholder, width));
    };
    this.add_input_text_title_field = function (text, placeholder, width) {
        document.getElementById('blanket_info_body').appendChild(factory.input_element_text_title(text, placeholder, width));
    };
    this.add_button_to_footer = function (text, fun, class_name) {
        document.getElementById('blanket_info_footer').appendChild(factory.button(text, fun, class_name));
    };
    this.position_blanket_info = function () {
        var total_width_bench = window.innerWidth;
        var total_height_bench = window.innerHeight;

        var total_width_info = document.getElementById('blanket_info').offsetWidth;
        var total_height_info = document.getElementById('blanket_info').offsetHeight;

        document.getElementById('blanket_info').style.marginLeft = ((total_width_bench / 2) - (total_width_info / 2)) + "px";
        document.getElementById('blanket_info').style.marginTop = ((total_height_bench / 2) - (total_height_info / 2) - 50) + "px";
    };
}
var basic_render = new basic_render();

function factory() {
    this.input_element_text = function (placeholder, width, class_name, id_name) {
        var input_http_element = document.createElement('input');
        if ((class_name !== undefined) || (id_name !== undefined)) {
            input_http_element = this.add_class_id(input_element, class_name, id_name);
        }
        input_http_element.type = 'text';
        input_http_element.style.width = width + "px";
        input_http_element.placeholder = placeholder;
        return input_http_element;
    };
    this.input_element_text_title = function (text, placeholder, width, class_name, id_name) {
        var input_element_text = document.createElement('div');
        if ((class_name !== undefined) || (id_name !== undefined)) {
            input_element_text = this.add_class_id(input_element, class_name, id_name);
        }
        input_element_text.innerHTML = text;
        var text_element = this.input_element_text(placeholder, width);
        input_element_text.appendChild(text_element);
        return input_element_text;
    };
    this.text_display = function (text) {
        var text_div = document.createElement('div');
        text_div.innerHTML = text;
        return text_div;
    };
    this.check_icon = function () {

    };
    this.button = function (text, fun, class_name, id_name) {
        var button = document.createElement('input');
        button.type = 'button';
        if ((class_name !== undefined) || (id_name !== undefined)) {
            button = this.add_class_id(button, class_name, id_name);
        }
        button.value = text;
        button.onclick = scope.scope_drag(fun);
        return button;
    };
    this.add_class_id = function (element, class_name, id_name) {
        if (class_name !== undefined) {
            element.className = class_name;
        }
        if (id_name !== undefined) {
            element.id = id_name;
        }
        return element;
    };
}
var factory = new factory();

function scope() {
    this.scope_drag = function (fun) {
        var execute = fun;
        function loadURL() {
            data_base_loader.proxy("url=" + document.getElementById('blanket_info_body').getElementsByTagName('input')[0].value);
            render.clear();
        }
        ;
        return loadURL;
    };
}
var scope = new scope();

function data_base_loader() {
    this.proxy = function (url, side) {

        var left_bench = document.getElementById('left_bench');
        var right_bench = document.getElementById('right_bench');

        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            //alert(xmlhttp.readyState + " " + xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                //alert(xmlhttp.responseText);
                if (side === 'left') {
                    document.getElementById('left_bench').innerHTML = xmlhttp.responseText;
                    left_bench.className = 'loaded';
                    page_style.height();
                } else {
                    document.getElementById('right_bench').innerHTML = xmlhttp.responseText;
                    right_bench.className = 'loaded';
                    page_style.height();
                }
                if ((left_bench.className !== 'empty') && (right_bench.className !== 'empty')) {
                    load_anchors.anchors_left_bench();
                }
            }
        };
        xmlhttp.open("POST", "proxy", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.setRequestHeader("Content-length", url.length);
        xmlhttp.setRequestHeader("Connection", "close");
        xmlhttp.send(url);

    };
}
var data_base_loader = new data_base_loader();

function page_style() {
    this.height = function () {
        var left = document.getElementById('left_bench').offsetHeight;
        var right = document.getElementById('right_bench').offsetHeight;

        if (left > right) {
            document.getElementById('content').style.height = left + 400 + "px";
        } else {
            document.getElementById('content').style.height = right + 400 + "px";
        }

    };
}
var page_style = new page_style();