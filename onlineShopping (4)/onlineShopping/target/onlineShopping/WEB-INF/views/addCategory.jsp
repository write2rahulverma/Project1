<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="well">
	<form:form action="${pageContext.request.contextPath}/addCategory" method="post" commandName="Category">
		<h4>Category Information</h4>
		<div class="control-group">
			<label class="control-label" for="categoryName">Category Name<sup>*</sup></label>
			<div class="controls">
			  <form:input path="categoryName" type="text" id="categoryName" placeholder="Enter Your Category Name"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="categoryDesc">Category Description<sup>*</sup></label>
			<div class="controls">
			  <form:input path="categoryDesc" type="text" id="categoryDesc" placeholder="Enter Description of the Category"/>
			</div>
		 </div>
		<input type="submit" value="submit"/>
	</form:form>
	</div>