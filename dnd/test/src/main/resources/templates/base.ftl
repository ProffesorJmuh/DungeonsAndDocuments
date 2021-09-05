<#include "security.ftl">
<#macro body title>
    <!DOCTYPE html>

    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="/main.css">
        <link rel="stylesheet" type="text/css" href="/style.css">

        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
                crossorigin="anonymous"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
        <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet">

        <title>${title}</title>
    </head>
    <body>
        <header>
            <div class="logo">
                <a href="">
                    <img id="logotipe" class='graficlogo left' src="/img/logo.png" alt="Logo"/>
                </a>

                <nav>
                    <div class="btn">
                        <a href="/user">Профиль</a>
                        <a href="/rating" target="_self">Рейтинг</a>
                        <a href="/task" target="_self">Задания</a>
                        <a href="#" target="_self">Гильдии</a>
                        <a href="/store" target="_self">Магазин</a>
                    </div>
                </nav>
            </div>

        </header>
    <div>
        <#nested>
    </div>


    <script>
        console.log(document.cookie)
        function set_cookie(name, value, exp_y, exp_m, exp_d, path, domain, secure) {
            var cookie_string = name + "=" + escape(value);
            if (exp_y) {
                var expires = new Date(exp_y, exp_m, exp_d);
                cookie_string += "; expires=" + expires.toGMTString();
            }
            if (path)
                cookie_string += "; path=" + escape(path);
            if (domain)
                cookie_string += "; domain=" + escape(domain);
            if (secure)
                cookie_string += "; secure";
            document.cookie = cookie_string;
        }
        function eraseCookie(name, path, domain) {
            console.log(get_cookie(name))
            document.cookie = name + "=" +
                ((path) ? ";path=" + path : "") +
                ((domain) ? ";domain=" + domain : "") +
                ";Max-Age=-99999999;";
        }
        function delete_cookie(cookie_name, path, domain) {
            console.log(get_cookie('Authorization'))
            var cookie_date = new Date();  // Текущая дата и время
            cookie_date.setTime(cookie_date.getTime() - 1);
            document.cookie = name + "=" +
                ((path) ? ";path=" + path : "") +
                ((domain) ? ";domain=" + domain : "") +
                ";expires=Thu, 01 Jan 1970 00:00:01 GMT";
        }
        function get_cookie(cookie_name) {
            var results = document.cookie.match('(^|;) ?' + cookie_name + '=([^;]*)(;|$)');
            if (results)
                return (unescape(results[2]));
            else
                return null;
        }
    </script>
    </body>
    </html>
</#macro>