$(function(){
	$('#input').click(function(){
		//チェック数を確認
		var count = $("input[type='radio']:checked").length;
		if(count > 0){
		    var form = $(this).parents('form');
		    form.submit();
		}else{
			alert("対象が選択されていません");
		}
	});
});
