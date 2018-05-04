/**
 * 房间信息js
 */
//init
$(function() {
	hotelShow(); //加载酒店列表
	//floorShow(); //楼层加载
});

function showRoomList(){
	floorShow($("#hotel").val()); //楼层加载
	
	$.ajax({
		type : "post",
		data : {
			"hotel" : $("#hotel").val()
		},
		url : "../../room/listByHotel",
		success : function(data) {
			var obj = eval(data);
			$("#seat").empty();
			for (var i = 0, len = obj.length; i < len; i++) {
				$("#seat").append("<div class=\"xBox overflow\"><p class=\"storey lt\">"+obj[i].floor+"楼</p><ol id='floor_"+obj[i].floor+"' class=\"overflow rt\"></ol></div>");
				var rooms = obj[i].list;
				//console.log(rooms);
				for (var j = 0, leng = rooms.length; j < leng; j++) {
					var room = ""
					if (rooms[j].state == "1") {
						room += "<li><p class=\"icon\"><u class=\"idle\"></u>"
							+ "</p> <span class=\"null\">" + rooms[j].roomNumber + "</span></li>";
					} else {
						room += "<li><p class=\"icon\"><u class=\"useI\"></u>"
							+ "</p> <span class=\"null\">" + rooms[j].roomNumber + "</span></li>";
					}
					if (obj[i].floor == rooms[j].floor) {
						$("#floor_" + +obj[i].floor).append(room);
					}
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
/*//加载房间*/
function showFloorRoomList() {
	$.ajax({
		type : "post",
		data : {
			"floor" :  $("#floor").val(),
			"hotel" : $("#hotel").val()
		},
		url : "../../room/floor",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$("#seat").empty();
			$("#seat").append("<div class=\"xBox overflow\"><p class=\"storey lt\">" + $("#floor").val() + "楼</p><ol id='floor_' class=\"overflow rt\"></ol></div>");
			for (var i = 0; i < obj.length; i++) {
				var room = ""
				if (obj[i].state == "1") {
					room += "<li><p class=\"icon\"><u class=\"idle\"></u>"
						+ "</p> <span class=\"null\">" + obj[i].roomNumber + "</span></li>";
				} else {
					room += "<li><p class=\"icon\"><u class=\"useI\"></u>"
						+ "</p> <span class=\"useIng\">" + obj[i].roomNumber + "</span></li>";
				}
				$("#floor_").append(room);
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