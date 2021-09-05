<#import "../base.ftl" as base>

<@base.body "${title}">
<main class="container">
				<div class="chara card_type">
					<div class="card_header">Персонаж</div>
					<div>
						<div style="margin: 0 auto; font-size: 18px; font-weight: 500;" class="userdata">lvl. </div>
						<progress class="progressbg" bg-color="#00FFFF" max="100" value="25"></progress>
					</div>
					<div class="image_container profile_background">
						<div class="charter_name">Ученик Волшебника</div>
						<img class="" src="sprites/IceWizard/Stand/7.png"  alt="" width="100%">
					</div>
				</div>
				<div class="teams card_type">
					<div class="team_header">
						<a class="ratingLink" href="index.html" target="_self">Одиночный</a>
						<a clas="ratingLink" href="projects.html" target="_self">Командный</a>
					</div>
					<div>

					</div>
				</div>
			  <div class="form-card card_type" id="" >
				  <div class="card_header">Визитная карточка</div>
				  <div class="userdatacontainer">
					<div class="userdata">ФИО</div>
					<div class="userdata">ДОЛЖНОСТЬ</div>
					<div class="userdata">КОМАНДА</div>
					<div class="userdata">КОНТАКТЫ</div>
				  	<form action="" method="POST">
					  <!-- <input class="inp" type="text" name="name" placeholder="ФИО" id="name">
					  <input class="inp" type="text" name="text" placeholder="ДОЛЖНОСТЬ" id="#">
					  <input class="inp" name="text" id="#" placeholder="КОМАНДА">
					  <input class="inp" name="text" id="#" placeholder="КОНТАКТЫ"> -->
					  <input type="submit" value="Изменить" class="button-submit">
				  </form>
				  </div>
				</div>
			</main>
		<footer></footer>

</@base.body>