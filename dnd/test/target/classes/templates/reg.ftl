<#import "base.ftl" as base>

<@base.body "${title}">
    <form method="POST" action="/login/new">
    
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-control">
            <label for="email" class="col-2">Введите email: </label>
            <input type="email" class="col-2" name="email" id="email"/>
        </div>
        <div class="form-control">
            <label for="password" class="col-2">Введите пароль: </label>
            <input type="password" class="col-2" name="password" id="password"/>
        </div>
        <br>
        <div class="form-control">
            <div>
                <label for="firstName" class="col-2">Введите имя: </label>
                <input type="text" class="col-2" name="firstName" id="firstName"/>
            </div>
            <div class="mt-3">
                <label for="lastName" class="col-2">Введите фамилию: </label>
                <input type="text" class="col-2" name="lastName" id="lastName"/>
            </div>
        </div>
        <br>
        <div class="form-control">
            <label for="phone" class="col-2">Введите телефон: </label>
            <input type="text" class="col-2" name="phone" id="phone"/>
        </div>
        <div class="form-control">
            <label for="icon" class="col-2">Выберете своего персонажа: </label>
            <input type="text" class="col-2" name="icon" id="icon"/>
        </div>
        <br>

        <div class="d-flex flex-row">
            <input class="btn btn-success" type="submit" value="Создать!"/>

        </div>

    </form>

</@base.body>