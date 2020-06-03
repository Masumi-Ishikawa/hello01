$(function(){
	$('#login').on("click",function(){
		var choice = $("input[name='choice']:checked").val();
		//alert(choice);
		var form = $(this).parents('form');
		if(choice == "productList"){
			form.attr('action','/login/productList');
		}
		form.submit();
	});
});
