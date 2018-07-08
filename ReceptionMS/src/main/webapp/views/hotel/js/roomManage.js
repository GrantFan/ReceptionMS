/**
 * 房间信息js
 */
//init
$(function() {
	hotelShow(); //加载酒店列表
	roomHotelLoad();
	loadRoomType();
});

function hotelShow(){
	$.ajax({
		type : "post",
//		data :{"hotelName":hotelName},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
//			console.log(obj);
			$("#hotel").empty();
			for (var i = 0, len = obj.length; i < len; i++) {
				$("#hotel").append(
					"<li name='"+obj[i].id+"'>" + obj[i].hotelName + "</li>"
				);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

function showRoomList() {
	var hotel = $("#hotel>li.active").text();
	//floorShow(hotelName); //楼层加载
//	alert(hotel);
	$.ajax({
		type : "post",
		data : {
			"hotel" : hotel
		},
		url : "../../room/listByHotel",
		success : function(data) {
			var obj = eval(data);
//			console.log(obj);
			if (obj.length != 0) {
				$("#hotelName").text(hotel);
				//			console.log(obj);
//				$("#seat").empty();
//				for (var i = 0, len = obj.length; i < len; i++) {
//					$("#seat").append("<div class=\"xBox overflow\"><p class=\"storey lt\">楼层：" + obj[i].floor + "</p><p onclick=\"planeGraph('" + obj[i].floor + "')\" style=\"cursor:pointer;width:8vw;\" class=\"storey lt\">【平面图】</p><div class='floors lt'><ol id='floor_" + obj[i].floor + "' class=\"overflow rt\"></ol></div></div>");
//					var rooms = obj[i].list;
//					//console.log(rooms);
//					for (var j = 0, leng = rooms.length; j < leng; j++) {
//						var room = ""
//						if (rooms[j].state == "空闲") {
//							room += "<li><p class=\"icon\" onclick=\"showRoom('" + rooms[j].id + "')\"><u class=\"idle\"></u>"
//								+ "</p> <span class=\"null\">" + rooms[j].roomNumber + "</span><p style='color: #40e0d0;'>"+rooms[j].roomType+"</p></li>";
//						} else {
//							room += "<li><p class=\"icon\" onclick=\"showRoom('" + rooms[j].id + "')\"><u class=\"useI\"></u>"
//								+ "</p> <span class=\"useIng\">" + rooms[j].roomNumber + "</span><p style='color: #ffb341;'>"+rooms[j].roomType+"</p></li>";
//						}
//						if (obj[i].floor == rooms[j].floor) {
//							$("#floor_" + +obj[i].floor).append(room);
//						}
//					}
//				}
				$("#seat").empty();
				for (var i = 0, len = obj.length; i < len; i++) {
					$("#seat").append("<div class=\"xBox overflow\"><p class=\"storey lt\">楼层：" + obj[i].floor + "</p><p onclick=\"planeGraph('" + obj[i].floor + "')\" style=\"cursor:pointer;width:8vw;\" class=\"storey lt\">【平面图】</p><div id='floor_" + obj[i].floor + "'  class='floors lt'></div></div>");					
					var orientation = obj[i].list;
					
					for (var j = 0, leng = orientation.length; j < leng; j++) {	
						
						$("#floor_" + +obj[i].floor).append("<ol id='ora_" + i+ j + "' class=\"overflow\"><li style=\"width:1.6vw;padding-top:1.5vh;\"><span> 朝  向 "+(orientation[j].orientation==null?'无':orientation[j].orientation)+" </span></li></ol>");
						var  rooms = orientation[j].list;
//						console.log(rooms);
						for (var k = 0, lengths = rooms.length; k < lengths; k++) {
							$("#ora_" + i+ j).width((7.5 * lengths)+'vw' );//设置每个ol宽度
							var room = ""
//							console.log($("#ora_" + i+ j).width((7.3 * lengths)+'vw' ));
							if (rooms[k].state == "空闲") {
								room += "<li><p class=\"icon\" onclick=\"showRoom('" + rooms[k].id + "')\"><u class=\"idle\"></u>"
									+ "</p> <span class=\"null\">" + rooms[k].roomNumber + "</span><p style='color: #40e0d0;'>"+rooms[k].roomType+"</p></li>";
							} else {
								room += "<li><p class=\"icon\" onclick=\"showRoom('" + rooms[k].id + "')\"><u class=\"useI\"></u>"
									+ "</p> <span class=\"useIng\">" + rooms[k].roomNumber + "</span><p style='color: #ffb341;'>"+rooms[k].roomType+"</p></li>";
							}
							if (orientation[j].orientation == rooms[k].orientation) {
//								alert(orientation[j].orientation);
								$("#ora_" + i+ j).append(room);
							}
							
						
						}
						
						 
					}
				}
			} else {
				$("#seat").empty();
				alert("无房间信息~");
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

function planeGraph(floor) {
	$("#graphModal").show(800);
	var hotel = $("#hotel>li.active").attr("name");
//	console.log(floor)
	$.ajax({
		url : '../../hotel_graph/selectImpByFloor',
		type : 'get',
		data : {
			"hotel" : hotel,
			"floor" : floor
		},
		success : function(result) {
			var list = eval("(" + result + ")");
//			console.log(list)
			var info = $("#imageOver").empty();
			for (var i = 0; i < list.length; i++) {
				if (i == 0) {
					info.append('<li name=\"' + list[i].id + '\" class="block"><img src="' + list[i].graph_url + '" width="100%" height="88%" /><div style="margin:0.384vw 0px;">名称：<input style="padding:0px 0.256vw;" disabled="disabled" value=\"'+list[i].graph_name+'\" /><span style="margin-left:0.384vw;">楼层:</span><input disabled="disabled"  value="'+list[i].floor+'"/></div></li>');
				} else {
					info.append('<li name=\"' + list[i].id + '\" class="none"><img src="' + list[i].graph_url + '" width="100%" height="88%" /><div style="margin:0.384vw 0px;">名称：<input style="padding:0px 0.256vw;" disabled="disabled" value=\"'+list[i].graph_name+'\" /><span style="margin-left:0.384vw;">楼层:</span><input disabled="disabled"  value="'+list[i].floor+'"/></div></li>');
				}
			}
		},
		error : function() {
			alert("获取图片失败！");
		}
	})
}

/*//加载房间
function showFloorRoomList() {
	$.ajax({
		type : "post",
		data : {
			"floor" : $("#floor").val(),
			"hotel" : $("#hotel option:selected").text()
		},
		url : "../../room/floor",
		success : function(data) {
			var obj = eval(data);
			//			console.log(obj);
			if (obj.length != 0) {
				$("#seat").empty();
				$("#seat").append("<div class=\"xBox overflow\"><p class=\"storey lt\">" + $("#floor").val() + "楼</p><ol id='floor_' class=\"overflow rt\"></ol></div>");
				for (var i = 0; i < obj.length; i++) {
					var room = ""
					if (obj[i].state == "空闲") {
						room += "<li><p class=\"icon\" onclick=\"showRoom('" + obj[i].id + "')\"><u class=\"idle\"></u>"
							+ "</p> <span class=\"null\">" + obj[i].roomNumber + "</span></li>";
					} else {
						room += "<li><p class=\"icon\" onclick=\"showRoom('" + obj[i].id + "')\"><u class=\"useI\"></u>"
							+ "</p> <span class=\"useIng\">" + obj[i].roomNumber + "</span></li>";
					}
					$("#floor_").append(room);
				}
			} else {
				alert("无房间信息~");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//alert(XMLHttpRequest.status);
			//alert(XMLHttpRequest.readyState);
			//alert(textStatus);
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})

}*/

//加载酒店列表
function roomHotelLoad(input) {
	//alert(input);
	$.ajax({
		type : "post",
		data : {
			"hotelName" : input
		},
		anyc : false,
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$(".roomHotel").empty();
			for (var i = 0, len = obj.length; i < len; i++) {
				$(".roomHotel").append(
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
			$(".roomType").empty();
			for (var i = 0, len = result.length; i < len; i++) {
				$(".roomType").append(
					"<option value='" + result[i].value + "'>" + result[i].name + "</option>"
				);
			}
		}
	);
}


function importModal(){
	$("#importModal").show(500);
}
/**
 * 导入
 */
function importExcel() {
	var f = $("#file_excel").val();
	if (f == null || f == undefined || f == '') {
		return false;
	}
	if (!/\.(?:xls|xlsx)$/.test(f)) {
		alert("请上传Excel文件");
		$("#file_excel").val('');
		return false;
	}
	var data = new FormData();
	$.each($("#file_excel")[0].files, function(i, file) {
		data.append('file', file);
	})
	$.ajax({
		type : "POST",
		url : "../../room/import",
		data : data,
		cache : false,
		processData : false,
		contentType : false,
		dataType : "json",
		success : function(str) {
			console.log(str);
			if (str.flag == "true") {
				alert("导入成功！ 导入" + str.count + "条数据");
				showHotelList(1, 10);
				$("#importModal").hide(500);
			} else {
				alert("导入" + str.count + "条数据");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("请求失败，请检查网络后重试");
		}
	});
}
//导出
function exportExcel() {
	location.href = '../../room/export';
}

//批量新增房间
function batchAdd(){
	$("#batchmodal").show(500);
	
	$("#b_roomHotel").val("");
	$("#b_roomNumber").val("");
	$("#b_roomFloor").val("");
	$("#b_orientation").val("");
	$("#b_supportFacilities").val("");
	$("#b_roomType").val("");
	$("#b_specialType").val("");
//	$("#b_specialServe").val("");
	$("#b_innerlinePhone").val("");
	$("#b_outsidePhone").val("");
//	$("#b_responsiblePerson").val("");
//	$("#b_rackPrice").val("");
	$("#b_agreementPrice").val("");
	$("#roomCount").val("");
	
	loadRoomType();
}
//批量新增房间提交
function batchAddSubmit() {
	if($("#b_roomFloor").val()=="" || $("#roomCount").val()=="" || $("#b_orientation").val()=="" || $("#b_roomHotel option:selected").text()==""){
		alert("必填项不能为空");
		return;
	}
	$.post("../../room/batchadd", {
		roomNumber : $("#b_roomNumber").val(),
		floor : $("#b_roomFloor").val(),
		orientation : $("#b_orientation").val(),
		supportFacilities : $("#b_supportFacilities").val(),
		roomType : $("#b_roomType option:selected").text(),
		specialType : $("#b_specialType").val(),
//		specialServe : $("#b_specialServe").val(),
		innerlinePhone : $("#b_innerlinePhone").val(),
		outsidePhone : $("#b_outsidePhone").val(),
//		responsiblePerson : $("#b_responsiblePerson").val(),
//		rackPrice : $("#b_rackPrice").val(),
		agreementPrice : $("#b_agreementPrice").val(),
		hotel : $("#b_roomHotel option:selected").text(),
//		containFood : $("#b_containFood option:selected").text(),
		state : $("#b_state option:selected").text(),
		roomCount : $("#roomCount").val().trim()
	}, function(result) {
		if (result == "true") {
			alert("添加成功");
			$('#batchmodal').hide();
		//			showRoomList();
		} else {
			alert("添加失败");
		}
	}
	).error(function(a) {
		console.log(a);
	});
}


//新增
function add() {
	//重置表单
	$("#modal").show(500);
	$('#add').show();
	$('#update').hide(500);

	$("#roomHotel").val("");
	$("#roomNumber").val("");
	$("#roomFloor").val("");
	$("#orientation").val("");
	$("#supportFacilities").val("");
	$("#roomType").val("");
	$("#specialType").val("");
//	$("#specialServe").val("");
	$("#innerlinePhone").val("");
	$("#outsidePhone").val("");
//	$("#responsiblePerson").val("");
//	$("#rackPrice").val("");
	$("#agreementPrice").val("");
	$("#remark").val("");

//	$("#input_hotel").show();
	roomHotelLoad();
	loadRoomType();
}
//新增提交
function addSubmit() {
	$.post("../../room/add", {
		roomNumber : $("#roomNumber").val(),
		floor : $("#roomFloor").val(),
		orientation : $("#orientation").val(),
		supportFacilities : $("#supportFacilities").val(),
		roomType : $("#roomType option:selected").text(),
		specialType : $("#specialType").val(),
//		specialServe : $("#specialServe").val(),
		innerlinePhone : $("#innerlinePhone").val(),
		outsidePhone : $("#outsidePhone").val(),
//		responsiblePerson : $("#responsiblePerson").val(),
//		rackPrice : $("#rackPrice").val(),
		agreementPrice : $("#agreementPrice").val(),
		hotel : $("#roomHotel option:selected").text(),
//		containFood : $("#containFood option:selected").text(),
		state : $("#state option:selected").text(),
		remark : $("#remark").val()
	}, function(result) {
		if (result == "true") {
			alert("添加成功");
			$('#modal').hide();
			$("#modal_name").text("房间信息");
		//			showRoomList();
		} else {
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
	$("#modal").show(500);
	$('#add').hide();
	$('#update').show(500);
	$("#input_hotel").hide();
	loadRoomType();
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
//			$("#specialServe").val(json.specialServe);
			$("#outsidePhone").val(json.outsidePhone);
			$("#innerlinePhone").val(json.innerlinePhone);
//			$("#responsiblePerson").val(json.responsiblePerson);
//			$("#rackPrice").val(json.rackPrice);
			$("#agreementPrice").val(json.agreementPrice);
			$("#remark").val(json.remark);

			for (var i = 0; i < $("#roomHotel option").length; i++) {
				if ($($("#roomHotel option")[i]).text() == json.hotel) {
					$("#roomHotel option")[i].selected = true;
				}
			}
			for (var i = 0; i < $("#roomType option").length; i++) {
				if ($($("#roomType option")[i]).text() == json.roomType) {
					$("#roomType option")[i].selected = true;
				}
			}
//			for (var i = 0; i < $("#containFood option").length; i++) {
//				if ($($("#containFood option")[i]).text() == json.containFood) {
//					$("#containFood option")[i].selected = true;
//				}
//			}
			for (var i = 0; i < $("#state option").length; i++) {
				if ($($("#state option")[i]).text() == json.state) {
					$("#state option")[i].selected = true;
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
			roomType : $("#roomType option:selected").text(),
			specialType : $("#specialType").val(),
//			specialServe : $("#specialServe").val(),
			innerlinePhone : $("#innerlinePhone").val(),
			outsidePhone : $("#outsidePhone").val(),
//			responsiblePerson : $("#responsiblePerson").val(),
//			rackPrice : $("#rackPrice").val(),
			agreementPrice : $("#agreementPrice").val(),
			hotel : $("#roomHotel option:selected").text(),
//			containFood : $("#containFood option:selected").text(),
			state : $("#state option:selected").text(),
			remark : $("#remark").val()
		},
		success : function(result) {
			//console.log(result);
			if (result == "true") {
				alert("修改成功");
				$('#modal').hide();
				$("#modal_name").text("房间信息");
				showRoomList();
			} else {
				alert("修改失败");
			}
		}
	});
}

//打印
function print(){
	var canvas = document.getElementById("mycanvas");
//	console.log(canvas);s
	var dataUrl = canvas.toDataURL();  
    var newImg = document.createElement("img");  
    newImg.src = dataUrl;  
    var printWindow = window.open(newImg.src);  
    printWindow.document.write('<img width="1200vw" src="'+newImg.src+'" />')  
    printWindow.print();  
}
//打印预览
function doprint(id) {
			html2canvas(document.querySelector("#"+id)).then(canvas => {
				canvas.id = "mycanvas";
//				document.body.appendChild(canvas);
				$("#img").empty();
				$("#img").append(canvas)
				$("#printModal").show(800);
			});
}

//打印
function printHtml(){
	bdhtml = window.document.body.innerHTML;  
	sprnstr = "<!--startprint-->";  
	eprnstr = "<!--endprint-->";  
	prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17);  
	prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));  
	var style = "<head><style></style></head>";
	var newWin = window.open('', '', '');
	newWin.document.write(style);
	newWin.document.write(prnhtml);
	newWin.print();
}

//打印
function printImg(){
var img = $("#imageOver li.block img");
var newImg = document.createElement("img");  
newImg.src = img[0].src;  
var printWindow = window.open(newImg.src);  
printWindow.document.write('<img src="'+newImg.src+'" />')  
printWindow.print();  
}