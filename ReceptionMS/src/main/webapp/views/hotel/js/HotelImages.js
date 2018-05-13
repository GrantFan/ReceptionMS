$(function(){
	
})



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
    }),
    //截取图片名称
    data.append("graph_name", f.substring(f.lastIndexOf("\\")+1, f.lastIndexOf(".")));
    //关联酒店id
    data.append("hotel", "1");
    $.ajax({
        type: "POST",
        url: "/ReceptionMS/hotel_graph/uploadImg",
        data:data,
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
    
    /**
     * 上传图片
     */
    function deleteImage(){//用于进行图片上传，返回地址
    	alert("222");
        $.ajax({
            type: "GET",
            url: "/ReceptionMS/hotel_graph/deleetImpByHotel",
            data:
            {
               "hotel":"3"
             },
            dataType:"json",
            success: function(suc) {
                if(suc){
                	    alert("删除成功");
                        $("#thumburlShow").attr("src","");//显示图片        
                  }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            }
        });
}
