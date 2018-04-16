//init
$(function() {
	showModule(); //显示功能模块
})

//显示功能模块结构
function showModule() {
	$.ajax({
		type : "post",
		url : "../module/show",
		success : function(data) {
			console.log(data);
			if (data.length > 0) {
				$("#accordion").empty();
				var li = "";
				var ul = "<ul class=\"submenu\">";
				for (var i = 0; i < data.length; i++) {
					if (data[i].moduleParentId == '0') {
						li += "<li name='" + data[i].moduleId + "'><div class=\"link\">" + data[i].moduleName + "<i class=\"fa fa-chevron-down\"></i></div></li>";
						$("#accordion").html(li);
					//console.log($("#accordion>li[name='"+ data[i].moduleId + "']"));
					}
					for (var j = 0; j < data.length; j++) {
						if (data[j].moduleParentId == data[i].moduleId) {
							console.log(data[j].moduleParentId,data[i].moduleId);
							$("#accordion>li[name='"+ data[i].moduleId + "']").append("<ul class=\"submenu\"><li><a href='" + data[j].url + "' class=\"active\">" + data[j].moduleName + "</a></li></ul>");
						}
					}
				
				}
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	})
}

// iframe    .load($(this).children('a').attr('href'))
$(".submenu>li").on("click", function(e) {
	$(this).addClass("active").siblings("li").removeClass("active");
	aText = $(this);
	e.preventDefault();
	//		li += "<li class='TabStyle' onclick='fn(this)'><span>"+$(this).text()+"</span> <b onclick='shut(this)'>X</b></li>";
	html = "<iframe src='" + $(this).children('a').attr('href') + "'></iframe>";

	$("#right>#iframeBox").html(html);

});


$(function() {
	// 导航
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
		;
	}

	var accordion = new Accordion($('#accordion'), false);

});

// 增加
function add() {
	$(".modal").show();
}

// 修改
function edit() {
	$(".modal").find('label').each(function() {
		console.log($(this).attr('for'));
		if ($(this).attr('for') == 'user') {
			$(this).css('color', '#ddd');
			$(this).children('input').attr("disabled", true);
			$(".modal").show();
		}
	})
}

// 删除
function dele() {
	alert("删除")
}

// 重置密码
function resetting() {
	alert("确定要重置为 123456吗？")
}

// 关闭
//function shut(a){	
//	$(a).parent().parent().next().find("iframe")[$(a).parent().index()].remove();
//  $(a).parent().remove();
// 	
// 	li -= "<li class='TabStyle'><span>"+aText.text()+"</span> <b onclick='shut(this)'>X</b></li>";
//	html -= "<div class='iframe'>"+aText.text()+"</div>";	
//	n -= 1;
//	console.log(n);	 
//}