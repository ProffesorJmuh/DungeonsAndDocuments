<#import "../base.ftl" as base>

<@base.body "${title}">
    <form id="addForm" method="POST" action="/task">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-control">
            <label for="name" class="col-2">Название: </label>
            <input type="name" class="col-2" name="name" id="name"/>
        </div>
        <div class="form-control">
            <label for="description" class="col-2">Условие выполнения: </label>
            <input type="description" class="col-2" name="description" id="description"/>
        </div>
        <br>


        <div class="offer form-control">
                    <div>
                        <label for="assigned_name" class="col-2">Назначена: </label>
                        <input type="text" class="col-2" name="assigned_name" id="assigned_name"/>
                    </div>
                    <input type="hidden" name="assigned" id="assigned">
                </div>
        <div class="d-flex flex-row">
            <input class="btn btn-success" type="submit" value="Создать"/>

        </div>
        <script>
        $("#assigned_name").autocomplete({
                    source: "/getUsersByTerm",
                    maxHeight: 400,
                    maxWidth: $(this).width,
                    minLength: 0,
                    select: function (event, ui) {
                        $("#assigned_name").val(ui.item.label)
                        $("#assigned").val(ui.item.value);
                        return false;
                    }
                })
        </script>

    </form>
</@base.body>