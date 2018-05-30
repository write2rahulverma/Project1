<%@include file="/WEB-INF/views/templates/header1.jsp"%>
<%@include file="/WEB-INF/views/templates/carousel.jsp"%>
<div id="mainBody">
	<div class="container">
		<div class="row">
			<%@include file="/WEB-INF/views/templates/sidebar.jsp"%>
			<%@include file="/WEB-INF/views/templates/innerCarousel.jsp"%>

			<div class="span9">
				<h2>Hello World!</h2>
				<a href="${contextRoot}/register">register</a>
				<a href="${contextRoot}/addProduct">Add Product</a>
				<a href="${contextRoot}/addCategory">Add Category</a>


				<h4>Latest Products</h4>
				<c:forEach items="${product}" var="product">
					<ul class="thumbnails">
						<li class="span3">
							<div class="thumbnail">
								<a href="${contextRoot}/show/${product.prodId}/product"><img
									src="<c:url value="/resources/images/${product.code}.jpg"/>" alt="" /></a>
								<div class="caption">
									<h5>${product.prodName}</h5>
									<h4 style="text-align: center">

										<a class="btn" href="${contextRoot}/show/${product.prodId}/product"> <i
											class="icon-zoom-in"></i></a>
										<a class="btn" href="${contextRoot}/cart/add/${product.prodId}/product">
											Add to <i class="icon-shopping-cart"></i></a>
										<a class="btn btn-primary" href="#"> &#8377;
											${product.prodPrice}</a>
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