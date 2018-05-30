<%@include file="/WEB-INF/views/templates/header1.jsp"%>
<%@include file="/WEB-INF/views/templates/carousel.jsp"%>
<div id="mainBody">
	<div class="container">
		<div class="row">
			<%@include file="/WEB-INF/views/templates/sidebar.jsp"%>
			<%@include file="/WEB-INF/views/templates/innerCarousel.jsp"%>

			<!-- <div class="span12"> -->
				<h4>Latest Products</h4>
				
					<ul class="thumbnails">
					<c:set var="i" value="0"/>
					<c:forEach items="${product}" var="product">
						<li class="span3">
						
							<div class="thumbnail">
								<a href="${contextRoot}/show/${product.prodId}/product"><img
									src="<c:url value="/resources/images/${product.code}.jpg"/>" height="200px" width="100px" alt="" /></a>
								<div class="caption">
									<h5>${product.prodName}</h5>
									<h4 style="text-align: center">

										<a class="btn" href="${contextRoot}/show/${product.prodId}/product"> <i
											class="icon-zoom-in"></i></a>
										<a class="btn" href="${contextRoot}/cart/add/${product.prodId}/product">
											Add to <i class="icon-shopping-cart"></i></a>
										<a class="btn btn-primary"> &#8377;
											${product.prodPrice}</a>
									</h4>
								</div>
							<!-- </div> -->
						
						</li>
						<%-- <c:if test="${i%3==0}">
						</ul>
						<ul class="thumbnails">
						</c:if>
						<c:set var="i" value="${i+1}"/> --%>
						</c:forEach>
					</ul>
				
			</div>
		</div>
	</div>
</div>