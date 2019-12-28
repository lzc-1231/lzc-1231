$(function(){
	//1、为页面中凡是带有name='secondMenu'超链接添加单击事件
	$('a[name="secondMenu"]').click(function(){
		var thisLinkVueStr = $(this).text();
		var linkImg = $(this).attr('id');
		var linkPageUrl = $(this).attr('title');
		limkImg = linkImg.substring(0,linkImg.indexOf('.'));
		if(!$('#shoppingtabs').tabs('exists',thisLinkVueStr)){
			$('#shoppingtabs').tabs('add',{
				title:thisLinkVueStr,
				closable:true,
				content:'<iframe frameborder=0 , src='+linkPageUrl+' style=width:100%;height:100%></iframe>',
				iconCls:'icon-' + limkImg
			});
		}else{o
			$('#shoppingtabs').tabs('select',thisLinkVueStr);
		}
	});
});