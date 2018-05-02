/**
 * 酒店信息管理
 */

//init
$(function() {
	showHotelList(1, 5); //加载酒店列表
});

//酒店列表
function showHotelList(pageNum, pageSize) {
	$.ajax({
		type : "post",
		data : {
			"pageNum" : pageNum,
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
					+ "<td><label><input type=\"Checkbox\" name=\"" + obj[i].id + "\" ><u></u></label></td>"
					+ "<td>" + obj[i].hotelName + "</td><td>" + obj[i].linkman + "</td>"
					+ "<td>" + obj[i].telphone + "</td><td>" + obj[i].phone + "</td>"
					+ "<td>" + obj[i].area + "</td><td>" + obj[i].address + "</td>	"
					+ "<td>" + obj[i].remark + "</td>"
					+ "</tr>";
			}
			$("#tablebody").append(tbody);
			//分页
			$("#page").whjPaging({
				//可选，每页显示条数下拉框，默认下拉框5条/页(默认)、10条/页、15条/页、20条/页
				pageSizeOpt : [
					{
						'value' : 5,
						'text' : '5条/页',
						'selected' : true
					},
					{
						'value' : 10,
						'text' : '10条/页'
					},
					{
						'value' : 15,
						'text' : '15条/页'
					},
					{
						'value' : 20,
						'text' : '20条/页'
					}
				],
				//可选，css设置，可设置值：css-1，css-2，css-3，css-4，css-5，默认css-1，可自定义样式
				css : 'css-1',
				//可选，总页数
				totalPage : 5,
				//可选，展示页码数量，默认5个页码数量
				showPageNum : 5,
				//可选，首页按钮展示文本，默认显示文本为首页
				firstPage : '首页',
				//可选，上一页按钮展示文本，默认显示文本为上一页
				previousPage : '上一页',
				//可选，下一页按钮展示文本，默认显示文本为下一页
				nextPage : '下一页',
				//可选，尾页按钮展示文本，默认显示文本为尾页
				lastPage : '尾页',
				//可选，跳至展示文本，默认显示文本为跳至
				skip : '跳至',
				//可选，确认按钮展示文本，默认显示文本为确认
				confirm : '确认',
				//可选，刷新按钮展示文本，默认显示文本为刷新
				refresh : '刷新',
				//可选，共{}页展示文本，默认显示文本为共{}页，其中{}会在js具体转化为数字
				totalPageText : '共{}页',
				//可选，是否展示首页与尾页，默认true
				isShowFL : true,
				//可选，是否展示每页N条下拉框，默认true
				isShowPageSizeOpt : true,
				//可选，是否展示跳到指定页数，默认true
				isShowSkip : true,
				//可选，是否展示刷新，默认true
				isShowRefresh : true,
				//可选，是否展示共{}页，默认true
				isShowTotalPage : true,
				//可选，是否需要重新设置当前页码及总页数，默认false，如果设为true，那么在请求服务器返回数据时，需要调用setPage方法
				isResetPage : false,
				//必选，回掉函数，返回参数：第一个参数为页码，第二个参数为每页显示N条
				callBack : function(currPage, pageSize) {
					sessionStorage.currPage = currPage;
					sessionStorage.pageSize = pageSize;
					showHotelList(currPage, pageSize);
				}
			});
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
function query() {
	var hotelName = $("#hotelName").val();
	$.ajax({
		type : "post",
		data : {
			"hotelName" : hotelName
		},
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
	$(".modal").show(500);
}
function addSubmit() {
	$.post("../../hotel/add", {
		hotelName : $("#hotel_name").val(),
		linkman : $("#linkman").val(),
		telphone : $("#telphone").val(),
		phone : $("#phone").val(),
		area : $("#area").val(),
		address : $("#address").val(),
		graph : $("#graph").val(),
		remark : $("#remark").val()
	}, function(result) {
		$('.modal').hide();
		showHotelList(sessionStorage.currPage, sessionStorage.pageSize);
	}
	).error(function(a) {
		console.log(a);
	});
}

//修改
function edit() {
	$(".modal").show(500);
	$('#add').hide();
	$('#update').show(500);

	var id = "11";
	$.get(
		'../../hotel/select/' + id,
		function(result) {
			$("#modal_name").text("酒店信息修改");
			$("#id").val(result.id);
		}
	);
}
function editSubmit() {
	$.ajax({
		url : '../../hotel/update',
		type : 'Put',
		data : {
			id : $("#id").val(),
			conference_name : $("#conference_name").val(),
			hotel : $("#hotel").val(),
			type : $("#type").val(),
			position : $("#position").val(),
			capacity_num : $("#capacity_num").val(),
			remark : $("#remark").val()
		},
		success : function(result) {
			if (result == true) {
				$('.modal').hide(500);
				$('#add').show();
				$('#update').hide(500);
				$("#modal_name").text("会议室新增");
				load_conferenceInfo(sessionStorage.currPage, sessionStorage.pageSize);
			}
		}
	});
}

//删除
function dele() {
	alert("确定删除？");
	var id = "1525189228436";
	$.ajax({
		url : '../../hotel/delete/' + id,
		type : 'Delete',
		success : function(result) {
			alert(result);
		}
	})
}

//exportExcel
function exportExcel() {
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