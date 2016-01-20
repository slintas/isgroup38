/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global jsPlumb */

function bench_helper() {
    this.collapse = function (element, this_element) {
        for (var i = 2; i < element.children.length; i++) {
            element.children[i].style.display = "none";
        }
        this_element.src = "../resources/images/cross.png";
        this_element.onclick = function () {
            bench_helper.expand(this.parentNode.parentNode.parentNode, this);
        };
    };
    this.expand = function (element, this_element) {
        for (var i = 1; i < element.children.length; i++) {
            element.children[i].style.display = "block";
        }
        this_element.src = "../resources/images/minus.png";
        this_element.onclick = function () {
            bench_helper.collapse(this.parentNode.parentNode.parentNode, this);
        };
    };
}
var bench_helper = new bench_helper();

function load_anchors() {
    this.anchors_left_bench = function () {

        jsPlumb.setContainer("main_frame");

        var left_leafs = document.getElementById("left_bench").getElementsByClassName("bench_sub_domain_content");
        var right_leafs = document.getElementById("right_bench").getElementsByClassName("bench_sub_domain_content");

        var left_bench = {
            isSource: true,
            maxConnections: 5,
            paintStyle: {fillStyle: "rgb(249,121,18)", outlineColor: "black", outlineWidth: 2},
            connector: ["Straight"]
        };

        var right_bench = {
            isTarget: true,
            isSource: true,
            paintStyle: {fillStyle: "rgb(249,121,18)", outlineColor: "black", outlineWidth: 2},
            connector: ["Straight"]
        };

        for (var i = 0; i < left_leafs.length; i++) {
            jsPlumb.addEndpoint(left_leafs[i].children[1], {
                anchors: ["Right"]
            }, left_bench);
        }

        for (var i = 0; i < right_leafs.length; i++) {
            jsPlumb.addEndpoint(right_leafs[i].children[0], {
                anchor: ["Left"]
            }, right_bench);
        }

    };
    this.anchors_right_bench = function () {

        jsPlumb.setContainer("main_frame");

        var right_leafs = document.getElementById("right_bench").getElementsByClassName("bench_sub_domain_content");

        var common = {
            isSource: true,
            isTarget: true,
            connector: ["Straight"]
        };

        for (var i = 0; i < right_leafs.length; i++) {
            jsPlumb.addEndpoint(right_leafs[i].children[0].children[0], {
                anchor: "Left"
            }, common);
        }
    };
}
var load_anchors = new load_anchors();