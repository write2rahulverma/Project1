<%@include file="/WEB-INF/views/templates/userHeader.jsp"%>
<%@include file="/WEB-INF/views/templates/carousel.jsp"%>
<div id="mainBody">
	<div class="container">
		<div class="row">
			<%@include file="/WEB-INF/views/templates/sidebar.jsp"%>
			<div class="span9">
			<h4>Latest Products</h4>
				<c:forEach items="${product}" var="product">
					<ul class="thumbnails">
						<li class="span3">
							<div class="thumbnail">
								<a href="${contextRoot}/show/${product.prodId}/product"><img src="${images}/${product.code}.jpg" alt="" /></a>
								<div class="caption">
									<h5>${product.prodName}</h5>
									<p>${product.prodDesc}</p>
									<h4 style="text-align: center">
									
										<a class="btn" href="${contextRoot}/show/${product.prodId}/product">
										<i class="icon-zoom-in"></i>View</a>
										
										<a href="${contextRoot}/cart/add/${product.prodId}/product" class="btn btn-success">
											<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>>
										
										<a class="btn btn-primary" href="#"> &#8377; ${product.prodPrice}</a>
									</h4>
								</div>
							</div>
						</li>
					</ul>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/footer1.jsp"%>
