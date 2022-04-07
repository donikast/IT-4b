<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="models.Skill" %>

<!DOCTYPE html>
<html>
<jsp:include page="shared/head.jsp"/>

<body>
<% User user = (User)request.getAttribute("loggedUser"); %>

<jsp:include page="shared/header.jsp"/>

	<div class="content">
	
	<form action="user" method="post">
		<div>
			<div class="profile-image-container">
				<img src="images/male.svg" />
			</div>
			<div class="profile-info-container">
				<h2>Профилна информация</h2>
				<p>Име:</p>
				<input type="text" name="personal-name" value="<%= user.getPersonalName() %>" />
				<p>Професия: </p>
				<input type="text" name="job-title" value="<%= user.getJobTitle() %>" />
				<p>Описание: </p>
				<input type="text" name="description" value="<%= user.getDescription() %>" />
			</div>
		</div>
		<h2>Умения</h2>

		<div class="skills-container">
			<div class="skills-container-element">
			
			<% int i=0;
			for(Skill skill:user.getProfessionalSkills()) { %>
				<div>
				<input type="text" name="prof-skill-name<%=i%>" value="<%= skill.getSkillName() %>" />
				<input type="range" name="prof-skill-value<%=i%>" value="<%= skill.getSkillLevel() %>" 
				min="0" max="100" step="10" /> 
				</div>
			<% i++;
			} %>
			</div>

			<div class="skills-container-element">
			<% for(Skill skill:user.getPersonalSkills()) { %>
				<div>
					<label><%= skill.getSkillName() %></label>
					<div class="outer-progress">
						<div class="inner-progress" style="width: <%= skill.getSkillLevel() %>%"></div>
					</div>
				</div>
			<% } %>
			</div>


		</div>
		<h2>Контакти</h2>

		<div class="skills-container">
			<div class="skills-container-element">
				<div>
					<label>E-mail</label>
					<input type="text" name="email" value="<%= user.getEmail() %>" />				 
				</div>

				<div>
					<label>Град</label>
					<input type="text" name="city" value="<%= user.getAddress().getCity() %>" />				 
				</div>

			</div>

			<div class="skills-container-element">
				<div>
					<label>Телефон</label>
					<input type="text" name="phone" value="<%= user.getPhone() %>" />				  
				</div>

				<div>
					<label>Улица</label>
					<input type="text" name="street" value="<%= user.getAddress().getStreet() %>" /> 			 
				</div>			
			</div>
		</div>
		</form>
	</div>
<jsp:include page="shared/footer.jsp"/>

</body>
</html>