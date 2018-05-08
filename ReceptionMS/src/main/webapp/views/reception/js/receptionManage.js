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
					+ "<td><label><input type=\"Checkbox\" name='check' value=\"" + obj[i].id + "\" ><u></u></label></td>"
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


function view(tr){
	$(".modal").show();
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
			console.log(reception);
			console.log(meals);
			console.log(accommodation);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("ERROR:" + XMLHttpRequest.status, XMLHttpRequest.readyState, textStatus);
		}
	})
}

function edit() {
	$(".modal").show();
	$("#update").show();
	$("#print").hide();
	
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