/**
 * 用户设置
 */

//init
$(function() {
	showUserList(1, 10); 
});

//用户列表
function showUserList(pageNum, pageSize) {
	var pageSize = pageSize;
	$.ajax({
		type : "post",
		data : {
			"pageNum" : pageNum,
			"pageSize" : pageSize
		},
		url : "../../user/list",
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
					+ "<td><label><input onclick='singleCheck(this)' type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
					+ "<td>" + obj[i].userName + "</td><td>" + obj[i].userNick + "</td>"
					+ "<td><input type='hidden' value=\"" + obj[i].roleId + "\" >" + obj[i].roleName + "</td><td>" + obj[i].lastLoginComputer + "</td>"
					+ "<td>" + obj[i].lastLoginTime + "</td>"
					+ "<td>" + obj[i].createTime + "</td>"
					+ "<td>" + obj[i].modifyTime + "</td>"
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
					showUserList(currPage, 10);
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
	var userName = $("#input_userName").val();
	$.ajax({
		type : "post",
		data : {
			"userName" : userName
		},
		url : "../../user/list",
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
					+ "<td><label><input onclick='singleCheck(this)' type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
					+ "<td>" + obj[i].userName + "</td><td>" + obj[i].userNick + "</td>"
					+ "<td><input type='hidden' value=\"" + obj[i].roleId + "\" >" + obj[i].roleName + "</td><td>" + obj[i].lastLoginComputer + "</td>"
					+ "<td>" + obj[i].lastLoginTime + "</td>"
					+ "<td>" + obj[i].createTime + "</td>"
					+ "<td>" + obj[i].modifyTime + "</td>"
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
					showUserList(currPage, 10);
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
//单选设置
function singleCheck(check){
	$("input:checkbox[name=check]").not($(check)).attr("checked", false);
}

//加载角色列表
function loadRole(){
	$.ajax({
		url : '../../role/list',
		type : 'post',
		success : function(result) {
//			console.log(result);
			$("#role").empty();
			for(var i=0,len=result.length;i<len;i++){
				$("#role").append("<option value='"+result[i].id+"'>"+result[i].roleName+"</option>");
			}
		}
	});
}
//新增
function add() {
	$(".modal").show(500);
	$('#add').show();
	$('#update').hide(500);
	
	//重置表单
	$("#id").val("");
	$("#userName").val("");
	$("#userNick").val("");
	$("#password").val("");
	loadRole();
}
//新增提交
function addSubmit() {
	$.post("../../user/add",{
		userName : $("#userName").val(),
		userNick : $("#userNick").val(),
		password : $("#password").val(),
		roleId : $("#role").val()
	}, function(result) {
		$('.modal').hide();
		if(result=="true"){
			alert("添加成功");
			showUserList(sessionStorage.currPage, 10);
		}else if(result=="exist"){
			alert("用户名已存在");
		}else{
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
	$(".modal").show(500);
	$('#add').hide();
	$('#update').show(500);
	loadRole();
	$.get(
		'../../user/' + id,
		function(result) {
			var json = JSON.parse(result);
//			console.log(json);
			$("#id").val(json.id);
			$("#userName").val(json.userName);
			$("#userNick").val(json.userNick);
			$("#password").val("");
			$("#password").attr("placeholder","密码为空则不修改");
			
			for (var i = 0; i < $("#role option").length; i++) {
				if ($("#role option")[i].value == json.roleId) {
					$("#role option")[i].setAttribute("selected", true);
				}
			}
		}
	);
}
//修改提交
function editSubmit() {
	$.ajax({
		url : '../../user/update',
		type : 'post',
		data : {
			id : $("#id").val(),
			userName : $("#userName").val(),
			userNick : $("#userNick").val(),
			password : $("#password").val(),
			roleId : $("#role").val()
		},
		success : function(result) {
			//console.log(result);
			if (result == "true") {
				alert("修改成功");
				$('.modal').hide();
				showUserList(sessionStorage.currPage, 10);
			}else{
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
			url : '../../user/' + id,
			type : 'Delete',
			success : function(result) {
				if(result=="true"){
					alert("删除成功");
					showUserList(sessionStorage.currPage, 10);
				}else{
					alert("删除失败");
				}
				
			}
		})
	} else {
		return;
	}
}