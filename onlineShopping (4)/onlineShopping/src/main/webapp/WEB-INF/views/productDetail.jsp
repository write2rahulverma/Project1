<%@include file="/WEB-INF/views/templates/header1.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

<div class="span12">
	<div class="container">
	<div class="row">
		
		<div class="span4">
			<div class="thumbnail">
			
				<img src="<c:url value="/resources/images/${product.code}.jpg"/>" class="img img-responsive"/>
			
			</div>		
		</div>
		
		<div class="span8">
		
			<h3>${product.prodName}</h3>
			<hr/>
			
			<p>${product.prodDesc}</p>
			<hr/>
			
			<h4>Price: <strong> &#8377; ${product.prodPrice} /-</strong></h4>
			<hr/>
			
			<h6>Quantity Available: ${product.prodStock}</h6>
			
			<a href="${contextRoot}/cart/add/${product.prodId}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
			<a href="${contextRoot}/" class="btn btn-primary">Back</a>
		
		</div>	
	</div>
	</div>
</div>
</div>
</div>
</div>
<%@include file="/WEB-INF/views/templates/footer1.jsp"%>