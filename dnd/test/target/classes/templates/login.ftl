<#import "base.ftl" as base>

<@base.body "${title}">
    <div class="container">
        <form id="loginForm" class="form-signin" method="post" action="/login">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <h2 class="form-signin-heading">Login</h2>
            <p>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" class="form-control" placeholder="email" required>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </p>
            <div class="d-flex flex-row">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <a class="btn btn-lg btn-success btn-block" href="/login/new">Sign up</a>
            </div>
        </form>
    </div>

</@base.body>