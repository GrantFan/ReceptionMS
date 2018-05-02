/**
 * 酒店信息管理
 */

//init
$(function() {
	showHotelList(1,5,1);//加载酒店列表
});

//酒店列表
function showHotelList(pageNum,pageSize,a) {
	$.ajax({
		type : "post",
		data :{
			 	"pageNum" :pageNum,
			 	"pageSize" : pageSize
			  },
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

			if (a == 1) {
				jqPaginator(5, 5, 1);
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
function add() {
	$(".modal").show();
}

//修改
function edit() {
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

//exportExcel
function exportExcel(){
	$.ajax({
		type : "post",
//		data :{
//			 	"pageNum" :pageNum,
//			 	"pageSize" : pageSize
//			  },
		url : "../../hotel/export",
		success : function(data) {
			alert(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//alert(XMLHttpRequest.status);
			//alert(XMLHttpRequest.readyState);
			//alert(textStatus);
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

//分页
function jqPaginator(pageSize, pages, a) {
	var pages = Number(pages);
	if (pages == 0) {
		pages = 1;
	}
	$.jqPaginator('#pagination', {
		totalPages : pages,
		//currentPage: 1,
		wrapper : '<ul class="pagination"></ul>',
		first : '<li class="first"><a href="javascript:void(0);">首页</a></li>',
		prev : '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
		next : '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
		last : '<li class="last"><a href="javascript:void(0);">尾页</a></li>',
		page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
		onPageChange : function(pageNumber) { // num为选择的页数
			if (a != 1) {
				showHotelList(pageNumber, pageSize);
			}
		}
	});
	a = a + 1;
}