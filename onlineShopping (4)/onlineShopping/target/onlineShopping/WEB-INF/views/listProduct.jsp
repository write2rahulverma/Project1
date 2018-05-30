<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/templates/header1.jsp"%>
<div id="mainBody">
	<div class="container">
		<div class="row">
		<table class="table table-hover table-condensed">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Name</th>
                  <th>Description</th>
                  <th>Quantity</th>
				  <th>Price</th>
                  <th>Status</th>                  
                  <th>Purchases</th>
                  <th>Views</th>
                  <th></th>
				</tr>
              </thead>
              <tbody>
              <c:forEach items="${product}" var="product">
                <tr>
                  <td> <img width="60" src="<c:url value="/resources/images/${product.code}.jpg"/>" alt=""/></td>
                  <td>${product.prodName}</td>
				  <td>${product.prodDesc}</td>
                  <td>${product.prodStock}</td>
                  <td>&#8377;&#160;${product.prodPrice} /-</td>
                  <td>${product.active}</td>
                  <td>${product.purchases}</td>
                  <td>${product.views}</td>
                  <td>
	                  <a href="${contextRoot}/show/${product.prodId}/product" class="btn btn-primary">View</a>&#160;
	                  <a href="${contextRoot}/cart/add/${product.prodId}/product" class="btn btn-success">Add to Cart</a>
                  </td>
                </tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/footer1.jsp"%>