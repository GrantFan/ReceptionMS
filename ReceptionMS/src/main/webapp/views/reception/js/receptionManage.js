/**
 * 接待信息管理
 */

//init
$(function() {
	showReceptionList();//加载接待信息列表
});

//接待信息列表
function showReceptionList() {
	$.ajax({
		type : "post",
		data : {
			"pageNum" : 1,
			"pageSize" : 5
		},
		url : "../../recep/list",
		success : function(data) {
			var obj = eval(data);
			//console.log(data);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr ondblclick=\"view()\">"
					+ "<td><label><input type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
					+ "<td>" + obj[i].receptionNumber + "</td><td>" + obj[i].receptionTitle + "</td>"
					+ "<td>" + obj[i].receptionDate + "</td><td>" + obj[i].receptionPerson + "</td>"
					+ "<td>" + obj[i].receptionPrinter + "</td><td>" + obj[i].guestName + "</td>	"
					+ "<td>" + obj[i].entourage + "</td>" + "</td><td>" + obj[i].guestNum + "</td>	"
					+ "<td>" + obj[i].receptionNum + "</td>" + "</td><td>" + obj[i].receptionDays + "</td>	"
					+ "<td>" + obj[i].hotel + "</td>" + "</td><td>" + obj[i].description + "</td>	"
					+ "</tr>";
			}
			$("#tablebody").append(tbody);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//alert(XMLHttpRequest.status);
			//alert(XMLHttpRequest.readyState);
			//alert(textStatus);
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

//通过酒店名称模糊查询酒店信息
function query(){
	var hotelName = $("#hotelName").val();
	$.ajax({
		type : "post",
		data :{"hotelName":hotelName},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr>"
					+ "<td><label><input type='checkbox' checked='checked'><span></span></label></td>"
					+ "<td>" + obj[i].hotelName + "</td><td>" + obj[i].linkman + "</td>"
					+ "<td>" + obj[i].telphone + "</td><td>" + obj[i].phone + "</td>"
					+ "<td>" + obj[i].area + "</td><td>" + obj[i].address + "</td>	"
					+ "<td>" + obj[i].remark + "</td>"
					+ "</tr>";
			}
			$("#tablebody").append(tbody);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//alert(XMLHttpRequest.status);
			//alert(XMLHttpRequest.readyState);
			//alert(textStatus);
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}


//增加
function edit() {
	$(".modal").show();
}

//修改
function editSubmit() {
	$(".modal").find('label').each(function() {
		//console.log($(this).attr('for'));
		if ($(this).attr('for') == 'user') {
			$(this).css('color', '#ddd');
			$(this).children('input').attr("disabled", true);
			$(".modal").show();
		}
	})
}

//删除
function dele() {
	alert("删除")
}