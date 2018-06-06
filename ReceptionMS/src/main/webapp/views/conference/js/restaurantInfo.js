$(function(){
	restaurantTypeShow(); 
	hotelShow();
	
}); 
/*
	 * 餐厅类型加载
	 */
	function restaurantTypeShow(){  
		$.ajax({
			type : "get",
			data :{"tableName":"DM_RESTAURANT_TYPE"},
			url : "../../dic",
			success : function(data) {  
				var obj = eval(data);  
				$("#QrestaurantType").empty();
				$("#QrestaurantType").append(
					"<option value=''>--请选择餐厅类型--</option>"
				);
				for (var i = 0, len = obj.length; i < len; i++) {
					$("#QrestaurantType").append(
						"<option value='" + obj[i].value + "'>" + obj[i].name + "</option>"
					);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) { 
				console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
			}
		})
	}
	/*
	 * 酒店联动餐厅加载
	 */
	function restaurantTypeList(obj){    
		$.ajax({
			type : "get", 
			url : "../../RestaurantInfoController/restaurantTypeList/",
			data:{
				hotel_name : $(obj).find("option:selected").text() 
			},
			success : function(data) {  
				$("#QrestaurantType").empty(); 
				if(data.length == 0){
					$("#QrestaurantType").append(
						"<option value=''>--无--</option>"
					);
				}else{
					$("#QrestaurantType").append(
						"<option value=''>--请选择餐厅--</option>"
					);
				} 
				for (var i = 0, len = data.length; i < len; i++) {
					$("#QrestaurantType").append(
						"<option value='" + data[i].value + "'>" + data[i].name + "</option>"
					);
				}
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				//alert(XMLHttpRequest.status);
				//alert(XMLHttpRequest.readyState);
				//alert(textStatus);
				console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
			}
		})
	}
	function hotelShow(input){
		var hotelName = $(input).val();
		//alert(hotelName);
		$.ajax({
			type : "post",
			data :{"hotelName":hotelName},
			url : "../../hotel/listByName",
			success : function(data) {
				var obj = eval(data); 
				$(".hotel").empty();
				$(".hotel").append(
					"<option value=''>--请选择酒店--</option>"
				);
				for (var i = 0, len = obj.length; i < len; i++) {
					$(".hotel").append(
						"<option value='" + obj[i].id + "'>" + obj[i].hotelName + "</option>"
					);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				//alert(XMLHttpRequest.status);
				//alert(XMLHttpRequest.readyState);
				//alert(textStatus);
				console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
			}
		})
	}
	/*
	 * 更新时酒店下拉加载
	 */
	function upHotelShow(hotelName){ 
		$.ajax({
			type : "post", 
			url : "../../hotel/listByName",
			success : function(data) {
				var obj = eval(data); 
				$("#HOTEL").empty();
				$("#HOTEL").append(
					"<option value=''>--请选择酒店--</option>"
				);
				for (var i = 0, len = obj.length; i < len; i++) {
					if(hotelName == obj[i].hotelName){
						$("#HOTEL").append(
						"<option value='" + obj[i].id + "' selected>" + obj[i].hotelName + "</option>"
					);
					}else{
						$("#HOTEL").append(
						"<option value='" + obj[i].id + "'>" + obj[i].hotelName + "</option>"
					);
					}
					
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				//alert(XMLHttpRequest.status);
				//alert(XMLHttpRequest.readyState);
				//alert(textStatus);
				console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
			}
		})
	}  
	/*
	 * 更新会议室类型加载
	 */
	function uprestaurantTypeShow(restairantType){  
		$.ajax({
			type : "get",
			data :{"tableName":"DM_RESTAURANT_TYPE"},
			url : "../../dic",
			success : function(data) { 
				var obj = eval(data);  
				$("#restaurant_type").empty();
//				$("#restaurant_type").append(
//					"<option value=''>--请选择餐厅类型--</option>"
//				);
				for (var i = 0, len = obj.length; i < len; i++) {
					if(restairantType == obj[i].name){
						$("#restaurant_type").append(
								"<option value='" + obj[i].value + "' selected>" + obj[i].name + "</option>"
							); 
					}else{
						$("#restaurant_type").append(
								"<option value='" + obj[i].value + "'>" + obj[i].name + "</option>"
							); 
					} 
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) { 
				console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
			}
		})
	}
	