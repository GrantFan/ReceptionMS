$(function(){
    //初始化賓客信息
    select_menu(1,10);
    select_hotel();
    //page();
})

//添加宾客功能
function add_menu(){
    document.getElementById("modal").style.visibility="visible";//显示
    $('.modal').show(500);
    $("#tijiao").show();
    $('.Tmodal table.tabTbody').empty();
    trAdd();
    $("#tijiao").attr("onclick","save_menu()");
    $("#modal input").val("");
	$("#modal select").val("请选择...");
}  

/**
 * 初始化菜单栏
 */
function select_menu(pageNum,pageSize){
	//currPage,pageSize
	pageNum == null ? 1 : pageNum;
	pageSize == null ? 10 : pageSize;
    $.ajax({
            url:"/ReceptionMS/menu_info/select",
            type:"GET",
            data:{
            	"pageNum":pageNum,
            	"pageSize":pageSize
            },
            success:function(data){
            	var result =  eval(data);
            	var info = $("#menu_info").empty();
            	//渲染数据
            	for(var i =0;i< result.list.length;i++){
            		var list = result.list[i];
            		info.append("<tr><td><label><input type='checkbox' name='mean_info' onclick='singleCheck()' value="+list.menu_number+"><u></u></label></td>"+
            				"<td  id= 'id' style='display:none' >"+list.id+
            				"</td><td>"+list.menu_number+
            				"</td><td>"+list.short_name+
            				"</td><td>"+list.menu_type+
            				"</td><td>"+list.hotel+
            				"</td><td>"+list.meals_time+
            				"</td><td>"+list.meals_type+
            				"</td><td>"+list.standard+
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
		    	select_menu(currPage,pageSize); 
		    }
     });
}

/**
 * 将套餐信息，拼接成字符串，提交
 */
 function getList(){
	 
	  var table = document.getElementById("food_infos");
	  var tr = table.getElementsByTagName("tr");
	  var str='{"menu_number" :"'+ $('#menu_number').val()+
			  '","menu_type" : "'+ $('#menu_type').val()+
			  '","short_name" : "'+ $('#short_name').val()+
		   	  '","hotel" : "'+$('#hotel').val() +
		   	   '","meals_time" :"'+ $('#meals_time').val()+
		   	   '","meals_type" :"'+ $('#meals_type').val()+
		       '","standard" :"'+ $('#standard').val()+
		  	   '","remark" : "'+ $('#remarks').val()+
  	           '","food_infos" : ['; 
	  for(i=0;i< tr.length -1;i++){
		  if($('input[name="food_name"]')[i].value != ""){
		str += '{"food_name"'+':"'+ $('input[name="food_name"]')[i].value+
		 '","price"'+':"'+ $('input[name="price"]')[i].value+
		 '","type"'+':"'+ $('input[name="type"]')[i].value+
		 '","remark"'+':"'+ $('input[name="remark"]')[i].value+'"},';
	    }
      }
	  str = str.substring(0,str.length-1)+']}';
	  //alert(str);
	  return str;
  }

/**
 * 提交添加的数据
 */
function save_menu(){
	  $.ajax({
          url:'/ReceptionMS/menu_info/insert',
          type:'PUT',
          dataType: 'JSON',
          data: getList(),
          contentType:"application/json",//*****和application-servlet.xml配置相同 
          success:function(data){
        	  alert("添加成功！");
        	  $("#modal input").val("");
        	  $("#modal select").val("请选择...");
        	  document.getElementById("modal").style.visibility="hidden";//隱藏
        	  //select_menu();
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
	  var obj = document.getElementsByName("mean_info");
	  var menu_number = "";
	  for(k in obj){
	        if(obj[k].checked)
	        	menu_number = obj[k].value;
	   }
	  if(menu_number != ""){
		 document.getElementById("modal").style.visibility="visible";//显示
		  $('.modal').show(500);
		  $("#tijiao").hide();
		  selectById(menu_number);
	  }else{
		  alert("请选择一条记录...");
	  }
}

/**
 * 根据id，查询详细的信息
 */
function selectById(menu_number){
	  $.ajax({
          url:'/ReceptionMS/menu_info/selectById.app',
          type:'GET',
          data:{
      	    "menu_number" : menu_number
         },
          success:function(data){
        	  var result =  eval(data);
        	  if(result != null){
        		  $('#menu_number').val(result.menu_number),
        		  $('#short_name').val(result.short_name),
        		   $('#menu_type').val(result.menu_type),
            	   $('#hotel').val(result.hotel),
            	   $('#meals_time').val(result.meals_time),
            	   $('#meals_type').val(result.meals_type),
                   $('#standard').val(result.standard),
           	       $('#remark').val(result.remark)
        		  $('.Tmodal table.tabTbody').empty();
              	//渲染数据
              	for(var i =0;i< result.food_infos.length;i++){
              		var list = result.food_infos[i];
              		$('.Tmodal table.tabTbody').append('<tr><td><input type="text" name="food_name"  value="'+list.food_name+'"/></td>'
            		+'<td><input type="number" name="price" value="'+(list.price==null? "": list.price)+'"/></td>'
            		+'<td><input type="text" name="type" value="'+(list.type==null? "": list.type)+'"/></td>'	
            		+'<td><input type="text" name="remark" value="'+(list.remark==null? "": list.remark)+'"/></td>'	
            		+'<td><button onclick="trDel(this)">×</button></td>'
            		+'</tr>');
              	}
              	trAdd();
        	  }
        	    
          },
          error:function(){
        	  alert("信息发生异常！");
          }
      });
}

/**
 * 删除菜单信息
 */
function delete_menu(){
	var obj = document.getElementsByName("mean_info");
	   var menu_number = "";
	   for(k in obj){
	        if(obj[k].checked)
	        	menu_number = obj[k].value;
	    }
	  if(menu_number != ""){
		if (confirm("确认删除吗?")==true){
			$.ajax({
		         url:"/ReceptionMS/menu_info/delete?menu_number="+menu_number,
		         type:"delete",
		         success:function(data){
		        	 alert("删除成功");
		        	 window.location.reload();
		        	 //select_menu(1,5);
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

/**
 * 编辑菜单栏
 */
function edit_menu(){
	 var obj = document.getElementsByName("mean_info");
	   var menu_number = -1;
	   for(k in obj){
	        if(obj[k].checked)
	        	menu_number = obj[k].value;
	    }
	  if(menu_number != -1){
	    document.getElementById("modal").style.visibility="visible";//显示
	    $('.modal').show(500);
	    $("#tijiao").show();
	    //trAdd();
	    $("#tijiao").attr("onclick","update_menu()");
	    selectById(menu_number);
	  }else{
			 alert("请选择一条记录...");
	}
}

/**
 *提交编辑后的内容
 */
function update_menu(){
	$.ajax({
        url:'/ReceptionMS/menu_info/update',
        type:'PUT',
        dataType: 'JSON',
        data: getList(),
        contentType:"application/json",//*****和application-servlet.xml配置相同 
        success:function(data){
      	  alert("修改成功！");
      	  $("#modal input").val("");
      	  $("#modal select").val("请选择...");
      	  document.getElementById("modal").style.visibility="hidden";//隱藏
      	  //select_menu();
      	  window.location.reload();
        },
        error:function(){
      	  alert("修改信息发生异常！");
        }
    });
}


/**
 * 输入食物信息
 */
function trAdd(){
	var tr ='<tr><td><input type="text" name="food_name" onchange="trAdd()"/></td>'
		+'<td><input type="number" name="price"></td>'
		+'<td><input type="text" name="type"/></td>'	
		+'<td><input type="text" name="remark"/></td>'	
		+'<td><button onclick="trDel(this)">×</button></td>'	
		+'</tr>';
    $('.Tmodal table.tabTbody').append(tr)
}

$(".tabTbody input").on('focus',function(){
	console.log($(this).parent('td').siblings('td').children('input'))
	console.log($(this).parent('td').siblings('td').children('input').attr('onchange',''));
})

/**
 * 查询酒店信息
 */
function select_hotel(){
	$.ajax({
        url:'/ReceptionMS/hotel/listByName',
        type:'post',
        data: {},
        success:function(data){
      	  var list = eval(data);
      	  $("#hotel").empty();
      	  for(var i =0 ; i< list.length;i++){
      		$("#hotel").append("<option value="+list[i].hotelName+">"+list[i].hotelName+"</option>");
      	  }
        },
        error:function(){
      	  alert("修改信息发生异常！");
        }
    });
}

/**
 * 删除tr
 */
function trDel(tr){
	$(tr).parent('td').parent('tr').remove();
}


/**
 * 导出菜单信息
 */
function export_menu(){
	location.href='../../menu_info/menu.xls';
}

function export_food(){
	location.href='../../menu_info/food.xls';
}

/**
 * 单选
 */
function singleCheck(){
    $('#menu_info tr td label').find('input[type=checkbox]').bind('click', function(){
   $('#menu_info tr td label').find('input[type=checkbox]').not(this).attr("checked", false);
  });
}