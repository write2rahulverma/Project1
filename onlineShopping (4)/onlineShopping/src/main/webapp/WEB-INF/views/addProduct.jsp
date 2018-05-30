<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file = "/WEB-INF/views/templates/header1.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

<div class="well">
<c:if test="${not empty message}">
	<div class="span12">
		<div class="alert alert-success alert-dismissible">${message}
			<button type="button" class="close" data-dismiss="alert">&times;</button>
		</div>
	</div>
</c:if>


<div class="span12">
    <ul class="breadcrumb">
		<li><a href="${contextRoot}/">Home</a> <span class="divider">/</span></li>
		<li class="active">Add New Product</li>
    </ul>
	<h3>Add New Product</h3>
	<div class="well">
	<form:form action="${contextRoot}/manage/addProduct" method="post" enctype="multipart/form-data" modelAttribute="product">
		<h4>Product Information</h4>
		<div class="control-group">
			<label class="control-label" for="prodName">Product Name<sup>*</sup></label>
			<div class="controls">
			  <form:input path="prodName" type="text" id="prodName" placeholder="Enter Your Product Name"/>
			  <form:errors path="prodName" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="prodDesc">Product Description<sup>*</sup></label>
			<div class="controls">
			  <form:input path="prodDesc" type="text" id="prodDesc" placeholder="Enter Description of the Product"/>
			  <form:errors path="prodDesc" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="prodPrice">Price</label>
			<div class="controls">
			  <form:input path="prodPrice" type="number" id="prodPrice" placeholder="Enter the price of the Product "/>
			  <form:errors path="prodPrice" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="prodStock">Stock</label>
			<div class="controls">
			  <form:input path="prodStock" type="number" id="prodStock" placeholder="Enter Stock of the Product"/>
			  <form:errors path="prodStock" cssClass="help-block" element="em"/>
			</div>
		 </div>
		  <div class="control-group">
			<label class="control-label" for="prodImage">Select an Image:</label>
			<div class="controls">
			  <form:input path="prodImage" type="file" id="prodImage"/>
			  <form:errors path="prodImage" cssClass="help-block" element="em"/>
			</div>
		 </div>
		<div class="control-group">
			<label class="control-label" for="category.catId">Select Category:</label>
			<div class="controls">
			  <form:select path="category.catId" id="category.catId" 
			  	items="${categories}"
			  	itemLabel="categoryName"
			  	itemValue="catId"
			  />
			  <c:if test="${product.prodId == 0}">
			  	<div class="text-right">
				  	<br/>
				  	<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add new Category</button>
			  	</div>
			  </c:if>
			</div>
		 </div>

		<input type="submit" value="submit"/>
		<a href="${contextRoot}/manage/products" class="btn btn-primary">Cancel</a>
		<form:hidden path="prodId"/>
		<form:hidden path="code"/>
		<form:hidden path="active"/>
		<form:hidden path="purchases"/>
		<form:hidden path="views"/>
	</form:form>
	</div>
	</div>
</div>
</div>

<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				<h4 class="modal-title">Add New Category</h4>
			</div>
			<div class="modal-body">
				<!-- Category Form -->
				<form:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
					
					<div class="form-group">
						<label for="categoryName" class="control-label col-md-4">Category Name</label>
						<div class="col-md-8">
							<form:input type="text" path="categoryName" id="categoryName" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="categoryDesc" class="control-label col-md-4">Category Description</label>
						<div class="col-md-8">
							<form:textarea cols="" rows="5"  path="categoryDesc" id="categoryDesc" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" value="Add Category" class="btn btn-primary"/>
						</div>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<%@include file = "/WEB-INF/views/templates/footer1.jsp"%>