$(function(){
    document.getElementById("modal").style.visibility="hidden";//隱藏
    //初始化賓客信息
    select_guest(1,5);
    //page();
})

//添加宾客功能
function add_guest(){
    document.getElementById("modal").style.visibility="visible";//显示
    $('.modal').show(500);
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
            	var result =  eval('(' + data + ')');
            	var info = $("#guest_info").empty();
            	//渲染数据
            	for(var i =0;i< result.list.length;i++){
            		var list = result.list[i];
            		info.append("<tr><td><label><input type='radio' name='gueat_info' value="+list.id+
            				"><u></u></label></td>"+
            				"<td  id= 'id' style='display:none' >"+list.id+
            				"</td><td>"+list.guest_name+
            				"</td><td>"+list.main_position+
            				"</td><td>"+list.deputy_position+
            				"</td><td>"+list.office_area+
            				/*"</td><td>"+list.sex+*/
//            				"</td><td>"+list.birth_date.substr(0,10)+
            				/*"</td><td>"+list.nation+
            				"</td><td>"+list.education+*/
            				"</td><td>"+list.origin_place+
            				"</td><td>"+list.telphone+
            				"</td><td>"+list.phone+
            				"</td><td>"+list.email+
            				"</td><td>"+list.address+
            				"</td><td>"+list.guest_type+
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
             {'value': 5, 'text': '5条/页', 'selected': true},
             {'value': 10, 'text': '10条/页'},
             {'value': 15, 'text': '15条/页'},
             {'value': 20, 'text': '20条/页'}
         ],
 	    //可选，css设置，可设置值：css-1，css-2，css-3，css-4，css-5，默认css-1，可自定义样式
		    css: 'css-1',
		    //可选，总页数
		    totalPage: result.pages,
		    //可选，展示页码数量，默认5个页码数量
		    showPageNum: 5,
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
		    isShowPageSizeOpt: true,
		    //可选，是否展示跳到指定页数，默认true
		    isShowSkip: true,
		    //可选，是否展示刷新，默认true
		    isShowRefresh: true,
		    //可选，是否展示共{}页，默认true
		    isShowTotalPage: true,
		    //可选，是否需要重新设置当前页码及总页数，默认false，如果设为true，那么在请求服务器返回数据时，需要调用setPage方法
		    isResetPage: false,
		    //必选，回掉函数，返回参数：第一个参数为页码，第二个参数为每页显示N条
		    callBack: function (currPage, pageSize) {
		    	select_guest(currPage,pageSize); 
		    }
     });
}

/**
 * 提交添加的数据
 */
function save_guest(){
	if($('#add_guest_name').val()=='' || $('#add_birth_date').val()==''||
			$('#add_sex').val()=='' ||$('#add_nation').val()=='' ||  $('#add_education').val()==''||
			$('#add_guest_type').val()==''){
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
      	    "education" : $('#add_education').val(),
      	    "origin_place" : $('#add_origin_place').val(),
      	    "telphone" : $('#add_telphone').val(),
      	    "phone" : $('#add_phone').val(),
      	    "email" : $('#add_email').val(),
      	    "address" : $('#add_address').val(),
      	    "guest_type" : $('#add_guest_type').val(),
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
function select_detail(){
	  var obj = document.getElementsByName("gueat_info");
	  var id = -1;
	  for(k in obj){
	        if(obj[k].checked)
	           id = obj[k].value;
	   }
	  if(id != -1){
		  document.getElementById("modal").style.visibility="visible";//显示
		  $('.modal').show(500);
		  $("#tijiao").hide();
		  selectById(id);
	  }else{
		  alert("请选择一条记录...");
	  }
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
        	  var result =  eval('(' + data + ')');
        	  if(result != null){
        		   $('#id').val(id),
        		   $('#add_guest_name').val(result.guest_name),
            	   $('#add_main_position').val(result.main_position),
            	   $('#add_deputy_position').val(result.deputy_position),
            	   $('#add_office_area').val(result.office_area),
            	   $('#add_sex').val(result.sex),
            	   $('#add_birth_date').val(result.birth_date.substr(0,10)),
            	   $('#add_nation').val(result.nation),
                   $('#add_education').val(result.education),
            	   $('#add_origin_place').val(result.origin_place),
            	   $('#add_telphone').val(result.telphone),
                   $('#add_phone').val(result.phone),
           	       $('#add_email').val(result.email),
           	       $('#add_address').val(result.address),
           	       $('#add_guest_type').val(result.guest_type),
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
	           id = obj[k].value;
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
	           id = obj[k].value;
	    }
	  if(id != -1){
		 document.getElementById("modal").style.visibility="visible";//显示
		    $('.modal').show(500);
		    $("#tijiao").show();
		    $("#tijiao").attr("onclick","update_guest("+id+")");
		    selectById(id);
	 }else{
		 alert("请选择一条记录...");
	}
	 }

function update_guest(id){
	if($('#add_guest_name').val()=='' || $('#add_birth_date').val()==''||
			$('#add_sex').val()=='' ||$('#add_nation').val()=='' ||  $('#add_education').val()==''||
			$('#add_guest_type').val()==''){
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
    	    "education" : $('#add_education').val(),
    	    "origin_place" : $('#add_origin_place').val(),
    	    "telphone" : $('#add_telphone').val(),
    	    "phone" : $('#add_phone').val(),
    	    "email" : $('#add_email').val(),
    	    "address" : $('#add_address').val(),
    	    "guest_type" : $('#add_guest_type').val(),
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
	location.href='http://localhost:8088/ReceptionMS/guest/guest.xls';
}
