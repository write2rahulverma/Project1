<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="span3">
<h4>Shop By Categories</h4>
	<ul id="sideManu" class="nav nav-tabs nav-stacked">
		<c:forEach items="${categories}" var="category">
		<li><a href="${contextRoot}/show/category/${category.catId}/products"><i class="icon-chevron-right"></i>${category.categoryName}</a></li>
		
		</c:forEach>
	</ul><br/>
		
		  <%-- <div class="thumbnail">
			<img src="<c:url value="/resources/themes/images/products/panasonic.jpg"/>" alt="Bootshop panasonoc New camera"/>
			<div class="caption">
			  <h5>Panasonic</h5>
				<h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&#8377;&#160;222.00</a></h4>
			</div>
		  </div><br/>
			<div class="thumbnail">
				<img src="<c:url value="/resources/themes/images/products/kindle.png"/>" title="Bootshop New Kindel" alt="Bootshop Kindel">
				<div class="caption">
				  <h5>Kindle</h5>
				    <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&#8377;&#160;222.00</a></h4>
				</div>
			  </div><br/> --%>
			<div class="thumbnail">
				<img src="<c:url value="/resources/themes/images/payment_methods.png"/>" title="Bootshop Payment Methods" alt="Payments Methods">
				<div class="caption">
				  <h5>Payment Methods</h5>
				</div>
			  </div>
	</div>