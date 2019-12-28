$(function(){
	console.log("hello world"); 
	$('#bookinfotable').datagrid({
		url:'servlet/userAuthorityManagerMenetServlet',
		fit:true,//自动填充
		//singleSelect:true,//一次只能选一条数据
		rownumbers:true,//显示行数
		/*rowStyler: function(index,row){
	  		if (index%2 == 0){
	  			return 'background-color:#6293BB;'
	  		}
	  	},*/
		columns:[[    
		          {field:'ok',title:'',checkbox:true,width:100},
		          {field:'bookNo',title:'图书编号',width:100,align:'center'},    
		          {field:'bookName',title:'图书名称',width:150,align:'center'},  
		          {field:'bookAuthor',title:'图书作者',width:100,align:'center'}, 
		          {field:'bookPublisher',title:'出版社名称',width:110,align:'center'},
		          {field:'bookPubDateStr',title:'出版社日期',width:200,align:'center'},
		          {field:'bookPrice',title:'图书原价',width:100,align:'center',
		          },
		          {field:'bookTypeNo',title:'图书类型',width:100,align:'center'},
		          {field:'bookImage',title:'图书图片',width:100,align:'center',
		        	  formatter: function(value,row,index){
				  				if (value!=null && 0<value.length){
				  					return "<img src='bookcover/"+value+"' style='width:80px; height:60px;'>";
				  				} else {
				  					return value;
				  				}
			  				}
		          },
		      ]],
		      loadMsg:'请您耐心等待,数据正在加载...',
		      pagination:true,
		      pagePosition:'top',
		      pageList:[5,10,15,20],
		      pageSize:5,
		      toolbar:'#allbth'
	});
	
	$('#dd').window('close');
	
	$('#add').click(function(){    
		$('#dd').window('open');
		//为图书编号添加值
		$.post("servlet/userBookTypeInfoServlet", { flag:"BookNo" },
	         function(data){
				var message=$.parseJSON(data).key;
				$('#bNo').textbox({
					value:message
				})
		}, "text");
		$('#cc').combobox({    
			editable:false,
		    url:'servlet/userBookTypeInfoServlet?flag=BookTypeNo',    
		    valueField:'bookTypeNo',    
		    textField:'bookTypeName',
		    onLoadSuccess:function(){
		    	var data=$('#cc').combobox('getData');
		    	if(data.length>0){
		    		$('#cc').combobox('select',data[0].bookTypeNo)
		    	}
		    }
		});
		//解绑
		$('#ok').unbind('click');
		
		$('#ok').click(function(){
		$('#ok').form('submit', {    
		    url:'servlet/userBookTypeInfoServlet',    
		    onSubmit: function(){    
		    	if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
		    },    
		    success:function(data){    
		    	var message=$.parseJSON(data).message;
				if("successed"==message){
					$.messager.progress('close');	// 如果提交成功则隐藏进度条
					//窗口提示成功
					$.messager.show({
						title:'新增提示',
						msg:'图书信息新增成功',
						timeout:2000,
						showType:'slide'
					});
					$('#ff').form('reset');
					//关闭窗口
					$('#dd').window('close');
					//刷新datagrid
					$('#bookinfotable').datagrid('reload');
				}else{
					//窗口提示失败
					$.messager.show({
						title:'新增提示',
						msg:'图书信息新增失败',
						timeout:2000,
						showType:'slide'
					});
				}
		    }    
		});
		});
    });
}); 









