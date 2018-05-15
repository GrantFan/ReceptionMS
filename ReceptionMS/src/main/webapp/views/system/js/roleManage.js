/**
 * 角色设置
 */

//init
$(function() {
	showRoleList(1, 10);
//	showModule();
});

function showRoleList(pageNum, pageSize) {
	var pageSize = pageSize;
	$.ajax({
		type : "post",
		data : {
			"pageNum" : pageNum,
			"pageSize" : pageSize
		},
		url : "../../role/listByName",
		success : function(data) {
			//			console.log(json);
			var json = JSON.parse(data);
			var obj = json.list;
			//console.log(obj);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr>"
					+ "<td><label><input type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
					+ "<td>" + obj[i].roleName + "</td><td>" + obj[i].description + "</td><td></td>"
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
				totalPageText : '共{json.pages}页',
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
				callBack : function(currPage) {
					sessionStorage.currPage = currPage;
					sessionStorage.pageSize = pageSize;
					showUserList(currPage, pageSize);
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

function query() {
	var roleName = $("#input_roleName").val();
	$.ajax({
		type : "post",
		data : {
			"roleName" : roleName
		},
		url : "../../role/listByName",
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
					+ "<td>" + obj[i].roleName + "</td><td>" + obj[i].description + "</td>"
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
				totalPageText : '共{json.pages}页',
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
				callBack : function(currPage) {
					sessionStorage.currPage = currPage;
					sessionStorage.pageSize = 10;
					showRoleList(currPage, 10);
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

//全选 反选
function toggle(checkbox){
	var check = $(checkbox).prop("checked");
	var subChecks = $(checkbox).parent().parent().parent().find("ul").find("input.module");
	for(var i=0;i<subChecks.length;i++){
		$(subChecks[i]).prop("checked",check);
	}
}
//显示功能模块结构
function showModule() {
	$.ajax({
		type : "post",
		url : "../../module/show",
		success : function(data) {
			//console.log(data);
			$("#accordion").empty();
			if (data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					if (data[i].moduleParentId == '0') {
						$("#accordion").append(
							"<li name='" + data[i].moduleId + "'><div class=\"link\"><span class=\"lt\">" + data[i].moduleName + "</span><label class=\"rt\"><input onchange='toggle(this)' type=\"checkbox\" class=\"module\" value='" + data[i].moduleId + "'><u class=\"top_1\"></u></label></div></li>");
						var ul = '<ul class=\"submenu\" style=\"display:block;\">';
						for (var j = 0; j < data.length; j++) {
							if (data[j].moduleParentId == data[i].moduleId) {
								ul += "<li class=\"overflow\"><span class=\"lt\">" + data[j].moduleName + "</span><label class=\"rt\"><input type=\"checkbox\" class=\"module\" value='" + data[j].moduleId + "'><u class=\"top_06\"></u></label></li>";
							}
						}
						ul += "</ul>";
						$("#accordion>li[name='" + data[i].moduleId + "']").append(ul);
					}

				}
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

function setRoleModule() {
	if ($(":checkbox[name='check']:checked").length != 1) {
		alert("请选择一个选项！");
		return false;
	}
	var id;
	$(":checkbox[name='check']:checked").each(function() { //遍历
		id = $(this).val().trim(); // 每一个被选中项的值
	});
	//	alert(id);
	
	showModule();
	$.get('../../role/' + id,
		function(result) {
			var json = JSON.parse(result);
			//				console.log(json);
			$("#roleId").val(json.id);
			$("#r_roleName").val(json.description);
			$("#r_description").val(json.roleName);

		}
	);
	$("#module").show(800);
	
	$.ajax({
		url : '../../role/selectRoleModule',
		type : 'post',
		data : {
			roleId : id
		},
		success : function(result) {
//			console.log(result);
			var checkArr = $(".module");
//			console.log(checkArr);
			for (var i = 0; i <result.length; i++) {
				for (var j = 0; j <checkArr.length; j++) {
					if (checkArr[j].value == result[i].module_id) {
						checkArr[j].checked="true";
					}
				}
			}
		}
	});
}

function setModuleSubmit() {
	var moduleId="";
	var checkArr = $(".module:checked");	
	for (var j = 0; j <checkArr.length; j++) {
		if(j==(checkArr.length-1)){
			moduleId += checkArr[j].value;
		}else{
			moduleId += checkArr[j].value+',';
		}
	}
//	console.log(moduleId);
	$.ajax({
		url : '../../role/setRoleModule',
		type : 'post',
		data : {
			"menuIds":moduleId,
			"roleId":$("#roleId").val()
		},
		success:function(data){
			if(data=="true"){
				alert("分配成功");
				$('.modal').hide();
			}else{
				alert("分配失败");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			//console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}
//新增
function add() {
	$("#modal").show(500);
	$('#add').show();
	$('#update').hide(500);

	//重置表单
	$("#roleName").val("");
	$("#description").val("");
	$("#id").val("");
}
//新增提交
function addSubmit() {
	$.post("../../role/add", {
		roleName : $("#roleName").val(),
		description : $("#description").val(),
	}, function(result) {
		if (result == "true") {
			$('.modal').hide();
			alert("添加成功");
			showRoleList(sessionStorage.currPage, 10);
		} else {
			alert("添加失败");
		}
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
	$("#modal").show(500);
	$('#add').hide();
	$('#update').show(500);
	$.get(
		'../../role/' + id,
		function(result) {
			var json = JSON.parse(result);
			//			console.log(json);
			$("#id").val(json.id);
			$("#description").val(json.description);
			$("#roleName").val(json.roleName);

		}
	);
}
//修改提交
function editSubmit() {
	$.ajax({
		url : '../../role/update',
		type : 'post',
		data : {
			id : $("#id").val(),
			roleName : $("#roleName").val(),
			description : $("#description").val()
		},
		success : function(result) {
			//console.log(result);
			if (result == "true") {
				alert("修改成功");
				$('.modal').hide();
				showRoleList(sessionStorage.currPage, 10);
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
			url : '../../role/' + id,
			type : 'Delete',
			success : function(result) {
				if (result == "true") {
					alert("删除成功");
					showRoleList(sessionStorage.currPage, 10);
				} else {
					alert("删除失败");
				}

			}
		})
	} else {
		return;
	}
}