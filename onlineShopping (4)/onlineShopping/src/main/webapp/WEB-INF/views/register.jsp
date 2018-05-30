<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file = "/WEB-INF/views/templates/header1.jsp"%>
<div class="span12">
    <ul class="breadcrumb">
		<li><a href="${contextRoot}/">Home</a> <span class="divider">/</span></li>
		<li class="active">Registration</li>
    </ul>
	<h3> Registration</h3>
	<div class="well">
	<form:form action="${contextRoot}/register" method="post" commandName="user">
		<h4>Your personal information</h4>
		<div class="form-group">
		<label class="control-label">Title <sup>*</sup></label>
		<div class="controls">
		<select class="span1" name="days">
			<option value="">-</option>
			<option value="1">Mr.</option>
			<option value="2">Mrs</option>
			<option value="3">Miss</option>
		</select>
		</div>
		</div>
		<div class="form-group">
			<label class="control-label" for="name">Name<sup>*</sup></label>
			<div class="controls">
			  <form:input path="Name" type="text" id="name" placeholder="Enter Your Name"/>
			  <form:errors path="Name" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="username">Username<sup>*</sup></label>
			<div class="controls">
			  <form:input path="username" type="text" id="username" placeholder="Enter Your Username"/>
			<form:errors path="username" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="password">Password<sup>*</sup></label>
			<div class="controls">
			  <form:input path="password" type="password" id="password" placeholder="Enter Password"/>
			  <form:errors path="password" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="email">E-mail<sup>*</sup></label>
			<div class="controls">
			  <form:input path="Email" id="email" placeholder="Enter Your E-mail Id"/>
			  <form:errors path="Email" cssClass="help-block" element="em"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="country">Country</label>
			<div class="controls">
			  <form:input path="country" type="text" id="country" placeholder="Enter Country"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="phone">Phone</label>
			<div class="controls">
			  <form:input path="phone" type="number" id="phone" placeholder="Enter Your Phone Number"/>
			</div>
		 </div>
		 
		 <h4>Your address</h4>
		  <div class="form-group">
			<label class="control-label" for="apartmentNumber">Appartment number</label>
			<div class="controls">
			  <form:input path="userAddress.apartmentNumber" type="text" id="apartmentNumber" placeholder="Apartment Number"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="streetName">Street Name</label>
			<div class="controls">
			  <form:input path="userAddress.streetName" type="text" id="streetName" placeholder="Street Name"/>
			</div>
		 </div>
		
		 <div class="form-group">
			<label class="control-label" for="city">City</label>
			<div class="controls">
			  <form:input path="userAddress.city" type="text" id="city" placeholder="City"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="state">State</label>
			<div class="controls">
			  <form:input path="userAddress.state" type="text" id="state" placeholder="State"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="country">Country</label>
			<div class="controls">
			  <form:input path="userAddress.country" type="text" id="country" placeholder="Country"/>
			</div>
		 </div>
		 <div class="form-group">
			<label class="control-label" for="zipCode">Pin Code</label>
			<div class="controls">
			  <form:input path="userAddress.zipCode" type="number" id="zipCode" placeholder="Area Pin Code"/>
			</div>
		 </div>
		
		<input type="submit" value="submit"/>
	</form:form>
	</div>
	</div>
<%@include file = "/WEB-INF/views/templates/footer1.jsp"%>