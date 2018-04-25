/**
 * 酒店信息管理
 */

//init
$(function() {
	showHotelList();//加载酒店列表
});

//酒店列表
function showHotelList() {
	$.ajax({
		type : "post",
		url : "../../hotel/list",
		success : function(data) {
			var obj = eval(data);
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