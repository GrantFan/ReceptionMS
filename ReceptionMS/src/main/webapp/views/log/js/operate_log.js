$(function(){
    //初始化賓客信息
	select_log(1,10);
    //page();
})

function select_log(pageNum,pageSize){
	//currPage,pageSize
	pageNum == null ? 1 : pageNum;
	pageSize == null ? 10 : pageSize;
    $.ajax({
            url:"/ReceptionMS/log/select",
            type:"GET",
            data:{
            	"pageNum":pageNum,
            	"pageSize":pageSize,
            	"start" : $("#start").val() == "" ? "0000-00-00" : $("#start").val(),
            	"end" : $("#end").val() == "" ?  new Date().format("yyyy-MM-dd") : $("#end").val()
            },
            success:function(data){
            	var result =  eval('(' + data + ')');
            	var info = $("#log_info").empty();
            	//渲染数据
            	for(var i =0;i< result.list.length;i++){
            		var list = result.list[i];
            		info.append("<tr><td  hidden='hidden'>"+list.id+
            				"</td><td>"+list.operator+
            				"</td><td>"+list.module+
            				"</td><td>"+list.compuer_ip+
            				"</td><td>"+list.time+
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
		    	select_log(currPage,pageSize); 
		    }
     });
}
