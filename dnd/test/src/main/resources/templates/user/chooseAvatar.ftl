<#import "../base.ftl" as base>

<@base.body "${title}">
    <form id="editForm" method="post" action="">
        <!--    <form id="editForm" method="post">-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-control">
            <label for="address" class="col-2">Выберете аватар: </label>
            <select name="avatar" class="col-2" id="avatar">
                <option data-img-src="cheliki/archer.png" alt="..."/><p>Лучник</p></option>
                <option data-img-src="cheliki/knight.png" alt="..."/><p>Рыцарь</p></option>
                <option data-img-src="cheliki/mage.png" alt="..."/><p>Маг</p></option>
                <option data-img-src="cheliki/viking2.png" alt="..."/><p>Варвар</p></option>
                <!--<option><div><img src="cheliki/archer.png" alt="..."/><p>Лучник</p></div></option>-->
            </select>
        </div>


        <div class="flex-box flex-row">
            <input class="btn btn-primary" type="submit" value="Update!"/>

        </div>

    </form>

</@base.body>