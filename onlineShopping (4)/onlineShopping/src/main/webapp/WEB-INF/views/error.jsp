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
	
	<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet">

<!-- Google-code-prettify -->	
	<link href="<c:url value="/resources/themes/js/google-code-prettify/prettify.css"/>" rel="stylesheet"/>

<!-- fav and touch icons -->
    <link rel="shortcut icon" href="<c:url value="/resources/themes/images/ico/favicon.ico"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-144-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-114-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-72-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" href="<c:url value="/resources/themes/images/ico/apple-touch-icon-57-precomposed.png"/>">
	<style type="text/css" id="enject"></style>
	
<!-- Self coded css -->
	<%-- <link href="<c:url value="/resources/css/myApp.css"/>" rel="stylesheet" > --%>

  </head>
<body>

	<div class="wrapper">

	    <div id="logoArea" class="navbar">
		  <div class="navbar-inner">
		    <ul id="topMenu" class="nav pull-left">
			 <li id="home"><a href="${contextRoot}/">HOME</a></li>
			</ul>
		  </div>
		</div>
			
		
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
								${errorDescription}
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
							
		</div>

		
		

	</div>
		
	
</body>


</html>