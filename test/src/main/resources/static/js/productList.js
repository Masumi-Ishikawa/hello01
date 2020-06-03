$(function(){
	$('#insert').click(function(){
		var form = $(this).parents('form');
		form.attr('method','get');
		form.attr('action','/productList/input');
		form.submit();
	});
	$('#delete').click(function(){
		//チェック数を確認
		var count = $("input[type='checkbox']:checked").length;
		if(count > 0){
		    var form = $(this).parents('form');
		    form.submit();
		}else{
			alert("削除対象が選択されていません");
		}
	});
});
