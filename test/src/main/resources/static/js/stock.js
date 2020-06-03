$(function(){
	$('#save').on("click",function(){
		//alert(choice);
		var date = $("input[type='date']").val();
		var number = $("input[type='number']").val();
		var select = $("select").val();

		if(date==""||number==""||select==""){
			alert("すべて入力してください");
		}else{
			var form = $(this).parents('form');
			form.submit();
		}
	});
	$('#cancel').on("click",function(){
		//alert(choice);
		var form = $(this).parents('form');
		form.attr('action','/stock/cancel');
		form.submit();
	});
});