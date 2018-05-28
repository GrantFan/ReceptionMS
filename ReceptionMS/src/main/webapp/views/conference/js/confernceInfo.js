$(function(){
	boardTypeShow(); 
	hotelShow();
	
}); 
/*
	 * 会议室类型加载
	 */
	function boardTypeShow(){ 
		//alert(hotelName); 
		$.ajax({
			type : "get",
			data :{"tableName":"dm_conference_type"},
			url : "../../dic",
			success : function(data) { 
				var obj = eval(data);  
				$("#QboardType").empty();
				$("#QboardType").append(
					"<option value=''>--请会议室类型--</option>"
				);
				for (var i = 0, len = obj.length; i < len; i++) {
					$("#QboardType").append(
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
	 * 会议室加载
	 */
	function confereceList(obj){   
		$.ajax({
			type : "get", 
			url : "../../ConferenceController/queryConferenectList/",
			data:{
				hotel_name : $(obj).find("option:selected").text() 
			},
			success : function(data) { 
				console.log(data);
				var obj = eval(data); 
				$("#CONFERENCE_NAME").empty(); 
				if(obj.length == 0){
					$("#CONFERENCE_NAME").append(
						"<option value=''>--无--</option>"
					);
				}else{
					$("#CONFERENCE_NAME").append(
						"<option value=''>--请选择会议室--</option>"
					);
				} 
				for (var i = 0, len = obj.length; i < len; i++) {
					$("#CONFERENCE_NAME").append(
						"<option value='" + obj[i].id + "'>" + obj[i].conference_name + "</option>"
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
	function upboardTypeShow(boardType){  
		$.ajax({
			type : "get",
			data :{"tableName":"dm_conference_type"},
			url : "../../dic",
			success : function(data) { 
				var obj = eval(data); 
				console.log(data);
				$(".boardType").empty();
				$(".boardType").append(
					"<option value=''>--请会议室类型--</option>"
				);
				for (var i = 0, len = obj.length; i < len; i++) {
					if(boardType == obj[i].name){
						$(".boardType").append(
								"<option value='" + obj[i].value + "' selected>" + obj[i].name + "</option>"
							); 
					}else{
						$(".boardType").append(
								"<option value='" + obj[i].value + "'>" + obj[i].name + "</option>"
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
	