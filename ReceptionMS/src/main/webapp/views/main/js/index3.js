//init
$(function() {
	showModule();
	$("#username").val(sessionStorage.username);
	$("#unick").val(sessionStorage.usernick);
});
//退出
function logout(){
		$.ajax({
			type : "post",
			url : "../../logout",
			success : function(data) {
				sessionStorage.username="";
				sessionStorage.usernick="";
//				alert(data);
				var flag = String($.trim(data));
				if (flag == "false") {
					location.href = "/ReceptionMS/views/login/login.html";
				} else {
					location.href = "/ReceptionMS/views/login/login.html";
				}
			},
			error : function(xhr, statue, error) {
				//console.log(error);
				location.href = "/ReceptionMS/views/login/login.html";
			},
			cache : false
		});
}
//修改个人信息
function updatePass() {
	var password = $("#password").val();
	var newpassword = $("#newpassword").val();
	if (password == "" || newpassword == "") {
		alert("密码不能为空");
		return flase;
	}
	if (password == newpassword) {
		alert("修改成功");
		$.ajax({
			type : "post",
			url : "../../user/updatePass",
			success : function(data) {},
			error : function(xhr, statue, error) {
				console.log(error);
			}
		});
	}else{
		alert("密码和确认密码不一致");
	}
}

//显示功能模块结构
function showModule() {
	console.time("showModule");
	$("#usernick").text(sessionStorage.usernick);
	$.ajax({
		type : "post",
		url : "../../module/show",
		success : function(data) {
			//console.log(data);
			if (data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					if (data[i].moduleParentId == '0') {
						$("#accordion").append(
							"<li name='" + data[i].moduleId + "'><div class=\"link\"><u class='"+data[i].icon+"'></u>" + data[i].moduleName + "<i class=\"fa fa-chevron-down\"></i></div></li>");
						var ul = '<ul class=\"submenu\">';
						for (var j = 0; j < data.length; j++) {
							if (data[j].moduleParentId == data[i].moduleId) {
								ul += "<li><a href='" + data[j].url + "'> <u class='"+data[j].icon+"'></u>" + data[j].moduleName + "</a></li>";
							}
						}
						ul += "</ul>";
						$("#accordion>li[name='" + data[i].moduleId + "']").append(ul);
					}

				}
			}
			var accordion = new Accordion($('#accordion'), false); // 导航 
			$(".submenu>li").on("click", function(e) { // 点击展示区
				var html = '';
				$(this).addClass("active").siblings("li").removeClass("active");
				//console.log($(this))
				e.preventDefault();
				//		li += "<li class='TabStyle' onclick='fn(this)'><span>"+$(this).text()+"</span> <b onclick='shut(this)'>X</b></li>";
				$('#Tab').html('<span>当前位置：</span><i>'+$(this).parent('ul').prev('.link').text()+'</i><i>&nbsp;/&nbsp;</i> <i>'+$(this).text()+'</i>')
				html = "<iframe src='" + $(this).children('a').attr('href') + "'></iframe>";
				$("#iframeBox").html(html);
			});
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	})
	console.timeEnd("showModule");
}

//显示功能模块
var Accordion = function(el, multiple) {
	this.el = el || {};
	this.multiple = multiple || false;

	// Variables privadas
	var links = this.el.find('.link');
	// Evento
	links.on('click', {
		el : this.el,
		multiple : this.multiple
	}, this.dropdown)
}

Accordion.prototype.dropdown = function(e) {
	var $el = e.data.el;
	$this = $(this),
	$next = $this.next();

	$next.slideToggle();
	$this.parent().toggleClass('open');

	if (!e.data.multiple) {
		$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
	}
}



