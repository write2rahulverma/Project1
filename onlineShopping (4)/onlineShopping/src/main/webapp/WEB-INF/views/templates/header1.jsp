<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Bootshop - ${title}</title>
    
    <script>
    	window.menu = '${title}';
    	window.contextRoot = '${contextRoot}';
    </script>
    
<!-- Bootstrap style --> 
    <link id="callCss" rel="stylesheet" href="<c:url value="/resources/themes/bootshop/bootstrap.min.css"/>" media="screen"/>
    <link href="<c:url value="/resources/themes/css/base.css"/>" rel="stylesheet" media="screen"/>

<!-- Bootstrap style responsive -->	
	<link href="<c:url value="/resources/themes/css/bootstrap-responsive.min.css"/>" rel="stylesheet"/>
	<link href="<c:url value="/resources/themes/css/font-awesome.css"/>" rel="stylesheet" type="text/css">

<!-- Google-code-prettify -->	
	<link href="<c:url value="/resources/themes/js/google-code-prettify/prettify.css"/>" rel="stylesheet"/>

<!-- Self coded css -->
	<link href="<c:url value="/resources/css/myApp.css"/>" rel="stylesheet"/>

<!-- fav and touch icons -->
    <link rel="shortcut icon" href="<c:url value="/resources/themes/images/ico/favicon.ico"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-144-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-114-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-72-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-57-precomposed.png"/>">
	<style type="text/css" id="enject"></style>
	
  </head>
<body>


<!-- Navbar -->

<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="${contextRoot}/"><img src="<c:url value="/resources/themes/images/logo.png"/>" alt="Bootsshop"/></a>
		<form class="form-inline navbar-search" method="post" action="products.jsp" >
		<input id="srchFld" class="srchTxt" type="text" />
		 
		  <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
    </form>
    <ul id="topMenu" class="nav pull-left">
	 <li id="home"><a href="${contextRoot}/">HOME</a></li>
	 <li id="listProduct"><a href="${contextRoot}/show/all/products">View Products</a></li>
	 <security:authorize access="hasAuthority('ADMIN')">
	 	<li id="manageProduct"><a href="${contextRoot}/manage/products">Manage Products</a></li>
	 </security:authorize>
	 <li id="about"><a href="${contextRoot}/about">About</a></li>
	 <li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
	 </ul>
	 
	 <ul id="topMenu" class="nav pull-right">	 
	 <security:authorize access="isAnonymous()">
		 <li id="register"><a href="${contextRoot}/register">Register</a></li>
		 <li id="login"><a href="${contextRoot}/login">Login</a></li>
	 </security:authorize>
	 <security:authorize access="isAuthenticated()">
	 	<security:authorize access="hasAuthority('USER')">
	 	<li><a><span class="btn btn-large btn-success">WELCOME: ${userModel.name}</span></a></li>
	 		<li>
	 			<a href="${contextRoot}/cart/show">
	 			
	 				<i class="icon-shopping-cart"></i>&#160;
	 				<span class="badge">${userModel.cart.cartLines}</span>
	 			</a>
	 		</li>
	 	</security:authorize>
	 	<li id="logout"><a href="${contextRoot}/logout"><span class="btn btn-large btn-info">Logout</span></a></li>
	 </security:authorize>
	</ul>
  </div>
</div>