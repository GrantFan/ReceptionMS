/**
 * 酒店对比js
 */

//init
$(function() {
	hotelShow(); //加载酒店列表
});

function hotelShow(input){
	//alert(hotelName);
	$.ajax({
		type : "post",
		data :{"hotelName":input},
		url : "../../hotel/listByName",
		success : function(data) {
			var obj = eval(data);
			//console.log(obj);
			$(".hotel").empty();
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
function loadContrastType(dic){
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
function contrastHotel(){
	if($("#type").val()=="dm_room_type") {
		$.ajax({
			type : "post",
			data : {
				"hotel_l" : $("#hotel_l") .val(),
				"hotel_r" : $("#hotel_r").val(),
				"roomType" : $("#contrast_type").val()
			},
			url : "../../room/roomType",
			success : function(data) {
				var json =  JSON.parse(data);
				var hotel_l = eval(json.hotel_l);
				var hotel_r = eval(json.hotel_r);
				//console.log(hotel_l);
				
				$("#ul_l").empty();
				for (var i = 0, len = hotel_l.length; i < len; i++) {
					$("#ul_l").append(
							"<li>"
							+"<u class=\"rooms\"></u>"
							+"<strong id=\"roomID\"><span>房间号：</span>"+hotel_l[i].roomNumber+"</strong>"
							+"<p class=\"JG\"><span>门市价：</span><b>"+hotel_l[i].rackPrice+"</b></p>"
							+"<p class=\"JG\"><span>协议价：</span><b>"+hotel_l[i].agreementPrice+"</b></p>"
							+"<p class=\"LC\"><span>楼层：</span><b>"+hotel_l[i].floor+"</b></p>"
							+"<p class=\"CX\"><span>朝向：</span><b>"+hotel_l[i].orientation+"</b></p>"
							+"<p class=\"CG\"><span>配套设施：</span><b>"+hotel_l[i].supportFacilities+"</b></p>"
							+"<p class=\"NX\"><span>内线电话：</span><b>"+hotel_l[i].innerlinePhone+"</b></p>"
							+"<p class=\"WX\"><span>外线电话：</span><b>"+hotel_l[i].outsidePhone+"</b></p>"
							+"</li>"
					);
				}
				
				$("#ol_r").empty();
				for (var i = 0, len = hotel_r.length; i < len; i++) {
					$("#ol_r").append(
							"<li>"
							+"<u class=\"rooms\"></u>"
							+"<strong id=\"roomID\"><span>房间号：</span>"+hotel_r[i].roomNumber+"</strong>"
							+"<p class=\"JG\"><span>门市价：</span><b>"+hotel_r[i].rackPrice+"</b></p>"
							+"<p class=\"JG\"><span>协议价：</span><b>"+hotel_r[i].agreementPrice+"</b></p>"
							+"<p class=\"LC\"><span>楼层：</span><b>"+hotel_r[i].floor+"</b></p>"
							+"<p class=\"CX\"><span>朝向：</span><b>"+hotel_r[i].orientation+"</b></p>"
							+"<p class=\"CG\"><span>配套设施：</span><b>"+hotel_r[i].supportFacilities+"</b></p>"
							+"<p class=\"NX\"><span>内线电话：</span><b>"+hotel_r[i].innerlinePhone+"</b></p>"
							+"<p class=\"WX\"><span>外线电话：</span><b>"+hotel_r[i].outsidePhone+"</b></p>"
							+"</li>"
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
}