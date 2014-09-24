/**
 * 
 */

window.onload = function(){

	
	var obj = $.parseJSON('{"id":null,"nome":"Combo","produtos":[]}');
    
    
	/*
	$.post( "http://localhost:8080/macaxeira/categoria/create", 
			obj,
			null,
			"json"
			);
	*/
	
	
	$.ajax({
        type:'POST',
        url:"http://localhost:8080/macaxeira/categoria/create",
        data:{
            categoria:obj
        },
        success:function (data) {
        	
        },
        contentType:"json"
    });
	
}