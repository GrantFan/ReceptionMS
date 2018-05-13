/**
 * 房间信息js
 */
//init
$(function() {
	hotelShow(); //加载酒店列表
	roomHotelLoad();
	loadRoomType();
	//floorShow(); //楼层加载
});

function showRoomList(){
	floorShow($("#hotel").val()); //楼层加载
	$("#hotelName").text($("#hotel option:selected").text());
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
						room += "<li><p class=\"icon\" onclick=\"showRoom('"+rooms[j].id+"')\"><u class=\"idle\"></u>"
							+ "</p> <span class=\"idle\">" + rooms[j].roomNumber + "</span></li>";
					} else {
						room += "<li><p class=\"icon\" onclick=\"showRoom('"+rooms[j].id+"')\"><u class=\"useI\"></u>"
							+ "</p> <span class=\"useIng\">" + rooms[j].roomNumber + "</span></li>";
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
					room += "<li><p class=\"icon\" onclick=\"showRoom('"+obj[i].id+"')\"><u class=\"idle\"></u>"
						+ "</p> <span class=\"idle\">" + obj[i].roomNumber + "</span></li>";
				} else {
					room += "<li><p class=\"icon\" onclick=\"showRoom('"+obj[i].id+"')\"><u class=\"useI\"></u>"
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
		data : {"hotelName":input},
		anyc : false,
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
	$("#roomFloor").val("");
	$("#orientation").val("");
	$("#supportFacilities").val("");
	$("#roomType").val("");
	$("#specialType").val("");
	$("#specialServe").val("");
	$("#innerlinePhone").val("");
	$("#outsidePhone").val("");
	$("#responsiblePerson").val("");
	$("#rackPrice").val("");
	$("#agreementPrice").val("");
	$("#remark").val("");
	
	$("#input_hotel").show();
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
		rackPrice : $("#rackPrice").val(),
		agreementPrice : $("#agreementPrice").val(),
		hotel : $("#roomHotel").val(),
		containFood : $("#containFood").val(),
		state : $("#state").val(),
		remark : $("#remark").val()
	}, function(result) {
		if (result == "true") {
			alert("添加成功");
			$('.modal').hide();
			$("#modal_name").text("房间信息");
//			showRoomList();
		}else{
			alert("添加失败");
		}
	}
	).error(function(a) {
		console.log(a);
	});
}

//单个房间信息查看及修改
function showRoom(roomId) {
	//	alert(roomId);
	$("#modal_name").text("房间信息");
	$(".modal").show(500);
	$('#add').hide();
	$('#update').show(500);
	$("#input_hotel").hide();

	$.get(
		'../../room/' + roomId,
		function(result) {
			var json = JSON.parse(result);
			//console.log(json);
			$("#id").val(json.id);
			$("#roomNumber").val(json.roomNumber);
			$("#roomFloor").val(json.floor);
			$("#orientation").val(json.orientation);
			$("#supportFacilities").val(json.supportFacilities);
			$("#specialType").val(json.specialType);
			$("#specialServe").val(json.specialServe);
			$("#outsidePhone").val(json.outsidePhone);
			$("#innerlinePhone").val(json.innerlinePhone);
			$("#responsiblePerson").val(json.responsiblePerson);
			$("#rackPrice").val(json.rackPrice);
			$("#agreementPrice").val(json.agreementPrice);
			$("#remark").val(json.remark);

			for (var i = 0; i < $("#roomHotel option").length; i++) {
				if ($("#roomHotel option")[i].value == json.hotel) {
					$("#roomHotel option")[i].setAttribute("selected", true);
				}
			}
			for (var i = 0; i < $("#roomType option").length; i++) {
				if ($("#roomType option")[i].value == json.roomType) {
					$("#roomType option")[i].setAttribute("selected", true);
				}
			}
			for (var i = 0; i < $("#containFood option").length; i++) {
				if ($("#containFood option")[i].value == json.containFood) {
					$("#containFood option")[i].setAttribute("selected", true);
				}
			}
			for (var i = 0; i < $("#state option").length; i++) {
				if ($("#state option")[i].value == json.state) {
					$("#state option")[i].setAttribute("selected", true);
				}
			}
		}
	);
}

//修改提交
function editSubmit() {
	$.ajax({
		url : '../../room/update',
		type : 'post',
		data : {
			id : $("#id").val(),
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
			rackPrice : $("#rackPrice").val(),
			agreementPrice : $("#agreementPrice").val(),
			hotel : $("#roomHotel").val(),
			containFood : $("#containFood").val(),
			state : $("#state").val(),
			remark : $("#remark").val()
		},
		success : function(result) {
			//console.log(result);
			if (result == "true") {
				alert("修改成功");
				$('.modal').hide();
				$("#modal_name").text("房间信息");
				showRoomList();
			}else{
				alert("修改失败");
			}
		}
	});
}