$(document).ready(function() { 
	//��������˵��ı���ʽ
	var removeClas = $('ul li.active'); 
	$('ul li').bind('click', function(){ 
		removeClas.removeClass('active'); 
		$(this).addClass('active'); 
		removeClas = $(this); 
	}); 
	
	
}); 
