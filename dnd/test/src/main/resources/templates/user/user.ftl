<#import "../base.ftl" as base>

<@base.body "${title}">
<main class="container">
				<div class="chara card_type">
					<div class="card_header">Персонаж</div>
					<div>
						<div style="margin: 0 auto; font-size: 18px; font-weight: 500;" class="userdata">lvl. ${user.level.levelNumber}</div>
						<progress class="progressbg" bg-color="#00FFFF" max="${addMax}" value="${currEx}"></progress>
					</div>
					<div class="image_container profile_background">
						<div class="charter_name">Ученик Волшебника</div>
						<img class="" src="${user.avatar}"  alt="" width="100%">
					</div>
				</div>
				<div class="teams card_type">
					<div class="team_header">
						<a class="ratingLink" href="index.html" target="_self">Одиночный</a>
						<a class="ratingLink" href="projects.html" target="_self">Командный</a>
					</div>
					<div>
                        <table style="font-size: 21px;font-weight: 800;">
                        <tr><td>1</td><td>Андропов Алексей</td><td>464</td></tr>
                        <tr><td>2</td><td>Митрованов Дмитрий</td><td>404</td></tr>
                        <tr><td>3</td><td>Андрейченко Михаил</td><td>382</td></tr>
                        <tr><td>4</td><td>Илюшин Павел</td><td>380</td></tr>
                        <tr><td>5</td><td>Галонов Юрий</td><td>345</td></tr>
                        <tr><td>6</td><td>Еромолаев Кирилл</td><td>343</td></tr>
                        <tr><td>7</td><td>Александр Киреев</td><td>333</td></tr>
                        <tr><td>8</td><td>Курицин Илья</td><td>320</td></tr>
                        <tr><td>9</td><td>Петров Виталий</td><td>302</td></tr>
                        <tr><td>10</td><td>Ямов Сергей</td><td>297</td></tr>

                        </table>
					</div>
				</div>
			  <div class="form-card card_type" id="" >
				  <div class="card_header">Визитная карточка</div>
				  <div class="userdatacontainer">
					<div class="userdata">${user.firstName} ${user.lastName}</div>
					<div class="userdata">${user.email}</div>
					<div class="userdata">${user.team.name}</div>
					<div class="userdata">${user.phone}</div>
				  	<!--form class="userdata" action="" method="POST">
					  <input type="submit" value="Изменить" class="button-submit">
				  </form-->
				  </div>
				</div>
			</main>
		<footer></footer>

</@base.body>