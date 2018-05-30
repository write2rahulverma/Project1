<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    </script>
    
<!-- Bootstrap style --> 
    <link id="callCss" rel="stylesheet" href="<c:url value="/resources/themes/bootshop/bootstrap.min.css"/>" media="screen"/>
    <link href="<c:url value="/resources/themes/css/base.css"/>" rel="stylesheet" media="screen"/>

<!-- Bootstrap style responsive -->	
	<link href="<c:url value="/resources/themes/css/bootstrap-responsive.min.css"/>" rel="stylesheet"/>
	<link href="<c:url value="/resources/themes/css/font-awesome.css"/>" rel="stylesheet" type="text/css">
	
<!-- Google-code-prettify -->	
	<link href="<c:url value="/resources/themes/js/google-code-prettify/prettify.css"/>" rel="stylesheet"/>

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
		  <select class="srchTxt">
			<option>All</option>
			<option>CAMERAS</option>
			<option>SMARTPHONES</option>
			<option>HOME APPLIANCES</option>
			<option>LAPTOPS AND COMPUTERS</option>
		</select> 
		  <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
    </form>
    <ul id="topMenu" class="nav pull-right">
	 <li id="home"><a href="${contextRoot}/">HOME</a></li>
	 <li id="manageProduct"><a href="${contextRoot}/manage">Manage Products</a></li>
	<li><a href="${contextRoot}/logout"><span class="btn btn-large btn-warning">Logout</span></a></li>
	</ul>
  </div>
</div>