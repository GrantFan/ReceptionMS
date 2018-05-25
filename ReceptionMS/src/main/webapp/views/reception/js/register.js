/**
 * 接待登记
 */

//init
$(function() {
	hotelShow(); //加载酒店列表
});

function hotelShow() {
	$.ajax({
		type : "post",
		//		data :{"hotelName":""},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//			console.log(obj);
			$(".hotel").empty();
			for (var i = 0, len = obj.length; i < len; i++) {
				$(".hotel").append(
					"<option value='" + obj[i].id + "'>" + obj[i].hotelName + "</option>"
				);
			}
			selectMenu(); //加载套餐列表
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}
function hotelShow1() {
	$.ajax({
		type : "post",
		//		data :{"hotelName":""},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//			console.log(obj);
			$(".hotel1").empty();
			for (var i = 0, len = obj.length; i < len; i++) {
				$(".hotel1").append(
					"<option value='" + obj[i].id + "'>" + obj[i].hotelName + "</option>"
				);
			}
			selectMenu(); //加载套餐列表
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

function selectMenu() {
	var hotel = $("#mealsHotel option:selected").text();
	//	alert(hotel);
	$.ajax({
		url : "/ReceptionMS/menu_info/selectByHotel",
		type : "post",
		data : {
			"hotel" : hotel
		},
		success : function(obj) {
			//            	console.log(obj)
			$(".menu").empty();
			for (var i = 0; i < obj.length; i++) {
				$(".menu").append("<option value='" + obj[i].id + "'>" + obj[i].short_name + "</option>");
			}
			;
		}
	});
}
//重置按钮
function reset() {
	$("#receptionTitle").val("");
	$("#receptionDate").val("");
	$("#receptionDays").val("");
	$("#receptionPerson").val("");
	$("#receptionPrinter").val("");
	$("#guestName").val("");
	$("#entourage").val("");
	$("#guestNum").val("");
//	$("#receptionNum").val("");
//	$("#description").val("");
//	$("#remark").val("");
}

function addMealsColumn(){
	hotelShow1();
	$("#table1").append("<tr>"
						+"<td><input onchange=\"addMealsColumn()\" type=\"text\"  value=\"\" /></td>"
//						+"<td><input type=\"text\" name=\"\"  value=\"\" /></td>"
						+"<td><select  class=\"hotel1\" onchange=\"selectMenu()\"><option>东方国际大酒店</option></select></td>"
						+"<td><select class=\"menu\"><option>套餐一</option></select></td>"
						+"<td><input type=\"text\" name=\"\" value=\"\" /></td>"
						+"</tr>");
}
function addAccomColumn(){
	hotelShow1();
	$("#table2").append("<tr>"
			+"<td><input onchange=\"addAccomColumn()\" type=\"text\" value=\"\" /></td>"
			+"<td><input type=\"text\" onclick=\"new Calendar().show(this);\" value=\"\" /></td>"
			+"<td><input type=\"text\" onclick=\"new Calendar().show(this);\" value=\"\" /></td>"
//			+"<td><input type=\"text\"  value=\"\" /></td>"
			+"<td><select class=\"hotel1\"><option>东方国际大酒店</option></select></td>"
			+"<td><input type=\"text\"  value=\"\" /></td>"
			+"</tr>");
}
//接待记录保存
function addSubmit() {
	var tr1 = $("#table1 tr");
	var tr2 = $("#table2 tr");
	console.log(tr1);
	var data = '{'
//		+ '"receptionNumber":"' + $("#receptionNumber").val() + '",'
		+ '"receptionTitle":"' + $("#receptionTitle").val() + '",'
		+ '"receptionDate":"' + $("#receptionDate").val() + '",'
		+ '"receptionPerson":"' + $("#receptionPerson").val() + '",'
		+ '"receptionPrinter":"' + $("#receptionPrinter").val() + '",'
		+ '"guestName":"' + $("#guestName").val() + '",'
		+ '"entourage":"' + $("#entourage").val() + '",'
		+ '"guestNum":"' + $("#guestNum").val() + '",'
//		+ '"receptionNum":"' + $("#receptionNum").val() + '",'
		+ '"receptionDays":"' + $("#receptionDays").val() + '",'
		+ '"hotel":"' + $("#hotel option:selected").text() + '",'
//		+ '"description":"' + $("#description").val() + '",'
//		+ '"remark":"' + $("#remark").val() + '",'
		+ '"meals":[';
	for (var i = 0; i < tr1.length-1; i++) {
		var tds = $(tr1[i]).find("td")
		//		console.log(tds[2]);
		var hotel = $(tds[1]).find("select option:selected").text();
		var menuNumber = $(tds[2]).find("select option:selected").text();
		var mealsTime = $(tds[0]).find("input").val();
//		var hobby = $(tds[1]).find("input").val();
		var remark = $(tds[3]).find("input").val();
		if(mealsTime!=""){
		if (i == tr1.length-2) {
				data += '{"hotel":\"' + hotel + '\",\"menuNumber\":\"' + menuNumber + '\",\"mealsTime\":\"' + mealsTime + '\",\"hobby\":\"\",\"remark\":\"' + remark + '\"}'
		} else {
			data += '{"hotel":\"' + hotel + '\",\"menuNumber\":\"' + menuNumber + '\",\"mealsTime\":\"' + mealsTime + '\",\"hobby\":\"\",\"remark\":\"' + remark + '\"},'
		}
		}
		}
	//			+'{"hotel":\"bzd\",\"menuNumber\":\"bzd\",\"mealsTime\":\"bzd\",\"hobby\":\"bzd\",\"remark\":\"bzd\"},'
	//			+'{\"hotel\":\"bzd\",\"menuNumber\":\"bzd\",\"mealsTime\":\"bzd\",\"hobby\":\"bzd\",\"remark\":\"bzd\"}'
	data += '],'
	data += '"accom":['
	for (var i = 0; i < tr2.length-1; i++) {
		var tds = $(tr2[i]).find("td")
//		console.log(tds[2]);
		var hotel = $(tds[3]).find("select option:selected").text();
		var roomNumber = $(tds[0]).find("input").val();
		var checkinTime = $(tds[1]).find("input").val();
		var checkoutTime = $(tds[2]).find("input").val();
//		var hobby = $(tds[3]).find("input").val();
		var remark = $(tds[4]).find("input").val();
		if(roomNumber!=""){
			if (i == tr2.length-2) {
				data += '{"hotel":\"' + hotel + '\",\"roomNumber\":\"' + roomNumber + '\",\"checkinTime\":\"' + checkinTime + '\",\"checkoutTime\":\"' + checkoutTime + '\",\"hobby\":\"\",\"remark\":\"' + remark + '\"}'
			} else {
				data += '{"hotel":\"' + hotel + '\",\"roomNumber\":\"' + roomNumber + '\",\"checkinTime\":\"' + checkinTime + '\",\"checkoutTime\":\"' + checkoutTime + '\",\"hobby\":\"\",\"remark\":\"' + remark + '\"},'
			}
		}
		}
	//			+'{"hotel":\"bzd\",\"roomNumber\":\"roomNumber\",\"checkinTime\":\"checkinTime\",\"checkoutTime\":\"checkinTime\",\"hobby\":\"bzd\",\"remark\":\"bzd\"},'
	//			+'{"hotel":\"bzd\",\"roomNumber\":\"roomNumber\",\"checkinTime\":\"checkinTime\",\"checkoutTime\":\"checkinTime\",\"hobby\":\"bzd\",\"remark\":\"bzd\"}'
	data += ']'
	data += '}';
//	console.log(data);
//	alert($("#hotel option:selected").text());
	$.ajax({
		url : '../../recep/add',
		type:'PUT',
		data :data,
		contentType:"application/json",
		success : function(result) {
//			console.log(result);
			if (result == "true") {
				alert("登记成功");
			}else{
				alert("登记失败");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	});
}