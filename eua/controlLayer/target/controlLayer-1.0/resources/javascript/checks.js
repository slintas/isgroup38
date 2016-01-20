
/*
 * General Purpose Functions
 */

function onlyNum(str) {
    return str.toString().replace(/\D/g, '');
}

function checkFields() {
    this.checkLogInEmail = function () {
        var emailcheck = document.getElementById('s_email').value.toString();
        if (emailcheck.length === 0) {
            document.getElementById('to_sign_in').getElementsByClassName('input')[0].children[0].style.border = '1px solid rgb(217,217,217)';
            document.getElementById('to_sign_in').getElementsByClassName('JS_error')[0].innerHTML = '';
            return false;
        } else if ((emailcheck.indexOf('@') >= 3) && (emailcheck.substring(emailcheck.indexOf('@')).indexOf('.') !== -1)) {
            document.getElementById('to_sign_in').getElementsByClassName('input')[0].children[0].style.border = '1px solid green';
            document.getElementById('to_sign_in').getElementsByClassName('JS_error')[0].innerHTML = '';
            return true;
        } else {
            document.getElementById('to_sign_in').getElementsByClassName('input')[0].children[0].style.border = '1px solid red';
            document.getElementById('to_sign_in').getElementsByClassName('JS_error')[0].innerHTML = 'example@example.com';
            return false;
        }
    };
    this.checkLogInPassword = function () {
        var password = document.getElementById('s_password').value.toString();
        if (password.length === 0) {
            document.getElementById('to_sign_in').getElementsByClassName('input')[1].children[0].style.border = '1px solid rgb(217,217,217)';
            document.getElementById('to_sign_in').getElementsByClassName('JS_error')[1].innerHTML = '';
            return false;
        } else if (password.length > 3) {
            document.getElementById('to_sign_in').getElementsByClassName('input')[1].children[0].style.border = '1px solid green';
            document.getElementById('to_sign_in').getElementsByClassName('JS_error')[1].innerHTML = '';
            return true;
        } else {
            document.getElementById('to_sign_in').getElementsByClassName('input')[1].children[0].style.border = '1px solid red';
            document.getElementById('to_sign_in').getElementsByClassName('JS_error')[1].innerHTML = 'at least 4 characters';
            return false;
        }
    };
    this.checkSignUpName = function () {
        var namecheck = document.getElementById('name').value.toString();
        if (namecheck.length === 0) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[0].children[0].style.border = '1px solid rgb(217,217,217)';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[0].innerHTML = '';
            return false;
        } else if (namecheck.length >= 3) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[0].children[0].style.border = '1px solid green';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[0].innerHTML = '';
            return true;
        } else {
            document.getElementById('to_sign_up').getElementsByClassName('input')[0].children[0].style.border = '1px solid red';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[0].innerHTML = 'At least 3 characters';
            return false;
        }
    };
    this.checkSignUpEmail = function () {
        var emailcheck = document.getElementById('email').value.toString();
        if (emailcheck.length === 0) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[2].children[0].style.border = '1px solid rgb(217,217,217)';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[2].innerHTML = '';
            return false;
        } else if ((emailcheck.indexOf('@') >= 3) && (emailcheck.substring(emailcheck.indexOf('@')).indexOf('.') !== -1)) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[2].children[0].style.border = '1px solid green';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[2].innerHTML = '';
            return true;
        } else {
            document.getElementById('to_sign_up').getElementsByClassName('input')[2].children[0].style.border = '1px solid red';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[2].innerHTML = 'example@example.com';
            return false;
        }
    };
    this.checkSignUpPassword = function () {
        var password = document.getElementById('password').value.toString();
        if (password.length === 0) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[3].children[0].style.border = '1px solid rgb(217,217,217)';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[3].innerHTML = '';
            return false;
        } else if (password.length > 3) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[3].children[0].style.border = '1px solid green';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[3].innerHTML = '';
            return true;
        } else {
            document.getElementById('to_sign_up').getElementsByClassName('input')[3].children[0].style.border = '1px solid red';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[3].innerHTML = 'at least 4 characters';
            return false;
        }
    };
    this.checkSignUpRePassword = function () {
        var password = document.getElementById('password_re').value.toString();
        if (password.length === 0) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[4].children[0].style.border = '1px solid rgb(217,217,217)';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[4].innerHTML = '';
            return false;
        } else if ((password.length > 3) && (password === document.getElementById('password').value.toString())) {
            document.getElementById('to_sign_up').getElementsByClassName('input')[4].children[0].style.border = '1px solid green';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[4].innerHTML = '';
            return true;
        } else {
            document.getElementById('to_sign_up').getElementsByClassName('input')[4].children[0].style.border = '1px solid red';
            document.getElementById('to_sign_up').getElementsByClassName('JS_error')[4].innerHTML = 'passwords do not match';
            return false;
        }
    };
}
var field = new checkFields();

function masterCheck() {
    this.logIn = function () {
        if ((field.checkLogInEmail()) && (field.checkLogInPassword())) {
            document.getElementById('sign_in_button').disabled = false;
            return true;
        }
        document.getElementById('sign_in_button').disabled = true;
        return false;
    };
    this.signUp = function () {
        if ((field.checkSignUpName()) && (field.checkSignUpEmail()) && (field.checkSignUpPassword()) && (field.checkSignUpRePassword())) {
            document.getElementById('sign_up_button').disabled = false;
            return true;
        }
        document.getElementById('sign_up_button').disabled = true;
        return false;
    };
}
var check = new masterCheck();

function timer() {
    var timer = false;
    this.start = function () {//
        this.stop();
        if (!this.isUp()) {
            timer = setInterval(function () {
                checks_ajax.check_email();
            }, 2000);
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
var timer = new timer();

function checks_ajax() {
    this.check_email = function () {

        timer.stop();

        if (!field.checkSignUpEmail()) {
            return;
        }

        var data = "&email=" + document.getElementById('email').value;
        var xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange = function () {
            //alert(xmlhttp.readyState + " " + xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var info = xmlhttp.responseText;
                if (info === "new") {
                    document.getElementById('to_sign_up').getElementsByClassName('input')[2].children[0].style.border = '1px solid green';
                } else {
                    document.getElementById('to_sign_up').getElementsByClassName('JS_error')[2].innerHTML = 'this email is taken';
                    document.getElementById('to_sign_up').getElementsByClassName('input')[2].children[0].style.border = '1px solid red';
                }
            }
        };
        xmlhttp.open("POST", "check_email", false);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.setRequestHeader("Content-length", data.length);
        xmlhttp.setRequestHeader("Connection", "close");
        xmlhttp.send(data);
    };
}
var checks_ajax = new checks_ajax();