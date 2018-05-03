/**
 * 房间信息js
 */
//init
$(function() {
	hotelShow(); //加载酒店列表
	floorShow(); //楼层加载
});

function showRoomList(){
//	floorShow($("#hotel").val());
	var arr = [];
	console.log(arr);
	var floor = $("#floor option");
	for(var i=0;i<floor.length;i++){
		arr.push(floor[i].getAttribute("value"));
	}
	for(var i=0;i<arr.length;i++){
	$.ajax({
		type : "post",
		data : {
			"floor" : arr[i]
		},
		url : "../../room/listByHotel",
		success : function(data) {
			console.log(data)
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//alert(XMLHttpRequest.status);
			//alert(XMLHttpRequest.readyState);
			//alert(textStatus);
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
	}
}

