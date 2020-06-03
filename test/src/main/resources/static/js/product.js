$(function(){
	var hidden = $("input[type='hidden']").val();
	//alert(result);
	if(hidden == ""){
		$(".update").remove();
	}else{
		$(".insert").remove();
	}

	$('#save').on("click",function(){
		//alert(choice);
		var result = true;
		var insert_product_id = $("#insert_product_id").val();
		var product_name = $("#product_name").val();
		var hidden = $("input[type='hidden']").val();

		if(hidden == ""){
			if(insert_product_id==""||product_name==""){
				result = false;
			}
		}else{
			if(product_name==""){
				result = false
			}
		}

		//未入力チェック
		if(result){
			var form = $(this).parents('form');
			form.submit();
		}else{
			alert("すべて入力してください");
		}
	});

	$('#cancel').on("click",function(){
		//alert(choice);
		var form = $(this).parents('form');
		form.attr('action','/product/cancel');
		form.submit();
	});
});

