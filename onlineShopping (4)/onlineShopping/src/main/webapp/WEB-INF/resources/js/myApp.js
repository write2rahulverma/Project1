$(function(){
	
	switch(menu){
	
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'Register':
		$('#register').addClass('active');
		break;
	case 'Login':
		$('#login').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProduct').addClass('active');
		break;
	case 'Add Products':
		$('#manageProduct').addClass('active');
		break;
	case 'All Products':
		$('#listProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userCart').addClass('active');
		break;
	default:
		if (menu == 'Home') break;
		$('#listProduct').addClass('active');
		$('a_'+menu).addClass('active');
		break;
	}

	//validation code for login
	
	var $loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({
			
			rules : {
				
				username : {				
					required: true
				},
				
				password : {
					required: true
				}
			},
			
			messages : {
				
				username : {
					required: 'Please enter username'
				},
				
				password : {
					required: 'Please enter the password'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				
				error.addClass('help-block');
				error.inserAfter(element);
			}
			
		});
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length) {
		
		setTimeout(function() {
			$alert.fadeOut('slow');
		} ,3000)
		}
	
	//-----------------------------------------------
	
	$('.switch input[type="checkbox"]').on('change', function(){
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the product?':
							  'You want to deactivate the product?';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'medium',
			title: 'Product Activation & Deactivation',
			message:dMsg,
			callback: function(confirmed) {
				
				if (confirmed) {
		            $.ajax({							            	
		            	type: 'GET',
		            	url: window.contextRoot + '/manage/product/' + value + '/activation',
		        		timeout : 100000,
		        		success : function(data) {
		        			bootbox.alert({ 
		        				size: 'medium',
								title: 'Information',
								message: data
		        			});							        										        			
		        		},
		        		error : function(e) {
		        			bootbox.alert('ERROR: '+ e);
		        			//display(e);
		        		}						            	
		            });
		        }
				else {
					checkbox.prop('checked', !checked);
				}
			}
		});
	});
	
	// handling the click event of refresh cart button
	$('button[name="refreshCart"]').click(function() {
		
		//fetch the cart line id
		var cartLineId = $(this).attr('value');
		var countElement = $('#count_' + cartLineId);
		
		var originalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		//work only when the count has changed
		if(currentCount !== originalCount) {
			
			if(currentCount < 1 || currentCount > 3) {
				//reverting back to the original count
				//user has given value below 1 and above 3
				countElement.val(originalCount);
				bootbox.alert({
					
					size: 'medium',
					title: 'Error',
					message: 'Product cont should be minimum 1 and maximum 3!'
				});
			}
			else {
				
				var updateUrl = window.contextRoot + '/cart' + cartLineId + '/update?count=' + currentCount;
				//forward it to the controller
				window.location.href = updateUrl;
				
			}
		}
	});
		


});