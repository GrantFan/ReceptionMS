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

//加载酒店列表
function roomHotelLoad(input){
	//alert(input);
	$.ajax({
		type : "post",
		data :{"hotelName":input},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$("#roomHotel").empty();
			for (var i = 0, len = obj.length; i < len; i++) {
				$("#roomHotel").append(
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
//加载房间类型
function loadRoomType() {
	$.get('../../dic',
		{
			tableName : "dm_room_type"
		},
		function(result) {
			//console.log(result);
			$("#roomType").empty();
			for (var i = 0, len = result.length; i < len; i++) {
				$("#roomType").append(
					"<option value='" + result[i].value + "'>" + result[i].name + "</option>"
				);
			}
		}
	);
}
//新增
function add() {
	//重置表单
	$(".modal").show(500);
	$('#add').show();
	$('#update').hide(500);
	
	$("#roomHotel").val("");
	$("#roomNumber").val("");
	$("#floor").val("");
	$("#orientation").val("");
	$("#supportFacilities").val("");
	$("#roomType").val("");
	$("#specialType").val("");
	$("#specialServe").val("");
	$("#innerlinePhone").val("");
	$("#responsiblePerson").val("");
	$("#rackPrice").val("");
	$("#agreementPrice").val("");
	$("#remark").val("");
	
	roomHotelLoad($("#input_hotel").val());
	loadRoomType();
}
//新增提交
function addSubmit() {
	$.post("../../room/add",{
		roomNumber : $("#roomNumber").val(),
		floor : $("#roomFloor").val(),
		orientation : $("#orientation").val(),
		supportFacilities : $("#supportFacilities").val(),
		roomType : $("#roomType").val(),
		specialType : $("#specialType").val(),
		specialServe : $("#specialServe").val(),
		innerlinePhone : $("#innerlinePhone").val(),
		outsidePhone : $("#outsidePhone").val(),
		responsiblePerson : $("#responsiblePerson").val(),
		rackPrice : $("rackPrice").val(),
		agreementPrice : $("#agreementPrice").val(),
		hotel : $("#roomHotel").val(),
		containFood : $("#containFood").val(),
		state : $("#state").val(),
		remark : $("#remark").val()
	}, function(result) {
		$('.modal').hide();
		alert(result);
	}
	).error(function(a) {
		console.log(a);
	});
}