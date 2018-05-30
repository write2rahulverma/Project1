<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="/WEB-INF/views/templates/header1.jsp"%>
<div id="mainBody">
	<div class="container">
		<div class="row">
		
		<div class="jumbotron">
			<h3>Want to add a new product register here.&#160;
			<a id="addProduct" href="${contextRoot}/manage/addProduct" class="btn btn-success">Open Form</a></h3>
		</div>
		</br></br>
		
		<h3>Available Products</h3>
		<hr/>
		
		<div style="overflow:auto">
		<table class="table table-bordered">
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
                  <th>Operations</th>
				</tr>
              </thead>
              <tbody>
              <c:forEach items="${product}" var="product">
                <tr>
                  <td> <img width="60" src="<c:url value="/resources/images/${product.code}.jpg"/>" alt=""/></td>
                  <td>${product.prodName}</td>
				  <td>${product.prodDesc}</td>
                  <td>${product.prodStock}</td>
                  <td>&#8377;&#160;${product.prodPrice}</td>
                  <td>
                  	<!-- toggle switch -->
                  	<label class="switch">
                  		<c:if test="${product.active==true}">
                  		<input type="checkbox" checked="checked" value="${product.prodId}"/>
                  		</c:if>
                  		<c:if test="${product.active==false}">
                  		<input type="checkbox" value="${product.prodId}"/>
                  		</c:if>
                  		<div class="slider"></div>
                  	</label>               
                  </td>
                  <td>${product.purchases}</td>
                  <td>${product.views}</td>
                  <td>
	                  <a href="${contextRoot}/show/${product.prodId}/product" class="btn btn-primary">View</a>&#160;
	                  <a href="${contextRoot}/manage/${product.prodId}/product" class="btn btn-primary">Edit</a>
                  </td>
                </tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/footer1.jsp"%>