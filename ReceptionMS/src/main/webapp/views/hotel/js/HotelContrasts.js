/**
 * 酒店对比js
 */

//init
$(function() {
	hotelShow(); //加载酒店列表
});

function hotelShow(input) {
	//alert(hotelName);
	$.ajax({
		type : "post",
		data : {
			"hotelName" : input
		},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$(".hotel").empty();
			//			$(".hotel").append(
			//			"<option value=''>-----请选择酒店-----</option>"
			//			);
			for (var i = 0, len = obj.length; i < len; i++) {
				$(".hotel").append(
					"<option value='" + obj[i].id + "'>" + obj[i].hotelName + "</option>"
				);
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

//加载对比类型
function loadContrastType(dic) {
	//	console.log(dic)
	$.get('../../dic',
		{
			tableName : dic
		},
		function(result) {
			//console.log(result);
			$("#contrast_type").empty();
			for (var i = 0, len = result.length; i < len; i++) {
				$("#contrast_type").append(
					"<option value='" + result[i].value + "'>" + result[i].name + "</option>"
				);
			}
		}
	);
}

//对比
function contrastHotel() {
	if ($("#type").val() != "") {
		if ($("#type").val() == "dm_room_type") {
			$.ajax({
				type : "post",
				data : {
					"hotel_l" : $("#hotel_l option:selected").text(),
					"hotel_r" : $("#hotel_r option:selected").text(),
					"roomType" : $("#contrast_type option:selected").text()
				},
				url : "../../room/roomType",
				success : function(data) {
					var json = JSON.parse(data);
					var hotel_l = eval(json.hotel_l);
					var hotel_r = eval(json.hotel_r);
					$(".tab>.fruit .lt>strong").text($('#hotel_l option:selected').text());
					$(".tab>.fruit .rt>strong").text($('#hotel_r option:selected').text());
					$("#ul_l").empty();
					for (var i = 0, len = hotel_l.length; i < len; i++) {
						$("#ul_l").append(
							"<li>"
							+ "<u class=\"rooms\"></u>"
							+ "<strong id=\"roomID\"><span class=\"webkit\">房间号：</span><b class=\"webkit\">" + hotel_l[i].roomNumber + "</b></strong>"
							+ "<p class=\"JG\"><span class=\"webkit\">门市价：</span><b class=\"webkit\">" + hotel_l[i].rackPrice + "/天</b></p>"
							+ "<p class=\"CX\"><span class=\"webkit\">协议价：</span><b class=\"webkit\">" + hotel_l[i].agreementPrice + "/天</b></p>"
							+ "<p class=\"CG\"><span class=\"webkit\">朝向：</span><b class=\"webkit\">" + hotel_l[i].orientation + "</b></p>"
							+ "</li>"
						);
					}

					$("#ol_r").empty();
					for (var i = 0, len = hotel_r.length; i < len; i++) {
						$("#ol_r").append(
							"<li>"
							+ "<u class=\"rooms\"></u>"
							+ "<strong id=\"roomID\"><span class=\"webkit\">房间号：</span><b class=\"webkit\">" + hotel_r[i].roomNumber + "</b></strong>"
							+ "<p class=\"JG\"><span class=\"webkit\">门市价：</span><b class=\"webkit\">" + hotel_r[i].rackPrice + "/天</b></p>"
							+ "<p class=\"CX\"><span class=\"webkit\">协议价：</span><b class=\"webkit\">" + hotel_r[i].agreementPrice + "/天</b></p>"
							+ "<p class=\"CG\"><span class=\"webkit\">朝向：</span><b class=\"webkit\">" + hotel_r[i].orientation + "</b></p>"
							+ "</li>"
						);
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
	} else {
		alert("请选择比较类型~");
	}
}

//打印
function print() {
	var canvas = document.getElementById("mycanvas");
	console.log(canvas);
	var dataUrl = canvas.toDataURL();
	var newImg = document.createElement("img");
	newImg.src = dataUrl;
	var printWindow = window.open(newImg.src);
	printWindow.document.write('<img src="' + newImg.src + '" />')
	printWindow.print();
}
//打印预览
function doprint(id) {
	html2canvas(document.querySelector("#" + id)).then(canvas => {
		canvas.id = "mycanvas";
		//				document.body.appendChild(canvas);
		$("#img").empty();
		$("#img").append(canvas)
		$("#printModal").show(800);
	});
}

//打印
function printHtml(){
	bdhtml = window.document.body.innerHTML;  
	sprnstr = "<!--startprint-->";  
	eprnstr = "<!--endprint-->";  
	prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17);  
	prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));  
	var style = "<head><style></style></head>";
	var newWin = window.open('', '', '');
	newWin.document.write(style);
	newWin.document.write(prnhtml);
	newWin.print();
}