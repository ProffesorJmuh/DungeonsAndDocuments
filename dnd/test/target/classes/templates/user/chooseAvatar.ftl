<#import "../base.ftl" as base>

<@base.body "${title}">
    <form method="post" action="/user/chooseAvatar">
        <!--    <form id="editForm" method="post">-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-control mt-5">
            <label for="avatar" class="col-2">Выберете аватар: </label>
            <div>

                <div class="d-flex align-items-center p-2 bd-highlight">
                    <input type="radio" name="avatar" id="avatar" value="/img/archer.png">
                    <div>Лучник</div>
                    <img style="width: 150px; height: 150px" src="/img/archer.png">
                </div>

                <div class="d-flex align-items-center p-2 bd-highlight">
                    <input type="radio" name="avatar" id="avatar" value="/img/knight.png">
                    <div>Рыцарь</div>
                    <img style="width: 150px; height: 150px" src="/img/knight.png">
                </div>

                <div class="d-flex align-items-center p-2 bd-highlight">
                    <input type="radio" name="avatar" id="avatar" value="/img/mage.png">
                    <div>Маг</div>
                    <img style="width: 150px; height: 150px" style src="/img/mage.png">
                </div>
                <div class="d-flex align-items-center p-2 bd-highlight">
                    <input type="radio" name="avatar" id="avatar" value="/img/viking3.png">
                    <div>Варвар</div>
                    <img style="width: 150px; height: 150px" src="/img/viking3.png">
                </div>
                <div class="d-flex  align-items-center p-2 bd-highlight">
                    <input type="radio" name="avatar" id="avatar" value="/img/samurai.png">
                    <div>Самурай</div>
                    <img style="width: 150px; height: 150px" src="/img/samurai.png">
                </div>
            </div>

        </div>


        <div class="flex-box flex-row">
            <input class="btn btn-primary" type="submit" value="Выбрать"/>

        </div>

    </form>

</@base.body>