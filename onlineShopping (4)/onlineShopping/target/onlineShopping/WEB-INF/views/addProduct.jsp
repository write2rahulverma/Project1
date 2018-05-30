<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<label class="control-label" for="prodCategory">Category<sup>*</sup></label>
			<div class="controls">
			  <form:input path="prodCategory" type="text" id="prodCategory" placeholder="Enter Category of Your Product"/>
			  <form:errors path="prodCategory" cssClass="help-block" element="em"/>
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
		<%-- <div class="control-group">
			<label class="control-label" for="catId">Select Category:</label>
			<div class="controls">
			  <form:select path="catId" id="catId" 
			  	items="${categories}"
			  	itemLabel="categoryName"
			  	itemValue="catId"
			  />
			</div>
		 </div> --%>

		<input type="submit" value="submit"/>
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
</div>
</div>
<%@include file = "/WEB-INF/views/templates/footer1.jsp"%>