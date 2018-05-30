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
	case 'View Cart':
		$('#cart').addClass('active');
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
		


});