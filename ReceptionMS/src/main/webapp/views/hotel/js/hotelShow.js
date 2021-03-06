/**
 * 酒店下拉加载
 */
function hotelShow(input){
	var hotelName = $(input).val();
	//alert(hotelName);
	$.ajax({
		type : "post",
		data :{"hotelName":hotelName},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$("#hotel").empty();
			$("#hotel").append(
				"<option value=''>-----请选择酒店-----</option>"
			);
			for (var i = 0, len = obj.length; i < len; i++) {
				$("#hotel").append(
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

/**
 * 楼层下拉加载
 */
function floorShow(hotel){
	$.ajax({
		type : "post",
		aync:false,
		data : {
			"hotel" : hotel
		},
		url : "../../room/floorList",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$("#floor").empty();
			$("#floor").append(
				"<option value=''>-----请选择楼层-----</option>"
			);
			for (var i = 0, len = obj.length; i < len; i++) {
				$("#floor").append(
					"<option value='" + obj[i].floor + "'>" + obj[i].floor + "楼</option>"
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
