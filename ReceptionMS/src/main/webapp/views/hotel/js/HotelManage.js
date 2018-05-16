/**
 * 酒店信息管理
 */

//init
$(function() {
	showHotelList(1, 10); //加载酒店列表
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
			//console.log(data);
			var json = JSON.parse(data);
			var obj = json.list;
			//console.log(obj);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr>"
					+ "<td><label><input type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
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
				totalPage : json.pages,
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
				isShowPageSizeOpt : false,
				//可选，是否展示跳到指定页数，默认true
				isShowSkip : true,
				//可选，是否展示刷新，默认true
				isShowRefresh : false,
				//可选，是否展示共{}页，默认true
				isShowTotalPage : true,
				//可选，是否需要重新设置当前页码及总页数，默认false，如果设为true，那么在请求服务器返回数据时，需要调用setPage方法
				isResetPage : false,
				//必选，回掉函数，返回参数：第一个参数为页码，第二个参数为每页显示N条
				callBack : function(currPage, pageSize) {
					sessionStorage.currPage = currPage;
					sessionStorage.pageSize = 10;
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
			//			console.log(obj);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr>"
					+ "<td><label><input type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
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

//加载所属行政区
function loadArea() {
	$.get('../../dic',
		{
			tableName : "dm_district"
		},
		function(result) {
			//console.log(result);
			$("#area").empty();
			for (var i = 0, len = result.length; i < len; i++) {
				$("#area").append(
					"<option value='" + result[i].value + "'>" + result[i].name + "</option>"
				);
			}
		}
	);
}
//新增
function add() {
	//重置表单
	$("#modal").show(500);
	$('#add').show();
	$('#update').hide(500);

	$("#hotel_name").val("");
	$("#linkman").val("");
	$("#telphone").val("");
	$("#phone").val("");
	$("#area").val("");
	$("#address").val("");
	$("#graph").val("");
	$("#remark").val("");
	loadArea();
}
//新增提交
function addSubmit() {
	$.post("../../hotel/add", {
		hotelName : $("#hotel_name").val(),
		linkman : $("#linkman").val(),
		telphone : $("#telphone").val(),
		phone : $("#phone").val(),
		area : $("#area option:selected").text(),
		address : $("#address").val(),
		planeGraph : $("#graph").val(),
		remark : $("#remark").val()
	}, function(result) {
		alert(result);
		$('#modal').hide();
		showHotelList(sessionStorage.currPage, sessionStorage.pageSize);
	}
	).error(function(a) {
		console.log(a);
	});
}

//修改
function edit() {
	if ($(":checkbox[name='check']:checked").length != 1) {
		alert("请选择一个选项！");
		return false;
	}
	var id;
	$(":checkbox[name='check']:checked").each(function() { //遍历
		id = $(this).val(); // 每一个被选中项的值
	});
	$("#modal_name").text("酒店信息修改");
	$("#modal").show(500);
	$('#add').hide();
	$('#update').show(500);

	$.get(
		'../../hotel/' + id,
		function(result) {
			var json = JSON.parse(result);
			//console.log(json);
			$("#id").val(json.id);
			$("#hotel_name").val(json.hotelName);
			$("#linkman").val(json.linkman);
			$("#telphone").val(json.telphone);
			$("#phone").val(json.phone);
			//$("#area").val(json.area);
			loadArea();
			$("#address").val(json.address);
			$("#graph").val(json.planeGraph);
			$("#remark").val(json.remark);
			getImage(id);
		}
	);
}
//修改提交
function editSubmit() {
	$.ajax({
		url : '../../hotel/update',
		type : 'post',
		data : {
			id : $("#id").val(),
			hotelName : $("#hotel_name").val(),
			linkman : $("#linkman").val(),
			telphone : $("#telphone").val(),
			phone : $("#phone").val(),
			area : $("#area option:selected").text(),
			address : $("#address").val(),
			planeGraph : $("#graph").val(),
			remark : $("#remark").val()
		},
		success : function(result) {
			console.log(result);
			if (result == "true") {
				alert("修改成功");
				$('#modal').hide();
				$("#modal_name").text("酒店信息");
				showHotelList(sessionStorage.currPage, sessionStorage.pageSize);
			} else {
				alert("修改失败");
			}
		}
	});
}

//删除
function dele() {
	if ($(":checkbox[name='check']:checked").length != 1) {
		alert("请选择一个选项！");
		return false;
	}
	var r = confirm("确定删除吗？");
	if (r == true) {
		var id;
		$(":checkbox[name='check']:checked").each(function() { //遍历
			id = $(this).val(); // 每一个被选中项的值
		});
		$.ajax({
			url : '../../hotel/' + id,
			type : 'Delete',
			success : function(result) {
				if (result == "true") {
					alert("删除成功");
					showHotelList(sessionStorage.currPage, sessionStorage.pageSize);
				} else {
					alert("删除失败");
				}

			}
		})
	} else {
		return;
	}
}

//exportExcel
function exportExcel() {
	location.href = '../../hotel/export';
}

function planeGraph() {
	if ($(":checkbox[name='check']:checked").length != 1) {
		alert("请选择一个选项！");
		return false;
	}
	var id;
	$(":checkbox[name='check']:checked").each(function() { //遍历
		id = $(this).val(); // 每一个被选中项的值
	});
	$("#graphModal").show(800);
	$("#hotelId").val(id);
	getImage(id);
}
/**
 * 获取图片
 */
function getImage(hotel) {
	$.ajax({
		url : '../../hotel_graph/selectImpByHotel',
		type : 'get',
		data : {
			"hotel" : hotel
		},
		success : function(result) {
			var list = eval("(" + result + ")");
//			$("#inmpage").text("1/"+list.length);
//			console.log(list)
			var info = $("#imageOver").empty();
			for (var i = 0; i < list.length; i++) {
				if (i == 0) {
					info.append('<li name=\"' + list[i].id + '\" class="block"><img src="' + list[i].graph_url + '" width="100%" height="100%" /><input value=\"'+list[i].graph_name+'\"></li>');
				} else {
					info.append('<li name=\"' + list[i].id + '\" class="none"><img src="' + list[i].graph_url + '" width="100%" height="100%" /><input value=\"'+list[i].graph_name+'\"></li>');
				}
			}
		},
		error : function() {
			alert("获取图片失败！");
		}
	})
}


/**
 * 上传图片
 */
function setImg(obj) { //用于进行图片上传，返回地址
	//获取当前用户id
	var f = $(obj).val();
	if (f == null || f == undefined || f == '') {
		return false;
	}
	if (!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)) {
		alert("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
		$(obj).val('');
		return false;
	}
	var data = new FormData();
	$.each($(obj)[0].files, function(i, file) {
		data.append('file', file);
	}),
	//截取图片名称
	data.append("graph_name", f.substring(f.lastIndexOf("\\") + 1, f.lastIndexOf(".")));
	//关联酒店id
	data.append("hotel", $("#hotelId").val());
	$.ajax({
		type : "POST",
		url : "/ReceptionMS/hotel_graph/uploadImg",
		data : data,
		cache : false,
		contentType : false, //不可缺
		processData : false, //不可缺
		dataType : "json",
		success : function(suc) {
			if (suc.code == 0) {
				// $("#thumbUrl").val(suc.message);//将地址存储好
//				var graphId = $("#imageOver li.block>img").attr("src",suc.message);
//				 $("#thumburlShow").attr("src",suc.message);//显示图片        
				alert("上传成功");
				getImage($("#hotelId").val());
			} else {
				alertLayel("上传失败");
				$("#url").val("");
				$(obj).val('');
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("上传失败，请检查网络后重试");
			$("#url").val("");
			$(obj).val('');
		}
	});
}

function delImg() {
	var graphId = $("#imageOver li.block").attr("name");
	console.log(graphId);
	$.ajax({
		type : "GET",
		url : "/ReceptionMS/hotel_graph/deleetImpById",
		data : {
			"id" : graphId
		},
		dataType : "json",
		success : function(suc) {
//			alert(suc)
			if (suc) {
				alert("删除成功");
				getImage($("#hotelId").val());
			//$("#thumburlShow").attr("src","");//显示图片        
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {}
	});
}

//打印
function print(){
  var img = $("#imageOver li.block img");
  var newImg = document.createElement("img");  
  newImg.src = img[0].src;  
  var printWindow = window.open(newImg.src);  
  printWindow.document.write('<img src="'+newImg.src+'" />')  
  printWindow.print();  
}