/**
 * 接待信息管理
 */

//init
$(function() {
	showReceptionList(1,5);//加载接待信息列表
});

//接待信息列表
function showReceptionList(pageNum, pageSize) {
	$.ajax({
		type : "post",
		data : {
			"pageNum" : pageNum,
			"pageSize" : pageSize
		},
		url : "../../recep/list",
		success : function(data) {
			var json = JSON.parse(data);
			var obj = json.list;
			//console.log(data);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr ondblclick=\"view(this)\">"
					+ "<td><label><input type=\"Checkbox\" name='check' value='" + obj[i].receptionNumber + "' /><u></u></label></td>"
					+ "<td class='number'>" + obj[i].receptionNumber + "</td><td>" + obj[i].receptionTitle + "</td>"
					+ "<td>" + obj[i].receptionDate + "</td><td>" + obj[i].receptionPerson + "</td>"
					+ "<td>" + obj[i].receptionPrinter + "</td><td>" + obj[i].guestName + "</td>	"
					+ "<td>" + obj[i].entourage + "</td>" + "</td><td>" + obj[i].guestNum + "</td>	"
					+ "<td>" + obj[i].receptionNum + "</td>" + "</td><td>" + obj[i].receptionDays + "</td>	"
					+ "<td>" + obj[i].hotel + "</td>" + "</td><td>" + obj[i].description + "</td>	"
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
				isShowRefresh : true,
				//可选，是否展示共{}页，默认true
				isShowTotalPage : true,
				//可选，是否需要重新设置当前页码及总页数，默认false，如果设为true，那么在请求服务器返回数据时，需要调用setPage方法
				isResetPage : false,
				//必选，回掉函数，返回参数：第一个参数为页码，第二个参数为每页显示N条
				callBack : function(currPage, pageSize) {
					sessionStorage.currPage = currPage;
					sessionStorage.pageSize = pageSize;
					showReceptionList(currPage, pageSize);
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

function search(pageNum,pageSize){
	var input_hotel = $("#input_hotel").val();
	var input_receptionTitle= $("#input_receptionTitle").val();
	var input_receptionDate= $("#input_receptionDate").val();
	
	$.ajax({
		type : "post",
		data : {
			"pageNum" : pageNum,
			"pageSize" : pageSize,
			"hotel" : input_hotel ,
			"receptionTitle" :input_receptionTitle,
			"receptionDate" :input_receptionDate
		},
		url : "../../recep/search",
		success : function(json) {
			var obj = json.list;
//			console.log(obj);
			$("#tablebody").empty();
			var tbody = "";
			for (i = 0, len = obj.length; i < len; i++) {
				//console.log(obj[i]);
				tbody += "<tr ondblclick=\"view(this)\">"
					+ "<td><label><input type=\"Checkbox\" name='check' value='" + obj[i].receptionNumber + "' ><u></u></label></td>"
					+ "<td class='number'>" + obj[i].receptionNumber + "</td><td>" + obj[i].receptionTitle + "</td>"
					+ "<td>" + obj[i].receptionDate + "</td><td>" + obj[i].receptionPerson + "</td>"
					+ "<td>" + obj[i].receptionPrinter + "</td><td>" + obj[i].guestName + "</td>	"
					+ "<td>" + obj[i].entourage + "</td>" + "</td><td>" + obj[i].guestNum + "</td>	"
					+ "<td>" + obj[i].receptionNum + "</td>" + "</td><td>" + obj[i].receptionDays + "</td>	"
					+ "<td>" + obj[i].hotel + "</td>" + "</td><td>" + obj[i].description + "</td>	"
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
					search(currPage, pageSize);
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

function view(tr){
	$(".modal").show(500);
	$("#update").hide();
	$("#print").show();
	
	var number = $(tr).find("td.number").text().trim();
	//console.log(number)
	$.ajax({
		type : "post",
		data :{"receptionNumber":number},
		url : "../../recep/recordInfo",
		success : function(data) {
			var json = JSON.parse(data);
			var reception = eval(json.reception);
			var meals = eval(json.meals);
			var accommodation = eval(json.accommodation);
//			console.log(reception);
//			console.log(meals);
//			console.log(accommodation);
			
			//接待信息
			$("#receptionNumber").val(reception.receptionNumber);
			$("#receptionTitle").val(reception.receptionTitle);
			$("#receptionDate").val(reception.receptionDate);
			$("#receptionPerson").val(reception.receptionPerson);
			$("#receptionPrinter").val(reception.receptionPrinter);
			$("#guestName").val(reception.guestName);
			$("#entourage").val(reception.entourage);
			$("#receptionNum").val(reception.receptionNum);
			$("#receptionDays").val(reception.receptionDays);
			$("#guestNum").val(reception.guestNum);
			$("#hotel").val(reception.hotel);
			$("#description").val(reception.description);
			$("#recordTime").val(reception.recordTime);
			$("#remark").val(reception.remark);
			//用餐记录显示
			$("#table1").empty();
			for(var i=0,len=meals.length;i<len;i++){
				$("#table1").append("<tr><input type=\"hidden\" value='"+meals[i].id+"' />"
								+"<td>"+meals[i].hotel+"</td>"
								+"<td>"+meals[i].menuNumber+"</td>"
								+"<td>"+meals[i].mealsTime+"</td>"
								+"<td>"+meals[i].hobby+"</td>"
								+"<td>"+meals[i].recordTime+"</td>"
								+"<td>"+meals[i].remark+"</td>"
								+"<td></td>"
								+"</tr>");
			}
			//住房记录显示
			$("#table2").empty();
			for(var i=0,len=accommodation.length;i<len;i++){
				$("#table2").append("<tr><input type=\"hidden\" value='"+accommodation[i].id+"' />"
								+"<td>"+accommodation[i].hotel+"</td>"
								+"<td>"+accommodation[i].roomNumber+"</td>"
								+"<td>"+accommodation[i].checkinTime+"</td>"
								+"<td>"+accommodation[i].checkoutTime+"</td>"
								+"<td>"+accommodation[i].hobby+"</td>"
								+"<td>"+accommodation[i].recordTime+"</td>"
								+"<td>"+accommodation[i].remark+"</td>"
								+"<td></td>"
								+"</tr>");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

function edit() {
	if ($(":checkbox[name='check']:checked").length != 1) {
		alert("请选择一个选项！");
		return false;
	}
	var number;
	$(":checkbox[name='check']:checked").each(function() { //遍历
		number = $(this).val(); // 每一个被选中项的值
	});
	$(".modal").show(500);
	$("#update").show();
	$("#print").hide();
	
	$.ajax({
		type : "post",
		data :{"receptionNumber":number},
		url : "../../recep/recordInfo",
		success : function(data) {
			var json = JSON.parse(data);
			var reception = eval(json.reception);
			var meals = eval(json.meals);
			var accommodation = eval(json.accommodation);
//			console.log(reception);
//			console.log(meals);
//			console.log(accommodation);
			
			//接待信息
			$("#receptionNumber").val(reception.receptionNumber);
			$("#receptionTitle").val(reception.receptionTitle);
			$("#receptionDate").val(reception.receptionDate);
			$("#receptionPerson").val(reception.receptionPerson);
			$("#receptionPrinter").val(reception.receptionPrinter);
			$("#guestName").val(reception.guestName);
			$("#entourage").val(reception.entourage);
			$("#receptionNum").val(reception.receptionNum);
			$("#receptionDays").val(reception.receptionDays);
			$("#guestNum").val(reception.guestNum);
			$("#hotel").val(reception.hotel);
			$("#description").val(reception.description);
			$("#recordTime").val(reception.recordTime);
			$("#remark").val(reception.remark);
			//用餐记录
			$("#table1").empty();
			for(var i=0,len=meals.length;i<len;i++){
				$("#table1").append("<tr><input type=\"hidden\" value='"+meals[i].id+"' />"
								+"<td><input class='hotel' value='"+meals[i].hotel+"' /></td>"
								+"<td><input class='menuNumber' value='"+meals[i].menuNumber+"' /></td>"
								+"<td><input class='mealsTime' value='"+meals[i].mealsTime+"' /></td>"
								+"<td><input class='hobby' value='"+meals[i].hobby+"' /></td>"
								+"<td><input class='recordTime' value='"+meals[i].recordTime+"' /></td>"
								+"<td><input class='remark' value='"+meals[i].remark+"' /></td>"
								+"<td><button onclick='mealsUpdate(this)'>保存</button><button onclick='mealsDelete(this)'>删除</button></td>"
								+"</tr>");
			}
			//住房记录
			$("#table2").empty();
			for(var i=0,len=accommodation.length;i<len;i++){
				$("#table2").append("<tr><input type=\"hidden\" value='"+accommodation[i].id+"' />"
								+"<td><input class='hotel' value='"+accommodation[i].hotel+"' /></td>"
								+"<td><input class='roomNumber' value='"+accommodation[i].roomNumber+"' /></td>"
								+"<td><input class='checkinTime' value='"+accommodation[i].checkinTime+"' /></td>"
								+"<td><input class='checkoutTime' value='"+accommodation[i].checkoutTime+"' /></td>"
								+"<td><input class='hobby' value='"+accommodation[i].hobby+"' /></td>"
								+"<td><input class='recordTime' value='"+accommodation[i].recordTime+"' /></td>"
								+"<td><input class='remark' value='"+accommodation[i].remark+"' /></td>"
								+"<td><button onclick='accomUpdate(this)'>保存</button><button onclick='accomDelete(this)'>删除</button></td>"
								+"</tr>");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

//修改
function editSubmit() {
	$.ajax({
		url : '../../recep/update',
		type : 'post',
		data : {
			receptionNumber: $("#receptionNumber").val(),
			receptionTitle: $("#receptionTitle").val(),
			receptionDate : $("#receptionDate").val(),
			receptionPerson : $("#receptionPerson").val(),
			receptionPrinter : $("#receptionPrinter").val(),
			guestName : $("#guestName").val(),
			entourage : $("#entourage").val(),
			guestNum : $("#guestNum").val(),
			receptionNum : $("#receptionNum").val(),
			receptionDays : $("#receptionDays").val(),
			hotel : $("#hotel").val(),
			description : $("#description").val(),
			remark : $("#remark").val()
		},
		success : function(result) {
			console.log(result);
			if (result == "true") {
				alert("修改成功");
				$('.modal').hide();
				showReceptionList(sessionStorage.currPage, sessionStorage.pageSize);
			}else{
				alert("修改失败");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
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
		var number;
		$(":checkbox[name='check']:checked").each(function() { //遍历
			number = $(this).val(); // 每一个被选中项的值
		});
		$.ajax({
			url : '../../recep/' + number,
			type : 'Delete',
			success : function(result) {
				if(result=="true"){
					alert("删除成功");
					showReceptionList(sessionStorage.currPage, sessionStorage.pageSize);
				}else{
					alert("删除失败");
				}
				
			}
		})
	} else {
		return;
	}
}

function mealsUpdate(button){
	var id = $(button).parent().siblings("input").val();
	var hotel = $(button).parent().siblings("td").find("input.hotel").val();
	var menuNumber = $(button).parent().siblings("td").find("input.menuNumber").val();
	var mealsTime =$(button).parent().siblings("td").find("input.mealsTime").val();
	var hobby = $(button).parent().siblings("td").find("input.hobby").val();
	var recordTime = $(button).parent().siblings("td").find("input.recordTime").val();
	var remark =$(button).parent().siblings("td").find("input.remark").val();
//	console.log(id,hotel,menuNumber,mealsTime,hobby,recordTime,remark)
	
	$.ajax({
		url : '../../meals/update',
		type : 'post',
		data : {
			id: id,
			hotel: hotel,
			menuNumber : menuNumber,
			mealsTime : mealsTime,
			hobby : hobby,
			recordTime :recordTime,
			remark : remark
		},
		success : function(result) {
			console.log(result);
			if (result == "true") {
				alert("修改成功");
				edit();
			}else{
				alert("修改失败");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	});
}
function mealsDelete(button){
	var id = $(button).parent().siblings("input").val();
	var r = confirm("确定删除吗？");
	if (r == true) {
		$.ajax({
			url : '../../meals/' + id,
			type : 'Delete',
			success : function(result) {
				if(result=="true"){
					alert("删除成功");
					edit();
				}else{
					alert("删除失败");
				}
				
			}
		})
	} else {
		return;
	}
}

function accomUpdate(button){
	var id = $(button).parent().siblings("input").val();
	var hotel = $(button).parent().siblings("td").find("input.hotel").val();
	var roomNumber = $(button).parent().siblings("td").find("input.roomNumber").val();
	var checkinTime =$(button).parent().siblings("td").find("input.checkinTime").val();
	var checkoutTime =$(button).parent().siblings("td").find("input.checkoutTime").val();
	var hobby = $(button).parent().siblings("td").find("input.hobby").val();
	var recordTime = $(button).parent().siblings("td").find("input.recordTime").val();
	var remark =$(button).parent().siblings("td").find("input.remark").val();
//	console.log(id,hotel,menuNumber,mealsTime,hobby,recordTime,remark)
	
	$.ajax({
		url : '../../accom/update',
		type : 'post',
		data : {
			id: id,
			hotel: hotel,
			roomNumber : roomNumber,
			checkinTime : checkinTime,
			checkoutTime : checkoutTime,
			hobby : hobby,
			recordTime :recordTime,
			remark : remark
		},
		success : function(result) {
			console.log(result);
			if (result == "true") {
				alert("修改成功");
				edit();
			}else{
				alert("修改失败");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	});
}
function accomDelete(button){
	var id = $(button).parent().siblings("input").val();
	var r = confirm("确定删除吗？");
	if (r == true) {
		$.ajax({
			url : '../../accom/' + id,
			type : 'Delete',
			success : function(result) {
				if(result=="true"){
					alert("删除成功");
					edit();
				}else{
					alert("删除失败");
				}
				
			}
		})
	} else {
		return;
	}
}