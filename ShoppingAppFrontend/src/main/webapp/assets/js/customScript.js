$(function()
{
	var $table=$('#producttable');
	var jsonUrl='';
		if(window.categoryId=='')
		{
			jsonUrl= window.contextRoot+'/json/show/all/active/products';
		}
		else
		{
			jsonUrl= window.contextRoot+'/json/show/all/active/category/'+window.categoryId+'/products';
		}
	
	$table.DataTable({
		lengthMenu: [[3,6,9],['3 Books','6 Books','9 Books']],
		pageLength:6,
		ajax : {
				url: jsonUrl,
				dataSrc : '',
			   },
		columns : [
					{
						data : 'code',
						bSortable:false,
						mRender:function(data,type,row)
						{
							return '<img src="'+window.contextRoot+'/rs/images/'+data+'.jpg" class="dataTableImg"/>'
						}
					},
					{
						data : 'name'
					},
					{
						data : 'author',
						bSortable:false,
					},
					{
						data : 'quantity',
						bSortable:false,
						mRender:function(data,type,row)
						{
							if (data<1)
							{
								return '<span style="color:red">Out of Stock!</span>'
							}
							else
							{
								return '<span style="color:green">Available</span>'
							}
						}
					},
					{
						data : 'unitPrice',
						mRender:function(data,type,row)
						{
							return '&#8377; '+data
						}
					},
					{
						data : 'id',
						mRender:function(data,type,row)
						{
							if (row.quantity<1)
							{
								return '<a class="btn btn-warning" href="'+window.contextRoot+'/product/show/single/'+data+'/product">View</a><a href="javascript:void(0)"class="btn btn-success disabled" href="#"><strike>Add to Cart</strike></a>'
							}
							else
							{
								return '<a class="btn btn-warning" href="'+window.contextRoot+'/product/show/single/'+data+'/product">View</a><a class="btn btn-success" href="#">Add to Cart</a>'
							}
						}
					},
				   ],
	});
});