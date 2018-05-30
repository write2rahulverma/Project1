<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file = "/WEB-INF/views/templates/header1.jsp"%>
<div class="span12">
    <ul class="breadcrumb">
		<li><a href="${contextRoot}/">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3>Login</h3>
	<div class="well">
	<c:if test="${not empty message}">
	<div class="alert alert-dange">${message}</div>
	</c:if>	
	<form name="loginForm" action="${contextRoot}/login" method="post" id="loginForm">
			  <div class="form-group">
				<label for="username">Username:</label>
				  <input type="text" name="username" id="username" class="form-control" placeholder="Username">
			  </div>
			  <div class="form-group">
				<label for="password">Password:</label>
				  <input type="password" name="password" id="password" class="form-control" name="password" placeholder="Password">
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="btn">Sign in</button> <a href="forgetpass.jsp">Forget password?</a>
				  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>				  
				</div>
			  </div>
			</form>
			</div>
			</div>
<%@include file = "/WEB-INF/views/templates/footer1.jsp"%>