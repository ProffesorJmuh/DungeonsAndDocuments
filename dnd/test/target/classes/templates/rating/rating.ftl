<#import "../base.ftl" as base>

<@base.body "${title}">
    <form method="GET" class="container mt-5" id="sortingForm" action="/rating">
        <input type="text" id="category" name="category" <#if category??>value="${category}"</#if> placeholder="Категория" />
        <input type="text" id="team" placeholder="Категория" <#if team_name??>value="${team_name}"</#if>/>
        <input type="hidden" id="team_id" name="team_id" <#if team_id??>value="${team_id}"</#if>/>
        <button type="submit" class="btn btn-lg btn-info btn-block">Сортировать</button>
    </form>
    <div class="container mt-5">
    <#list userList as userRating>
        ${userRating.user.email} - ${userRating.result}<#sep><br></#sep>
    </#list>
    </div>
    <br/>
    <hr/>
    <script>
        $("#team").autocomplete({
            source: "/getTeamsByTerm",
            maxHeight: 400,
            maxWidth: $(this).width,
            minLength: 0,
            select: function (event, ui) {
                $("#team").val(ui.item.label)
                $("#team_id").val(ui.item.value);
                return false;
            }
        })
        $("#category").autocomplete({
            source: "/getCategoriesByTerm",
            maxHeight: 400,
            maxWidth: $(this).width,
            minLength: 0,
            select: function (event, ui) {
                $("#category").val(ui.item.label)
                
                return false;
            }
        })

    </script>
</@base.body>