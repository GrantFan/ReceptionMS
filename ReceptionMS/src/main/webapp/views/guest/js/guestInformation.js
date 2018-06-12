$(function(){
    //初始化賓客信息
    select_guest(1,10);
    //page();
})

//添加宾客功能
function add_guest(){
    document.getElementById("modal").style.visibility="visible";//显示
    $('#modal').show(500);
    $('#checkRecord').hide();
    $("#tijiao").show();
    $("#tijiao").attr("onclick","save_guest()");
    $("#modal input").val("");
  	$("#thumburlShow").attr("src","");
	$("#modal select").val("请选择...");
}  

function select_guest(pageNum,pageSize){
	//currPage,pageSize
	pageNum == null ? 1 : pageNum;
	pageSize == null ? 10 : pageSize;
    $.ajax({
            url:"/ReceptionMS/guest/select",
            type:"GET",
            data:{
            	"pageNum":pageNum,
            	"pageSize":pageSize
            },
            success:function(data){
            	var result =  eval(data);
            	var info = $("#guest_info").empty();
            	//渲染数据
            	for(var i =0;i< result.list.length;i++){
            		var list = result.list[i];
            		info.append("<tr ondblclick='select_detail("+list.id+")'><td><label><input type='checkbox' onclick='singleCheck()' name='gueat_info' value="+JSON.stringify(list)+
            				"><u></u></label></td>"+
            				"<td  id= 'id' style='display:none' >"+list.id+
            				"</td><td>"+list.guest_name+
            				"</td><td>"+list.main_position+
            				"</td><td>"+list.deputy_position+
            				"</td><td>"+list.office_area+
            				"</td><td>"+list.birth_date.substr(0,10)+
            				"</td><td>"+list.origin_place+
            				"</td><td>"+list.menu+
            				"</td><td>"+list.drink+
            				"</td><td>"+list.flavor+
            				"</td><td>"+list.sleep+
            				"</td><td>"+list.remark+"</td></tr> ");
            	};
            	page(result);
            }
        });
       // return menu;
}

/**
 * 分页展示数据
 */
function page(result){
	 $("#pagination").whjPaging({
         pageSizeOpt: [
             {'value': 5, 'text': '5条/页'},
             {'value': 10, 'text': '10条/页', 'selected': true},
             {'value': 15, 'text': '15条/页'},
             {'value': 20, 'text': '20条/页'}
         ],
 	    //可选，css设置，可设置值：css-1，css-2，css-3，css-4，css-5，默认css-1，可自定义样式
		    css: 'css-1',
		    //可选，总页数
		    totalPage: result.pages,
		    //可选，展示页码数量，默认5个页码数量
		    showPageNum: 10,
		    //可选，首页按钮展示文本，默认显示文本为首页
		    firstPage: '首页',
		    //可选，上一页按钮展示文本，默认显示文本为上一页
		    previousPage: '上一页',
		    //可选，下一页按钮展示文本，默认显示文本为下一页
		    nextPage: '下一页',
		    //可选，尾页按钮展示文本，默认显示文本为尾页
		    lastPage: '尾页',
		    //可选，跳至展示文本，默认显示文本为跳至
		    skip: '跳至',
		    //可选，确认按钮展示文本，默认显示文本为确认
		    confirm: '确认',
		    //可选，刷新按钮展示文本，默认显示文本为刷新
		    refresh: '刷新',
		    //可选，共{}页展示文本，默认显示文本为共{}页，其中{}会在js具体转化为数字
		    totalPageText: '共{}页',
		    //可选，是否展示首页与尾页，默认true
		    isShowFL: true,
		    //可选，是否展示每页N条下拉框，默认true
		    isShowPageSizeOpt: false,
		    //可选，是否展示跳到指定页数，默认true
		    isShowSkip: false,
		    //可选，是否展示刷新，默认true
		    isShowRefresh: false,
		    //可选，是否展示共{}页，默认true
		    isShowTotalPage: false,
		    //可选，是否需要重新设置当前页码及总页数，默认false，如果设为true，那么在请求服务器返回数据时，需要调用setPage方法
		    isResetPage: false,
		    //必选，回掉函数，返回参数：第一个参数为页码，第二个参数为每页显示N条
		    callBack: function (currPage, pageSize) {
		    	pageSize = 10;
		    	select_guest(currPage,pageSize); 
		    }
     });
}

/**
 * 提交添加的数据
 */
function save_guest(){
	if($('#add_guest_name').val()=='' || $('#add_birth_date').val()==''||
			$('#add_sex').val()=='' ||$('#add_nation').val()==''){
		alert("请检查必填项！");
		return;
	}
	  $.ajax({
          url:'/ReceptionMS/guest/insert',
          type:'POST',
          data:{
        	"guest_name" : $('#add_guest_name').val(),
      	    "main_position" : $('#add_main_position').val(),
      	    "deputy_position" : $('#add_deputy_position').val(),
      	    "office_area" : $('#add_office_area').val(),
      	    "sex" : $('#add_sex').val(),
      	    "birth_date": $('#add_birth_date').val(),
      	    "nation" : $('#add_nation').val(),
      	    "origin_place" : $('#add_origin_place').val(),
      	    "menu" : $('#add_menu').val(),
      	    "drink" : $('#add_drink').val(),
      	    "flavor" : $('#add_flavor').val(),
      	    "sleep" : $('#add_sleep').val(),
      	    "remark" : $('#add_remark').val(),
      	    "url" : $("#thumburlShow").attr("src")
         },
          success:function(data){
        	  alert("添加成功！");
        	  $("#modal input").val("");
        	  $("#modal select").val("请选择...");
            	$("#thumburlShow").attr("src","");
        	  document.getElementById("modal").style.visibility="hidden";//隱藏
        	  //select_guest();
        	  window.location.reload();
          },
          error:function(){
        	  alert("添加信息发生异常！");
          }
      });
}

/**
 * 查看详情
 */
function select_detail(id){
		  document.getElementById("modal").style.visibility="visible";//显示
		  $('#modal').show(500);
		  $('#checkRecord').show();
		  $("#tijiao").hide();
		  selectById(id);
}

/**
 * 根据id，查询详细的信息
 */
function selectById(id){
	  $.ajax({
          url:'/ReceptionMS/guest/selectById',
          type:'GET',
          data:{
      	    "id" : id
         },
          success:function(data){
        	  var result =  eval(data);
        	  if(result != null){
        		   $('#id').val(id),
        		   $('#add_guest_name').val(result.guest_name),
            	   $('#add_main_position').val(result.main_position),
            	   $('#add_deputy_position').val(result.deputy_position),
            	   $('#add_office_area').val(result.office_area),
            	   $('#add_sex').val(result.sex),
            	   $('#add_birth_date').val(result.birth_date.substr(0,10)),
            	   $('#add_nation').val(result.nation),
            	   $('#add_origin_place').val(result.origin_place),
            	   $('#add_menu').val(result.menu),
                   $('#add_drink').val(result.drink),
           	       $('#add_flavor').val(result.flavor),
           	       $('#add_sleep').val(result.sleep),
           	       $('#add_remark').val(result.remark),
           	       $("#thumburlShow").attr("src",result.url);//显示图片     
        	  }
          },
          error:function(){
        	  alert("信息发生异常！");
          }
      });
}

/**
 * 删除客户信息
 */
function delete_guest(){
	var obj = document.getElementsByName("gueat_info");
	   var id = -1;
	   for(k in obj){
	        if(obj[k].checked)
	           id = JSON.parse(obj[k].value).id;
	    }
	  if(id != -1){
		if (confirm("确认删除吗?")==true){
			$.ajax({
		         url:"/ReceptionMS/guest/delete?id="+id,
		         type:"delete",
		         success:function(data){
		        	 alert("删除成功");
		        	 //select_guest(1,5);
		        	 window.location.reload();
		            },
		         error:function(){
		            	alert("请求发生异常！");
		          }
		         });
			}
	  }else{
		  alert("请选择一条记录...");
	  }
}

function edit_guest(){
	 var obj = document.getElementsByName("gueat_info");
	   var id = -1;
	   for(k in obj){
	        if(obj[k].checked)
	           id = JSON.parse(obj[k].value).id;
	    }
	  if(id != -1){
		 document.getElementById("modal").style.visibility="visible";//显示
		    $('#modal').show(500);
		    $('#checkRecord').hide();
		    $("#tijiao").show();
		    $("#tijiao").attr("onclick","update_guest("+id+")");
		    selectById(id);
	 }else{
		 alert("请选择一条记录...");
	}
}

function update_guest(id){
	if($('#add_guest_name').val()=='' || $('#add_birth_date').val()==''||
			$('#add_sex').val()=='' ||$('#add_nation').val()==''){
		alert("请检查必填项！");
		return;
	}
	$.ajax({
        url:'/ReceptionMS/guest/update',
        type:'POST',
        data:{
        	"id" : id,
      	    "guest_name" : $('#add_guest_name').val(),
    	    "main_position" : $('#add_main_position').val(),
    	    "deputy_position" : $('#add_deputy_position').val(),
    	    "office_area" : $('#add_office_area').val(),
    	    "sex" : $('#add_sex').val(),
    	    "birth_date": $('#add_birth_date').val(),
    	    "nation" : $('#add_nation').val(),
    	    "origin_place" : $('#add_origin_place').val(),
    	    "menu" : $('#add_menu').val(),
    	    "drink" : $('#add_drink').val(),
    	    "flavor" : $('#add_flavor').val(),
    	    "sleep" : $('#add_sleep').val(),
    	    "remark" : $('#add_remark').val(),
    	    "url": $("#thumburlShow").attr("src")
       },
        success:function(data){
      	  alert("修改成功！");
      	  $("#modal input").val("");
      	  $("#modal select").val("请选择...");
      	 $("#thumburlShow").attr("src","");
      	  document.getElementById("modal").style.visibility="hidden";//隱藏
      	 // select_guest();
      	 window.location.reload();
        },
        error:function(){
      	  alert("修改信息发生异常！");
        }
    });
}

/**
 * 上传图片
 */
function setImg(obj){//用于进行图片上传，返回地址
   //获取当前用户id
	var f=$(obj).val();
    if(f == null || f ==undefined || f == ''){
        return false;
    }
    if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
    {
        alert("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
        $(obj).val('');
        return false;
    }
    var data = new FormData();
    $.each($(obj)[0].files,function(i,file){
        data.append('file', file);
    })
    $.ajax({
        type: "POST",
        url: "/ReceptionMS/guest/uploadImg",
        data: data,
        cache: false,
        contentType: false,    //不可缺
        processData: false,    //不可缺
        dataType:"json",
        success: function(suc) {
            if(suc.code==0){
                   // $("#thumbUrl").val(suc.message);//将地址存储好
                    $("#thumburlShow").attr("src",suc.message);//显示图片        
                   // alert(suc.message);
                }else{
                alertLayel("上传失败");
                $("#url").val("");
                $(obj).val(''); 
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("上传失败，请检查网络后重试");
            $("#url").val("");
            $(obj).val('');
        }
    });
}

function delete_img(){
	 $.ajax({
	        type: "POST",
	        url: "/ReceptionMS/guest/deleteImg",
	        data: {
	        },
	        success: function(data) {
                alert("删除成功！");
                $("#thumburlShow").attr("src","");//显示图片
	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	            alert($("#thumburlShow").attr("src"));
	        }
	    });
}


/**
 * 导出酒店信息信息
 */
function export_guest(){
	location.href='../../guest/guest.xls';
}


function importModal(){
	$("#importModal").show(500);
}

/**
 * 导入
 */
function import_Excel(obj){
	var f=$(obj).val();
    if(f == null || f ==undefined || f == ''){
        return false;
    }
    if(!/\.(?:xls|xlsx)$/.test(f))
    {
        alert("请上传Excel文件");
        $(obj).val('');
        return false;
    }
	var data = new FormData();
	 $.each($("#file_excel")[0].files,function(i,file){
	        data.append('file', file);
	    })
	 $.ajax({
	        type: "POST",
	        url: "/ReceptionMS/guest/upLoadFile",
	        data:data,
	        cache: false,
	        processData: false,
	        contentType: false,
	        dataType:"json",
	        success: function(str) {
             alert("导入成功！");
             select_guest(1,10);
	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	        	alert("请求失败，请检查网络后重试");
	        }
	    });
}

/**
 * 单选
 */
function singleCheck(){
    $('#guest_info tr td label').find('input[type=checkbox]').bind('click', function(){
   $('#guest_info tr td label').find('input[type=checkbox]').not(this).attr("checked", false);
  });
}

/**
 * 查看记录
 */
function checkRecord(){
	/*var obj = document.getElementsByName("gueat_info");
	   var guest_name = -1;
	   for(k in obj){
	        if(obj[k].checked)
	        	guest_name = JSON.parse(obj[k].value).guest_name;
	    }
	  if(guest_name != -1){*/
	   var guest_name = $('#add_guest_name').val();
		  $("#recordModal").show(500);
		  $('#checkRecord').show();
		  selectMeal(guest_name);
		  selectAccom(guest_name);
	 /* }else{
		 alert("请选择一条记录...");
	}*/
}

/**
 * 查看用餐记录
 */
function selectMeal(guest_name){
	//alert("查看用餐记录"+guest_name);
	$.ajax({
        url:"/ReceptionMS/meals/listByGuest.app",
        type:"post",
        data:{
       	 "guestName":guest_name
        },
        success:function(data){
        	var info = $("#meals").empty();
        	//渲染数据
        	for(var i =0;i< data.length;i++){
        		var list = data[i];
        		info.append("<tr>"+
        				"</td><td>"+list.menuNumber+
        				"</td><td>"+list.hotel+
        				"</td><td>"+list.mealsTime+
        				"</td><td>"+list.hobby+
        				"</td><td>"+list.recordTime+
        				"</td><td>"+list.remark+"</td></tr> ");
        	};
        },
        error:function(){
           	alert("请求发生异常！");
         }
  });
}
/**
 * 查看住房记录
 */
function selectAccom(guest_name){
	//alert("查看住房记录"+guest_name);
	$.ajax({
        url:"/ReceptionMS/accom/listByGuest.app",
        type:"post",
        data:{
       	 "guestName":guest_name
        },
        success:function(data){
        	var info = $("#accoms").empty();
        	//渲染数据
        	for(var i =0;i< data.length;i++){
        		var list = data[i];
        		info.append("<tr>"+
        				"</td><td>"+list.hotel+
        				"</td><td>"+list.roomNumber+
        				"</td><td>"+list.checkinTime+
        				"</td><td>"+list.checkoutTime+
        				"</td><td>"+list.hobby+
        				"</td><td>"+list.recordTime+
        				"</td><td>"+(list.remark==null?"":list.remark)+"</td></tr> ");
        	};
         },
        error:function(){
           	alert("请求发生异常！");
         }
  });
}