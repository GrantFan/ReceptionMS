/**
 * 酒店下拉加载
 */
function hotelShow(){
	var hotelName = "";
	$.ajax({
		type : "post",
		data :{"hotelName":hotelName},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			console.log(obj);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//alert(XMLHttpRequest.status);
			//alert(XMLHttpRequest.readyState);
			//alert(textStatus);
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}