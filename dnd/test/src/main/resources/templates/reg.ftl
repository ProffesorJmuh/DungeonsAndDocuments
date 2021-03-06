<#import "base.ftl" as base>

<@base.body "${title}">
    <div class="container-fluid">
        <form method="POST" class="mt-5" action="/login/new">

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
                <div class="mt-3">
                    <label for="phone" class="col-2">Введите телефон: </label>
                    <input type="text" class="col-2" name="phone" id="phone"/>
                </div>
            </div>
            <br>
            <div class="form-control">
                <label for="icon" class="col-2">Выберете вашу команду: </label>
                <input type="text" class="col-2" name="teamName" id="teamName"/>
                <input type="hidden" name="team_id" id="team_id"/>
            </div>
            <br>

            <br>

            <div class="d-flex flex-row">
                <input class="btn btn-success ms-2" type="submit" value="Создать"/>

            </div>
            <script>
                $("#teamName").autocomplete({
                                    source: "/getTeamsByTerm",
                                    maxHeight: 400,
                                    maxWidth: $(this).width,
                                    minLength: 0,
                                    select: function (event, ui) {
                                        $("#teamName").val(ui.item.label)
                                        $("#team_id").val(ui.item.value);
                                        return false;
                                    }
                                })
            </script>

        </form>
    </div>

</@base.body>