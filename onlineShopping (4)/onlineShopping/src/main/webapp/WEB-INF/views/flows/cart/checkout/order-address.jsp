<%@include file="../../flows-shared/header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>			
<div class="container">

	<div class="row">
		
			<div class="col-md-4">
				
				<h4>Select Shipping Address</h4>
				<hr/>
				
				<div class="row">
					<c:forEach items="${UserAddresses}" var="userAddress">					
						<div class="cols-xs-12">
							<h3>${userAddress.apartmentNumber}</h3>
							<h3>${userAddress.streetName}</h3>
							<h4>${userAddress.city} - ${userAddress.zipCode}</h4>
							<h4>${userAddress.state} - ${userAddress.country}</h4>
							<hr/>
							<div class="text-center">
								<a href="${flowExecutionUrl}&_eventId_addressSelection&shippingId=${userAddress.userAddressId}" class="btn btn-primary">Select</a>
							</div>												
						</div>
					</c:forEach>			
				</div>
	
	
			</div>		
			
			<div class="col-md-8">
			
				
				<div class="panel panel-primary">
				
					<div class="panel-heading">
						<h4>Sign Up - Address</h4>
					</div>
					
					<div class="panel-body">
										
						<sf:form
							method="POST"
							modelAttribute="shipping"
							class="form-horizontal"
							id="billingForm"
						>
						
							
							<div class="form-group">
								<label class="control-label col-md-4" for="apartmentNumber">Address Line One</label>
								<div class="col-md-8">
									<sf:input type="text" path="apartmentNumber" class="form-control"
										placeholder="Enter Address Line One" />
									<sf:errors path="apartmentNumber" cssClass="help-block" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="streetName">Address Line Two</label>
								<div class="col-md-8">
									<sf:input type="text" path="streetName" class="form-control"
										placeholder="Enter Address Line Two" />
									<sf:errors path="streetName" cssClass="help-block" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-md-8">
									<sf:input type="text" path="city" class="form-control"
										placeholder="Enter City Name" />
									<sf:errors path="city" cssClass="help-block" element="em"/> 
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="zipCode">Postal Code</label>
								<div class="col-md-8">
									<sf:input type="text" path="zipCode" class="form-control"
										placeholder="XXXXXX" />
									<sf:errors path="zipCode" cssClass="help-block" element="em"/> 
								</div>
							</div>							
						
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-md-8">
									<sf:input type="text" path="state" class="form-control"
										placeholder="Enter State Name" />
									<sf:errors path="state" cssClass="help-block" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-md-8">
									<sf:input type="text" path="country" class="form-control"
										placeholder="Enter Country Name" />
									<sf:errors path="country" cssClass="help-block" element="em"/> 
								</div>
							</div>
							
							
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" name="_eventId_saveAddress" class="btn btn-primary">
										<span class="glyphicon glyphicon-plus"></span> Add Address
									</button>																	 
								</div>
							</div>
						
						
						</sf:form>					
					
					
					</div>
				
				
				</div>
			
								
			
			</div>			

	</div>	

</div>	
<%@include file="../../flows-shared/footer.jsp" %>	