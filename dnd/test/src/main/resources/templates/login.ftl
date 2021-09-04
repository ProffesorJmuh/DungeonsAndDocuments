<#import "base.ftl" as base>

<@base.body "${title}">
    <div class="container">
        <form id="loginForm" class="form-signin" method="post" action="/login">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <h2 class="form-signin-heading">Login</h2>
            <p>
                <label for="username">Email</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="email" required>
            </p>
            <p>
                <label for="password">Пароль</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </p>
            <div class="d-flex flex-row">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                <a class="btn btn-lg btn-success btn-block" href="/login/new">Зарегестрироваться</a>
            </div>
        </form>
    </div>

</@base.body>